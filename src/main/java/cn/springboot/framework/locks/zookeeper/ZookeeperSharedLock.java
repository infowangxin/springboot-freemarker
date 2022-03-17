package cn.springboot.framework.locks.zookeeper;

import cn.springboot.framework.locks.SharedLock;
import cn.springboot.framework.locks.exception.BuildLockException;
import cn.springboot.framework.locks.exception.LockException;
import cn.springboot.framework.locks.exception.UnLockException;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.locks.InterProcessLock;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.framework.recipes.locks.InterProcessSemaphoreV2;
import org.apache.curator.framework.recipes.locks.Lease;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Stack;
import java.util.concurrent.TimeUnit;

/**
 * <h3>ZooKeeper共享锁实现</h3>
 *
 * <p>基于 ZooKeeper 实现了分布式共享锁接口{@link SharedLock SharedLock}</p>
 *
 * @author 胡桃夹子
 */
public class ZookeeperSharedLock implements SharedLock {

    private static final Logger LOG = LoggerFactory.getLogger(ZookeeperSharedLock.class);

    private final InterProcessSemaphoreV2 lock;

    private final Stack<Lease> leases;

    private final CuratorFramework client;

    private final int poolSize;

    private final String lockPath;

    protected ZookeeperSharedLock(CuratorFramework client, String name, int poolSize) {
        if (client == null || name == null || poolSize < 1) {
            throw new BuildLockException("init ZookeeperSharedLock error!");
        }
        if (!name.startsWith("/")) {
            name = "/" + name;
        }
        lock = new InterProcessSemaphoreV2(client, name, poolSize);
        this.client = client;
        this.poolSize = poolSize;
        this.lockPath = name;
        this.leases = new Stack<>();
    }

    @Override
    public void lock() {
        try {
            leases.push(lock.acquire());
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            throw new LockException(e.getMessage(), e);
        }
    }

    @Override
    public void lock(int qty) {
        try {
            if (qty < 1 || qty > poolSize) {
                throw new LockException("lock quantity error!");
            }
            leases.addAll(lock.acquire(qty));
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            throw new LockException(e.getMessage(), e);
        }
    }

    @Override
    public synchronized boolean tryLock() {
        try {
            InterProcessLock mutexLock = new InterProcessMutex(client, lockPath + "-SharedLock");
            int count = 0;
            Lease lease = null;
            do {
                lease = lock.acquire(1, TimeUnit.MICROSECONDS);
                if (lease == null) {
                    mutexLock.acquire();
                    try {
                        count = client.checkExists().forPath(lockPath + "/leases").getNumChildren();
                        if (count >= poolSize) {
                            break;
                        }
                    } finally {
                        mutexLock.release();
                    }
                }
            } while (lease == null);
            if (lease == null) {
                return false;
            } else {
                leases.push(lease);
                return true;
            }
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            throw new LockException(e.getMessage(), e);
        }
    }

    @Override
    public synchronized boolean tryLock(long time, TimeUnit unit) {
        try {
            if (time <= 0) {
                throw new LockException("lock time error!");
            }
            Lease lease = lock.acquire(time, unit);
            if (lease == null) {
                return false;
            } else {
                leases.push(lease);
                return true;
            }
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            throw new LockException(e.getMessage(), e);
        }
    }

    @Override
    public synchronized boolean tryLock(int qty) {
        if (qty < 1 || qty > poolSize) {
            throw new LockException("lock quantity error!");
        }
        try {
            InterProcessLock mutexLock = new InterProcessMutex(client, lockPath + "-SharedLock");
            int count = 0;
            Collection<Lease> newLeases = null;
            do {
                newLeases = lock.acquire(qty, 1, TimeUnit.MICROSECONDS);
                if (newLeases == null) {
                    mutexLock.acquire();
                    try {
                        count = client.checkExists().forPath(lockPath + "/leases").getNumChildren();
                        if (count + qty > poolSize) {
                            break;
                        }
                    } finally {
                        mutexLock.release();
                    }
                }
            } while (newLeases == null);
            if (newLeases == null) {
                return false;
            } else {
                leases.addAll(newLeases);
                return true;
            }
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            throw new LockException(e.getMessage(), e);
        }
    }

    @Override
    public synchronized boolean tryLock(int qty, long time, TimeUnit unit) {
        try {
            if (time <= 0 || unit == null) {
                throw new LockException("lock time error!");
            }
            if (qty < 1 || qty > poolSize) {
                throw new LockException("lock quantity error!");
            }

            Collection<Lease> newLeases = lock.acquire(qty, time, unit);
            if (newLeases == null) {
                return false;
            } else {
                leases.addAll(newLeases);
                return true;
            }
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            throw new LockException(e.getMessage(), e);
        }
    }

    @Override
    public synchronized void unlock() {
        try {
            if (leases == null || leases.empty()) {
                throw new UnLockException("no lock found !");
            }
            if (leases != null) {
                lock.returnAll(leases);
                leases.clear();
            }
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            throw new UnLockException(e.getMessage(), e);
        }
    }

    @Override
    public synchronized void unlock(int qty) {
        try {
            if (leases == null || leases.empty()) {
                throw new UnLockException("no lock found !");
            }
            if (qty < 1 || qty > leases.size()) {
                throw new LockException("unlock quantity error!");
            }
            Collection<Lease> newLeases = new ArrayList<>();
            for (int i = 0; i < qty; i++) {
                newLeases.add(leases.pop());
            }
            lock.returnAll(newLeases);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            throw new UnLockException(e.getMessage(), e);
        }

    }

    @Override
    public int getInstanceLocks() {
        return leases == null ? 0 : leases.size();
    }

    @Override
    public synchronized int getTotalLocks() {
        try {
            InterProcessLock mutexLock = new InterProcessMutex(client, lockPath + "-SharedLock");
            mutexLock.acquire();
            int leases, locks;
            try {
                leases = client.checkExists().forPath(lockPath + "/leases").getNumChildren();
                locks = client.checkExists().forPath(lockPath + "/locks").getNumChildren();
            } finally {
                mutexLock.release();
            }
            return leases - locks;
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage(), e);
        }
    }

}

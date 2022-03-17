package cn.springboot.framework.locks.zookeeper;

import cn.springboot.framework.locks.MutexLock;
import cn.springboot.framework.locks.ReadWriteLock;
import cn.springboot.framework.locks.exception.BuildLockException;
import cn.springboot.framework.locks.exception.LockException;
import cn.springboot.framework.locks.exception.UnLockException;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.framework.recipes.locks.InterProcessReadWriteLock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * <h3>ZooKeeper读写锁实现</h3>
 *
 * <p>基于 ZooKeeper 实现了分布式读写锁接口{@link ReadWriteLock ReadWriteLock}</p>
 *
 * @author 胡桃夹子
 */
public class ZookeeperReadWriteLock implements ReadWriteLock {

    private static final Logger LOG = LoggerFactory.getLogger(ZookeeperReadWriteLock.class);

    private final InterProcessReadWriteLock lock;

    protected ZookeeperReadWriteLock(CuratorFramework client, String name) {
        if (client == null || name == null) {
            throw new BuildLockException("init ZookeeperReadWriteLock error!");
        }
        if (!name.startsWith("/")) {
            name = "/" + name;
        }
        lock = new InterProcessReadWriteLock(client, name);
    }

    @Override
    public MutexLock readLock() {
        return new ZookeeperReadLock(lock.readLock());
    }

    @Override
    public MutexLock writeLock() {
        return new ZookeeperWriteLock(lock.writeLock());
    }

    private class ZookeeperReadLock implements MutexLock {

        private final InterProcessMutex readLock;

        private int holdCount = 0;

        protected ZookeeperReadLock(InterProcessMutex readLock) {
            this.readLock = readLock;
        }

        @Override
        public void lock() {
            try {
                readLock.acquire();
                holdCount++;
            } catch (Exception e) {
                LOG.error(e.getMessage(), e);
                throw new LockException(e.getMessage(), e);
            }
        }

        @Override
        public boolean tryLock() {
            try {
                boolean result = readLock.acquire(1, TimeUnit.MICROSECONDS);
                if (result) {
                    holdCount++;
                }
                return result;
            } catch (Exception e) {
                LOG.error(e.getMessage(), e);
                throw new LockException(e.getMessage(), e);
            }
        }

        @Override
        public boolean tryLock(long time, TimeUnit unit) {
            try {
                if (time <= 0 || unit == null) {
                    throw new LockException("lock time error!");
                }
                boolean result = readLock.acquire(time, unit);
                if (result) {
                    holdCount++;
                }
                return result;
            } catch (Exception e) {
                LOG.error(e.getMessage(), e);
                throw new LockException(e.getMessage(), e);
            }
        }

        @Override
        public void unlock() {
            try {
                readLock.release();
                holdCount--;
            } catch (Exception e) {
                LOG.error(e.getMessage(), e);
                throw new UnLockException(e.getMessage(), e);
            }
        }

        @Override
        public int getHoldCount() {
            return holdCount;
        }

        @Override
        public boolean isHeldByCurrentThread() {
            return holdCount > 0;
        }
    }

    private class ZookeeperWriteLock implements MutexLock {

        private final InterProcessMutex writeLock;

        private int holdCount = 0;

        protected ZookeeperWriteLock(InterProcessMutex writeLock) {
            this.writeLock = writeLock;
        }

        @Override
        public void lock() {
            try {
                writeLock.acquire();
                holdCount++;
            } catch (Exception e) {
                LOG.error(e.getMessage(), e);
                throw new LockException(e.getMessage(), e);
            }
        }

        @Override
        public boolean tryLock() {
            try {
                boolean result = writeLock.acquire(1, TimeUnit.MICROSECONDS);
                if (result) {
                    holdCount++;
                }
                return result;
            } catch (Exception e) {
                LOG.error(e.getMessage(), e);
                throw new LockException(e.getMessage(), e);
            }
        }

        @Override
        public boolean tryLock(long time, TimeUnit unit) {
            try {
                if (time <= 0 || unit == null) {
                    throw new LockException("lock time error!");
                }
                boolean result = writeLock.acquire(time, unit);
                if (result) {
                    holdCount++;
                }
                return result;
            } catch (Exception e) {
                LOG.error(e.getMessage(), e);
                throw new LockException(e.getMessage(), e);
            }
        }

        @Override
        public void unlock() {
            try {
                writeLock.release();
                holdCount--;
            } catch (Exception e) {
                LOG.error(e.getMessage(), e);
                throw new UnLockException(e.getMessage(), e);
            }
        }

        @Override
        public int getHoldCount() {
            return holdCount;
        }

        @Override
        public boolean isHeldByCurrentThread() {
            return holdCount > 0;
        }

    }
}

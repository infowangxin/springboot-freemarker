package cn.springboot.framework.locks.zookeeper;

import cn.springboot.framework.locks.MutexLock;
import cn.springboot.framework.locks.exception.BuildLockException;
import cn.springboot.framework.locks.exception.LockException;
import cn.springboot.framework.locks.exception.UnLockException;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.locks.InterProcessLock;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * <h3>ZooKeeper互斥锁实现</h3>
 *
 * <p>基于 ZooKeeper 实现了分布式互斥锁接口{@link MutexLock MutexLock}</p>
 *
 * @author 胡桃夹子
 */
public class ZookeeperMutexLock implements MutexLock {

    private static final Logger LOG = LoggerFactory.getLogger(ZookeeperMutexLock.class);

    private final InterProcessLock lock;

    private int holdCount = 0;

    protected ZookeeperMutexLock(CuratorFramework client, String name) {
        if (client == null || name == null) {
            throw new BuildLockException("init ZookeeperMutexLock error!");
        }
        if (!name.startsWith("/")) {
            name = "/" + name;
        }
        lock = new InterProcessMutex(client, name);
    }

    @Override
    public void lock() {
        try {
            lock.acquire();
            holdCount++;
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            throw new LockException(e.getMessage(), e);
        }
    }

    @Override
    public boolean tryLock() {
        try {
            boolean result = lock.acquire(1, TimeUnit.MICROSECONDS);
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
            boolean result = lock.acquire(time, unit);
            if (result) {
                holdCount++;
            }
            LOG.debug("{}", result);
            return result;
			/*
			time=unit.toMillis(time);
			log.debug("time:{}",time);
			long beginTime=System.currentTimeMillis();
			boolean result=false;
			do{
				result=lock.acquire(1, TimeUnit.MICROSECONDS);
				log.debug("diff:{}",System.currentTimeMillis()-beginTime);
			}while(System.currentTimeMillis()-beginTime < time);
			return result;
			*/
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            throw new LockException(e.getMessage(), e);
        }
    }

    @Override
    public void unlock() {
        try {
            lock.release();
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

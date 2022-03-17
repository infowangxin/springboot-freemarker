package cn.springboot.framework.locks;

/**
 * <h3>互斥锁接口</h3>
 *
 * <p>
 * 继承自分布式锁接口{@link cn.springboot.framework.locks.DistributedLock DistributedLock}，
 * 同一时间只有一个线程能够获取锁，其他线程必须等待它释放锁后，才能获取。
 * </p>
 *
 * @author 胡桃夹子
 */
public interface MutexLock extends DistributedLock {

    /**
     * <h3>获取当前线程保持此锁的次数</h3>
     *
     * <p>
     * 每调用一次 lock()或tryLock()方法，当前线程保持此锁的次数增加 1。
     * 每调用一次unlock()方法，当前线程保持此锁的次数减 1。
     * </p>
     *
     * @return 当前线程保持此锁的次数，如果此锁未被当前线程保持过，则返回 0
     */
    int getHoldCount();

    /**
     * <h3>查询当前线程是否保持此锁</h3>
     *
     * <p>
     * 等同于 调用{@link cn.springboot.framework.locks.MutexLock#getHoldCount() getHoldCount()}方法，
     * 返回值大于 0 则当前线程保持此锁。
     * </p>
     *
     * @return 如果当前线程保持此锁，则返回 true；否则返回 false
     */
    boolean isHeldByCurrentThread();
}

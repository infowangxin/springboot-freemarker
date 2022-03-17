package cn.springboot.framework.locks;

/**
 * <h3>读写锁接口</h3>
 *
 * <p>
 * ReadWriteLock 维护了一对相关的锁，一个用于只读操作，另一个用于写入操作。
 * 只要没有 writer，读取锁可以由多个 reader 线程同时保持，写入锁是独占的。 </br>
 * 与互斥锁相比，读写锁允许对共享数据进行更高级别的并发访问。
 * 一次只有一个线程（writer 线程）可以修改共享数据，任何数量的线程可以同时读取共享数据（reader 线程）。</br>
 * 若读锁已经存在，则写锁不能被获取，必须等待读锁释放。
 * 若写锁已经存在，则不同线程的读锁不能被获取，但是相同线程内的读锁可以被获取。
 * </p>
 *
 * @author 胡桃夹子
 */
public interface ReadWriteLock {

    /**
     * <h3>获取读锁</h3>
     *
     * @return 返回读锁对象
     */
    MutexLock readLock();

    /**
     * <h3>获取写锁</h3>
     *
     * @return 返回写锁对象
     */
    MutexLock writeLock();

}

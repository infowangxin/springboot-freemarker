package cn.springboot.framework.locks;

/**
 * <h3>分布式锁工厂接口</h3>
 *
 * <p>
 * 为了方便分布式锁的使用，所有分布式锁的实例对象全部由分布式锁工厂负责提供。
 * 不能单独构造实例化分布式锁对象。
 * </p>
 *
 * <p>
 * 异常处理 ：构造分布式锁实例时，任何错误都会导致抛出运行时异常 {@link cn.springboot.framework.locks.exception.BuildLockException BuildLockException}
 * </p>
 *
 * @author 胡桃夹子
 */
public interface DistributedLockFactory {

    /**
     * <h3>创建互斥锁实例对象</h3>
     *
     * @param name 锁的名称
     * @return 互斥锁实例对象
     * @see MutexLock
     */
    MutexLock buildMutexLock(String name);

    /**
     * <h3>创建读写锁实例对象</h3>
     *
     * @param name 锁的名称
     * @return 读写锁实例对象
     * @see ReadWriteLock
     */
    ReadWriteLock buildReadWriteLock(String name);

    /**
     * <h3>创建共享锁实例对象</h3>
     *
     * @param name     锁的名称
     * @param poolSize 共享池的大小，必须大于等于 1
     * @return 共享锁实例对象
     * @see SharedLock
     */
    SharedLock buildSharedLock(String name, int poolSize);
}

package cn.springboot.framework.locks;

import java.util.concurrent.TimeUnit;

/**
 * <h3>共享锁接口</h3>
 *
 * <p>
 * 指定共享锁池的大小，可以被不同线程共享的锁，获取锁的线程都可以访问共享资源。
 * 同一线程可以一次性获取多个锁，这些锁不能分开获取，锁池必须能够一次性提供。
 * </p>
 *
 * @author 胡桃夹子
 */
public interface SharedLock extends DistributedLock {

    /**
     * <h3>获取指定数量的锁</h3>
     *
     * @param qty 获取锁的数量，必须大于等于 1，并且不能大于共享锁的总数量
     *            <p>
     *            能一次性获取指定数量的锁才算成功获取</br>
     *            若无法获取锁，则当前线程阻塞，直到成功获取锁为止
     */
    void lock(int qty);

    /**
     * <h3>尝试获取指定数量的锁</h3>
     *
     * @param qty 获取锁的数量，必须大于等于 1，并且不能大于共享锁的总数量
     * @return 成功获取锁立即返回 true，否则立即返回 false
     * <p>
     * 能一次性获取指定数量的锁才算成功获取，也就是锁池空闲锁的数量必须能够满足。
     */
    boolean tryLock(int qty);

    /**
     * <h3>在限定时间内获取指定数量的锁</h3>
     *
     * @param qty  获取锁的数量，必须大于等于 1，并且不能大于共享锁的总数量
     * @param time 时间数值，长整形数字，必须大于等于 1
     * @param unit 时间单位
     * @return 成功获取锁返回 true，否则返回 false
     * @see TimeUnit
     * <p>
     * 能一次性获取指定数量的锁才算成功获取，也就是锁池空闲锁的数量必须能够满足。
     */
    boolean tryLock(int qty, long time, TimeUnit unit);

    /**
     * <h3>释放指定数量的锁</h3>
     *
     * @param qty 释放锁的数量，必须大于等于 1，并且不能大于已经获取的锁的数量
     *            <p>
     *            必须和lock()、tryLock()成对使用，释放锁后共享锁池大小将会增加。
     */
    void unlock(int qty);

    /**
     * <h3>获取当前共享锁实例的锁数量</h3>
     *
     * @return 当前共享锁实例中所获取的锁数量
     */
    int getInstanceLocks();

    /**
     * <h3>获取当前共享锁池中的锁数量</h3>
     *
     * @return 当前共享锁池中的锁数量，按锁名称进行统计，包含其它锁实例所获取的锁
     */
    int getTotalLocks();
}

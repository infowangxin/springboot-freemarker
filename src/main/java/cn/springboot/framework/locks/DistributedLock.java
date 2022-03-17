package cn.springboot.framework.locks;

import java.util.concurrent.TimeUnit;

/**
 * <h3>分布式锁接口</h3>
 *
 * <p>
 * 分布式锁是控制不同JVM下的多个线程对共享资源进行访问的工具。
 * 通常，锁提供了对共享资源的独占访问。
 * 一次只能有一个线程获得锁，对共享资源的所有访问都需要首先获得锁。
 * 不过，某些锁可能允许对共享资源并发访问，如 {@link cn.springboot.framework.locks.ReadWriteLock ReadWriteLock} 的读取锁，共享锁 {@link cn.springboot.framework.locks.SharedLock SharedLock} 。
 * </p>
 *
 * @author 胡桃夹子
 */
public interface DistributedLock {

    /**
     * <h3>获取锁</h3>
     * <p>
     * 若无法获取锁，则当前线程阻塞，直到成功获取锁为止。</br></br>
     * 代码示例：</br>
     * <pre>
     * lock.lock();
     * try {
     *   //操作共享资源的代码
     * }
     * finally {
     *   lock.unlock();
     * }
     * </pre>
     *
     * <p>
     * 异常处理 ：任何错误都会导致抛出运行时异常 {@link cn.springboot.framework.locks.exception.LockException LockException}
     * </p>
     */
	void lock();

    /**
     * <h3>尝试获取空闲状态的锁</h3>
     * <p>
     * 若存在可用的锁，则获取并立即返回 true，否则立即返回 false，线程不会阻塞。</br></br>
     * 代码示例：</br>
     * <pre>
     * if(lock.tryLock()) {
     *   try {
     *     //操作共享资源的代码
     *   }
     *   finally {
     *     lock.unlock();
     *   }
     * } else {
     *    //无法获取锁时的处理代码
     * }
     * </pre>
     *
     * <p>
     * 异常处理 ：任何错误都会导致抛出运行时异常 {@link cn.springboot.framework.locks.exception.LockException LockException}
     * </p>
     *
     * @return 成功获取锁返回 true，否则返回 false
     */
	boolean tryLock();

    /**
     * <h3>在限定时间内获取空闲状态的锁</h3>
     * <p>
     * 若存在可用的锁，则获取并立即返回 true，否则会在限定时间内不停尝试获取，直到成功获取返回 true 或者失败返回 false。</br></br>
     * 代码示例：</br>
     * <pre>
     * if(lock.tryLock(1, TimeUnit.SECONDS)) {
     *   try {
     *     //操作共享资源的代码
     *   }
     *   finally {
     *     lock.unlock();
     *   }
     * }else{
     *   //无法获取锁时的处理代码
     * }
     * </pre>
     *
     * <p>
     * 异常处理 ：任何错误都会导致抛出运行时异常 {@link cn.springboot.framework.locks.exception.LockException LockException}
     * </p>
     *
     * @param time 时间数值，长整形数字，必须大于等于 1
     * @param unit 时间单位
     * @return 成功获取锁返回 true，否则返回 false
     * @see TimeUnit
     */
	boolean tryLock(long time, TimeUnit unit);

    /**
     * <h3>释放锁</h3>
     * <p>
     * 必须和lock()，tryLock()成对使用，由持有锁的对象释放锁。</br></br>
     *
     * <p>
     * 异常处理 ：任何错误都会导致抛出运行时异常 {@link cn.springboot.framework.locks.exception.UnLockException UnLockException}
     * </p>
     */
	void unlock();
}

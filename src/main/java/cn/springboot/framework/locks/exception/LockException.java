package cn.springboot.framework.locks.exception;

/**
 * <p>获取锁运行时异常</p>
 *
 * @author 胡桃夹子
 */
public class LockException extends RuntimeException {

    private static final long serialVersionUID = -1881390443685916800L;

    public LockException(String message) {
        super(message);
    }

    public LockException(String message, Throwable cause) {
        super(message, cause);
    }
}

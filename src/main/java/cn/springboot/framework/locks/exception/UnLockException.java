package cn.springboot.framework.locks.exception;

/**
 * <p>解锁运行时异常</p>
 *
 * @author 胡桃夹子
 */
public class UnLockException extends RuntimeException {

    private static final long serialVersionUID = -2298723230022810352L;

    public UnLockException(String message) {
        super(message);
    }

    public UnLockException(String message, Throwable cause) {
        super(message, cause);
    }
}

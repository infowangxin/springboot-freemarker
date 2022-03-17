package cn.springboot.framework.locks.exception;

/**
 * <p>创建锁运行时异常</p>
 *
 * @author 胡桃夹子
 */
public class BuildLockException extends RuntimeException {

    private static final long serialVersionUID = 3875257035681233457L;

    public BuildLockException(String message) {
        super(message);
    }

    public BuildLockException(String message, Throwable cause) {
        super(message, cause);
    }
}

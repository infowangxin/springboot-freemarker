package cn.springboot.framework.exception;

/**
 * 自定义异常类
 *
 * @author 胡桃夹子
 * @date 2021/11/19 13:54
 */
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 2248546206040115304L;
    /**
     * 错误码
     */
    private String code;

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public String getCode() {
        return this.code;
    }
}

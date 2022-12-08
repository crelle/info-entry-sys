package baseline.common.exception;

import baseline.common.enumeration.ResponseEnum;

public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = -330737451734079004L;
    private String code;
    private String message;

    public BusinessException() {
        super();
    }

    public BusinessException(ResponseEnum exceptionEnum) {
        this.code = exceptionEnum.getCode();
        this.message = exceptionEnum.getMessage();
    }

    public BusinessException(Throwable throwable) {
        this.code = ResponseEnum.UNKNOWN.getCode();
        this.message = throwable.getMessage();
    }

    public BusinessException(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public BusinessException(String code, String message, Object... args) {
        this.code = code;
        this.message = String.format(message, args);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

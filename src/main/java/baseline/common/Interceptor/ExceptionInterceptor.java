package baseline.common.Interceptor;

import baseline.common.enumeration.ResponseEnum;
import baseline.common.exception.BusinessException;
import baseline.common.pojo.vo.ResponseResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.sql.SQLSyntaxErrorException;

@RestControllerAdvice
public class ExceptionInterceptor {


    /**
     * 业务异常处理
     */
    @ExceptionHandler(value = BusinessException.class)
    public ResponseResult exceptionHandler(BusinessException e) {
        return ResponseResult.fail(StringUtils.isBlank(e.getCode()) ? e.getCode() : ResponseEnum.UNKNOWN.getCode(), e.getMessage());
    }

    /**
     * 未知异常处理
     */
    @ExceptionHandler(value = Exception.class)
    public ResponseResult exceptionHandler(Exception e) {
        return ResponseResult.fail(ResponseEnum.UNKNOWN.getCode(),
                ResponseEnum.UNKNOWN.getMessage());
    }

    /**
     * 空指针异常
     */
    @ExceptionHandler(value = NullPointerException.class)
    public ResponseResult exceptionHandler(NullPointerException e) {
        return ResponseResult.fail(ResponseEnum.SERVER_ERROR.getCode(),
                ResponseEnum.SERVER_ERROR.getMessage());
    }

    /**
     * sql语法异常
     */
    @ExceptionHandler(value = SQLSyntaxErrorException.class)
    public ResponseResult exceptionHandler(SQLSyntaxErrorException e) {
        return ResponseResult.fail(ResponseEnum.SERVER_ERROR.getCode(),
                ResponseEnum.SERVER_ERROR.getMessage());
    }

    /**
     * validation框架MethodArgumentNotValidException异常处理
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseResult exceptionHandler(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        StringBuffer sb = new StringBuffer("参数校验失败:");
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            sb.append(fieldError.getField()).append(":").append(fieldError.getDefaultMessage()).append(",");
        }
        String msg = sb.toString();
        return ResponseResult.fail(ResponseEnum.FAIL.getCode(), msg);
    }

    /**
     * alidation框架ConstraintViolationException异常处理
     */
    @ExceptionHandler(value = ConstraintViolationException.class)
    public ResponseResult exceptionHandler(ConstraintViolationException e) {
        return ResponseResult.fail(ResponseEnum.FAIL.getCode(), e.getMessage());
    }

}

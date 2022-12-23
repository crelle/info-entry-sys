package baseline.common.Interceptor;

import baseline.common.enumeration.ResponseEnum;
import baseline.common.exception.BusinessException;
import baseline.common.pojo.vo.ResponseResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

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

}

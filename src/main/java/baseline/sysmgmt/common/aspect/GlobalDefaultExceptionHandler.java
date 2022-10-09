package baseline.sysmgmt.common.aspect;

import baseline.sysmgmt.common.ResponseResult;
import baseline.sysmgmt.common.util.ResultUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * @author:crelle
 * @className:GlobalDefaultExceptionHandler
 * @version:1.0.0
 * @date:2021/4/12
 * @description:使用切面统一异常处理，这个无法处理springSecurity的异常，因为springSecurity的异常是在过滤器中拦截的，代码中无法拦截。
 * 需要配置springSecurity相应的handler来处理
 **/
@Component
public class GlobalDefaultExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public ResponseResult<String> defaultExceptionHandler(HttpServletRequest req, Exception e) {

        String a = null;
        return ResultUtils.fail("权限不足！");

    }


}

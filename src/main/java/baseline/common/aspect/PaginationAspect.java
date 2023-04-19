package baseline.common.aspect;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.ArrayUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PaginationAspect {

    @Pointcut("@annotation(baseline.common.annotation.EnablePagination)")
    public void addAdvice() {
    }

    @Around("addAdvice()")
    public Object interceptor(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result = null;
        Object[] args = joinPoint.getArgs();
        Integer pageNum = null;
        Integer pageSize = null;
        if (ArrayUtils.isNotEmpty(args)) {
            Page page = (Page) args[0];
            pageNum = (int) page.getCurrent();
            pageSize = (int) page.getSize();
        }
        if (pageNum != null) {
            PageHelper.startPage(pageNum, pageSize);
            result = joinPoint.proceed();
            PageHelper.clearPage();
        }
        return result;
    }

}

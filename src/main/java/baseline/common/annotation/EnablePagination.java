package baseline.common.annotation;

import java.lang.annotation.*;


/**
 * 标记一个方法是否需要分页
 */
@Target(ElementType.METHOD)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface EnablePagination {
}

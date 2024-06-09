package com.qxc.blog.AOPInterceptor.AuthorNeed;

import java.lang.annotation.*;

/**
 * @Author qxc
 * @Date 2024 2024/6/2 下午7:59
 * @Version 1.0
 * @PACKAGE com.qxc.blog.AOPInterceptor.AuthorNeed
 */
@Inherited
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface AuthorNeed {
    boolean value() default true;
}

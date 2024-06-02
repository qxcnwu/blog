package com.qxc.blog.AOPInterceptor.AuthorNeed;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Target;

/**
 * @Author qxc
 * @Date 2024 2024/6/2 下午7:59
 * @Version 1.0
 * @PACKAGE com.qxc.blog.AOPInterceptor.AuthorNeed
 */
@Inherited
@Documented
@Target({ElementType.METHOD})
public @interface AuthorNeed {
    boolean value() default true;
}

package com.qxc.blog.aopInterceptor.LocalHandlerInterceptor;

import java.lang.annotation.*;

/**
 * @Author qxc
 * @Date 2024 2024/6/3 下午10:59
 * @Version 1.0
 * @PACKAGE com.qxc.blog.aopInterceptor.LocalHandlerInterceptor
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OnlyLocalHost {
    boolean value() default true;
}

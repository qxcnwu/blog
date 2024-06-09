package com.qxc.blog.aopInterceptor.aop.LogRecod;

import java.lang.annotation.*;

/**
 * @Author qxc
 * @Date 2024 2024/6/8 下午2:59
 * @Version 1.0
 * @PACKAGE com.qxc.blog.aopInterceptor.LogRecod
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
@Inherited
public @interface LogRecord {
    /**
     * 是否记录
     *
     * @return
     */
    boolean value() default true;

    /**
     * 记录入参
     *
     * @return
     */
    boolean param() default false;

    /**
     * 记录出参
     *
     * @return
     */
    boolean result() default true;

    /**
     * 是否记录时间
     *
     * @return
     */
    boolean time() default false;

    /**
     * 记录异常
     *
     * @return
     */
    boolean exception() default true;
}

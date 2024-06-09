package com.qxc.blog.Utiles;

import org.aspectj.lang.reflect.MethodSignature;
import org.jetbrains.annotations.NotNull;

import java.lang.annotation.Annotation;

/**
 * @Author qxc
 * @Date 2024 2024/6/8 下午3:11
 * @Version 1.0
 * @PACKAGE com.qxc.blog.Utiles
 */
public class AopUtiles {
    /**
     * 获取对应的注解
     * @param tClass
     * @param methodSignature
     * @return
     * @param <T>
     */
    public static <T extends Annotation> T getAnnotation(Class<T> tClass, @NotNull MethodSignature methodSignature) {
        return methodSignature.getMethod().getAnnotation(tClass);
    }
}

package com.qxc.blog.AOPInterceptor.LogRecod;

import com.qxc.blog.Utiles.AopUtiles;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

/**
 * @Author qxc
 * @Date 2024 2024/6/8 下午3:03
 * @Version 1.0
 * @PACKAGE com.qxc.blog.AOPInterceptor.LogRecod
 */
@Component
@Aspect
@Slf4j
public class LogRecordHandler {
    @Pointcut("@annotation(com.qxc.blog.AOPInterceptor.LogRecod.LogRecord)")
    public void logRecord() {
    }

    @Around("logRecord()")
    public Object logMethod(@NotNull ProceedingJoinPoint joinPoint) throws Throwable {
        final MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        final String methodName = signature.getMethod().toGenericString();
        final LogRecord annotation = AopUtiles.getAnnotation(LogRecord.class, signature);
        // 如果不记录直接返回
        if (!annotation.result()) {
            return joinPoint.proceed();
        }
        // 讨论记录时间
        Long startTime = null;
        if (annotation.time()) {
            startTime = System.currentTimeMillis();
        }
        // 记录入参
        if (annotation.param()) {
            log.info("{} input params: {}", methodName, joinPoint.getArgs());
        }
        final Object result = joinPoint.proceed();
        // 记录结果
        if (annotation.result()) {
            if (annotation.time()) {
                log.info("{} output result: {},cost: {} ms", methodName, result, System.currentTimeMillis() - startTime);
            } else {
                log.info("{} output result: {}", methodName, result);
            }
        }
        return result;
    }

    @AfterThrowing(value = "logRecord()", throwing = "exception")
    public void logAfterThrowing(@NotNull JoinPoint joinPoint, Exception exception) throws Exception {
        final MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        final LogRecord annotation = AopUtiles.getAnnotation(LogRecord.class, signature);
        if (annotation.exception()) {
            log.error("{} throws exception: {}", signature.getMethod().toGenericString(), exception.getMessage());
        }
    }
}

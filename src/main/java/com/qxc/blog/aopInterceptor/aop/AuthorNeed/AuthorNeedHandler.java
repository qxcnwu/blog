package com.qxc.blog.aopInterceptor.aop.AuthorNeed;

import com.qxc.blog.pojo.BlogUser;
import com.qxc.blog.self.Result;
import com.qxc.blog.service.impl.RedisServerUtiles;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @Author qxc
 * @Date 2024 2024/6/2 下午8:16
 * @Version 1.0
 * @PACKAGE com.qxc.blog.aopInterceptor.AuthorNeed
 */
@Aspect
@Component
@Slf4j
public class AuthorNeedHandler {

    @Resource
    private RedisServerUtiles redisServerUtiles;

    @Pointcut("@annotation(com.qxc.blog.aopInterceptor.aop.AuthorNeed.AuthorNeed)&&args(String,..,com.qxc.blog.pojo.BlogUser)")
    public void authorNeed() {
    }

    @Around("authorNeed()")
    public Object validateParam(@NotNull ProceedingJoinPoint joinPoint) throws Throwable {
        final Object[] args = joinPoint.getArgs();
        String token = (String) args[0];
        final BlogUser blogUser = redisServerUtiles.getUserByToken(token);
        if (Objects.isNull(blogUser)) {
            log.error("Please login first!");
            final Class<?> aClass = ((MethodSignature) joinPoint.getSignature()).getReturnType();
            return Result.needLoginResult(aClass);
        }
        args[args.length - 1] = blogUser;
        return joinPoint.proceed(args);
    }
}

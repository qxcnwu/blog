package com.qxc.blog.AOPInterceptor.LocalHandlerInterceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * @Author qxc
 * @Date 2024 2024/6/3 下午11:07
 * @Version 1.0
 * @PACKAGE com.qxc.blog.AOPInterceptor.LocalHandlerInterceptor
 */
@Configuration
@Slf4j
public class WebConfiguration implements WebMvcConfigurer {
    @Resource
    private LocalHandlerInterceptor localHandlerInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        log.info("本地访问拦截器!");
        registry.addInterceptor(localHandlerInterceptor);
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}

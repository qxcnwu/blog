package com.qxc.blog;

import com.qxc.blog.AOPInterceptor.HotfixEvent.HotfixEvent;
import com.qxc.blog.AOPInterceptor.HotfixEvent.HotfixEventPublisher;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
@MapperScan(basePackages = {"com.qxc.blog.dao"})
@Slf4j
public class BlogApplication {

    public static void main(String[] args) {
        final ConfigurableApplicationContext applicationContext = SpringApplication.run(BlogApplication.class, args);
        // 预热
        applicationContext.getBean(HotfixEventPublisher.class).publishHotfixEvent(new HotfixEvent());
        log.info("application start finished!");
    }

}

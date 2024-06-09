package com.qxc.blog.aopInterceptor.event.hotfixEvent;

import com.qxc.blog.aopInterceptor.PublishEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author qxc
 * @Date 2024 2024/6/2 下午9:03
 * @Version 1.0
 * @PACKAGE com.qxc.blog.aopInterceptor.hotfixEvent
 */
@Component
public class HotfixEventPublisher implements PublishEvent {
    @Resource
    private ApplicationContext applicationContext;

    /**
     * 发布消息
     *
     * @param applicationEvent
     */
    @Override
    public void publish(ApplicationEvent applicationEvent) {
        applicationContext.publishEvent(applicationEvent);
    }
}

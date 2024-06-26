package com.qxc.blog.aopInterceptor;

import org.springframework.context.ApplicationEvent;

/**
 * @Author qxc
 * @Date 2024 2024/6/6 下午10:57
 * @Version 1.0
 * @PACKAGE com.qxc.blog.aopInterceptor
 */
public interface PublishEvent {
    /**
     * 发布消息
     * @param applicationEvent
     */
    void publish(ApplicationEvent applicationEvent);
}

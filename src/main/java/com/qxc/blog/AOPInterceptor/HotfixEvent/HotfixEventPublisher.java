package com.qxc.blog.AOPInterceptor.HotfixEvent;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author qxc
 * @Date 2024 2024/6/2 下午9:03
 * @Version 1.0
 * @PACKAGE com.qxc.blog.AOPInterceptor.HotfixEvent
 */
@Component
public class HotfixEventPublisher {
    @Resource
    private ApplicationContext applicationContext;

    public void publishHotfixEvent(HotfixEvent hotfixEvent) {
        applicationContext.publishEvent(hotfixEvent);
    }
}

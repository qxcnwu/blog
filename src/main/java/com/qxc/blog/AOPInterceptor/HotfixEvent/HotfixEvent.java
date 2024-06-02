package com.qxc.blog.AOPInterceptor.HotfixEvent;

import org.springframework.context.ApplicationEvent;

import java.time.Clock;

/**
 * @Author qxc
 * @Date 2024 2024/6/2 下午9:01
 * @Version 1.0
 * @PACKAGE com.qxc.blog.AOPInterceptor.HotfixEvent
 */
public class HotfixEvent extends ApplicationEvent {
    public HotfixEvent(Object source) {
        super(source);
    }

    public HotfixEvent(Object source, Clock clock) {
        super(source, clock);
    }

    public HotfixEvent() {
        super(new Object());
    }
}

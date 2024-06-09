package com.qxc.blog.aopInterceptor.event.blogEvent;

import com.qxc.blog.self.BlogEventEnum;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

import java.time.Clock;
import java.util.List;

/**
 * @Author qxc
 * @Date 2024 2024/6/2 下午9:01
 * @Version 1.0
 * @PACKAGE com.qxc.blog.aopInterceptor.hotfixEvent
 */
@Getter
public class BlogEvent extends ApplicationEvent {

    private List<String> articleId;
    private BlogEventEnum eventType;

    public BlogEvent(String articleId, BlogEventEnum eventType) {
        this(List.of(new String[]{articleId}), eventType);
    }

    public BlogEvent(List<String> articleId, BlogEventEnum eventType) {
        super(new Object());
        this.articleId = articleId;
        this.eventType = eventType;
    }

    public BlogEvent(Object source, Clock clock) {
        super(source, clock);
    }

    public BlogEvent() {
        super(new Object());
    }
}

package com.qxc.blog.service.impl;

import com.qxc.blog.aopInterceptor.event.hotfixEvent.HotfixEvent;
import com.qxc.blog.configuration.RedisConfiguration;
import com.qxc.blog.pojo.BlogUser;
import jakarta.annotation.Nullable;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.redisson.api.RedissonClient;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @Author qxc
 * @Date 2024 2024/6/2 下午8:44
 * @Version 1.0
 * @PACKAGE com.qxc.blog.service.impl
 */
@Service
@Slf4j
public class RedisServerUtiles implements ApplicationListener<HotfixEvent> {
    @Resource
    private RedissonClient redissonClient;

    @Resource
    private RedisConfiguration redisConfiguration;

    /**
     * 获取
     *
     * @param token
     * @return
     */
    public @Nullable BlogUser getUserByToken(String token) {
        final Object object = redissonClient.getMapCache(redisConfiguration.getUserKey()).remove(token);
        if (Objects.isNull(object)) {
            return null;
        }
        // 更新
        setUserByToken(token, (BlogUser) object);
        return (BlogUser) object;
    }

    /**
     * 存储
     *
     * @param token
     * @param user
     */
    public void setUserByToken(String token, BlogUser user) {
        redissonClient.getMapCache(redisConfiguration.getUserKey()).put(token, user, redisConfiguration.getExpireTime().get(redisConfiguration.getUserKey()), TimeUnit.SECONDS);
    }

    /**
     * 用户登出移除token
     * @param token
     * @return
     */
    public boolean removeUserByToken(String token) {
        return !Objects.isNull(redissonClient.getMapCache(redisConfiguration.getUserKey()).remove(token));
    }


    @Override
    public void onApplicationEvent(@NotNull HotfixEvent event) {
        log.info("redis hotfix start");
    }
}

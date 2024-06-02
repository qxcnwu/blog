package com.qxc.blog.configuration;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.HashMap;

/**
 * @Author qxc
 * @Date 2024 2024/6/2 下午9:08
 * @Version 1.0
 * @PACKAGE com.qxc.blog.configuration
 */
@Configuration
@Slf4j
@PropertySource("classpath:blog.properties")
@Data
public class RedisConfiguration {
    @Value("${redis-key.user-key}")
    private String userKey;

    @Value("#{${redis-key.expire-time}}")
    private HashMap<String, Integer> expireTime;
}

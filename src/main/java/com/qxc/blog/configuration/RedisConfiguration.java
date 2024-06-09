package com.qxc.blog.configuration;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author qxc
 * @Date 2024 2024/6/2 下午9:08
 * @Version 1.0
 * @PACKAGE com.qxc.blog.configuration
 */
@Configuration
@Slf4j
@Data
public class RedisConfiguration {
    @Value("${rediskey.userKey}")
    private String userKey;
    @Value("#{${rediskey.expireTime}}")
    private Map<String, Integer> expireTime;
}

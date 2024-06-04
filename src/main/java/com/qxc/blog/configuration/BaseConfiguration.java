package com.qxc.blog.configuration;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @Author qxc
 * @Date 2024 2024/6/2 下午4:03
 * @Version 1.0
 * @PACKAGE com.qxc.blog.configuration
 */
@Configuration
@Slf4j
@ConfigurationProperties(prefix = "base")
@PropertySource("classpath:blog.properties")
@Data
public class BaseConfiguration {
    private String preUrl;
    private String ipv4Url;
    private String ipv6Url;
    private String jwtCreat;
    private String cookieName;
}

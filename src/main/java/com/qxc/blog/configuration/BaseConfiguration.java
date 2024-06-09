package com.qxc.blog.configuration;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
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
@Data
public class BaseConfiguration {
    @Value("${base.preUrl}")
    private String preUrl;
    @Value("${base.ipv4Url}")
    private String ipv4Url;
    @Value("${base.ipv6Url}")
    private String ipv6Url;
    @Value("${base.jwtCreat}")
    private String jwtCreat;
    @Value("${base.cookieName}")
    private String cookieName;
    @Value("${base.rootRS}")
    private String rootRS;
    @Value("${base.baseName}")
    private String baseName;
    @Value("${base.baseTitle}")
    private String baseTitle;
}

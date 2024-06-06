package com.qxc.blog.configuration;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @Author qxc
 * @Date 2024 2024/6/6 下午10:05
 * @Version 1.0
 * @PACKAGE com.qxc.blog.configuration
 */
@Configuration
@Slf4j
@ConfigurationProperties(prefix = "out-time")
@PropertySource("classpath:blog.properties")
@Data
public class OutTimeConfiguration {
    int addLogTime;
}

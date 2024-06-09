package com.qxc.blog.configuration;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @Author qxc
 * @Date 2024 2024/6/2 下午3:51
 * @Version 1.0
 * @PACKAGE com.qxc.blog.configuration
 */
@Configuration
@Slf4j
@Data
public class PathConfiguration {
    @Value("${upload.uploadImagePath}")
    public String uploadImagePath;
    @Value("${upload.uploadImageTmpPath}")
    public String uploadImageTmpPath;
    @Value("${upload.uploadAttachmentPath}")
    public String uploadAttachmentPath;
    @Value("${upload.uploadAttachmentTmpPath}")
    public String uploadAttachmentTmpPath;
}

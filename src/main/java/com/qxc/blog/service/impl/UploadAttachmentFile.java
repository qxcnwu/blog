package com.qxc.blog.service.impl;

import com.qxc.blog.configuration.BaseConfiguration;
import com.qxc.blog.configuration.PathConfiguration;
import com.qxc.blog.self.ResultEnum;
import com.qxc.blog.pojo.BlogUser;
import com.qxc.blog.self.AttachmentResult;
import com.qxc.blog.service.UploadFileServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

/**
 * @Author qxc
 * @Date 2024 2024/6/2 下午6:52
 * @Version 1.0
 * @PACKAGE com.qxc.blog.service.impl
 */
@Service
@Slf4j
public class UploadAttachmentFile extends UploadFileServiceImpl implements InitializingBean {

    @Resource
    private PathConfiguration pathConfiguration;

    @Resource
    private BaseConfiguration baseConfiguration;

    private String attachmentBaseDir;
    private String attachmentTmpBaseDir;
    private String preUrl;

    /**
     * 上传文件
     *
     * @param file 文件
     * @param user 用户
     * @return
     */
    @Override
    public AttachmentResult uploadFile(MultipartFile file, BlogUser user) {
        AttachmentResult attachmentResult = new AttachmentResult();
        try {
            final String saveDir = getSaveDir(user);
            final String hashed = hashFile(file, saveDir);
            // 获取下载连接
            final String url = getUrl(user, hashed);
            // 拼接
            attachmentResult.setState(ResultEnum.UPLOADATTACHMENTSUCCESS);
            attachmentResult.setUrl(url);
        } catch (IOException | NoSuchAlgorithmException e) {
            log.error("upload attachment error", e);
            attachmentResult.setState(ResultEnum.UPLOADIMAGESUCCESS);
        }
        return attachmentResult;
    }

    /**
     * 获取基础保存路径
     *
     * @param user
     * @return
     */
    @Override
    public String getSaveBaseDir(@NotNull BlogUser user) {
        return Path.of(attachmentBaseDir,user.getName()).toString();
    }

    @Override
    public File getTmpPath() {
        final Path path = Path.of(attachmentTmpBaseDir, UUID.randomUUID().toString());
        return path.toFile();
    }

    @Override
    public String getUrl(@NotNull BlogUser user, String name) {
        return preUrl + "/attachment/" + user.getName() + "/" + name;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.attachmentBaseDir = pathConfiguration.getUploadAttachmentPath();
        this.attachmentTmpBaseDir = pathConfiguration.getUploadAttachmentTmpPath();
        this.preUrl = baseConfiguration.getPreUrl();
    }
}

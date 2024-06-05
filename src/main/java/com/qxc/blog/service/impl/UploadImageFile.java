package com.qxc.blog.service.impl;

import com.qxc.blog.configuration.BaseConfiguration;
import com.qxc.blog.configuration.PathConfiguration;
import com.qxc.blog.self.ResultEnum;
import com.qxc.blog.pojo.BlogUser;
import com.qxc.blog.self.ImageResult;
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
 * @Date 2024 2024/6/2 下午3:50
 * @Version 1.0
 * @PACKAGE com.qxc.blog.service.impl
 */
@Service
@Slf4j
public class UploadImageFile extends UploadFileServiceImpl implements InitializingBean {

    @Resource
    private PathConfiguration pathConfiguration;

    @Resource
    private BaseConfiguration baseConfiguration;

    private String imageBaseDir;
    private String imageTmpBaseDir;
    private String preUrl;

    /**
     * 上传文件
     *
     * @param file 文件
     * @param user 用户
     * @return
     */
    @Override
    public ImageResult uploadFile(MultipartFile file, BlogUser user) {
        ImageResult imageResult = new ImageResult();
        try {
            final String saveDir = getSaveDir(user);
            final String hashed = hashFile(file, saveDir);
            // 获取下载连接
            final String url = getUrl(user, hashed);
            // 拼接
            imageResult.setState(ResultEnum.UPLOADIMAGESUCCESS);
            imageResult.setUrl(url);
        } catch (IOException | NoSuchAlgorithmException e) {
            log.error("upload image error", e);
            imageResult.setState(ResultEnum.UPLOADIMAGEERROR);
        }
        return imageResult;
    }

    /**
     * 获取基础保存路径
     *
     * @param user
     * @return
     */
    @Override
    public String getSaveBaseDir(@NotNull BlogUser user) {
        return Path.of(imageBaseDir,user.getName()).toString();
    }

    @Override
    public File getTmpPath() {
        final Path path = Path.of(imageTmpBaseDir, UUID.randomUUID().toString());
        return path.toFile();
    }

    @Override
    public String getUrl(@NotNull BlogUser user, String name) {
        return preUrl + "/image/" + user.getName() + "/" + name;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.imageBaseDir = pathConfiguration.getUploadImagePath();
        this.imageTmpBaseDir = pathConfiguration.getUploadImageTmpPath();
        this.preUrl = baseConfiguration.getPreUrl();
    }
}

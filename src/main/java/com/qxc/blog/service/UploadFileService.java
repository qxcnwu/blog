package com.qxc.blog.service;

import com.qxc.blog.pojo.BlogUser;
import com.qxc.blog.self.Result;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/**
 * @Author qxc
 * @Date 2024 2024/6/2 下午2:47
 * @Version 1.0
 * @PACKAGE com.qxc.blog.service
 */
public interface UploadFileService {
    /**
     * 上传文件
     *
     * @param file 文件
     * @param user 用户
     * @return
     */
    Result uploadFile(MultipartFile file, BlogUser user);

    /**
     * 查询文件md5
     *
     * @param file
     * @return
     */
    String hashFile(MultipartFile file, String saveDir) throws IOException, NoSuchAlgorithmException;

    /**
     * 获取保存路径
     *
     * @param name
     * @param user
     * @return
     */
    String getSaveDir(BlogUser user);

    /**
     * 创建保存路径
     *
     * @param path
     */
    void createSaveDir(String path);

    /**
     * 获取基础保存路径
     *
     * @param user
     * @return
     */
    String getSaveBaseDir(BlogUser user);

    File getTmpPath();

    String getUrl(BlogUser user,String name);
}

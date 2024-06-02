package com.qxc.blog.service;

import com.qxc.blog.pojo.BlogUser;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

/**
 * @Author qxc
 * @Date 2024 2024/6/2 下午3:26
 * @Version 1.0
 * @PACKAGE com.qxc.blog.service.impl
 */
public abstract class UploadFileServiceImpl implements UploadFileService {

    /**
     * 查询文件md5
     *
     * @param file
     * @return
     */
    @Override
    public String hashFile(@NotNull MultipartFile file, String saveDir) throws IOException, NoSuchAlgorithmException {
        // 获取文件后缀
        String name = file.getOriginalFilename();
        if (name != null) {
            name = name.substring(name.lastIndexOf("."));
        } else {
            name = "png";
        }
        final String hashed = UUID.randomUUID().toString();
        // 计算新文件名并保存
        final String fName = hashed + "." + name;
        final Path path = Path.of(saveDir, fName);
        file.transferTo(path.toFile());
        return fName;
    }

    /**
     * 获取保存路径
     *
     * @param name
     * @param user
     * @return
     */
    @Override
    public String getSaveDir(BlogUser user) {
        String saveBaseDir = getSaveBaseDir(user);
        // 创建文件夹
        createSaveDir(saveBaseDir);
        return saveBaseDir;
    }

    /**
     * 创建保存路径
     *
     * @param path
     */
    @Override
    public void createSaveDir(String path) {
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
    }
}

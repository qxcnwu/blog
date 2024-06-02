package com.qxc.blog.controller;

import com.qxc.blog.AOPInterceptor.AuthorNeed.AuthorNeed;
import com.qxc.blog.pojo.BlogUser;
import com.qxc.blog.self.AttachmentResult;
import com.qxc.blog.self.ImageResult;
import com.qxc.blog.service.impl.UploadAttachmentFile;
import com.qxc.blog.service.impl.UploadImageFile;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * @Author qxc
 * @Date 2024 2024/6/2 下午2:22
 * @Version 1.0
 * @PACKAGE com.qxc.blog.controller
 */
@RestController
@RequestMapping("/upload")
public class UploadController {

    @Resource
    private UploadImageFile uploadImageFile;

    @Resource
    private UploadAttachmentFile uploadAttachmentFile;

    @AuthorNeed
    @PostMapping(value = "/image")
    public ImageResult uploadImage(@CookieValue(value = "token", defaultValue = "qxc") String token, @RequestParam("image") MultipartFile file, @RequestParam(required = false) BlogUser blogUser) {
        return uploadImageFile.uploadFile(file, blogUser);
    }

    @AuthorNeed
    @PostMapping(value = "/attachment")
    public AttachmentResult uploadAttachment(@CookieValue(value = "token", defaultValue = "qxc") String token, @RequestParam("attachment") MultipartFile file, @RequestParam(required = false) BlogUser blogUser) {
        return uploadAttachmentFile.uploadFile(file, blogUser);
    }
}

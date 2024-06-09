package com.qxc.blog.controller;

import com.qxc.blog.aopInterceptor.aop.AuthorNeed.AuthorNeed;
import com.qxc.blog.pojo.BlogUser;
import com.qxc.blog.self.BlogAndContent;
import com.qxc.blog.self.BlogResult;
import com.qxc.blog.service.impl.EditBlogServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @Author qxc
 * @Date 2024 2024/6/8 下午6:41
 * @Version 1.0
 * @PACKAGE com.qxc.blog.controller
 */
@RestController
@RequestMapping("/blog")
public class BlogController {

    @Resource
    private EditBlogServiceImpl editBlogService;

    @PostMapping("/create")
    @AuthorNeed
    public BlogResult create(@RequestParam(value = "token") String token, @RequestBody BlogAndContent blogAndContent, @RequestParam(required = false) BlogUser blogUser) throws Exception {
        // 初始化创建博客
        blogAndContent.setCreate();
        if (editBlogService.addBlog(blogUser, blogAndContent)) {
            return new BlogResult(blogAndContent.getBlog().getArticleid());
        }
        return BlogResult.getNullBlogResult();
    }

    @PostMapping("/update")
    @AuthorNeed
    public BlogResult update(@RequestParam(value = "token") String token, @RequestBody BlogAndContent blogAndContent, @RequestParam(required = false) BlogUser blogUser) throws Exception {
        // 初始化创建博客
        blogAndContent.setCreate();
        if (editBlogService.updateBlog(blogUser, blogAndContent)) {
            return new BlogResult(blogAndContent.getBlog().getArticleid());
        }
        return BlogResult.getNullBlogResult();
    }

    @PostMapping("/delete")
    @AuthorNeed
    public BlogResult delete(@RequestParam(value = "token") String token, @RequestBody BlogAndContent blogAndContent, @RequestParam(required = false) BlogUser blogUser) throws Exception {
        // 初始化创建博客
        blogAndContent.setCreate();
        if (editBlogService.deleteBlog(blogUser, blogAndContent)) {
            return new BlogResult(blogAndContent.getBlog().getArticleid());
        }
        return BlogResult.getNullBlogResult();
    }

    @GetMapping("/get/{articalId}")
    @AuthorNeed
    public BlogResult create(@RequestParam(value = "token") String token, @PathVariable("articalId") String articalId, @RequestParam(required = false) BlogUser blogUser) {
        final BlogAndContent blogById = editBlogService.getBlogById(blogUser, articalId);
        if (!Objects.isNull(blogById)) {
            return new BlogResult(blogById);
        }
        return BlogResult.getNullBlogResult();
    }
}

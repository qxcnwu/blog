package com.qxc.blog.controller;

import com.qxc.blog.AOPInterceptor.AuthorNeed.AuthorNeed;
import com.qxc.blog.pojo.BlogUser;
import com.qxc.blog.self.BlogAndContent;
import com.qxc.blog.self.BlogResult;
import com.qxc.blog.service.impl.EditBlogServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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
    public BlogResult create(@CookieValue(value = "token", defaultValue = "qxc") String token, @RequestBody BlogAndContent blogAndContent, @RequestParam(required = false) BlogUser blogUser) {
        return BlogResult.getNullBlogResult();
    }
}

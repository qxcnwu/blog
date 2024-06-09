package com.qxc.blog.controller;

import com.qxc.blog.pojo.BlogRelationship;
import com.qxc.blog.self.BlogChannelResult;
import com.qxc.blog.service.BlogRelationshipService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author qxc
 * @Date 2024 2024/6/9 下午3:51
 * @Version 1.0
 * @PACKAGE com.qxc.blog.controller
 */
@RestController
@RequestMapping("/channel")
public class BlogChannelController {
    @Resource
    private BlogRelationshipService blogRelationshipService;

    @GetMapping("/get/{articalId}")
    public BlogChannelResult get(@PathVariable String articalId) {
        final List<BlogRelationship> blogRelationShip = blogRelationshipService.getBlogRelationShip(articalId);
        return new BlogChannelResult(blogRelationShip);
    }
}

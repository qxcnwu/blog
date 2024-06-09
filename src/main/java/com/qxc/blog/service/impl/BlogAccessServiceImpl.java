package com.qxc.blog.service.impl;

import com.qxc.blog.pojo.Blog;
import com.qxc.blog.pojo.BlogRole;
import com.qxc.blog.pojo.BlogUser;
import com.qxc.blog.self.BlogEventEnum;
import com.qxc.blog.service.BlogAccessService;
import com.qxc.blog.service.BlogRoleService;
import com.qxc.blog.service.BlogService;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author qxc
 * @Date 2024 2024/6/8 下午6:50
 * @Version 1.0
 * @PACKAGE com.qxc.blog.service.impl
 */
@Service
public class BlogAccessServiceImpl implements BlogAccessService {
    @Resource
    private BlogService blogService;

    @Resource
    private BlogRoleService blogRoleService;

    /**
     * 验证操作是否满足权限
     *
     * @param blogUser
     * @param blogEvent
     * @param articalId
     * @return
     */
    @Override
    public boolean checkRole(@NotNull BlogUser blogUser, BlogEventEnum blogEventEnum, String articalId) {
        final Blog blog = blogService.getBlogById(articalId);
        // 所有者操作直接放行
        if (blog.getUsername().equals(blogUser.getName())) {
            return true;
        }
        // 查询操作需要额外进行判断，判断对应的
        if (blogEventEnum.equals(BlogEventEnum.SEE)) {
            // 判断是否针对当前用户等级开放阅读权限
            if (blogUser.getRole() >= blog.getRole()) {
                return true;
            }
        }
        // 服务查询操作是否可以执行
        BlogRole blogRole = new BlogRole();
        blogRole.setAllowedusername(blogUser.getName());
        blogRole.setArticleid(articalId);
        return blogRoleService.checkBlogRole(blogRole, blogEventEnum);
    }
}

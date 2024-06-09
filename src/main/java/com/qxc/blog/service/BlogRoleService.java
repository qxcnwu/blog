package com.qxc.blog.service;

import com.qxc.blog.AOPInterceptor.BlogEvent.BlogEvent;
import com.qxc.blog.pojo.BlogRole;
import com.qxc.blog.self.BlogEventEnum;

import java.util.List;

/**
 * @Author qxc
 * @Date 2024 2024/6/8 下午6:54
 * @Version 1.0
 * @PACKAGE com.qxc.blog.service
 */
public interface BlogRoleService {
    /**
     * 增加操作权限
     * @param blogRole
     * @return
     */
    boolean addBlogRole(BlogRole blogRole);

    /**
     * 删除权限
     * @param blogRole
     * @return
     */
    boolean deleteBlogRole(BlogRole blogRole);

    /**
     * 修改权限
     * @param blogRole
     * @return
     */
    boolean updateBlogRole(BlogRole blogRole);

    /**
     * 获取对应文章的权限
     * @param articalId
     * @return
     */
    List<BlogRole> getBlogRoles(String articalId);

    /**
     * 检查是否有该操作的权限
     * @param blogRole
     * @param blogEvent
     * @return
     */
    boolean checkBlogRole(BlogRole blogRole, BlogEventEnum blogEventEnum);

    /**
     * 查询是否存在
     * @param blogRole
     * @return
     */
    BlogRole getBlogRole(BlogRole blogRole);
}

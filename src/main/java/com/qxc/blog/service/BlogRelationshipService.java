package com.qxc.blog.service;

import com.qxc.blog.pojo.BlogRelationship;

import java.util.List;

/**
 * @Author qxc
 * @Date 2024 2024/6/8 下午5:54
 * @Version 1.0
 * @PACKAGE com.qxc.blog.service
 */
public interface BlogRelationshipService {
    /**
     * 增加
     * @param blogRelationship
     * @return
     */
    boolean addBlogRelationship(BlogRelationship blogRelationship) throws Exception;

    /**
     * 删除
     * @param blogRelationship
     * @return
     */
    List<String> deleteBlogRelationship(String articalId) throws Exception;

    /**
     * 获取
     * @param articalId
     * @return
     */
    List<BlogRelationship> getBlogRelationShip(String articalId);
}

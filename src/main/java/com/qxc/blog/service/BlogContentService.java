package com.qxc.blog.service;

import com.qxc.blog.pojo.BlogContent;

/**
 * @Author qxc
 * @Date 2024 2024/6/6 下午9:58
 * @Version 1.0
 * @PACKAGE com.qxc.blog.service
 */
public interface BlogContentService {
    /**
     * 添加内容
     * @param blogContent
     * @return
     */
    boolean addBlogContent(BlogContent blogContent);

    /**
     * 更新内容
     * @param blogContent
     * @return
     */
    boolean updateBlogContent(BlogContent blogContent);

    /**
     * 删除内容
     * @param blogContent
     * @return
     */
    boolean deleteBlogContent(BlogContent blogContent);

    /**
     * 更新
     * @param id
     * @return
     */
    BlogContent getBlogContentById(String id);
}

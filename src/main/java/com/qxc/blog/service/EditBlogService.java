package com.qxc.blog.service;

import com.qxc.blog.self.BlogAndContent;

/**
 * @Author qxc
 * @Date 2024 2024/6/6 下午10:23
 * @Version 1.0
 * @PACKAGE com.qxc.blog.service
 */
public interface EditBlogService {
    /**
     * 获取整个博客全部信息
     *
     * @param articalId
     * @return
     */
    BlogAndContent getBlogById(String articalId);

    /**
     * 创建新博客
     *
     * @param blogAndContent
     * @return
     */
    boolean addBlog(BlogAndContent blogAndContent) throws Exception;

    /**
     * 更新博客
     *
     * @param blogAndContent
     * @return
     */
    boolean updateBlog(BlogAndContent blogAndContent) throws Exception;

    /**
     * 删除博客
     *
     * @param blogAndContent
     * @return
     */
    boolean deleteBlog(BlogAndContent blogAndContent) throws Exception;
}

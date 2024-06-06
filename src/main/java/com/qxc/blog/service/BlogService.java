package com.qxc.blog.service;

import com.qxc.blog.pojo.Blog;

/**
 * @Author qxc
 * @Date 2024 2024/6/6 下午9:53
 * @Version 1.0
 * @PACKAGE com.qxc.blog.service
 */
public interface BlogService {
    /**
     * 新增博客
     *
     * @param blog
     * @return
     */
    boolean addBlog(Blog blog) throws Exception;

    /**
     * 更新博客
     *
     * @param blog
     * @return
     */
    boolean updateBlog(Blog blog) throws Exception;

    /**
     * 删除博客
     *
     * @param blog
     * @return
     */
    boolean deleteBlog(Blog blog) throws Exception;

    /**
     * 是否存在
     *
     * @param blog
     * @return
     */
    boolean contentsBlog(Blog blog);

    /**
     * 获取博客详情
     *
     * @param id
     * @return
     */
    Blog getBlogById(String id);
}

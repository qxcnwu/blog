package com.qxc.blog.service;

import com.qxc.blog.aopInterceptor.aop.LogRecod.LogRecord;
import com.qxc.blog.pojo.BlogUser;
import com.qxc.blog.self.BlogAndContent;
import org.jetbrains.annotations.NotNull;
import org.springframework.transaction.annotation.Transactional;

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
    BlogAndContent getBlogById(BlogUser blogUser, String articalId);

    /**
     * 创建新博客
     *
     * @param blogAndContent
     * @return
     */
    boolean addBlog(BlogUser blogUser, BlogAndContent blogAndContent) throws Exception;

    @Transactional
    @LogRecord(param = true, time = true)
    boolean addBlogWithOutCheck(BlogUser blogUser, @NotNull BlogAndContent blogAndContent) throws Exception;

    /**
     * 更新博客
     *
     * @param blogAndContent
     * @return
     */
    boolean updateBlog(BlogUser blogUser, BlogAndContent blogAndContent) throws Exception;

    /**
     * 删除博客
     *
     * @param blogAndContent
     * @return
     */
    boolean deleteBlog(BlogUser blogUser, BlogAndContent blogAndContent) throws Exception;
}

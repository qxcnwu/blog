package com.qxc.blog.service;

import com.qxc.blog.pojo.BlogComments;

import java.util.List;

/**
 * @Author qxc
 * @Date 2024 2024/6/6 下午10:41
 * @Version 1.0
 * @PACKAGE com.qxc.blog.service
 */
public interface BlogCommentsService {
    List<BlogComments> getBlogComments(String articalId);

    boolean addBlogComment(BlogComments blogComments);

    boolean deleteBlogComment(BlogComments blogComments);

    boolean updateBlogComment(BlogComments blogComments);
}

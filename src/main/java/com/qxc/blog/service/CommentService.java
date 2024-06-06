package com.qxc.blog.service;

import com.qxc.blog.pojo.BlogComments;

import java.util.List;

/**
 * @Author qxc
 * @Date 2024 2024/6/6 下午9:55
 * @Version 1.0
 * @PACKAGE com.qxc.blog.service
 */
public interface CommentService {
    /**
     * 添加评论
     * @param comment
     * @return
     */
    boolean addComment(BlogComments comment);

    /**
     * 获取文章评论
     * @param articleId
     * @return
     */
    List<BlogComments> getAllComments(String articleId);

    /**
     * 更新评论
     * @param comment
     * @return
     */
    boolean updateComment(BlogComments comment);

    /**
     * 删除评论
     * @param comment
     * @return
     */
    boolean deleteComment(BlogComments comment);
}

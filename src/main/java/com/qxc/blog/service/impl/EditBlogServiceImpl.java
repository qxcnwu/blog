package com.qxc.blog.service.impl;

import com.qxc.blog.AOPInterceptor.BlogEvent.BlogEvent;
import com.qxc.blog.AOPInterceptor.BlogEvent.BlogEventPublisher;
import com.qxc.blog.pojo.Blog;
import com.qxc.blog.pojo.BlogComments;
import com.qxc.blog.pojo.BlogContent;
import com.qxc.blog.self.BlogAndContent;
import com.qxc.blog.self.BlogEventEnum;
import com.qxc.blog.service.BlogCommentsService;
import com.qxc.blog.service.BlogContentService;
import com.qxc.blog.service.BlogService;
import com.qxc.blog.service.EditBlogService;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * @Author qxc
 * @Date 2024 2024/6/6 下午10:38
 * @Version 1.0
 * @PACKAGE com.qxc.blog.service.impl
 */
@Service
public class EditBlogServiceImpl implements EditBlogService {

    @Resource
    private BlogService blogService;

    @Resource
    private BlogContentService blogContentService;

    @Resource
    private BlogCommentsService blogCommentsService;

    @Resource
    private BlogEventPublisher blogAddEventPublisher;

    /**
     * 获取整个博客全部信息
     *
     * @param articalId
     * @return
     */
    @Override
    public BlogAndContent getBlogById(String articalId) {
        final Blog blog = blogService.getBlogById(articalId);
        if (Objects.isNull(blog)) {
            return null;
        }
        final BlogContent content = blogContentService.getBlogContentById(articalId);
        if (Objects.isNull(content)) {
            return null;
        }
        final List<BlogComments> comments = blogCommentsService.getBlogComments(articalId);
        if (Objects.isNull(comments)) {
            return null;
        }
        return new BlogAndContent(blog, content, comments);
    }

    /**
     * 创建新博客
     *
     * @param blogAndContent
     * @return
     */
    @Override
    @Transactional
    public boolean addBlog(@NotNull BlogAndContent blogAndContent) throws Exception {
        if (!blogService.addBlog(blogAndContent.getBlog())) {
            throw new Exception("add blog failed");
        }
        if (!blogContentService.addBlogContent(blogAndContent.getBlogContent())) {
            throw new Exception("add blog content failed");
        }
        // 发布事件els可能订阅
        blogAddEventPublisher.publish(new BlogEvent(blogAndContent.getBlog().getArticleid(), BlogEventEnum.CREATE));
        return true;
    }

    /**
     * 更新博客
     *
     * @param blogAndContent
     * @return
     */
    @Override
    @Transactional
    public boolean updateBlog(@NotNull BlogAndContent blogAndContent) throws Exception {
        if (!blogService.updateBlog(blogAndContent.getBlog())) {
            throw new Exception("add blog failed");
        }
        if (!blogContentService.updateBlogContent(blogAndContent.getBlogContent())) {
            throw new Exception("add blog content failed");
        }
        // 发布事件els可能订阅
        blogAddEventPublisher.publish(new BlogEvent(blogAndContent.getBlog().getArticleid(), BlogEventEnum.UPDATE));
        return true;
    }

    /**
     * 删除博客
     *
     * @param blogAndContent
     * @return
     */
    @Override
    @Transactional
    public boolean deleteBlog(@NotNull BlogAndContent blogAndContent) throws Exception {
        if (!blogService.deleteBlog(blogAndContent.getBlog())) {
            throw new Exception("add blog failed");
        }
        if (!blogContentService.deleteBlogContent(blogAndContent.getBlogContent())) {
            throw new Exception("add blog content failed");
        }
        // 发布事件els可能订阅
        blogAddEventPublisher.publish(new BlogEvent(blogAndContent.getBlog().getArticleid(), BlogEventEnum.DELETE));
        return true;
    }
}

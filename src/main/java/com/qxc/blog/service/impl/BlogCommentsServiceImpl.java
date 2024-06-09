package com.qxc.blog.service.impl;

import com.qxc.blog.dao.BlogCommentsMapper;
import com.qxc.blog.pojo.BlogComments;
import com.qxc.blog.pojo.BlogCommentsExample;
import com.qxc.blog.service.BlogCommentsService;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author qxc
 * @Date 2024 2024/6/8 下午2:34
 * @Version 1.0
 * @PACKAGE com.qxc.blog.service.impl
 */
@Service
public class BlogCommentsServiceImpl implements BlogCommentsService {

    @Resource
    private BlogCommentsMapper blogCommentsMapper;

    @Override
    public List<BlogComments> getBlogComments(String articalId) {
        BlogCommentsExample example = new BlogCommentsExample();
        example.createCriteria().andArticleidEqualTo(articalId);
        return blogCommentsMapper.selectByExample(example);
    }

    @Transactional
    @Override
    public boolean addBlogComment(BlogComments blogComments) {
        return blogCommentsMapper.insertSelective(blogComments) == 1;
    }

    @Transactional
    @Override
    public boolean deleteBlogComment(@NotNull BlogComments blogComments) {
        BlogCommentsExample example = new BlogCommentsExample();
        example.createCriteria().andArticleidEqualTo(blogComments.getArticleid()).andIdxEqualTo(blogComments.getIdx());
        return blogCommentsMapper.deleteByExample(example) == 1;
    }

    @Transactional
    @Override
    public boolean updateBlogComment(@NotNull BlogComments blogComments) {
        BlogCommentsExample example = new BlogCommentsExample();
        example.createCriteria().andArticleidEqualTo(blogComments.getArticleid()).andIdxEqualTo(blogComments.getIdx());
        return blogCommentsMapper.updateByExampleSelective(blogComments, example) == 1;
    }
}

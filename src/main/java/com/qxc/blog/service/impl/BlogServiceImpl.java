package com.qxc.blog.service.impl;

import com.qxc.blog.dao.BlogMapper;
import com.qxc.blog.pojo.Blog;
import com.qxc.blog.pojo.BlogExample;
import com.qxc.blog.service.BlogService;
import jakarta.annotation.Nullable;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author qxc
 * @Date 2024 2024/6/6 下午10:00
 * @Version 1.0
 * @PACKAGE com.qxc.blog.service.impl
 */
@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogMapper blogMapper;

    /**
     * 新增博客
     *
     * @param blog
     * @return
     */
    @Override
    @Transactional
    public boolean addBlog(Blog blog) throws Exception {
        if (contentsBlog(blog)) {
            throw new Exception("contains blog id");
        }
        return blogMapper.insertSelective(blog) == 1;
    }

    /**
     * 更新博客
     *
     * @param blog
     * @return
     */
    @Override
    @Transactional
    public boolean updateBlog(Blog blog) throws Exception {
        if (!contentsBlog(blog)) {
            throw new Exception("contains blog id");
        }
        BlogExample example = new BlogExample();
        example.createCriteria().andArticleidEqualTo(blog.getArticleid());
        return blogMapper.updateByExampleSelective(blog, example) == 1;
    }

    /**
     * 删除博客
     *
     * @param blog
     * @return
     */
    @Override
    @Transactional
    public boolean deleteBlog(Blog blog) throws Exception {
        if (!contentsBlog(blog)) {
            throw new Exception("blog not exist");
        }
        BlogExample example = new BlogExample();
        example.createCriteria().andArticleidEqualTo(blog.getArticleid());
        return blogMapper.updateByExampleSelective(blog, example) == 1;
    }

    /**
     * 是否存在
     *
     * @param blog
     * @return
     */
    @Override
    public boolean contentsBlog(@NotNull Blog blog) {
        BlogExample blogExample = new BlogExample();
        blogExample.createCriteria().andArticleidEqualTo(blog.getArticleid());
        return blogMapper.selectByExample(blogExample).isEmpty();
    }

    /**
     * 获取博客详情
     *
     * @param id
     * @return
     */
    @Override
    public @Nullable Blog getBlogById(String id) {
        BlogExample example = new BlogExample();
        example.createCriteria().andArticleidEqualTo(id);
        return blogMapper.selectByExample(example).stream().findFirst().orElse(null);
    }
}

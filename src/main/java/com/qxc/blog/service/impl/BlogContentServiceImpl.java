package com.qxc.blog.service.impl;

import com.qxc.blog.AOPInterceptor.LogRecod.LogRecord;
import com.qxc.blog.dao.BlogContentMapper;
import com.qxc.blog.pojo.BlogContent;
import com.qxc.blog.pojo.BlogContentExample;
import com.qxc.blog.service.BlogContentService;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author qxc
 * @Date 2024 2024/6/8 下午2:41
 * @Version 1.0
 * @PACKAGE com.qxc.blog.service.impl
 */
@Service
public class BlogContentServiceImpl implements BlogContentService {

    @Resource
    private BlogContentMapper blogContentMapper;

    /**
     * 添加内容
     *
     * @param blogContent
     * @return
     */
    @Override
    @Transactional(rollbackFor = {Exception.class, RuntimeException.class})
    @LogRecord
    public boolean addBlogContent(@NotNull BlogContent blogContent) throws Exception {
        if (containsBlogContents(blogContent.getArticleid())) {
            throw new Exception("such blog has been exist");
        }
        if (blogContentMapper.insert(blogContent) != 1) {
            throw new Exception("blog insert wrong!");
        }
        return true;
    }

    /**
     * 更新内容
     *
     * @param blogContent
     * @return
     */
    @Override
    @Transactional
    @LogRecord
    public boolean updateBlogContent(@NotNull BlogContent blogContent) throws Exception {
        if (!containsBlogContents(blogContent.getArticleid())) {
            throw new Exception("such blog not exist");
        }
        if (blogContentMapper.updateByPrimaryKeySelective(blogContent) != 1) {
            throw new Exception("update blog unsuccessful");
        }
        return true;
    }

    /**
     * 删除内容
     *
     * @param blogContent
     * @return
     */
    @Override
    @Transactional
    @LogRecord
    public boolean deleteBlogContent(@NotNull BlogContent blogContent) throws Exception {
        if (!containsBlogContents(blogContent.getArticleid())) {
            throw new Exception("such blog not exist");
        }
        return true;
    }

    /**
     * 更新
     *
     * @param id
     * @return
     */
    @Override
    @Transactional
    @LogRecord
    public BlogContent getBlogContentById(String id) {
        BlogContentExample example = new BlogContentExample();
        example.createCriteria().andArticleidEqualTo(id);
        final List<BlogContent> blogContents = blogContentMapper.selectByExample(example);
        return blogContents.size() != 1 ? null : blogContents.getFirst();
    }

    /**
     * 是否存在
     *
     * @param title
     * @return
     */
    @Override
    @Transactional
    @LogRecord(param = false, time = false, exception = false)
    public boolean containsBlogContents(String title) {
        BlogContentExample example = new BlogContentExample();
        example.createCriteria().andArticleidEqualTo(title);
        return blogContentMapper.countByExample(example) > 0;
    }
}

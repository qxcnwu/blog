package com.qxc.blog.service.impl;

import com.qxc.blog.dao.BlogMapper;
import com.qxc.blog.pojo.Blog;
import com.qxc.blog.pojo.BlogExample;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author qxc
 * @Date 2024 2024/6/9 下午4:45
 * @Version 1.0
 * @PACKAGE com.qxc.blog.service.impl
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class BlogTest {
    @Resource
    private BlogMapper blogMapper;

    @Test
    public void insert() {
        BlogExample example = new BlogExample();
        example.createCriteria().andArticleidEqualTo("base");
        final List<Blog> blogs = blogMapper.selectByExample(example);
        System.out.println(blogs.getFirst());
        log.info(String.valueOf(blogs.getFirst()));
    }
}

package com.qxc.blog.service.impl;

import com.qxc.blog.pojo.Blog;
import com.qxc.blog.pojo.BlogContent;
import com.qxc.blog.self.BlogAndContent;
import com.qxc.blog.self.BlogRoleEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author qxc
 * @Date 2024 2024/6/8 下午3:44
 * @Version 1.0
 * @PACKAGE com.qxc.blog.service.impl
 */
@SpringBootTest
@Transactional
@RunWith(SpringRunner.class)
public class TestAopAndTransaction {

    @Autowired
    private EditBlogServiceImpl editBlogService;

    @Test
    @Rollback
    public void test() throws Exception {
        BlogAndContent blogAndContent = new BlogAndContent();
        Blog blog = new Blog();
        blog.setArticleid("test");
        blog.setTitle("title");
        blog.setRole(BlogRoleEnum.EVERYONE.toString());
        blog.setHasdelete(0);
        blog.setUsername("qxc");
        final BlogContent blogContent = new BlogContent();
        blogContent.setArticleid("test");
        blogContent.setTitle("title");
        blogAndContent.setBlog(blog);
        blogAndContent.setBlogContent(blogContent);
        blogAndContent.setCreate();
        editBlogService.addBlog(blogAndContent);
    }
}

package com.qxc.blog.self;

import com.qxc.blog.pojo.Blog;
import com.qxc.blog.pojo.BlogComments;
import com.qxc.blog.pojo.BlogContent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * @Author qxc
 * @Date 2024 2024/6/6 下午10:24
 * @Version 1.0
 * @PACKAGE com.qxc.blog.self
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogAndContent implements Serializable {
    private Blog blog;
    private BlogContent blogContent;
    private List<BlogComments> blogComments;

    /**
     * 更新时间
     */
    public void updateTime() {
        blog.setChangedate(new Date());
    }

    /**
     * 更新时间
     */
    public void updateCreateTime() {
        blog.setCreatedate(new Date());
    }

    /**
     * 生成水机ID
     */
    public void createId() {
        blog.setArticleid(UUID.randomUUID().toString());
        if (Objects.isNull(blogContent)) {
            blogContent = new BlogContent();
            blogContent.setTitle(blog.getTitle());
        }
        blogContent.setArticleid(blog.getArticleid());
    }

}

package com.qxc.blog.self;

import com.qxc.blog.pojo.Blog;
import com.qxc.blog.pojo.BlogComments;
import com.qxc.blog.pojo.BlogContent;
import com.qxc.blog.pojo.BlogRelationship;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

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
    private List<BlogRelationship> blogRelationship;

    @Contract(pure = true)
    public BlogAndContent(Blog blog, BlogContent blogContent, List<BlogComments> blogComments) {
        this.blog = blog;
        this.blogContent = blogContent;
        this.blogComments = blogComments;
    }

    /**
     * 更新时间
     */
    public void updateChangeTime() {
        blog.setChangedate(new Date());
    }

    /**
     * 更新时间
     */
    private void updateCreateTime() {
        blog.setCreatedate(new Date());
    }

    /**
     * 初始化
     */
    public void setCreate() {
        createId();
        updateCreateTime();
        updateChangeTime();
        getBlog().setHasdelete(BlogDeleteEnum.CONTAINS.ordinal());
    }

    /**
     * 生成水机ID
     */
    private void createId() {
        if (Objects.isNull(blog)) {
            blog = new Blog();
        }
        blog.setArticleid(UUID.randomUUID().toString());
        if (Objects.isNull(blogContent)) {
            blogContent = new BlogContent();
            blogContent.setTitle(blog.getTitle());
        }
        blogContent.setArticleid(blog.getArticleid());
    }

    /**
     * 创建默认空间
     *
     * @param username
     * @return
     */
    @Contract(pure = true)
    public static @NotNull BlogAndContent initUser(String username, String titleName, String base) {
        BlogAndContent blogAndContent = new BlogAndContent();
        blogAndContent.setBlog(new Blog());
        blogAndContent.setCreate();
        blogAndContent.getBlog().setTitle(titleName);
        blogAndContent.getBlog().setRole(1);
        blogAndContent.getBlog().setUsername(username);
        blogAndContent.getBlogContent().setTitle(titleName);
        BlogRelationship blogRelationship = new BlogRelationship();
        blogRelationship.setTitle(titleName);
        blogRelationship.setFatheridx(base);
        blogRelationship.setSonidx(blogAndContent.getBlog().getArticleid());
        blogAndContent.setBlogRelationship(List.of(blogRelationship));
        return blogAndContent;
    }

    @Override
    public String toString() {
        return "BlogAndContent{" +
                "blog=" + blog +
                ", blogContent=" + blogContent +
                ", blogComments=" + blogComments +
                ", blogRelationship=" + blogRelationship +
                '}';
    }
}

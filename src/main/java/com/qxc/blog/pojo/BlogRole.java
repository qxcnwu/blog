package com.qxc.blog.pojo;

import com.qxc.blog.self.BlogAndContent;

public class BlogRole extends BlogRoleKey {
    private String allowedusername;

    private Integer allowmethod;

    public String getAllowedusername() {
        return allowedusername;
    }

    public void setAllowedusername(String allowedusername) {
        this.allowedusername = allowedusername == null ? null : allowedusername.trim();
    }

    public Integer getAllowmethod() {
        return allowmethod;
    }

    public void setAllowmethod(Integer allowmethod) {
        this.allowmethod = allowmethod;
    }

    public static BlogRole initBlogRole(BlogAndContent blogAndContent,BlogUser blogUser){
        BlogRole blogRole = new BlogRole();
        blogRole.setArticleid(blogAndContent.getBlog().getArticleid());
        blogRole.setAllowedusername(blogUser.getName());
        blogRole.setAllowmethod(4);
        return blogRole;
    }

    @Override
    public String toString() {
        return "BlogRole{" +
                "allowedusername='" + allowedusername + '\'' +
                ", allowmethod=" + allowmethod +
                '}';
    }
}
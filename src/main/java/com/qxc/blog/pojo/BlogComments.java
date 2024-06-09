package com.qxc.blog.pojo;

public class BlogComments extends BlogCommentsKey {
    private String username;

    private Integer commentsid;

    private Integer hasdelete;

    private String content;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Integer getCommentsid() {
        return commentsid;
    }

    public void setCommentsid(Integer commentsid) {
        this.commentsid = commentsid;
    }

    public Integer getHasdelete() {
        return hasdelete;
    }

    public void setHasdelete(Integer hasdelete) {
        this.hasdelete = hasdelete;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}
package com.qxc.blog.pojo;

public class Blog extends BlogKey {
    private String articleid;

    private String title;

    private String role;

    private Integer hasdelete;

    public String getArticleid() {
        return articleid;
    }

    public void setArticleid(String articleid) {
        this.articleid = articleid == null ? null : articleid.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }

    public Integer getHasdelete() {
        return hasdelete;
    }

    public void setHasdelete(Integer hasdelete) {
        this.hasdelete = hasdelete;
    }
}
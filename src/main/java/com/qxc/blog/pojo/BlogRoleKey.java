package com.qxc.blog.pojo;

public class BlogRoleKey {
    private Long idx;

    private String articleid;

    public Long getIdx() {
        return idx;
    }

    public void setIdx(Long idx) {
        this.idx = idx;
    }

    public String getArticleid() {
        return articleid;
    }

    public void setArticleid(String articleid) {
        this.articleid = articleid == null ? null : articleid.trim();
    }
}
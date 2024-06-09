package com.qxc.blog.pojo;

public class BlogRelationship extends BlogRelationshipKey {
    private String sonidx;

    private String title;

    public String getSonidx() {
        return sonidx;
    }

    public void setSonidx(String sonidx) {
        this.sonidx = sonidx == null ? null : sonidx.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }
}
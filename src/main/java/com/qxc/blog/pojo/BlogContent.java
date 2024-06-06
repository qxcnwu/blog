package com.qxc.blog.pojo;

import java.io.Serializable;

public class BlogContent extends BlogContentKey implements Serializable {
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }
}
package com.qxc.blog.pojo;

public class BlogContent extends BlogContentKey {
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    @Override
    public String toString() {
        return "BlogContent{" +
                "title='" + title + '\'' +
                '}';
    }
}
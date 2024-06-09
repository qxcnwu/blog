package com.qxc.blog.pojo;

import java.util.Date;

public class BlogKey {
    private Long idx;

    private String username;

    private Date createdate;

    private Date changedate;

    public Long getIdx() {
        return idx;
    }

    public void setIdx(Long idx) {
        this.idx = idx;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Date getChangedate() {
        return changedate;
    }

    public void setChangedate(Date changedate) {
        this.changedate = changedate;
    }

    @Override
    public String toString() {
        return "BlogKey{" +
                "idx=" + idx +
                ", username='" + username + '\'' +
                ", createdate=" + createdate +
                ", changedate=" + changedate +
                '}';
    }
}
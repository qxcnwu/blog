package com.qxc.blog.pojo;

import java.util.Date;

public class BlogCommentsKey {
    private Long idx;

    private String articleid;

    private Date createtime;

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

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        return "BlogCommentsKey{" +
                "idx=" + idx +
                ", articleid='" + articleid + '\'' +
                ", createtime=" + createtime +
                '}';
    }
}
package com.qxc.blog.pojo;

public class BlogRelationshipKey {
    private Integer idx;

    private String fatheridx;

    public Integer getIdx() {
        return idx;
    }

    public void setIdx(Integer idx) {
        this.idx = idx;
    }

    public String getFatheridx() {
        return fatheridx;
    }

    public void setFatheridx(String fatheridx) {
        this.fatheridx = fatheridx == null ? null : fatheridx.trim();
    }
}
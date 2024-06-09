package com.qxc.blog.pojo;

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
}
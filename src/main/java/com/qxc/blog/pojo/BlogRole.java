package com.qxc.blog.pojo;

public class BlogRole extends BlogRoleKey {
    private String allowedusername;

    public String getAllowedusername() {
        return allowedusername;
    }

    public void setAllowedusername(String allowedusername) {
        this.allowedusername = allowedusername == null ? null : allowedusername.trim();
    }
}
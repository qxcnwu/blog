package com.qxc.blog.service;

import com.qxc.blog.pojo.BlogUser;

/**
 * @Author qxc
 * @Date 2024 2024/6/2 下午10:43
 * @Version 1.0
 * @PACKAGE com.qxc.blog.service
 */
public interface BlogUserService {

    /**
     * 登录
     *
     * @param username
     * @param password
     * @return
     */
    BlogUser login(String username, String password);

    /**
     * 注销
     *
     * @param username
     * @return
     */
    boolean logout(String username);

    /**
     * 注册
     *
     * @param blogUser
     * @return
     */
    boolean register(BlogUser blogUser);

    /**
     * 创建cookie
     *
     * @return
     */
    String createCookie(BlogUser blogUser);

    /**
     * 查询用户是否存在
     * @param userName
     * @return
     */
    boolean containsUser(String userName);
}

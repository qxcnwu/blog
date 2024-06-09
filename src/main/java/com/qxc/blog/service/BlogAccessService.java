package com.qxc.blog.service;

import com.qxc.blog.pojo.BlogUser;
import com.qxc.blog.self.BlogEventEnum;

/**
 * @Author qxc
 * @Date 2024 2024/6/8 下午6:48
 * @Version 1.0
 * @PACKAGE com.qxc.blog.service
 */
public interface BlogAccessService {
    /**
     * 验证操作是否满足权限
     *
     * @param blogUser
     * @param blogEvent
     * @param articalId
     * @return
     */
    boolean checkRole(BlogUser blogUser, BlogEventEnum blogEventEnum, String articalId);

    boolean checkSee(BlogUser blogUser, String articalId);
    boolean checkDelete(BlogUser blogUser, String articalId);
    boolean checkUpdate(BlogUser blogUser, String articalId);
    boolean checkAdd(BlogUser blogUser, String articalId);
}

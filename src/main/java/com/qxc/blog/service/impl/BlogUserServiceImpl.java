package com.qxc.blog.service.impl;

import com.qxc.blog.Utiles.PojoUtiles;
import com.qxc.blog.dao.BlogUserMapper;
import com.qxc.blog.pojo.BlogUser;
import com.qxc.blog.pojo.BlogUserExample;
import com.qxc.blog.service.BlogUserService;
import jakarta.annotation.Nullable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @Author qxc
 * @Date 2024 2024/6/2 下午10:48
 * @Version 1.0
 * @PACKAGE com.qxc.blog.service.impl
 */
@Service
@Slf4j
public class BlogUserServiceImpl implements BlogUserService {

    @Resource
    private RedisServerUtiles redisServerUtiles;

    @Resource
    private BlogUserMapper blogUserMapper;

    /**
     * 登录
     *
     * @param username
     * @param password
     * @return
     */
    @Override
    public @Nullable BlogUser login(String username, String password) {
        BlogUserExample blogUserExample = new BlogUserExample();
        blogUserExample.createCriteria().andNameEqualTo(username).andPwdEqualTo(password);
        final List<BlogUser> blogUsers = blogUserMapper.selectByExample(blogUserExample);
        if (blogUsers.size() != 1) {
            return null;
        }
        return blogUsers.getFirst();
    }

    /**
     * 注销
     *
     * @param username
     * @return
     */
    @Override
    public boolean logout(String username) {
        return false;
    }

    /**
     * 注册
     *
     * @param blogUser
     * @return
     */
    @Override
    public boolean register(BlogUser blogUser) {
        if (!PojoUtiles.isRightBlogUser(blogUser)) {
            log.error("register user:{} occur error!", blogUser);
            return false;
        }
        if (containsUser(blogUser.getName())) {
            log.error("such user name exist {}", blogUser);
            return false;
        }
        blogUser.setCreattime(new Date());
        return blogUserMapper.insert(blogUser) == 1;
    }

    /**
     * 创建cookie
     *
     * @param blogUser
     * @return
     */
    @Override
    public String createCookie(BlogUser blogUser) {
        final String token = UUID.randomUUID().toString();
        redisServerUtiles.setUserByToken(token, blogUser);
        return token;
    }

    /**
     * 查询用户是否存在
     *
     * @param userName
     * @return
     */
    @Override
    public boolean containsUser(String userName) {
        BlogUserExample blogUserExample = new BlogUserExample();
        blogUserExample.createCriteria().andNameEqualTo(userName);
        final List<BlogUser> blogUsers = blogUserMapper.selectByExample(blogUserExample);
        return !blogUsers.isEmpty();
    }
}

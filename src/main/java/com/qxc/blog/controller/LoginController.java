package com.qxc.blog.controller;

import com.qxc.blog.Utiles.JWTUtiles;
import com.qxc.blog.aopInterceptor.LocalHandlerInterceptor.OnlyLocalHost;
import com.qxc.blog.aopInterceptor.aop.AuthorNeed.AuthorNeed;
import com.qxc.blog.configuration.BaseConfiguration;
import com.qxc.blog.pojo.BlogRole;
import com.qxc.blog.pojo.BlogUser;
import com.qxc.blog.self.BlogAndContent;
import com.qxc.blog.self.LoginResult;
import com.qxc.blog.self.LogoutResult;
import com.qxc.blog.self.RegisterResult;
import com.qxc.blog.service.BlogRoleService;
import com.qxc.blog.service.BlogUserService;
import com.qxc.blog.service.EditBlogService;
import com.qxc.blog.service.impl.RedisServerUtiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @Author qxc
 * @Date 2024 2024/6/3 下午11:11
 * @Version 1.0
 * @PACKAGE com.qxc.blog.controller
 */
@RestController
@RequestMapping("/user")
public class LoginController {

    @Resource
    private BlogUserService blogUserService;

    @Resource
    private JWTUtiles jwtUtiles;

    @Resource
    private RedisServerUtiles redisServerUtiles;

    @Resource
    private EditBlogService editBlogService;

    @Autowired
    private BaseConfiguration baseConfiguration;

    @Autowired
    private BlogRoleService blogRoleService;

    @PostMapping("/login")
    public LoginResult login(@RequestParam(value = "name") String name, @RequestParam(value = "password") String password) {
        final BlogUser login = blogUserService.login(name, password);
        if (Objects.isNull(login)) {
            return LoginResult.getNullLoginResult();
        }
        // 获取jwt token
        final String token = jwtUtiles.createUserJwt(login);
        // 写入token到redis
        redisServerUtiles.setUserByToken(token, login);
        return new LoginResult(login, token);
    }

    @AuthorNeed
    @PostMapping("/logout")
    public LogoutResult logout(@CookieValue(value = "token", defaultValue = "qxc") String token, @RequestParam(required = false) BlogUser blogUser) {
        if (!redisServerUtiles.removeUserByToken(token)) {
            return LogoutResult.getNullLoginResult();
        }
        return new LogoutResult();
    }

    @OnlyLocalHost
    @PostMapping("/register")
    @Transactional(rollbackFor = {Exception.class, RuntimeException.class})
    public RegisterResult register(@RequestBody BlogUser blogUser) throws Exception {
        if (!blogUserService.register(blogUser)) {
            return RegisterResult.getNullLoginResult();
        }
        // 初始化权限
        final String name = blogUser.getName();
        final BlogAndContent blogAndContent = BlogAndContent.initUser(name, name + baseConfiguration.getBaseName(), baseConfiguration.getRootRS());
        if (!blogRoleService.addBlogRole(BlogRole.initBlogRole(blogAndContent, blogUser))) {
            return RegisterResult.getNullLoginResult();
        }
        // 初始化操作空间
        if (!editBlogService.addBlogWithOutCheck(blogUser, blogAndContent)) {
            return RegisterResult.getNullLoginResult();
        }
        return new RegisterResult();
    }
}

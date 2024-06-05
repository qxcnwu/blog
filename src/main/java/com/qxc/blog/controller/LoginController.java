package com.qxc.blog.controller;

import com.qxc.blog.AOPInterceptor.AuthorNeed.AuthorNeed;
import com.qxc.blog.AOPInterceptor.LocalHandlerInterceptor.OnlyLocalHost;
import com.qxc.blog.Utiles.JWTUtiles;
import com.qxc.blog.configuration.BaseConfiguration;
import com.qxc.blog.pojo.BlogUser;
import com.qxc.blog.self.LoginResult;
import com.qxc.blog.self.LogoutResult;
import com.qxc.blog.self.RegisterResult;
import com.qxc.blog.service.BlogUserService;
import com.qxc.blog.service.impl.RedisServerUtiles;
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
    public RegisterResult register(BlogUser blogUser) {
        if (!blogUserService.register(blogUser)) {
            return RegisterResult.getNullLoginResult();
        }
        return new RegisterResult();
    }
}

package com.qxc.blog.controller;

import com.qxc.blog.AOPInterceptor.LocalHandlerInterceptor.OnlyLocalHost;
import com.qxc.blog.self.LoginResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author qxc
 * @Date 2024 2024/6/3 下午11:11
 * @Version 1.0
 * @PACKAGE com.qxc.blog.controller
 */
@RestController
@RequestMapping("/user")
public class LoginController {

    @OnlyLocalHost
    @PostMapping("login")
    public LoginResult login(@RequestParam(value = "name") String name, @RequestParam(value = "password") String password) {

        return new LoginResult();
    }

}

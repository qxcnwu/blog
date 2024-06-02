package com.qxc.blog.service.impl;

import com.qxc.blog.pojo.BlogUser;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author qxc
 * @Date 2024 2024/6/2 下午10:05
 * @Version 1.0
 * @PACKAGE com.qxc.blog.service.impl
 */
@SpringBootTest
@RunWith(SpringRunner.class)
class RedisServerUtilesTest {

    @Resource
    private RedisServerUtiles redisServerUtiles;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getUserByToken() {
    }

    @Test
    void setUserByToken() {
        final BlogUser blogUser = new BlogUser();
        blogUser.setName("qxc");
        redisServerUtiles.setUserByToken("qxc", blogUser);
    }
}
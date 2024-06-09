package com.qxc.blog.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Date;

/**
 * @Author qxc
 * @Date 2024 2024/6/9 下午4:42
 * @Version 1.0
 * @PACKAGE com.qxc.blog.service.impl
 */
@Slf4j
public class TimeUtileTest {
    @Test
    public void test() {
        log.info(String.valueOf(new java.sql.Date(System.currentTimeMillis())));
        log.info(String.valueOf(new Date()));
        System.out.println(new Date());
    }
}

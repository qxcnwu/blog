package com.qxc.blog.Utiles;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.jwt.JWTPayload;
import cn.hutool.jwt.JWTUtil;
import com.qxc.blog.configuration.BaseConfiguration;
import com.qxc.blog.pojo.BlogUser;
import jakarta.servlet.http.Cookie;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * @Author qxc
 * @Date 2024 2024/6/4 下午10:35
 * @Version 1.0
 * @PACKAGE com.qxc.blog.Utiles
 */
@Component
public class JWTUtiles implements InitializingBean {

    @Resource
    private BaseConfiguration baseConfiguration;

    private byte[] bytes;

    private String cookieName;

    /**
     * 创建对应的token
     *
     * @param blogUser
     * @return
     */
    public String createUserJwt(@NotNull BlogUser blogUser) {
        HashMap<String, Object> map = new HashMap<>();
        DateTime now = DateTime.now();
        DateTime dateTime = now.offsetNew(DateField.HOUR, 24);
        map.put(JWTPayload.ISSUED_AT, now);
        map.put(JWTPayload.EXPIRES_AT, now);
        map.put("username", blogUser.getName());
        return JWTUtil.createToken(map, bytes);
    }

    /**
     * 验证
     *
     * @param token
     * @return
     */
    public boolean verify(String token) {
        return JWTUtil.verify(token, bytes);
    }

    /**
     * 验证
     *
     * @return
     */
    public String getName(String token) {
        if (verify(token)) {
            return "";
        }
        return JWTUtil.parseToken(token).getHeader("username").toString();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        bytes = baseConfiguration.getJwtCreat().getBytes();
        cookieName = baseConfiguration.getCookieName();
    }
}

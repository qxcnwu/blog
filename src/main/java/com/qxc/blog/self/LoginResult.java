package com.qxc.blog.self;

import com.qxc.blog.pojo.BlogUser;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

/**
 * @Author qxc
 * @Date 2024 2024/6/3 下午11:13
 * @Version 1.0
 * @PACKAGE com.qxc.blog.self
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class LoginResult extends Result<BlogUser> {

    private final static LoginResult ERROR_LOGIN_RESULT = new LoginResult();

    private String token;

    static {
        ERROR_LOGIN_RESULT.setResultEnum(ResultEnum.LOGINERROR);
    }

    /**
     * 移除密码再次提交
     *
     * @param blogUser
     */
    public LoginResult(@NotNull BlogUser blogUser, String token) {
        blogUser.setPwd("");
        setData(blogUser);
        setToken(token);
        setResultEnum(ResultEnum.LOGINSUCCESS);
    }

    /**
     * 返回登录失败对象
     *
     * @return
     */
    public static LoginResult getNullLoginResult() {
        return ERROR_LOGIN_RESULT;
    }
}

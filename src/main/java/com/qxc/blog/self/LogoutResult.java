package com.qxc.blog.self;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.jetbrains.annotations.Contract;

/**
 * @Author qxc
 * @Date 2024 2024/6/5 下午11:08
 * @Version 1.0
 * @PACKAGE com.qxc.blog.self
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class LogoutResult extends Result<Boolean>{
    private final static LogoutResult ERROR_LOGOUT_RESULT = new LogoutResult();


    static {
        ERROR_LOGOUT_RESULT.setResultEnum(ResultEnum.LOGOUTERROR);
        ERROR_LOGOUT_RESULT.setData(false);
    }

    /**
     * 登出用户
     */
    public LogoutResult() {
        setResultEnum(ResultEnum.LOGOUTSUCCESS);
        setData(true);
    }

    /**
     * 返回创建失败对象
     *
     * @return
     */
    @Contract(pure = true)
    public static LogoutResult getNullLoginResult() {
        return ERROR_LOGOUT_RESULT;
    }
}

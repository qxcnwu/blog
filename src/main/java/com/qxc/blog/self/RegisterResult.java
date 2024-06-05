package com.qxc.blog.self;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.jetbrains.annotations.Contract;

/**
 * @Author qxc
 * @Date 2024 2024/6/5 下午11:00
 * @Version 1.0
 * @PACKAGE com.qxc.blog.self
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class RegisterResult extends Result<Boolean> {
    private final static RegisterResult ERROR_REGISTER_RESULT = new RegisterResult();


    static {
        ERROR_REGISTER_RESULT.setResultEnum(ResultEnum.REGISTERERROR);
        ERROR_REGISTER_RESULT.setData(false);
    }

    /**
     * 创建用户
     */
    public RegisterResult() {
        setResultEnum(ResultEnum.REGISTERSUCCESS);
        setData(true);
    }

    /**
     * 返回创建失败对象
     *
     * @return
     */
    @Contract(pure = true)
    public static RegisterResult getNullLoginResult() {
        return ERROR_REGISTER_RESULT;
    }
}

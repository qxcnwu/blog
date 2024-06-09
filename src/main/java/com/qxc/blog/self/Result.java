package com.qxc.blog.self;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * @Author qxc
 * @Date 2024 2024/6/2 下午4:13
 * @Version 1.0
 * @PACKAGE com.qxc.blog.self
 */
@Setter
@Getter
public class Result<T> {
    private int errno;
    private String message;
    private T data;

    @Contract(pure = true)
    public Result() {
    }

    @Contract(pure = true)
    public Result(int errno, String message, T data) {
        this.errno = errno;
        this.message = message;
        this.data = data;
    }

    public void setResultEnum(@NotNull ResultEnum resultEnum) {
        setErrno(resultEnum.getCode());
        setMessage(resultEnum.getName());
    }

    /**
     * 需要登录返回这个对象
     * @return
     */
    public static @NotNull Result<Object> needLoginResult() {
        Result<Object> result = new Result<>();
        result.setMessage(ResultEnum.NEEDLOGINERROR.getName());
        result.setErrno(ResultEnum.NEEDLOGINERROR.getCode());
        return result;
    }

    @Override
    public String toString() {
        return "Result{" +
                "errno=" + errno +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}

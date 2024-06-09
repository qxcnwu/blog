package com.qxc.blog.self;

import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Constructor;

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
     *
     * @return
     */
    @SneakyThrows
    public static @NotNull <T extends Result<Object>> T needLoginResult(@NotNull Class<?> tClass) {
        final Constructor<T> declaredConstructor = (Constructor<T>) tClass.getDeclaredConstructor();
        final T t = declaredConstructor.newInstance();
        t.setErrno(ResultEnum.NEEDLOGINERROR.getCode());
        t.setMessage(ResultEnum.NEEDLOGINERROR.getName());
        return t;
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

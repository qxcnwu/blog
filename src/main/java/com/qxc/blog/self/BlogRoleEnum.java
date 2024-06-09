package com.qxc.blog.self;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * @Author qxc
 * @Date 2024 2024/6/6 下午9:49
 * @Version 1.0
 * @PACKAGE com.qxc.blog.self
 */
public enum BlogRoleEnum {
    WRITER(0, "ONLY WRITER"),
    TEAM(1, "ONLY TEAM PARTICIPANT"),
    USER(2, "ONLY LOGIN USER"),
    EVERYONE(3, "EVERYONE");

    private final int code;
    private final String description;

    @Contract(pure = true)
    BlogRoleEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

    @Contract(pure = true)
    public int getCode() {
        return code;
    }

    @Contract(pure = true)
    public String getDescription() {
        return description;
    }

    @Contract(pure = true)
    @Override
    public @NotNull String toString() {
        return "BlogRole{" +
                "code='" + code + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

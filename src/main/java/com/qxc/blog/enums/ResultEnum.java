package com.qxc.blog.enums;

import lombok.Getter;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * @Author qxc
 * @Date 2024 2024/6/2 下午2:36
 * @Version 1.0
 * @PACKAGE com.qxc.blog.enums
 */
@Getter
public enum ResultEnum {

    UPLOADIMAGESUCCESS("upload image success", 0),
    UPLOADIMAGEERROR("upload image error", 1),
    UPLOADATTACHMENTSUCCESS("upload attachment error", 0),
    UPLOADATTACHMENTERROR("upload attachment error", 1),
    NEEDLOGINERROR("please login again", -1);

    private final String name;
    private final int code;

    @Contract(pure = true)
    ResultEnum(String name, int code) {
        this.name = name;
        this.code = code;
    }

    @Contract(pure = true)
    @Override
    public @NotNull String toString() {
        return "ResultEnum{" +
                "name='" + name + '\'' +
                ", code=" + code +
                '}';
    }
}

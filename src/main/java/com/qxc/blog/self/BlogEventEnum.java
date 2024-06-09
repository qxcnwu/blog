package com.qxc.blog.self;

import org.jetbrains.annotations.Contract;

/**
 * @Author qxc
 * @Date 2024 2024/6/6 下午11:05
 * @Version 1.0
 * @PACKAGE com.qxc.blog.self
 */
public enum BlogEventEnum {
    CREATE(3), UPDATE(2), DELETE(4), SEE(1);

    private final int opVal;

    @Contract(pure = true)
    BlogEventEnum(int opVal) {
        this.opVal = opVal;
    }

    @Contract(pure = true)
    public int getOpVal() {
        return opVal;
    }
}

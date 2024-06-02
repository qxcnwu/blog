package com.qxc.blog.Utiles;

import com.qxc.blog.pojo.BlogUser;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

/**
 * @Author qxc
 * @Date 2024 2024/6/2 下午11:08
 * @Version 1.0
 * @PACKAGE com.qxc.blog.Utiles
 */
@Slf4j
public class PojoUtiles {
    public static boolean isRightBlogUser(@NotNull BlogUser blogUser) {
        String[] params = new String[]{
                blogUser.getName(),
                blogUser.getEmail(),
                blogUser.getPhone(),
                blogUser.getPwd()
        };
        if (Arrays.stream(params).anyMatch(PojoUtiles::checkEmptyAndBlank)) {
            log.error("user object has empty or blank value");
            return false;
        }
        return true;
    }

    /**
     * 参数校验非空非空格
     *
     * @param str
     * @return
     */
    private static boolean checkEmptyAndBlank(@NotNull String str) {
        return str.isEmpty() || str.isBlank();
    }
}

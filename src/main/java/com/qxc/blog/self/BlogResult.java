package com.qxc.blog.self;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.Contract;

import java.io.Serializable;

/**
 * @Author qxc
 * @Date 2024 2024/6/8 下午6:43
 * @Version 1.0
 * @PACKAGE com.qxc.blog.self
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class BlogResult extends Result<Object> implements Serializable {
    private final static BlogResult ERROR_BLOG_RESULT = new BlogResult();

    private String token;

    static {
        ERROR_BLOG_RESULT.setResultEnum(ResultEnum.BLOGEDITERROR);
    }

    public BlogResult(String articalId) {
        setResultEnum(ResultEnum.BLOGEDITSUCCESS);
        setData(articalId);
    }

    public BlogResult(BlogAndContent blogAndContent) {
        setResultEnum(ResultEnum.BLOGEDITSUCCESS);
        setData(blogAndContent);
    }

    /**
     * 返回登录失败对象
     *
     * @return
     */
    @Contract(pure = true)
    public static BlogResult getNullBlogResult() {
        return ERROR_BLOG_RESULT;
    }
}

package com.qxc.blog.self;

import com.qxc.blog.pojo.BlogUser;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

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
    public LoginResult(BlogUser blogUser) {
        setData(blogUser);
    }
}

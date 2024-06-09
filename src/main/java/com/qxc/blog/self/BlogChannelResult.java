package com.qxc.blog.self;

import com.qxc.blog.pojo.BlogRelationship;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @Author qxc
 * @Date 2024 2024/6/9 下午3:53
 * @Version 1.0
 * @PACKAGE com.qxc.blog.self
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BlogChannelResult extends Result<List<BlogRelationship>> {

    public BlogChannelResult(List<BlogRelationship> blogRelationShip) {
        setResultEnum(ResultEnum.BLOGCHANNELSUCCESS);
        setData(blogRelationShip);
    }
}

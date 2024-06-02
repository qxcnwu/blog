package com.qxc.blog.self;

import com.qxc.blog.enums.ResultEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

/**
 * @Author qxc
 * @Date 2024 2024/6/2 下午6:51
 * @Version 1.0
 * @PACKAGE com.qxc.blog.self
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class AttachmentResult extends Result<HashMap<String, String>> {

    public AttachmentResult() {
        setData(new HashMap<>());
    }

    public void setState(@NotNull ResultEnum resultEnum) {
        setErrno(resultEnum.getCode());
        setMessage(resultEnum.getName());
    }

    public void setUrl(String url) {
        getData().put("url", url);
    }

    public void setAlt(String alt) {
        getData().put("alt", alt);
    }

    public void setHref(String href) {
        getData().put("href", href);
    }
}

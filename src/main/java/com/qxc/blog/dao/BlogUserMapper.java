package com.qxc.blog.dao;

import com.qxc.blog.pojo.BlogUser;
import com.qxc.blog.pojo.BlogUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BlogUserMapper {
    long countByExample(BlogUserExample example);

    int deleteByExample(BlogUserExample example);

    int deleteByPrimaryKey(Long index);

    int insert(BlogUser record);

    int insertSelective(BlogUser record);

    List<BlogUser> selectByExample(BlogUserExample example);

    BlogUser selectByPrimaryKey(Long index);

    int updateByExampleSelective(@Param("record") BlogUser record, @Param("example") BlogUserExample example);

    int updateByExample(@Param("record") BlogUser record, @Param("example") BlogUserExample example);

    int updateByPrimaryKeySelective(BlogUser record);

    int updateByPrimaryKey(BlogUser record);
}
package com.qxc.blog.dao;

import com.qxc.blog.pojo.BlogRole;
import com.qxc.blog.pojo.BlogRoleExample;
import com.qxc.blog.pojo.BlogRoleKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BlogRoleMapper {
    long countByExample(BlogRoleExample example);

    int deleteByExample(BlogRoleExample example);

    int deleteByPrimaryKey(BlogRoleKey key);

    int insert(BlogRole record);

    int insertSelective(BlogRole record);

    List<BlogRole> selectByExample(BlogRoleExample example);

    BlogRole selectByPrimaryKey(BlogRoleKey key);

    int updateByExampleSelective(@Param("record") BlogRole record, @Param("example") BlogRoleExample example);

    int updateByExample(@Param("record") BlogRole record, @Param("example") BlogRoleExample example);

    int updateByPrimaryKeySelective(BlogRole record);

    int updateByPrimaryKey(BlogRole record);
}
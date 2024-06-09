package com.qxc.blog.dao;

import com.qxc.blog.pojo.BlogRelationship;
import com.qxc.blog.pojo.BlogRelationshipExample;
import com.qxc.blog.pojo.BlogRelationshipKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BlogRelationshipMapper {
    long countByExample(BlogRelationshipExample example);

    int deleteByExample(BlogRelationshipExample example);

    int deleteByPrimaryKey(BlogRelationshipKey key);

    int insert(BlogRelationship record);

    int insertSelective(BlogRelationship record);

    List<BlogRelationship> selectByExample(BlogRelationshipExample example);

    BlogRelationship selectByPrimaryKey(BlogRelationshipKey key);

    int updateByExampleSelective(@Param("record") BlogRelationship record, @Param("example") BlogRelationshipExample example);

    int updateByExample(@Param("record") BlogRelationship record, @Param("example") BlogRelationshipExample example);

    int updateByPrimaryKeySelective(BlogRelationship record);

    int updateByPrimaryKey(BlogRelationship record);
}
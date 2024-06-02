package com.qxc.blog.dao;

import com.qxc.blog.pojo.BlogComments;
import com.qxc.blog.pojo.BlogCommentsExample;
import com.qxc.blog.pojo.BlogCommentsKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BlogCommentsMapper {
    long countByExample(BlogCommentsExample example);

    int deleteByExample(BlogCommentsExample example);

    int deleteByPrimaryKey(BlogCommentsKey key);

    int insert(BlogComments record);

    int insertSelective(BlogComments record);

    List<BlogComments> selectByExampleWithBLOBs(BlogCommentsExample example);

    List<BlogComments> selectByExample(BlogCommentsExample example);

    BlogComments selectByPrimaryKey(BlogCommentsKey key);

    int updateByExampleSelective(@Param("record") BlogComments record, @Param("example") BlogCommentsExample example);

    int updateByExampleWithBLOBs(@Param("record") BlogComments record, @Param("example") BlogCommentsExample example);

    int updateByExample(@Param("record") BlogComments record, @Param("example") BlogCommentsExample example);

    int updateByPrimaryKeySelective(BlogComments record);

    int updateByPrimaryKeyWithBLOBs(BlogComments record);

    int updateByPrimaryKey(BlogComments record);
}
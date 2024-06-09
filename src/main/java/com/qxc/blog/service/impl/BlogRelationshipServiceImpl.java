package com.qxc.blog.service.impl;

import com.qxc.blog.AOPInterceptor.LogRecod.LogRecord;
import com.qxc.blog.dao.BlogRelationshipMapper;
import com.qxc.blog.pojo.BlogRelationship;
import com.qxc.blog.pojo.BlogRelationshipExample;
import com.qxc.blog.service.BlogRelationshipService;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author qxc
 * @Date 2024 2024/6/8 下午5:59
 * @Version 1.0
 * @PACKAGE com.qxc.blog.service.impl
 */
@Service
public class BlogRelationshipServiceImpl implements BlogRelationshipService {

    @Resource
    private BlogRelationshipMapper blogRelationshipMapper;

    /**
     * 增加
     *
     * @param blogRelationship
     * @return
     */
    @Override
    @Transactional
    @LogRecord
    public boolean addBlogRelationship(@NotNull BlogRelationship blogRelationship) throws Exception {
        BlogRelationshipExample example = new BlogRelationshipExample();
        example.createCriteria().andSonidxEqualTo(blogRelationship.getSonidx());
        List<BlogRelationship> list = blogRelationshipMapper.selectByExample(example);
        if (!list.isEmpty()) {
            throw new Exception("such relation ship contains!");
        }
        return blogRelationshipMapper.insert(blogRelationship) == 1;
    }

    /**
     * 删除
     *
     * @param blogRelationship
     * @return
     */
    @Override
    @Transactional(rollbackFor = {Exception.class, RuntimeException.class})
    @LogRecord()
    public List<String> deleteBlogRelationship(String articalId) throws Exception {
        final List<BlogRelationship> blogRelationShip = getBlogRelationShip(articalId);
        final List<String> sons = blogRelationShip.stream().map(BlogRelationship::getSonidx).collect(Collectors.toList());
        final List<String> answer = new ArrayList<>(sons);
        BlogRelationshipExample example = new BlogRelationshipExample();
        example.createCriteria().andSonidxIn(sons);
        if (blogRelationshipMapper.deleteByExample(example) != sons.size()) {
            throw new Exception("such relationship contains!");
        }
        sons.forEach(s -> {
            try {
                answer.addAll(deleteBlogRelationship(s));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        return answer;
    }

    /**
     * 获取
     *
     * @param articalId
     * @return
     */
    @Override
    @Transactional
    @LogRecord
    public List<BlogRelationship> getBlogRelationShip(String articalId) {
        BlogRelationshipExample example = new BlogRelationshipExample();
        example.createCriteria().andFatheridxEqualTo(articalId);
        return blogRelationshipMapper.selectByExample(example);
    }
}

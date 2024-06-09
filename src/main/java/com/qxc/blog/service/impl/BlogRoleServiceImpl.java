package com.qxc.blog.service.impl;

import com.qxc.blog.AOPInterceptor.LogRecod.LogRecord;
import com.qxc.blog.dao.BlogRoleMapper;
import com.qxc.blog.pojo.BlogRole;
import com.qxc.blog.pojo.BlogRoleExample;
import com.qxc.blog.self.BlogEventEnum;
import com.qxc.blog.service.BlogRoleService;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * @Author qxc
 * @Date 2024 2024/6/8 下午7:17
 * @Version 1.0
 * @PACKAGE com.qxc.blog.service.impl
 */
@Service
public class BlogRoleServiceImpl implements BlogRoleService {

    @Resource
    private BlogRoleMapper blogRoleMapper;

    /**
     * 增加操作权限
     *
     * @param blogRole
     * @return
     */
    @Override
    @Transactional
    @LogRecord
    public boolean addBlogRole(BlogRole blogRole) {
        final BlogRole role = getBlogRole(blogRole);
        if (Objects.isNull(role)) {
            return blogRoleMapper.insertSelective(blogRole) == 1;
        }
        BlogRoleExample example = new BlogRoleExample();
        example.createCriteria().andArticleidEqualTo(blogRole.getArticleid()).andAllowedusernameEqualTo(blogRole.getAllowedusername());
        return blogRoleMapper.updateByExample(blogRole, example) == 1;
    }

    /**
     * 删除权限
     *
     * @param blogRole
     * @return
     */
    @Override
    @Transactional
    @LogRecord
    public boolean deleteBlogRole(@NotNull BlogRole blogRole) {
        BlogRoleExample example = new BlogRoleExample();
        example.createCriteria().andArticleidEqualTo(blogRole.getArticleid()).andAllowedusernameEqualTo(blogRole.getAllowedusername());
        return blogRoleMapper.deleteByExample(example) == 1;
    }

    /**
     * 修改权限
     *
     * @param blogRole
     * @return
     */
    @Override
    @Transactional
    @LogRecord
    public boolean updateBlogRole(BlogRole blogRole) {
        final BlogRole role = getBlogRole(blogRole);
        if (Objects.isNull(role)) {
            return false;
        }
        BlogRoleExample example = new BlogRoleExample();
        example.createCriteria().andArticleidEqualTo(blogRole.getArticleid()).andAllowedusernameEqualTo(blogRole.getAllowedusername());
        return blogRoleMapper.updateByExample(blogRole, example) == 1;
    }

    /**
     * 获取对应文章的权限
     *
     * @param articalId
     * @return
     */
    @Override
    @Transactional
    @LogRecord
    public List<BlogRole> getBlogRoles(String articalId) {
        BlogRoleExample example = new BlogRoleExample();
        example.createCriteria().andArticleidEqualTo(articalId);
        return blogRoleMapper.selectByExample(example);
    }

    /**
     * 检查是否有该操作的权限
     *
     * @param blogRole
     * @param blogEvent
     * @return
     */
    @Override
    @Transactional
    @LogRecord
    public boolean checkBlogRole(BlogRole blogRole, BlogEventEnum blogEventEnum) {
        final BlogRole role = getBlogRole(blogRole);
        if (Objects.isNull(role)) {
            return false;
        }
        // 当前的操作代码是否小于赋权的操作
        return blogEventEnum.getOpVal() <= blogRole.getAllowmethod();
    }

    /**
     * 查询是否存在
     *
     * @param blogRole
     * @return
     */
    @Override
    public BlogRole getBlogRole(@NotNull BlogRole blogRole) {
        BlogRoleExample example = new BlogRoleExample();
        example.createCriteria().andArticleidEqualTo(blogRole.getArticleid()).andAllowedusernameEqualTo(blogRole.getAllowedusername());
        return blogRoleMapper.selectByExample(example).getFirst();
    }
}

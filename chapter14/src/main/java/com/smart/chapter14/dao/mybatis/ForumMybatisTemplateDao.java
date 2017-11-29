package com.smart.chapter14.dao.mybatis;

import com.smart.chapter14.domain.Forum;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * ForumMybatisTemplateDao
 *
 * @author ascend
 * @date 2017/11/29 15:13.
 */
@Repository
public class ForumMybatisTemplateDao {
    private SqlSessionTemplate sqlSessionTemplate;

    public Forum getForum(int forumId) {
        return sqlSessionTemplate.selectOne("com.smart.chapter14.dao.mybatis.ForumMybatisDao.getForum", forumId);
    }

    /**
     * 使用映射接口
     * @param forumId forumId
     * @return Forum
     */
    public Forum getForum2(int forumId) {
        ForumMybatisDao forumMybatisDao = sqlSessionTemplate.getMapper(ForumMybatisDao.class);
        return forumMybatisDao.getForum(forumId);
    }

    @Autowired
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }
}

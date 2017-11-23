package com.smart.chapter13.dao;

import com.smart.chapter13.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * PostDaoTest
 *
 * @author ascend
 * @date 2017/11/23 14:31.
 */
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@Rollback
@Transactional
public class PostDaoTest extends AbstractTransactionalTestNGSpringContextTests{
    private PostDao postDao;

    @Test
    public void testAddPost() throws IOException {
        Post post = new Post();
        post.setUserId(2);

        // 1、获取图片资源
        ClassPathResource resource = new ClassPathResource("temp.jpg");
        // 2、读取图片文件数据
        byte[] mockImg = FileCopyUtils.copyToByteArray(resource.getFile());
        post.setPostAttach(mockImg);
        post.setPostText("测试帖子的内容");
        postDao.addPost(post);
    }

    @Autowired
    public void setPostDao(PostDao postDao) {
        this.postDao = postDao;
    }
}

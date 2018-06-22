package com.smart.chapter18.dao;

import com.smart.chapter18.domain.User;
import com.smart.chapter18.test.dataset.util.XlsDataSetBeanFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.dbunit.annotation.ExpectedDataSet;
import org.unitils.spring.annotation.SpringBean;

/**
 * UserDaoTest
 *
 * @author ascend
 * @date 2018/6/21 9:51.
 */
public class UserDaoTest extends BaseDaoTest {
    @SpringBean("userDao")
    private UserDao userDao;

    @Test
    public void testGetUserByUserName() {
        User user = userDao.getUserByUserName("tony");
        Assert.assertNull(user, "不存在用户名为tony的用户!");
        user = userDao.getUserByUserName("john");
        Assert.assertNotNull(user, "john用户存在！");
        Assert.assertEquals("john", user.getUserName());
        Assert.assertEquals("1234", user.getPassword());
        Assert.assertEquals(10, user.getCredit());
    }

    // 验证数据库保存的正确性
    @Test
    @DataSet("XiaoChun.SaveUser.xls")
    @ExpectedDataSet("XiaoChun.ExpectedSaveUser.xls")
    public void saveUser()throws Exception  {
        User u  = XlsDataSetBeanFactory.createBean(UserDaoTest.class,"XiaoChun.SaveUser.xls", "t_user", User.class);
        userDao.update(u);  //执行用户信息更新操作
    }


    @Test
    public void testUpdateUser()throws Exception  {
        User user = XlsDataSetBeanFactory.createBean(UserDaoTest.class, "XiaoChun.SaveUser.xls", "t_user", User.class);
        System.out.println("user = " + user);
    }
}

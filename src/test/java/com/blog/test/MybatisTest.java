package com.blog.test;

import com.blog.dao.IUserDao;
import com.blog.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MybatisTest {
    private InputStream in ;
    private SqlSession session ;
    private IUserDao userDao;

    @Before
    public void init() throws Exception{
        //读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 创建SqlSessionFactory 工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        // 使用工厂生产对象
        session = factory.openSession();
        // 使用SqlSession 创建Dao 代理对象
        userDao = session.getMapper(IUserDao.class);
    }
    @After
    public void destroy() throws Exception{
        // 提交事务
        session.commit();
        //  释放资源
        session.close();
        in.close();
    }

    @Test
    public void findAll(){
        List<User> users = userDao.findAll();
        for (User user: users ) {
            System.out.println(user);
        }
    }

    @Test
    public void testSave(){
        User user = new User();
        user.setUsername("老张");
        user.setBirthday(new Date());
        user.setSex("男");
        user.setAddress("浙江杭州");
        userDao.saveUser(user);
    }

    @Test
    public void findById(){
        List<User> users = userDao.findById(1);
        for (User user: users) {
            System.out.println(user);
        }
    }

    @Test
    public void findByName(){
        List<User> users = userDao.findByName("%王%");
        for (User user: users) {
            System.out.println(user);
        }
    }
}

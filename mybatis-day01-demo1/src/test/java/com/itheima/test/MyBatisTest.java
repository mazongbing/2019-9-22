package com.itheima.test;

import com.itheima.domain.User;
import com.itheima.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/****
 * @Author:shenkunlin
 * @Date:2019/5/20 15:17
 * @Description:测试
 *****/
public class MyBatisTest {


    /****
     * 测试查询所有
     */
    @Test
    public void testFindAll() throws Exception{
        //读取配置文件,配置文件需要放在类路径下
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");

        //创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

        //通过SqlSessionBuilder对象构建一个SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = builder.build(is);

        //通过SqlSessionFactory构建一个SqlSession
        SqlSession session = sqlSessionFactory.openSession();

        //获取Dao接口的代理对象(获取Dao的实现类)
        UserMapper userProxy = session.getMapper(UserMapper.class);

        //调用接口指定方法->SELECT * FROM user->ResultSet->JavaBean
        List<User> users = userProxy.findAll();
        for (User user : users) {
            System.out.println(user.getUsername() + "住在：" + user.getAddress());
        }

        //关闭资源
        session.close();
        is.close();
    }

}

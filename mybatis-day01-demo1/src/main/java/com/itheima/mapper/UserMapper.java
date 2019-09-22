package com.itheima.mapper;

import com.itheima.domain.User;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Date:2019/5/20 15:09
 * @Description:Dao层
 *               UserDao
 *****/
public interface UserMapper {
    /***
     * 集合查询
     * @return
     */
    List<User> findAll();
}

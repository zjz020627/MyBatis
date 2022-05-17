package com.study.mybatis.mapper;

import com.study.mybatis.pojo.User;

import java.util.List;

/**
 * @author RenAshbell
 * @create 2022-05-17-20:19
 */
public interface UserMapper {
    /**
     * Mybatis面向接口编程的两个一致
     * 1.映射文件的namespace要和mapper接口的全类目保持一致
     *
     * 表--实体类--mapper接口--映射文件
     */

    /**
     *
     * 增加用户信息
     */
    int insertUser();

    /**
     * 修改用户信息
     */
    void updateUser();

    /**
     * 删除用户信息
     */
    void deleteUser();

    /**
     * 根据id查询用户信息
     */
    User getUserById();

    /**
     * 查询所有的用户信息
     */
    List<User> getAllUser();
}

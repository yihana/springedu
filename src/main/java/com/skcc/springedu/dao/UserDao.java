package com.skcc.springedu.dao;

import com.skcc.springedu.domain.User;

import java.util.List;

/**
 * @author HyunSub Shim
 * @since 1.0
 */
public interface UserDao {

    List<User> selectAll();

    User selectUser(int id);

    int insertUser(User user);

    int deleteUser(int id);

    int updateUser(User user);
}

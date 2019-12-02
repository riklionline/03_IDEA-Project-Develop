package com.remcal.dao;

import com.remcal.domain.User;

import java.util.List;

/**
 * @author wgy
 * @version 1.0
 * @date 2019/10/30
 */
public interface UserDao {
     List<User> findAll();
     User findById(Integer id);
     User findByUsernameAndPassword(String username, String password);

     User findByUserName(String username);

     void add(User user);

     void update(User user);

     void delete(Integer id);

     void updateActive(String email, String code);
}

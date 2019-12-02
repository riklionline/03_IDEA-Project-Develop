package com.remcal.service;


import com.remcal.domain.User;

/**
 * @author wgy
 * @version 1.0
 * @date 2019/10/30
 */
public interface UserService {

    public User checkUserName(String username);

    public void regist(User user);

    public User login(String username, String password);

    void activate(String email, String code);
}

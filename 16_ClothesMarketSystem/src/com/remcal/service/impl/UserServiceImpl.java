package com.remcal.service.impl;

import com.remcal.bean.User;
import com.remcal.service.UserService;
import com.remcal.utils.BusinessException;
import com.remcal.utils.EmptyUtils;
import com.remcal.utils.UserIO;


public class UserServiceImpl implements UserService {
    @Override
    public User register(User user) throws BusinessException {
        UserIO userIO = new UserIO();
        userIO.add(user);
        userIO.writeUsers();
        return user;
    }

    @Override
    public User login(String username, String password) throws BusinessException {
        if(EmptyUtils.isEmpty(username)){
            throw new BusinessException("username.notnull");
        }
        if(EmptyUtils.isEmpty(password)){
            throw new BusinessException("password.notnull");
        }

        UserIO userIO = new UserIO();
        userIO.readUsers();
        User user = userIO.findByUsernameAndPassword(username,password);

        return user;
    }
}

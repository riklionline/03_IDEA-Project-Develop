package com.remcal.service;

import com.remcal.bean.User;
import com.remcal.utils.BusinessException;


public interface UserService {

    public User register(User user)throws BusinessException;

    public User login(String username,String password)throws BusinessException;
}

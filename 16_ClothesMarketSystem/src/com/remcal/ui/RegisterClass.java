package com.remcal.ui;

import com.remcal.bean.User;
import com.remcal.service.UserService;
import com.remcal.service.impl.UserServiceImpl;
import com.remcal.utils.BusinessException;


public class RegisterClass extends BaseClass {

    private UserService userService;
    public RegisterClass(){
        userService = (UserService) beanFactory.getBean("userService");
    }
    public void register()throws BusinessException{
        println(getString("input.username"));
        String username = input.nextLine();
        println(getString("input.password"));
        String password = input.nextLine();
        User user = new User(username,password);
        UserService userService = new UserServiceImpl();
        userService.register(user);
    }

}

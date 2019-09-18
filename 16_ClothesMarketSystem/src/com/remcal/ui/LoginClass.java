package com.remcal.ui;

import com.remcal.bean.User;
import com.remcal.service.UserService;
import com.remcal.service.impl.UserServiceImpl;
import com.remcal.utils.BusinessException;

public class LoginClass extends BaseClass {
    private UserService userService;
    public LoginClass(){
        userService = (UserService) beanFactory.getBean("userService");
    }

    public void login()throws BusinessException{
        println(getString("input.username"));
        String username = input.nextLine();
        println(getString("input.password"));
        String password = input.nextLine();

        UserService userService = new UserServiceImpl();
        User user = userService.login(username,password);

        if(user!=null){
            currUser = user;
        }else{
            throw new BusinessException("login.error");
        }
    }
}

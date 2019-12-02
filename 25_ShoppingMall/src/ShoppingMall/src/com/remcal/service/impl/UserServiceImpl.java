package com.remcal.service.impl;

import com.remcal.dao.UserDao;
import com.remcal.dao.impl.UserDaoImpl;
import com.remcal.domain.User;
import com.remcal.service.UserService;
import com.remcal.utils.EmailUtils;
import com.remcal.utils.Md5Utils;

/**
 * @author wgy
 * @version 1.0
 * @date 2019/10/30
 */
public class UserServiceImpl implements UserService {
    UserDao userDao=new UserDaoImpl();
    @Override
    public User checkUserName(String username) {
        return userDao.findByUserName(username);
    }

    @Override
    public void regist(User user) {
        //逻辑
        //1密码加密
        String password=Md5Utils.md5(user.getPassword());
        user.setPassword(password);
        userDao.add(user);
        //2发送邮件
        EmailUtils.sendEmail(user);

    }

    @Override
    public User login(String username, String password) {
        //逻辑
        //密码加密
        password=Md5Utils.md5(password);
        return userDao.findByUsernameAndPassword(username, password);
    }

    @Override
    public void activate(String email, String code) {
        userDao.updateActive(email,code);
    }
}

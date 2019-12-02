package com.remcal.dao.impl;

import com.remcal.dao.UserDao;
import com.remcal.domain.User;
import com.remcal.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @author wgy
 * @version 1.0
 * @date 2019/10/30
 */
public class UserDaoImpl implements UserDao {
    @Override
    public List<User> findAll() {
        QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
        try {
            return qr.query("select * from tb_user", new BeanListHandler<>(User.class));
        } catch (SQLException e) {
            e.printStackTrace();
            throw  new RuntimeException("查询所有用户失败");
        }
    }

    @Override
    public User findById(Integer id) {
        QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
        try {
            return qr.query("select * from tb_user where id=?", new BeanHandler<>(User.class),id);
        } catch (SQLException e) {
            e.printStackTrace();
            throw  new RuntimeException("根据id查询所有用户失败");
        }
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
        try {
            return qr.query("select * from tb_user where username=? and password=?", new BeanHandler<>(User.class),username,password);
        } catch (SQLException e) {
            e.printStackTrace();
            throw  new RuntimeException("根据用户名和密码查询所有用户失败");
        }

    }

    @Override
    public User findByUserName(String username) {
        QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
        try {
            return qr.query("select * from tb_user where username=?", new BeanHandler<>(User.class),username);
        } catch (SQLException e) {
            e.printStackTrace();
            throw  new RuntimeException("根据用户名查询所有用户失败");
        }
    }

    @Override
    public void add(User user) {
        QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
        try {
            Object[] params={user.getUsername(),user.getPassword(),user.getEmail(),user.getGender(),user.getFlag(),user.getRole(),user.getCode()};
            qr.update("insert into tb_user(username,password,email,gender,flag,role,code) values(?,?,?,?,?,?,?)", params);
        } catch (SQLException e) {
            e.printStackTrace();
            throw  new RuntimeException("添加用户失败");
        }

    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void updateActive(String email, String code) {
        QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
        try {
            qr.update("update tb_user set flag=1 where email=? and code=?", email,code);
        } catch (SQLException e) {
            e.printStackTrace();
            throw  new RuntimeException("激活失败");
        }
    }
}

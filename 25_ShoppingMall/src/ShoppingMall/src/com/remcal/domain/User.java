package com.remcal.domain;

/**
 * @author wgy
 * @version 1.0
 * @date 2019/10/30
 * CREATE TABLE `tb_user` (
 *   `id` int(11) NOT NULL AUTO_INCREMENT,
 *   `username` varchar(20) NOT NULL,
 *   `password` varchar(32) NOT NULL,
 *   `email` varchar(50) NOT NULL,
 *   `gender` varchar(50) NOT NULL,
 *   `flag` int(11) DEFAULT NULL,
 *   `role` int(11) DEFAULT NULL,
 *   `code` varchar(100) DEFAULT NULL,
 *   PRIMARY KEY (`id`)
 * ) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8
 */
public class User {
    private Integer id;
    private String username;
    private String password;
    private String email;
    private String gender;
    private Integer flag;
    private Integer role;
    private String code;

    public User(Integer id, String username, String password, String email, String gender, Integer flag, Integer role, String code) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.gender = gender;
        this.flag = flag;
        this.role = role;
        this.code = code;
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}

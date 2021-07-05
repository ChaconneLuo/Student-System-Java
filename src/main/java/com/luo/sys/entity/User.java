package com.luo.sys.entity;

import lombok.Data;

@Data
public class User {
    private Integer uid;

    private Integer permission;

    private String userName;

    private String password;

    private Boolean sex;

    private Integer age;

    private String email;

    private Boolean Deleted;

    public User(Integer uid, Integer permission, String userName, String password, Boolean sex, Integer age, String email) {
        this.uid = uid;
        this.permission = permission;
        this.userName = userName;
        this.password = password;
        this.sex = sex;
        this.age = age;
        this.email = email;
        this.Deleted = false;
    }
}

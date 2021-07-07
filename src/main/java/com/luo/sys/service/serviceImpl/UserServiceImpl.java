package com.luo.sys.service.serviceImpl;

import com.luo.sys.entity.StudentInformation;
import com.luo.sys.entity.StudentScore;
import com.luo.sys.entity.TeacherInformation;
import com.luo.sys.entity.User;
import com.luo.sys.mapper.UserMapper;
import com.luo.sys.service.UserService;
import com.luo.sys.util.MapperUtils;


import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;

    public UserServiceImpl()
    {
        userMapper = MapperUtils.getMapper(UserMapper.class);
    }

    @Override
    public String getUserName(Integer uid) {
        return userMapper.getUserName(uid);
    }

    @Override
    public Integer getPermission(Integer uid) {
        return userMapper.getPermission(uid);
    }

    @Override
    public Boolean checkUid(Integer uid) {
        return userMapper.checkUid(uid);
    }

    @Override
    public void createUser(User u) {
        userMapper.createUser(u);
    }

    @Override
    public void createStu(StudentInformation s) {
        userMapper.createStu(s);
    }

    @Override
    public void createStuScore(StudentScore s) {
        userMapper.createStuScore(s);
    }

    @Override
    public void createTeacher(TeacherInformation t) {
        userMapper.createTeacher(t);
    }

    @Override
    public void deleteUser(Integer uid) {
        userMapper.deleteUser(uid);
    }

    @Override
    public Boolean checkRoot(Integer uid) {
        return userMapper.checkRoot(uid);
    }

    @Override
    public void updatePermission(Integer uid, Integer permission) {
        userMapper.updatePermission(uid, permission);
    }

    @Override
    public Map<String, Integer> getStuInformation(Integer uid) {
        return userMapper.getStuInformation(uid);
    }

    @Override
    public Map<String, Integer> getStuScore(Integer uid) {
        return userMapper.getStuScore(uid);
    }

    @Override
    public void updateEmail(Integer uid, String Email) {
        userMapper.updateEmail(uid,Email);
    }

    @Override
    public String getPassword(Integer uid) {
        return userMapper.getPassword(uid);
    }

    @Override
    public Integer Login(Integer uid, String password) {
        return userMapper.Login(uid,password);
    }

    @Override
    public Integer getUid(String username) {
        return userMapper.getUid(username);
    }

    @Override
    public void setScore(StudentScore studentScore){
        userMapper.setScore(studentScore);
    }

    @Override
    public List<User> getUser(Integer uid)
    {
        return userMapper.getUser(uid);
    }
}

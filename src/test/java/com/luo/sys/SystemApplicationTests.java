package com.luo.sys;

import com.luo.sys.entity.StudentInformation;
import com.luo.sys.entity.StudentScore;
import com.luo.sys.entity.User;
import com.luo.sys.service.UserService;
import com.luo.sys.service.serviceImpl.UserServiceImpl;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;

public class SystemApplicationTests {
    @Test
    public void Test(){
        UserServiceImpl userService = new UserServiceImpl();
        User u = new User(2,2,"luo","plf,.123",true,18,"luo@luo.com");
        userService.createUser(u);
        StudentInformation studentInformation = new StudentInformation(2,"computer",1,"Data",1,4,"9246");
        userService.createStu(studentInformation);
        StudentScore studentScore = new StudentScore(2,100,100,100,100,100,100,100);
        userService.createStuScore(studentScore);
        System.out.println("1");
    }
}

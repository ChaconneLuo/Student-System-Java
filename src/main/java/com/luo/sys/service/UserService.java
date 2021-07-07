package com.luo.sys.service;

import com.luo.sys.entity.StudentInformation;
import com.luo.sys.entity.StudentScore;
import com.luo.sys.entity.TeacherInformation;
import com.luo.sys.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserService {

    String getUserName(Integer uid);

    Integer getPermission(@Param("uid") Integer uid);

    Boolean checkUid(@Param("uid") Integer uid);

    void createUser(User u);

    void createStu(StudentInformation s);

    void createStuScore(StudentScore s);

    void createTeacher(TeacherInformation t);

    void deleteUser(Integer uid);

    Boolean checkRoot(@Param("uid") Integer uid);

    void updatePermission(@Param("uid") Integer uid, @Param("permission") Integer permission); //Integer id,Integer Permission

    Map<String, Integer> getStuInformation(Integer uid);

    Map<String, Integer> getStuScore(Integer uid);

    void updateEmail(@Param("uid") Integer uid, @Param("email") String Email);

    String getPassword(Integer uid);

    Integer Login(@Param("uid") Integer uid, @Param("password") String password);

    Integer getUid(String username);

    void setScore(StudentScore studentScore);

    List<User> getUser(Integer uid);
}

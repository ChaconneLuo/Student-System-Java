package com.luo.sys.mapper;

import com.luo.sys.entity.StudentInformation;
import com.luo.sys.entity.StudentScore;
import com.luo.sys.entity.TeacherInformation;
import com.luo.sys.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {
    String getUserName(Integer uid);     //Tested

    Integer getPermission(Integer uid);         //Tested

    Boolean checkUid(Integer uid);          //Tested

    void createUser(User u);            //Tested

    void createStu(StudentInformation s);

    void createStuScore(StudentScore s);

    void createTeacher(TeacherInformation t);

    void deleteUser(Integer uid);           //Tested

    Boolean checkRoot(Integer uid);   //Tested

    void updatePermission(@Param("uid") Integer uid,@Param("permission")Integer permission); //Integer id,Integer Permission

    Map<String,Integer> getStuInformation(Integer uid);

    Map<String,Integer> getStuScore(Integer uid);

    void updateEmail(@Param("uid") Integer uid,@Param("email") String Email);  //Tested

    String getPassword(Integer uid);

    Integer Login(@Param("uid") Integer uid,@Param("password")String password);

    Integer getUid(String username);

    void setScore(StudentScore studentScore);

    List<User> getUser(Integer uid);
}

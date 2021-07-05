package com.luo.sys.mapper;

import com.luo.sys.entity.StudentInformation;
import com.luo.sys.entity.StudentScore;
import com.luo.sys.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface ManageMapper {

    void createUser(User u);

    void createStu(StudentInformation s);

    void createStuScore(StudentScore s);

    Map<String, Integer> getStuInformation(Integer uid);

    Map<String, Integer> getStuScore(Integer uid);

    void deleteUser(Integer uid);

}

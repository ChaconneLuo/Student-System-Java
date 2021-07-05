package com.luo.sys.service;

import com.luo.sys.entity.StudentInformation;
import com.luo.sys.entity.StudentScore;
import com.luo.sys.entity.User;
import java.util.Map;

public interface ManageService {
    void createUser(User u);

    void createStu(StudentInformation s);

    void createStuScore(StudentScore s);

    Map<String, Integer> getStuInformation(Integer uid);

    Map<String, Integer> getStuScore(Integer uid);

    void deleteUser(Integer uid);
}

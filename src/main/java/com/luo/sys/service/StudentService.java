package com.luo.sys.service;


import java.util.Map;

public interface StudentService {
    Map<String, Integer> getStuInformation(Integer uid);

    Map<String, Integer> getStuScore(Integer uid);
}

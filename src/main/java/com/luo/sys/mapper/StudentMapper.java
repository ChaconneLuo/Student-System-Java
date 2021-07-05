package com.luo.sys.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface StudentMapper {

    Map<String, Integer> getStuInformation(Integer uid);

    Map<String, Integer> getStuScore(Integer uid);

}

package com.luo.sys.service.serviceImpl;

import com.luo.sys.mapper.StudentMapper;
import com.luo.sys.service.StudentService;
import com.luo.sys.util.MapperUtils;

import java.util.Map;

public class StudentServiceImpl implements StudentService
{
    private final StudentMapper studentMapper;

    public StudentServiceImpl()
    {
        studentMapper = MapperUtils.getMapper(StudentMapper.class);
    }

    @Override
    public Map<String, Integer> getStuInformation(Integer uid) {
        return studentMapper.getStuInformation(uid);
    }

    @Override
    public Map<String, Integer> getStuScore(Integer uid) {
        return studentMapper.getStuScore(uid);
    }
}

package com.luo.sys.service.serviceImpl;

import com.luo.sys.entity.StudentInformation;
import com.luo.sys.entity.StudentScore;
import com.luo.sys.entity.User;
import com.luo.sys.mapper.ManageMapper;
import com.luo.sys.service.ManageService;
import com.luo.sys.util.MapperUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ManageServiceImpl implements ManageService {

    private final ManageMapper manageMapper;

    public ManageServiceImpl()
    {
        manageMapper = MapperUtils.getMapper(ManageMapper.class);
    }

    @Override
    public void createUser(User u) {
        manageMapper.createUser(u);
    }

    @Override
    public void createStu(StudentInformation s) {
        manageMapper.createStu(s);
    }

    @Override
    public void createStuScore(StudentScore s) {
        manageMapper.createStuScore(s);
    }

    @Override
    public Map<String, Integer> getStuInformation(Integer uid) {
        return manageMapper.getStuInformation(uid);
    }

    @Override
    public Map<String, Integer> getStuScore(Integer uid) {
        return manageMapper.getStuScore(uid);
    }

    @Override
    public void deleteUser(Integer uid) {
        manageMapper.deleteUser(uid);
    }
}

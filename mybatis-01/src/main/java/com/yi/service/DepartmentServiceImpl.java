package com.yi.service;

import com.yi.mapper.DepartmentMapper;
import com.yi.pojo.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    DepartmentMapper departmentMapper;

    @Override
    public int insertDpt(Department department) {
        return departmentMapper.insertDpt(department);
    }

    @Override
    public int deleteDptById(int departmentid) {
        return departmentMapper.deleteDptById(departmentid);
    }

    @Override
    public int updateDpt(Department department) {
        return departmentMapper.updateDpt(department);
    }

    @Override
    public Department queryDptById(int departmentid) {
        return departmentMapper.queryDptById(departmentid);
    }

    @Override
    public List<Department> queryAllDpt() {
        return departmentMapper.queryAllDpt();
    }
}

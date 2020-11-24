package com.yi.mapper;

import com.yi.pojo.Department;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DepartmentMapper {
    //增加部门
    int insertDpt(Department department);

    //删除部门
    int deleteDptById(int departmentid);

    //更新部门信息
    int updateDpt(Department department);

    //查询所有部门
    List<Department> queryAllDpt();

    //根据ID查询部门
    Department queryDptById(int departmentid);
}

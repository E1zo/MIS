package com.yi.mapper;

import com.yi.pojo.Doctor;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DoctorMapper {
    //增加医生
    int insertDoc(Doctor doctor);

    //删除医生
    int deleteDocById(int doctorid);

    //更新医生信息
    int updateDoc(Doctor doctor);

    //查询所有医生
    List<Doctor> queryAllDoc();

    //根据ID查询医生
    Doctor queryDocById(int doctorid);
}

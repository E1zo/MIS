package com.yi.mapper;

import com.yi.pojo.Drug;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DrugMapper {

    //增加药品
    int insertDrug(Drug drug);

    //删除药品
    int deleteDrugById(int drugid);

    //更新药品信息
    int updateDrug(Drug drug);

    //查询所有药品
    List<Drug> queryAllDrug();

    //根据ID查询药品
    Drug queryDrugById(int drugid);

    //取药操作
    int takeDrug(Drug drug);
}

package com.yi.service;

import com.yi.pojo.Drug;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DrugService {

    //添加
    int insertDrug(Drug drug);

    //删除
    int deleteDrugById(int drugid);

    //更新
    int updateDrug(Drug drug);

    //根据ID查询
    Drug queryDrugById(int drugid);

    //查询全部
    List<Drug> queryAllDrug();

}

package com.yi.service;

import com.yi.mapper.DrugMapper;
import com.yi.pojo.Drug;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrugServiceImpl implements DrugService {

    @Autowired
    DrugMapper drugMapper;

    @Override
    public int insertDrug(Drug drug) {
        return drugMapper.insertDrug(drug);
    }

    @Override
    public int deleteDrugById(int drugid) {
        return drugMapper.deleteDrugById(drugid);
    }

    @Override
    public int updateDrug(Drug drug) {
        return drugMapper.updateDrug(drug);
    }

    public int updateDrugQuantity (Drug drug){
        return drugMapper.updateDrugQuantity(drug);
    }
    @Override
    public Drug queryDrugById(int drugid) {
        return drugMapper.queryDrugById(drugid);
    }

    @Override
    public List<Drug> queryAllDrug() {
        return drugMapper.queryAllDrug();
    }
    public List<Integer>queryAllDrugId(){
       return drugMapper.queryAllDrugId();
    }

    @Override
    public int takeDrug(Drug drug) {
        return drugMapper.takeDrug(drug);
    }
}

package com.yi.service;

import com.yi.mapper.CostMapper;
import com.yi.pojo.Cost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CostServiceImpl implements CostService {
    @Autowired
    CostMapper costMapper;
    @Override
    public int insertCost(Cost cost) {
        return costMapper.insertCost(cost);
    }

    @Override
    public int updateCost(Cost cost) {
        return costMapper.updateCost(cost);
    }

    public Cost queryCostByOutpatientid(Integer outpatientid){

        return costMapper.queryCostByOutpatientid(outpatientid);
    }
    public int  updateCostTotal(Cost cost){
        return costMapper.updateCostTotal(cost);
    }
}

package com.yi.service;

import com.yi.pojo.Cost;
import org.springframework.stereotype.Service;

@Service
public interface CostService {
    int insertCost(Cost cost);
    int updateCost(Cost cost);
    int updateCostTotal(Cost cost);
    Cost queryCostByOutpatientid(Integer outpatientid);
}

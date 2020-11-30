package com.yi.mapper;

import com.yi.pojo.Cost;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CostMapper {

    int insertCost(Cost cost);

    int updateCost(Cost cost);

    Cost queryCostByOutpatientid(Integer outpatientid);

    int updateCostTotal(Cost cost);
}

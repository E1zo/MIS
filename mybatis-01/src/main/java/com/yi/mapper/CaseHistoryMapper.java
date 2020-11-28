package com.yi.mapper;

import com.yi.pojo.CaseHistory;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CaseHistoryMapper {
    public  int updateCaseHistoryByCaseId(CaseHistory caseHistory);
}

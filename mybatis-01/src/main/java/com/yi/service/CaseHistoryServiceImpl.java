package com.yi.service;

import com.yi.mapper.CaseHistoryMapper;
import com.yi.pojo.CaseHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CaseHistoryServiceImpl implements CaseHistoryService {
   @Autowired
    CaseHistoryMapper caseHistoryMapper;


    public  int updateCaseHistoryByCaseId(CaseHistory caseHistory){
        return caseHistoryMapper.updateCaseHistoryByCaseId(caseHistory);
    }
}

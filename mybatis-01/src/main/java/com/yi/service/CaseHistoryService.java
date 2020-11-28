package com.yi.service;

import com.yi.pojo.CaseHistory;
import org.springframework.stereotype.Service;

@Service
public interface CaseHistoryService {
    public  int updateCaseHistoryByCaseId(CaseHistory caseHistory);
}

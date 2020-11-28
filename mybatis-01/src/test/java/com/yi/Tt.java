package com.yi;

import com.yi.pojo.CaseHistory;
import com.yi.pojo.Department;
import com.yi.pojo.Drug;
import com.yi.pojo.Prescription;
import com.yi.service.*;

import org.apache.ibatis.annotations.Case;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;


@SpringBootTest
class Tt {
    @Autowired
    UserService userService;
    @Autowired
    OutPatientService outPatientService;
    @Autowired
    DrugService drugService;
    @Autowired
    DepartmentService departmentService;
    @Autowired
    PrescriptionService prescriptionService;
    @Autowired
    CaseHistoryService caseHistoryService;
    @Autowired
    PrescriptionMedicationService prescriptionMedicationService;
    @Test
   void contextLoads(){


        List<Integer> a=prescriptionMedicationService.queryAlldrugid();
        System.out.println(a.contains(2));
    }
}

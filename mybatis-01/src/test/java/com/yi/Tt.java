package com.yi;

import com.yi.pojo.Drug;
import com.yi.service.DrugService;
import com.yi.service.OutPatientService;
import com.yi.service.UserService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


@SpringBootTest
class Tt {
    @Autowired
    UserService userService;
    @Autowired
    OutPatientService outPatientService;
    @Autowired
    DrugService drugService;

    @Test
   void contextLoads(){
        System.out.println(outPatientService.findOutPatientByPatientId(5));
        for (Drug drug : drugService.queryAllDrug()) {
            System.out.println(drug);
        }
    }
}

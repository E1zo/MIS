package com.yi;

import com.yi.pojo.Department;
import com.yi.pojo.Drug;
import com.yi.service.DepartmentService;
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
    @Autowired
    DepartmentService departmentService;

    @Test
   void contextLoads(){
        System.out.println(outPatientService.findOutPatientByPatientId(5));

        for (Drug drug : drugService.queryAllDrug()) {
            System.out.println(drug);
        }

        for (Department department : departmentService.queryAllDpt()) {
            System.out.println(department);
        }

        /*System.out.println(departmentService.insertDpt(new Department(3,"儿科","治儿童的")));*/

        System.out.println(departmentService.updateDpt(new Department(3,"五官科","治五官的")));

    }
}

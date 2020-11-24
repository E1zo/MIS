package com.yi;

import com.yi.service.OutPatientService;
import com.yi.service.UserService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class Tt {
    @Autowired
    UserService userService;
    @Autowired
    OutPatientService outPatientService;

    @Test
   void contextLoads(){
        System.out.println(outPatientService.findOutPatientByPatientId(5));
    }
}

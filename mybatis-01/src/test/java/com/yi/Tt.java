package com.yi;

import com.yi.service.UserService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class Tt {
    @Autowired
    UserService userService;

    @Test
   void contextLoads(){
        System.out.println(userService.queryByName("Ezio"));
    }
}

package com.yi;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class mybatis01Application {
    public static void main(String[] args) {

        SpringApplication.run(mybatis01Application.class,args);
    }
}

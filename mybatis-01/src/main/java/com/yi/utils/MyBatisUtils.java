package com.yi.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisUtils {
    private static SqlSessionFactory sqlSessionFactory;


    static {
        try{
            String resource="C:\\Users\\hasee\\Desktop\\Mybatis-3\\mybatis-01\\src\\main\\resources\\mybatis-config.xml";
            InputStream inputStream =Resources.getResourceAsStream(resource);
            sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);
        }catch(IOException e){
            e.printStackTrace();
        }

    }

    public  static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
    }
}

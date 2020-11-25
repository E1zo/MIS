package com.yi.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    //ShiroFilterFactoryBean
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("getDefaultWebSecurityManager") DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean bean=new ShiroFilterFactoryBean();
        //设置安全管理器
        bean.setSecurityManager(defaultWebSecurityManager);

        //shiro内置过滤器
        /*
        anon: 无需认证
        authc: 需要认证
        User: 拥有记住我才能用
        perms: 拥有对某个资源的权限才能访问:
        role: 拥有某个角色权限才能访问
         */
        Map<String, String> filterMap =new LinkedHashMap<>();
        //授权

        filterMap.put("/doctor/*","authc");
        filterMap.put("/drug/*","authc");
        filterMap.put("/outpatient/*","authc");
        filterMap.put("/patient/*","authc");
        filterMap.put("/setting/*","authc");
        filterMap.put("/user/*","authc");

        filterMap.put("/doctor/*","perms[Doctor]");
        filterMap.put("/drug/*","perms[Doctor]");
        filterMap.put("/outpatient/*","perms[Doctor]");
        filterMap.put("/patient/*","perms[Doctor]");
        filterMap.put("/setting/*","perms[Doctor]");
        filterMap.put("/Admin/*","perms[Admin]");




        //设置登录的请求
        bean.setFilterChainDefinitionMap(filterMap);
        bean.setLoginUrl("/toLogin");
        bean.setUnauthorizedUrl("/unAuthorization");


        return  bean;
    }

    //DefaultWebSecurityManager
    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager= new DefaultWebSecurityManager();
        //关联UserRealm
        securityManager.setRealm(userRealm);
        return  securityManager;
    }

    //创建 Realm对象
    @Bean(name = "userRealm")
    public UserRealm userRealm(){
        return new UserRealm();
    }
}

package com.duing.login.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean shiroFilter() {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //传入安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager());
        //传入未登录用户访问登陆用户的权限所跳转的页面
        shiroFilterFactoryBean.setLoginUrl("/login.html");
        //创建集合对象
        Map<String, String> map = new LinkedHashMap<>();
        //以下请求不需要验证
        map.put("/index.html", "anon");
        map.put("/login.html", "anon");
        map.put("/forget.html", "anon");
        map.put("/reg.html", "anon");
        map.put("/proList.html", "anon");
        map.put("/decoration.html", "anon");
        map.put("/vase_proList.html", "anon");
        map.put("/zbproList.html", "anon");
        map.put("/bzproList.html", "anon");
        map.put("/paint.html", "anon");
        map.put("/perfume.html", "anon");
        map.put("/showAllFurnitureToTable.html", "anon");
        map.put("/backEndLogin.html", "anon");
        map.put("/uploadFurniture.html", "anon");
        map.put("/swagger-ui.html", "anon");
        //所有请求都需要验证
        map.put("/*", "authc");
        //将集合放入shiro过滤器
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        //返回shiroFilterFactoryBean
        return shiroFilterFactoryBean;
    }

    @Bean
    public DefaultWebSecurityManager securityManager() {
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        MyRealm myRealm = myRealm();
        //将我们配置好的密码校验放入域中
        myRealm.setCredentialsMatcher(myCredentialsMatcher());
        //将域添加到我们的安全管理器中
        manager.setRealm(myRealm);
        return manager;
    }

    @Bean
    public MyCredentialsMatcher myCredentialsMatcher() {
        return new MyCredentialsMatcher();
    }

    @Bean
    public MyRealm myRealm() {
        return new MyRealm();
    }

}

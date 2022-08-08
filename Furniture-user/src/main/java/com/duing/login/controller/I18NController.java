package com.duing.login.controller;

import com.duing.annotation.SysLog;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * 做国际化效果
 */
@RestController
@RequestMapping("/householdFurniture/backstageI18n")
public class I18NController {

    @Autowired
    private Properties properties;


    /**
     * i18n国际化效果的展示
     * @param language 选择的语言
     * @return 选择语言的相关信息
     * @throws IOException io异常
     */
    @GetMapping("/i18n/{language}")
    @ApiOperation("i18n国际化效果的接口")
    @SysLog(BusinessName = "i18n国际化效果的接口")
    public Map<String,String> loginI18N(@PathVariable("language") String language) throws IOException {
        //创建集合对象
        Map<String,String> map = new HashMap<>();
        String load = "";
        //通过选择不同语言获取不同的配置文件的地址1
        if("中文".equals(language)){
            load = "i18n/messages_zh_CN.properties";
        }else {
            load = "i18n/messages_en_US.properties";
        }
        //获取输入流
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(load);
        //读取路径
        properties.load(is);
        //获取配置文件中的属性
        String account = properties.getProperty("manager.account");
        String password = properties.getProperty("manager.password");
        String submit = properties.getProperty("manager.submit");
        String reset = properties.getProperty("manager.reset");
        String info = properties.getProperty("manager.info");
        //将信息装入集合
        map.put("account",account);
        map.put("password",password);
        map.put("submit",submit);
        map.put("reset",reset);
        map.put("info",info);
        //返回集合
        return map;
    }



}

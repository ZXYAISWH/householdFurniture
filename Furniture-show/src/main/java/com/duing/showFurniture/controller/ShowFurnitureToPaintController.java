package com.duing.showFurniture.controller;

import com.duing.annotation.SysLog;
import com.duing.showFurniture.service.ShowAllFurnitureService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 家具墙饰壁挂的控制层
 *
 * @RestController 说明这是一个控制层对象, 并且方法返回json对象, 将这个控制层交给spring来管理, 底层实际用的是@Controller注解
 * @RequestMapping 处理请求地址映射的注解
 * @Api 表示标识这个类是swagger的资源, 并且说明接口的模块
 * @SuppressWarnings 不扫描本类规范
 */
@RestController
@RequestMapping("/householdFurniture/show")
@Api(tags = "家具展示(墙饰壁挂)的接口")
@SuppressWarnings("all")
public class ShowFurnitureToPaintController {

    /**
     * 获取家具的业务层
     *
     * @Autowired 自动注入对象
     */
    @Autowired
    private ShowAllFurnitureService showAllFurnitureService;

    /**
     * 获取墙饰壁挂家具的信息
     *
     * @return 墙饰壁挂家具的信息
     * @GetMapping 获取get请求的地址映射的注解
     * @ApiOperation 对某个方法/接口进行描述
     * @SysLog 通过切面的方式打印日志信息
     */
    @GetMapping("/getAllFurnitureToPaint")
    @ApiOperation("墙饰壁挂家具展示的接口")
    @SysLog(BusinessName = "墙饰壁挂家具展示的接口")
    public List<Map<String, String>> getAllFurnitureToPaint() {
        //调用业务层获取家具信息的方法,并且返回数据,墙饰壁挂类型
        return showAllFurnitureService.getAllFurnitureToPaint();
    }

}

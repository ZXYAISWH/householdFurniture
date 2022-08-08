package com.duing.showFurniture.controller;

import com.duing.annotation.SysLog;
import com.duing.showFurniture.service.ShowAllFurnitureService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 所有家具展示的控制层
 *
 * @RestController 说明这是一个控制层对象, 并且方法返回json对象, 将这个控制层交给spring来管理, 底层实际用的是@Controller注解
 * @RequestMapping 处理请求地址映射的注解
 * @Api 表示标识这个类是swagger的资源, 并且说明接口的模块
 * @SuppressWarnings 不扫描本类规范
 */
@RestController
@RequestMapping("/householdFurniture/show")
@Api(tags = "所有家具展示的接口")
@SuppressWarnings("all")
public class ShowAllFurnitureController {

    /**
     * 获取所有家具展示的业务层
     *
     * @Autowired 自动注入对象
     */
    @Autowired
    private ShowAllFurnitureService showAllFurnitureService;

    /**
     * 获取一些数据加载去首页
     *
     * @return 家具的信息
     * @GetMapping 获取get请求的地址映射的注解
     * @ApiOperation 对某个方法/接口进行描述
     * @SysLog 通过切面的方式打印日志信息
     */
    @GetMapping("/getAllFurniture")
    @ApiOperation("所有家具展示的接口")
    @SysLog(BusinessName = "所有家具展示的接口")
    public List<Map<String, String>> getAllFurniture() {
        //调用业务层获取所有家具的方法
        return showAllFurnitureService.getAllFurniture();
    }

    /**
     * 所有家具排序的控制层
     *
     * @return 所有家具信息
     * @paarm value 排序的方式
     * @GetMapping 获取get请求的地址映射的注解
     * @ApiOperation 对某个方法/接口进行描述
     * @ApiImplicitParam 对接口的参数的描述
     * @PathVariable 可以将 URL 中占位符参数绑定到控制器处理方法的入参中:URL 中的{xxx}占位符可以通过
     * @SysLog 通过切面的方式打印日志信息
     */
    @GetMapping("/getAllFurnitureOrderBy/{value}")
    @ApiOperation("所有家具排序展示的接口")
    @ApiImplicitParam(name = "value", value = "排序的方式")
    @SysLog(BusinessName = "所有家具排序展示的接口")
    public List<Map<String, String>> getAllFurnitureOrderBy(@PathVariable("value") String value) {
        //调用业务层所有家具排序的方法
        return showAllFurnitureService.getAllFurnitureOrderBy(value);
    }
}

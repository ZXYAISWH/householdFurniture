package com.duing.backstage.controller;

import com.duing.annotation.SysLog;
import com.duing.backstage.service.AddFurnitureTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 做后台上传家具类型的的控制层
 * 接收前端请求的
 * @RestController 说明这是一个控制层对象, 并且方法返回json对象, 将这个控制层交给spring来管理, 底层实际用的是@Controller注解
 * @RequestMapping 处理请求地址映射的注解
 * @Api 表示标识这个类是swagger的资源
 * @SuppressWarnings 不扫描本类规范
 */
@RestController
@RequestMapping("/householdFurniture/backstage")
@Api(tags = "后台添加家具类型的接口")
@SuppressWarnings("all")
public class AddFurnitureTypeController {

    /**
     * 获取添加家具类型的业务层
     */
    @Autowired
    private AddFurnitureTypeService addFurnitureTypeService;

    /**
     * 添加家具类型
     *
     * @param furnitureTypeName 家具类型的名称
     * @return 添加家具类型的结果
     * @PostMapping 获取post请求的地址映射的注解
     * @ApiOperation 对某个方法/接口进行描述
     * @ApiImplicitParam 对接口参数的描述
     * @SysLog 通过切面打印日志
     */
    @PostMapping("/addFurnitureType")
    @ApiOperation("添加家具类型的接口")
    @ApiImplicitParam(name = "furnitureTypeName", value = "家具类型的名称")
    @SysLog(BusinessName = "添加家具类型的接口")
    public String addFurnitureType(String furnitureTypeName) {
        //调用业务成添加家具类型的方法,并且返回结果
        return addFurnitureTypeService.addFurnitureType(furnitureTypeName);
    }

    /**
     * 获取家具类型的接口
     *
     * @return 所有的家具类型
     * @GetMapping 获取get请求的地址映射的注解
     * @ApiOperation 对某个方法/接口进行描述
     * @SysLog 通过切面打印日志
     */
    @GetMapping("/getAllFurnitureType")
    @ApiOperation("获取所有家具类型的接口")
    @SysLog(BusinessName = "获取所有家具类型的接口")
    public List<String> getAllFurnitureType() {
        //调用业务层获取家具类型的方法
        return addFurnitureTypeService.getAllFurnitureType();
    }
}

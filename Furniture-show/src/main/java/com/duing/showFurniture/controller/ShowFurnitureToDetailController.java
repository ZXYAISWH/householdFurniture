package com.duing.showFurniture.controller;

import com.duing.annotation.SysLog;
import com.duing.showFurniture.service.GetFurnitureDetailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 家具详情展示的控制层
 *
 * @RestController 说明这是一个控制层对象, 并且方法返回json对象, 将这个控制层交给spring来管理, 底层实际用的是@Controller注解
 * @RequestMapping 处理请求地址映射的注解
 * @Api 表示标识这个类是swagger的资源, 并且说明接口的模块
 * @SuppressWarnings 不扫描本类规范
 */

@RestController
@RequestMapping("/householdFurniture/show")
@Api(tags = "家具详细信息的接口")
@SuppressWarnings("all")
public class ShowFurnitureToDetailController {

    /**
     * 获取家具详情展示的业务层对象
     *
     * @Autowired 自动注入对象
     */
    @Autowired
    private GetFurnitureDetailService getFurnitureDetailService;

    /**
     * 通过家具的id获取家具的详情
     *
     * @param furnitureId 家具的id
     * @return 家具的详细信息
     * @GetMapping 获取get请求的地址映射的注解
     * @ApiOperation 对某个方法/接口进行描述
     * @ApiImplicitParam 对接口的参数的描述
     * @SysLog 通过切面的方式打印日志信息
     * @PathVariable 可以将 URL 中占位符参数绑定到控制器处理方法的入参中:URL 中的{xxx}占位符可以通过
     */
    @GetMapping("/getFurnitureDetail/{furnitureId}")
    @ApiOperation("家具详细信息展示的接口")
    @ApiImplicitParam(name = "furnitureId", value = "家具的id")
    @SysLog(BusinessName = "家具详细信息展示的接口")
    public Map<String, Object> getFurnitureDetail(@PathVariable("furnitureId") Integer furnitureId) {
        //调用业务层获取家具详细信息的方法
        return getFurnitureDetailService.getDetail(furnitureId);

    }

    /**
     * 获取家具的评论信息
     *
     * @param furnitureId 家具的id
     * @return 获取家具的评论信息
     * @GetMapping 获取get请求的地址映射的注解
     * @ApiOperation 对某个方法/接口进行描述
     * @ApiImplicitParam 对接口的参数的描述
     * @SysLog 通过切面的方式打印日志信息
     * @PathVariable 可以将 URL 中占位符参数绑定到控制器处理方法的入参中:URL 中的{xxx}占位符可以通过
     */
    @GetMapping("/getFurnitureComment/{furnitureId}")
    @ApiOperation("获取家具评论信息的接口")
    @ApiImplicitParam(name = "furnitureId", value = "家具的id")
    @SysLog(BusinessName = "获取家具评论信息的接口")
    public List<HashMap<String, Object>> getFurnitureComment(@PathVariable("furnitureId") Integer furnitureId) {
        //调用业务层获取家具评论信息的方法
        return getFurnitureDetailService.getFurnitureComment(furnitureId);
    }

    /**
     * 获取家具详情时猜你喜欢的家具
     * @return 家具的详细信息
     * @GetMapping 获取get请求的地址映射的注解
     * @ApiOperation 对某个方法/接口进行描述
     * @SysLog 通过切面的方式打印日志信息
     */
    @GetMapping("/getFurnitureToYouLove")
    @ApiOperation("获取猜你喜欢家具的接口")
    @SysLog(BusinessName = "获取猜你喜欢家具的接口")
    public List<Map<String, String>> getFurnitureToYouLove(){
        //调用业务层的方法
        return getFurnitureDetailService.getFurnitureToYouLove();
    }

}

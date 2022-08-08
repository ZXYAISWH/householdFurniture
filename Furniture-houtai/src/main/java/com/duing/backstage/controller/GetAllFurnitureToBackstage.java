package com.duing.backstage.controller;

import com.duing.annotation.SysLog;
import com.duing.backstage.domain.F_furniture;
import com.duing.backstage.domain.F_furniture_inventory;
import com.duing.backstage.service.GetAllFurnitureService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 后台操作家具的控制层
 *
 * @RestController 说明这是一个控制层对象, 并且方法返回json对象, 将这个控制层交给spring来管理, 底层实际用的是@Controller注解
 * @RequestMapping 处理请求地址映射的注解
 * @Api 表示标识这个类是swagger的资源, 并且说明接口的模块
 * @SuppressWarnings 不扫描本类规范
 */
@RestController
@Api(tags = "后台展示所有家具的接口")
@RequestMapping("/householdFurniture/backstage")
@SuppressWarnings("all")
public class GetAllFurnitureToBackstage {

    /**
     * 获取业务层对象
     *
     * @Autowired 自动注入对象
     */
    @Autowired
    private GetAllFurnitureService getAllFurnitureService;

    /**
     * 获取所有家具
     *
     * @GetMapping 获取get请求的地址映射的注解
     * @ApiOperation 对某个方法/接口进行描述
     * @SysLog 通过切面打印日志
     */
    @GetMapping("/getAllFurniture")
    @ApiOperation("获取所有的家具信息的接口")
    @SysLog(BusinessName = "获取所有的家具信息的接口")
    public List<Map<String, Object>> getAllFurniture() {
        //调用业务层的方法
        return getAllFurnitureService.getAllFurniture();
    }

    /**
     * 获取家具的详细信息
     *
     * @param id 家具id
     * @return 家具的信息
     * @GetMapping 获取get请求的地址映射的注解
     * @ApiOperation 对某个方法/接口进行描述
     * @SysLog 通过切面打印日志
     */
    @GetMapping("/getFurnitureInfo/{fid}")
    @ApiOperation("获取家具的详细信息的接口")
    @SysLog(BusinessName = "获取家具的详细信息的接口")
    public Map<String, Object> getFurnitureInfo(@PathVariable("fid") Integer id) {
        //调用业务层的方法
        return getAllFurnitureService.getFurnitureInfo(id);
    }

    /**
     * 用来下架家具
     *
     * @param id 家具的id
     * @PutMapping 获取put请求的地址映射的注解
     * @ApiOperation 对某个方法/接口进行描述
     * @SysLog 通过切面打印日志
     */
    @PutMapping("/soldOutFurniture")
    @ApiOperation("下架家具的接口")
    @SysLog(BusinessName = "下架家具的接口")
    public void soldOutFurniture(Integer id) {
        //调用业务层家具下架的方法
        getAllFurnitureService.soldOutFurniture(id);
    }

    /**
     * 用来上架家具
     *
     * @param id 家具的id
     * @PutMapping 获取put请求的地址映射的注解
     * @ApiOperation 对某个方法/接口进行描述
     * @SysLog 通过切面打印日志
     */
    @PutMapping("/soldInFurniture")
    @ApiOperation("上架家具的接口")
    @SysLog(BusinessName = "上架家具的接口")
    public void soldInFurniture(Integer id) {
        //调用业务层家具上架的方法
        getAllFurnitureService.soldInFurniture(id);
    }

    /**
     * 用来删除家具
     *
     * @param id 家具的id
     * @DeleteMapping 获取delete请求的地址映射的注解
     * @ApiOperation 对某个方法/接口进行描述
     * @SysLog 通过切面打印日志
     */
    @DeleteMapping("/deleteFurniture/{id}")
    @ApiOperation("删除家具的接口")
    @SysLog(BusinessName = "删除家具的接口")
    public void deleteFurniture(@PathVariable("id") Integer id) {
        //调用业务层家具删除的方法
        getAllFurnitureService.deleteFurniture(id);
    }

    /**
     * 修改家具信息的方法
     *
     * @param furniture 家具信息对象
     * @param inventory 家具库存对象
     * @PutMapping 获取put请求的地址映射的注解
     * @ApiOperation 对某个方法/接口进行描述
     * @SysLog 通过切面打印日志
     */
    @PutMapping("/updateFurnitureInfo")
    @ApiOperation("修改家具信息的接口")
    @SysLog(BusinessName = "修改家具信息的接口")
    public void updateFurnitureInfo(F_furniture furniture, F_furniture_inventory inventory) {
        //调用业务层的方法
        getAllFurnitureService.updateFurnitureInfo(furniture, inventory);
    }

    /**
     *
     * @return 所有的家具类型
     * @GetMapping 获取get请求的地址映射的注解
     * @ApiOperation 对某个方法/接口进行描述
     * @SysLog 通过切面打印日志
     */
    @GetMapping("/getSumFurnitureType")
    @ApiOperation("获取所有家具类型的接口")
    @SysLog(BusinessName = "获取所有家具类型的接口")
    public List<String> getAllFurnitureType(){
        //调用业务层的方法
        return getAllFurnitureService.getAllFurnitureType();
    }

    /**
     * 通过家具类型获取家具
     * @param type 家具的类型
     * @return 属于家具类型的家具
     * @GetMapping 获取get请求的地址映射的注解
     * @ApiOperation 对某个方法/接口进行描述
     * @SysLog 通过切面打印日志
     */
    @GetMapping("/getFurnitureByType/{type}")
    @ApiOperation("获取属于家具类型家具的接口")
    @SysLog(BusinessName = "获取属于家具类型家具的接口")
    public List<Map<String, Object>> getFurnitureByType(@PathVariable("type") String type){
        //调用业务层的方法
        return getAllFurnitureService.getFurnitureByType(type);
    }
}

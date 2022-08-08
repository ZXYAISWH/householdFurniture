package com.duing.backstage.controller;

import com.duing.annotation.NotControllerResponseAdvice;
import com.duing.backstage.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * 后台添加家具的控制层
 *
 * @RestController 说明这是一个控制层对象, 并且方法返回json对象, 将这个控制层交给spring来管理, 底层实际用的是@Controller注解
 * @RequestMapping 处理请求地址映射的注解
 * @Api 表示标识这个类是swagger的资源, 并且说明接口的模块
 * @SuppressWarnings 不扫描本类规范
 */

@RestController
@RequestMapping("/householdFurniture/backstage")
@Api(tags = "后台添加家具的接口")
@SuppressWarnings("all")
public class AddFurnitureController {

    /**
     * 获取添加家具类型的业务层
     *
     * @Autowired 自动注入对象
     */
    @Autowired
    private AddFurnitureTypeService addFurnitureTypeService;

    /**
     * 添加家具的业务层
     *
     * @Autowired 自动注入对象
     */
    @Autowired
    private AddFurnitureService addFurnitureService;

    /**
     * 获取家具小图添加的业务层
     *
     * @Autowired 自动注入对象
     */
    @Autowired
    private AddFurnitureSmallImgService addFurnitureSmallImgService;

    /**
     * 获取家具详情表的业务层
     *
     * @Autowired 自动注入对象
     */
    @Autowired
    private AddFurnitureDetailService addFurnitureDetailService;

    /**
     * 获取家具属性业务层对象
     *
     * @Autowired 自动注入对象
     */
    @Autowired
    private AddFurniturePropertyKeyService addFurniturePropertyKeyService;

    /**
     * 获取家具属性值业务层对象
     *
     * @Autowired 自动注入对象
     */
    @Autowired
    private AddFurniturePropertyValueService addFurniturePropertyValueService;

    /**
     * 获取属性/属性值/家具公共的业务层
     *
     * @Autowired 自动注入对象
     */
    @Autowired
    private AddFurniturePropertyService addFurniturePropertyService;

    /**
     * 获取库表业务层的对象
     *
     * @Autowired 自动注入对象
     */
    @Autowired
    private AddFurnitureInventoryService addFurnitureInventoryService;

    /**
     * 做后台家具的新增
     *
     * @param furnitureBigImg        大图的路径
     * @param furnitureSmallImg      多个小图的路径
     * @param price                  家具的价格
     * @param selectType             家具的类型
     * @param furnitureName          家具的名称
     * @param description            家具的描述
     * @param keyWordSearch          家具的关键字
     * @param selectFurnitureDetails 家具的详情属性
     * @param details                家具的详情值
     * @param inventory              家具的库存
     */
    @PostMapping("/addFurniture")
    @ApiOperation("添加家具后台的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "furnitureBigImg", value = "大图的路径"),
            @ApiImplicitParam(name = "furnitureSmallImg", value = "多个小图的路径"),
            @ApiImplicitParam(name = "price", value = "家具的价格"),
            @ApiImplicitParam(name = "selectType", value = "家具的类型"),
            @ApiImplicitParam(name = "furnitureName", value = "家具的名称"),
            @ApiImplicitParam(name = "description", value = "家具的描述"),
            @ApiImplicitParam(name = "keyWordSearch", value = "家具的关键字"),
            @ApiImplicitParam(name = "selectFurnitureDetails", value = "家具的详情属性"),
            @ApiImplicitParam(name = "details", value = "家具的详情值"),
            @ApiImplicitParam(name = "inventory", value = "家具的库存"),
    })
    @NotControllerResponseAdvice
    public void addFurniture(MultipartFile furnitureBigImg, MultipartFile[] furnitureSmallImg, String price, String selectType, String furnitureName, String description, String keyWordSearch, String selectFurnitureDetails, String details, String inventory) {
        //调用业务层的方法,通过类型获取ID
        Integer classifyId = addFurnitureTypeService.getFuritureTypeId(selectType);
        //调用添加家具业务层的方法
        String furnitureNo = addFurnitureService.addFurniture(furnitureBigImg, classifyId, furnitureName, keyWordSearch, description);
        //通过唯一的家具标识获取家具的ID
        Integer furnitureId = addFurnitureService.getFurnitureID(furnitureNo);
        //调用添加家具小图业务成的方法
        addFurnitureSmallImgService.addFurnitureSmallImg(furnitureSmallImg, furnitureId);
        //调用添加家具详情业务层的方法
        addFurnitureDetailService.addFurnitureDetail(selectFurnitureDetails, details, furnitureId);
        //调用业务层添加家具属性的方法
        addFurniturePropertyKeyService.addFurniturePropertyKey(selectFurnitureDetails, furnitureId);
        //获取家具属性的id
        Integer propertykeyId = addFurniturePropertyKeyService.getPropertyId(furnitureId);
        //调用业务层添加家具属性值的方法
        addFurniturePropertyValueService.addFurniturePropertyValue(details, propertykeyId);
        //获取属性对应属性值的id
        Integer propertyValueId = addFurniturePropertyValueService.getPropertyValueId(propertykeyId);
        //获取添加公共值的业务层
        addFurniturePropertyService.addProperty(furnitureId, propertykeyId, propertyValueId);
        //获取添加家具库存的业务层
        addFurnitureInventoryService.addFurnitureInventory(price, inventory, furnitureId);
    }
}

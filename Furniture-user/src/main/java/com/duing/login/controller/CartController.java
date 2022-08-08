package com.duing.login.controller;

import com.duing.annotation.SysLog;
import com.duing.login.service.CartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;


/**
 * 做用户购物车模块的控制层
 *
 * @RestController 说明这是一个控制层对象, 并且方法返回json对象, 将这个控制层交给spring来管理, 底层实际用的是@Controller注解
 * @RequestMapping 处理请求地址映射的注解
 * @Api 表示标识这个类是swagger的资源, 并且说明接口的模块
 * @SuppressWarnings 不扫描本类规范
 */

@RestController
@RequestMapping("/householdFurniture/cart")
@Api(tags = "购物车模块的接口")
@SuppressWarnings("all")
public class CartController {

    /**
     * 获取购物车业务层
     *
     * @Autowired 自动注入对象
     */
    @Autowired
    private CartService cartService;

    /**
     * 用户添加购物车
     *
     * @param id      家具的id
     * @param number  订单家具的数量
     * @param account 用户的账号
     * @PostMapping 获取post请求的地址映射的注解
     * @ApiOperation 对某个方法/接口进行描述
     * @ApiImplicitParams 对接口的多个参数描述
     * @ApiImplicitParam 对接口的参数的描述
     * @SysLog 通过切面的方式打印日志信息
     */
    @PostMapping("/addCart")
    @ApiOperation("添加购物车的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "家具的id"),
            @ApiImplicitParam(name = "number", value = "订单家具的数量"),
            @ApiImplicitParam(name = "account", value = "用户的账号"),
    })
    @SysLog(BusinessName = "添加购物车的接口")
    public void addCart(Integer id, Integer number, String account) {
        //调用业务层添加购物车的方法
        cartService.addCart(id, number, account);
    }

    /**
     * 获取用户所有购物车的家具
     *
     * @param account 用户的账号
     * @return 所有家具信息
     * @GetMapping 获取get请求的地址映射的注解
     * @ApiOperation 对某个方法/接口进行描述
     * @ApiImplicitParam 对接口的参数的描述
     * @SysLog 通过切面的方式打印日志信息
     */
    @GetMapping("/getAllCarFurniture/{account}")
    @ApiOperation("获取用户所有购物车家具的接口")
    @ApiImplicitParam(name = "account", value = "用户的账号")
    @SysLog(BusinessName = "获取用户所有购物车家具的接口")
    public List<HashMap<String, Object>> getAllCarFurniture(@PathVariable("account") String account) {
        //调用业务层的方法
        return cartService.getAllCarFurniture(account);
    }

    /**
     * 删除购物车家具信息
     *
     * @param cartId 购物车信息的id
     * @DeleteMapping 获取delete请求的地址映射的注解
     * @ApiOperation 对某个方法/接口进行描述
     * @ApiImplicitParam 对接口的参数的描述
     * @SysLog 通过切面的方式打印日志信息
     */
    @DeleteMapping("/deleteCartFurniture/{cartId}")
    @ApiOperation("删除购物车家具信息的接口")
    @ApiImplicitParam(name = "cartId", value = "购物车信息的id")
    @SysLog(BusinessName = "删除购物车家具信息的接口")
    public void deleteCartFurniture(@PathVariable("cartId") Integer cartId) {
        //调用业务层的方法
        cartService.deleteCartFurniture(cartId);
    }
}

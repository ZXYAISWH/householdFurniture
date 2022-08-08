package com.duing.login.controller;

import com.alipay.api.AlipayApiException;
import com.duing.annotation.NotControllerResponseAdvice;
import com.duing.annotation.SysLog;
import com.duing.login.domain.AliPayBean;
import com.duing.login.domain.F_user_address;
import com.duing.login.service.OrderService;
import com.duing.login.service.PayService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;


/**
 * 做用户订单模块的控制层
 *
 * @RestController 说明这是一个控制层对象, 并且方法返回json对象, 将这个控制层交给spring来管理, 底层实际用的是@Controller注解
 * @RequestMapping 处理请求地址映射的注解
 * @Api 表示标识这个类是swagger的资源, 并且说明接口的模块
 * @SuppressWarnings 不扫描本类规范
 */
@RestController
@RequestMapping("/householdFurniture/order")
@Api(tags = "订单模块的接口")
@SuppressWarnings("all")
public class OrderController {

    /**
     * 获取订单模块的业务层对象
     *
     * @Autowired 自动注入对象
     */
    @Autowired
    private OrderService orderService;

    @Autowired
    private PayService payService;

    /**
     * 获取所有的用户地址
     *
     * @param account 用户的账号
     * @return 所有地址对象
     * @GetMapping 获取get请求的地址映射的注解
     * @ApiOperation 对某个方法/接口进行描述
     * @ApiImplicitParam 对接口的参数的描述
     * @SysLog 通过切面的方式打印日志信息
     * @PathVariable 可以将 URL 中占位符参数绑定到控制器处理方法的入参中:URL 中的{xxx}占位符可以通过
     */
    @GetMapping("/getUserAllAddress/{account}")
    @ApiOperation("获取用户所有收货地址的接口")
    @ApiImplicitParam(name = "account", value = "用户的账号")
    @SysLog(BusinessName = "获取用户所有收货地址的接口")
    public List<F_user_address> getUserAllAddress(@PathVariable("account") String account) {
        //调用业务层获取用户所有地址的方法
        return orderService.getUserAllAddress(account);
    }

    /**
     * 订单购买家具详细信息
     *
     * @param id      购买家具的id
     * @param price   购买家具的价格
     * @param number  购买家具的数量
     * @param account 用户的账号
     * @return 家具的编号
     * @PostMapping 获取post请求的地址映射的注解
     * @ApiOperation 对某个方法/接口进行描述
     * @ApiImplicitParams 描述多个参数
     * @ApiImplicitParam 对接口的参数的描述
     * @SysLog 通过切面的方式打印日志信息
     * @PathVariable 可以将 URL 中占位符参数绑定到控制器处理方法的入参中:URL 中的{xxx}占位符可以通过
     */
    @PostMapping("/orderFurnitureDetailInfo")
    @ApiOperation("订单家具详细信息的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "account", value = "用户的账号"),
            @ApiImplicitParam(name = "id", value = "购买家具的id"),
            @ApiImplicitParam(name = "price", value = "购买家具的价格"),
            @ApiImplicitParam(name = "number", value = "购买家具的数量"),
    })
    @SysLog(BusinessName = "订单家具详细信息的接口")
    public String orderFurnitureDetailInfo(String id, String price, String number, String account) {
        //调用业务层订单详细信息的方法,并且返回订单的编号
        return orderService.orderFurnitureDetailInfo(id, price, number, account);
    }

    /**
     * 获取订单详细信息
     *
     * @param OrderCode 订单编号
     * @return 订单的信息
     * @GetMapping 获取get请求的地址映射的注解
     * @ApiOperation 对某个方法/接口进行描述
     * @ApiImplicitParam 对接口的参数的描述
     * @SysLog 通过切面的方式打印日志信息
     * @PathVariable 可以将 URL 中占位符参数绑定到控制器处理方法的入参中:URL 中的{xxx}占位符可以通过
     */
    @GetMapping("/getOrderDetail/{OrderCode}")
    @ApiOperation("获取订单家具详细信息的接口")
    @ApiImplicitParam(name = "OrderCode", value = "订单的编号")
    @SysLog(BusinessName = "获取订单家具详细信息的接口")
    public HashMap<String, Object> getOrderDetail(@PathVariable("OrderCode") String OrderCode) {
        //调用业务层获取订单详细信息的方法
        return orderService.getOrderDetail(OrderCode);
    }


    /**
     * 获取用户所有的订单
     *
     * @param account 用户的账号
     * @return 用户所有的订单
     * @GetMapping 获取get请求的地址映射的注解
     * @ApiOperation 对某个方法/接口进行描述
     * @ApiImplicitParam 对接口的参数的描述
     * @SysLog 通过切面的方式打印日志信息
     * @PathVariable 可以将 URL 中占位符参数绑定到控制器处理方法的入参中:URL 中的{xxx}占位符可以通过
     */
    @GetMapping("/getAllUserOrder/{account}")
    @ApiOperation("获取用户所有订单的接口")
    @ApiImplicitParam(name = "account", value = "用户的账号")
    @SysLog(BusinessName = "获取用户所有订单的接口")
    public List<HashMap<String, Object>> getAllUserOrder(@PathVariable("account") String account) {
        //获取用户所有订单的信息
        return orderService.getAllUserOrder(account);
    }

    /**
     * 获取用户所有未付款的订单
     *
     * @param account 用户的账号
     * @return 返回用户全部没有付款的订单
     * @GetMapping 获取get请求的地址映射的注解
     * @ApiOperation 对某个方法/接口进行描述
     * @ApiImplicitParam 对接口的参数的描述
     * @SysLog 通过切面的方式打印日志信息
     * @PathVariable 可以将 URL 中占位符参数绑定到控制器处理方法的入参中 :URL 中的{xxx}占位符可以通过
     */
    @GetMapping("/obligation/{account}")
    @ApiOperation("获取用户所有未付款订单的接口")
    @ApiImplicitParam(name = "account", value = "用户的账号")
    @SysLog(BusinessName = "获取用户所有未付款订单的接口")
    public List<HashMap<String, Object>> obligation(@PathVariable("account") String account) {
        //调用业务层用户所有未付款的订单
        return orderService.obligation(account);
    }

    /**
     * 获取用户所有未收货的订单
     *
     * @param account 用户的账号
     * @return 返回用户全部没有付款的订单
     * @GetMapping 获取get请求的地址映射的注解
     * @ApiOperation 对某个方法/接口进行描述
     * @ApiImplicitParam 对接口的参数的描述
     * @SysLog 通过切面的方式打印日志信息
     * @PathVariable 可以将 URL 中占位符参数绑定到控制器处理方法的入参中 :URL 中的{xxx}占位符可以通过
     */
    @GetMapping("/waitReceive/{account}")
    @ApiOperation("获取用户所有未收货订单的接口")
    @ApiImplicitParam(name = "account", value = "用户的账号")
    @SysLog(BusinessName = "获取用户所有未收货订单的接口")
    public List<HashMap<String, Object>> waitReceive(@PathVariable("account") String account) {
        //调用业务层用户所有未收货的订单
        return orderService.waitReceive(account);
    }

    /**
     * 获取已收货订单的详情
     *
     * @param orderId 订单的id
     * @return 订单的详情
     * @GetMapping 获取get请求的地址映射的注解
     * @ApiOperation 对某个方法/接口进行描述
     * @ApiImplicitParam 对接口的参数的描述
     * @SysLog 通过切面的方式打印日志信息
     * @PathVariable 可以将 URL 中占位符参数绑定到控制器处理方法的入参中 :URL 中的{xxx}占位符可以通过
     */
    @GetMapping("/getOrderDetailByOrderId/{orderId}")
    @ApiOperation("获取已收货订单详情的接口")
    @ApiImplicitParam(name = "orderId", value = "订单的id")
    @SysLog(BusinessName = "获取已收货订单详情的接口")
    public HashMap<String, Object> getOrderDetailByOrderId(@PathVariable("orderId") Integer orderId) {
        //调用业务层获取订单详情的方法
        return orderService.getOrderDetailByOrderId(orderId);
    }

    /**
     * 确认订单收获
     *
     * @param orderNo 订单的编号
     * @PostMapping 获取post请求的地址映射的注解
     * @ApiOperation 对某个方法/接口进行描述
     * @ApiImplicitParam 对接口的参数的描述
     * @SysLog 通过切面的方式打印日志信息
     */
    @PostMapping("/confirmReceipt")
    @ApiOperation("确认收获订单的接口")
    @ApiImplicitParam(name = "orderNo", value = "订单的编号")
    @SysLog(BusinessName = "确认收获订单的接口")
    public void confirmReceipt(String orderNo) {
        //调用业务层确认收获的方法
        orderService.confirmReceipt(orderNo);
    }

    /**
     * 获取未支付订单的信息
     *
     * @param orderNo 订单的编号
     * @return 订单的信息
     * @GetMapping 获取get请求的地址映射的注解
     * @ApiOperation 对某个方法/接口进行描述
     * @ApiImplicitParam 对接口的参数的描述
     * @SysLog 通过切面的方式打印日志信息
     */
    @GetMapping("/nowPay/{orderNo}")
    @ApiOperation("获取未支付订单的信息的接口")
    @ApiImplicitParam(name = "orderNo", value = "订单的编号")
    @SysLog(BusinessName = "获取未支付订单的信息的接口")
    public HashMap<String, Object> nowPay(@PathVariable("orderNo") String orderNo) {
        //调用业务层未支付订单的信息
        return orderService.nowPay(orderNo);
    }


    /**
     * 订单支付
     *
     * @param code      家具的编号
     * @param addressId 地址的id
     * @param payType   支付的类型
     * @param price     支付家具的价格
     * @PostMapping 获取post请求的地址映射的注解
     * @ApiOperation 对某个方法/接口进行描述
     * @ApiImplicitParams 对接口多个参数的描述
     * @ApiImplicitParam 对接口的参数的描述
     * @SysLog 通过切面的方式打印日志信息
     */
    @PostMapping("/orderNowPay")
    @ApiOperation("订单支付信息的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "code", value = "订单的编号"),
            @ApiImplicitParam(name = "addressId", value = "地址的id"),
            @ApiImplicitParam(name = "payType", value = "支付的类型"),
            @ApiImplicitParam(name = "price", value = "支付家具的价格"),
    })
    @SysLog(BusinessName = "订单支付信息的接口")
    public String alipay(@RequestParam Integer is,@RequestParam(value = "code",required = false) String code, @RequestParam Integer addressId, @RequestParam String payType, @RequestParam Double price) throws AlipayApiException {
        //创建对象
        AliPayBean alipayBean = orderService.orderNowPay(is,code, addressId, payType, price);
        //调用支付宝沙箱支付的业务层
        return payService.aliPay(alipayBean);
    }


}

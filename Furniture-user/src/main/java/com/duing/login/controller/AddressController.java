package com.duing.login.controller;

import com.duing.annotation.SysLog;
import com.duing.login.domain.F_user_address;
import com.duing.login.service.AddressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 收获地址模块的控制层
 * 接收请求的
 *
 * @RestController 说明这是一个控制层对象, 并且方法返回json对象, 将这个控制层交给spring来管理, 底层实际用的是@Controller注解
 * @RequestMapping 处理请求地址映射的注解
 * @Api 表示标识这个类是swagger的资源
 * @Slf4j 打印的日志信息 该注解相当于代替了以下的代码：private  final Logger logger = LoggerFactory.getLogger(当前类名.class);
 * @SuppressWarnings 不扫描本类规范
 */
@RestController
@RequestMapping("/householdFurniture/address")
@Api(tags = "收获地址模块的接口")
@SuppressWarnings("all")
public class AddressController {

    /**
     * 获取地址模块的业务层对象
     *
     * @Autowired 自动注入对象
     */
    @Autowired
    private AddressService addressService;

    /**
     * 添加地址
     *
     * @param address 地址对象
     * @param account 账号
     * @return addResult 地址添加的结果
     * @PostMapping 获取post请求的地址映射的注解
     * @ApiOperation 对某个方法/接口进行描述
     * @ApiImplicitParams 描述多个参数
     * @ApiImplicitParam 对接口参数的描述
     */
    @PostMapping("/addAddress")
    @ApiOperation("添加用户地址的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "address", value = "地址对象"),
            @ApiImplicitParam(name = "account", value = "用户账号")
    })
    @SysLog(BusinessName = "添加用户地址的接口")
    public void addAddress(F_user_address address, String account) {
        //调用业务成添加地址的方法,并且返回添加的信息
        addressService.addAddress(address, account);
    }

    /**
     * 查询所有用户的地址
     *
     * @param account 账号
     * @return 查询到的地址
     * @GetMapping 获取get请求的地址映射的注解
     * @ApiOperation 对某个方法/接口进行描述
     * @ApiImplicitParam 对接口参数的描述
     * @PathVariable 可以将 URL 中占位符参数绑定到控制器处理方法的入参中:URL 中的{xxx}占位符可以通过
     * @SysLog 通过切面打印日志
     */
    @GetMapping("/getAllUserAddress/{account}")
    @ApiOperation("查询用户地址的接口")
    @ApiImplicitParam(name = "account", value = "账号")
    @SysLog(BusinessName = "查询用户地址的接口")
    public List<F_user_address> getAllUserAddress(@PathVariable("account") String account) {
        //调用service层通过账号,查询所有用户的地址,并且返回回去
        return addressService.getAllUserAddress(account);
    }

    /**
     * 删除用户收货地址
     *
     * @param addressId 地址的id
     * @DeleteMapping 获取delete请求的地址映射的注解
     * @ApiOperation 对某个方法/接口进行描述
     * @ApiImplicitParam 对接口参数的描述
     * @PathVariable 可以将 URL 中占位符参数绑定到控制器处理方法的入参中:URL 中的{xxx}占位符可以通过
     * @SysLog 通过切面打印日志
     */
    @DeleteMapping("/deleteUserAddress/{addressId}")
    @ApiOperation("删除用户收货地址")
    @ApiImplicitParam(name = "addressId", value = "地址的id")
    @SysLog(BusinessName = "删除用户收货地址")
    public void deleteUserAddress(@PathVariable("addressId") Integer addressId) {
        //调用业务层删除用户收货地址的方法
        addressService.deleteUserAddress(addressId);
    }
}

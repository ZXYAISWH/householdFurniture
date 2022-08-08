package com.duing.login.controller;

import com.duing.annotation.NotControllerResponseAdvice;
import com.duing.annotation.SysLog;
import com.duing.login.domain.F_user;
import com.duing.login.service.PersonalService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


/**
 * 用户信息模块的控制层
 * 接收前端请求的
 *
 * @RestController 说明这是一个控制层对象, 并且方法返回json对象, 将这个控制层交给spring来管理, 底层实际用的是@Controller注解
 * @RequestMapping 处理请求地址映射的注解
 * @Api 表示标识这个类是swagger的资源
 * @Slf4j 打印的日志信息 该注解相当于代替了以下的代码：private  final Logger logger = LoggerFactory.getLogger(当前类名.class);
 * @SuppressWarnings 不扫描本类规范
 */
@RestController
@Api(tags = "用户个人信息模块的接口")
@RequestMapping("/householdFurniture/personal")
@SuppressWarnings("all")
public class PersonalController {

    /**
     * 获取用户信息的工具类
     *
     * @Autowired 自动注入对象
     */
    @Autowired
    private PersonalService personalService;


    /**
     * 通过账号获取用户的信息
     *
     * @param account 账号
     * @return f_user 返回用户对象
     * @GetMapping 获取get请求的地址映射的注解
     * @ApiOperation 对某个方法/接口进行描述
     * @ApiImplicitParam 对接口的参数的描述
     * @PathVariable 可以将 URL 中占位符参数绑定到控制器处理方法的入参中:URL 中的{xxx}占位符可以通过
     */
    @GetMapping("/getUserInfo/{account}")
    @ApiOperation("获取用户信息的接口")
    @ApiImplicitParam(name = "account", value = "账号")
    @SysLog(BusinessName = "获取用户信息的接口")
    public F_user getUserInfo(@PathVariable("account") String account) {
        //调用业务层的方法,获取用户信息
        F_user f_user = personalService.getUserInfo(account);
        //返回用户信息
        return f_user;
    }

    /**
     * 通过账号进行文件上传
     *
     * @param uploadImg 文件上传的对象
     * @param account   账号
     * @PostMapping 获取post请求的地址映射的注解
     * @ApiOperation 对某个方法/接口进行描述
     * @ApiImplicitParams 描述多个参数
     * @ApiImplicitParam 对接口的参数的描述
     * @NotControllerResponseAdvice 自定义注解, 无返回值
     */
    @PostMapping(value = "/uploadImg")
    @ApiOperation("修改用户图像的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "uploadImg", value = "文件上传的对象"),
            @ApiImplicitParam(name = "account", value = "账号")
    })
    @NotControllerResponseAdvice
    public void uploadImg(MultipartFile img, String account) {
        //调用业务层的修改用户图像的方法
        personalService.uploadImgUrl(img, account);
    }

    /**
     * 修改用户信息
     *
     * @param f_user  用户对象
     * @param account 账号
     * @PutMapping 获取put请求地址映射的注解
     * @ApiOperation 对某个方法/接口进行描述
     * @ApiImplicitParams 描述多个参数
     * @ApiImplicitParam 对接口的参数的描述
     * @SysLog 通过切面打印日志
     */
    @PutMapping(value = "/changeUserInfo")
    @ApiOperation("修改用户信息的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "f_user", value = "用户对象"),
            @ApiImplicitParam(name = "account", value = "账号")
    })
    @SysLog(BusinessName = "修改用户信息的接口")
    public void changeUserInfo(F_user f_user, String account) {
        //调用业务层修修改信息的方法
        personalService.changeUserInfo(f_user, account);
    }

    /**
     * 修改用户账号地址
     *
     * @param country 地区
     * @param account 账号
     * @PutMapping 获取put请求地址映射的注解
     * @ApiOperation 对某个方法/接口进行描述
     * @ApiImplicitParams 描述多个参数
     * @ApiImplicitParam 对接口的参数的描述
     */
    @PutMapping("/changeUserRegion")
    @ApiOperation("修改用户账号地址的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "country", value = "用户账号地区"),
            @ApiImplicitParam(name = "account", value = "账号")
    })
    @SysLog(BusinessName = "修改用户账号地址的接口")
    public void changeUserRegion(String country, String account) {
        //调用业务层修改用户账号地区的方法
        personalService.changeUserRegion(country, account);
    }

    /**
     * 修改用户密码
     *
     * @param oldPass 旧密码
     * @param newPass 新密码
     * @param account 账号
     * @return 修改的结果
     * @PostMapping 获取post请求地址映射的注解
     * @ApiOperation 对某个方法/接口进行描述
     * @ApiImplicitParams 描述多个参数
     * @ApiImplicitParam 对接口的参数的描述
     * @RequestParam 请求的参数
     */
    @PostMapping("/changePassword")
    @ApiOperation("用户修改密码的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "oldPass", value = "旧密码"),
            @ApiImplicitParam(name = "newPass", value = "新密码"),
            @ApiImplicitParam(name = "account", value = "账号")
    })
    @SysLog(BusinessName = "用户修改密码的接口")
    public String changePassword(@RequestParam String oldPass, @RequestParam String newPass, @RequestParam String account) {
        //调用业务成的修改密码的方法
        String changeResult = personalService.changePassword(oldPass, newPass, account);
        //返回修改的结果
        return changeResult;
    }


}

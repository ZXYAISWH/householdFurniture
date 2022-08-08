package com.duing.login.controller;

import com.duing.annotation.SysLog;
import com.duing.login.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;

/**
 * 做登录模块的控制层
 *
 * @RestController 说明这是一个控制层对象, 并且方法返回json对象, 将这个控制层交给spring来管理, 底层实际用的是@Controller注解
 * @RequestMapping 处理请求地址映射的注解
 * @Api 表示标识这个类是swagger的资源, 并且说明接口的模块
 * @SuppressWarnings 不扫描本类规范
 */

@RestController
@RequestMapping("/householdFurniture/login")
@Api(tags = "登录模块的接口")
@SuppressWarnings("all")
public class LoginController {

    /**
     * 获取登录模块的业务成对象
     *
     * @Autowired 自动注入对象
     */
    @Autowired
    private LoginService loginService;

    /**
     * 判断手机号是否被注册
     *
     * @param phone 需要判断是否存在的手机号
     * @return 是否存在的结果
     * @GetMapping 获取get请求的地址映射的注解
     * @ApiOperation 对某个方法/接口进行描述
     * @ApiImplicitParam 对接口的参数的描述
     * @SysLog 通过切面的方式打印日志信息
     * @PathVariable 可以将 URL 中占位符参数绑定到控制器处理方法的入参中:URL 中的{xxx}占位符可以通过
     */
    @GetMapping("/selectPhoneExist/{phone}")
    @ApiOperation("判断手机号是否存在的接口")
    @ApiImplicitParam(name = "phone", value = "手机号码")
    @SysLog(BusinessName = "判断手机号是否存在的接口")
    public String selectPhoneExist(@PathVariable("phone") String phone) {
        //调用业务层判断手机号是否存在的方法
        String exist = loginService.selectPhoneExist(phone);
        //返回是否存在的结果
        return exist;
    }

    /**
     * 获取手机验证码
     *
     * @param phone 手机号码
     * @return 手机号的验证码
     * @GetMapping 获取get请求的地址映射的注解
     * @ApiOperation 对某个方法/接口进行描述
     * @ApiImplicitParam 对接口参数的描述
     * @SysLog 通过切面的方式打印日志信息
     * @PathVariable 可以将 URL 中占位符参数绑定到控制器处理方法的入参中:URL 中的 {xxx} 占位符可以通过
     */
    @GetMapping(value = "/getVerificationCode/{phone}")
    @ApiOperation("获取手机号验证码的接口")
    @ApiImplicitParam(name = "phone", value = "手机号码")
    @SysLog(BusinessName = "获取手机号验证码的接口")
    public String getVerificationCode(@PathVariable("phone") String phone) {
        //调用业务层发送手机验证码的方法
        String verification = loginService.sendPhoneCode(phone);
        //返回手机验证码
        return verification;
    }


    /**
     * 用户注册
     *
     * @param phone    手机号码
     * @param password 注册密码
     * @return 注册的结果
     * @PostMapping 获取post请求的地址映射的注解
     * @ApiOperation 对某个方法/接口进行描述
     * @ApiImplicitParams 描述多个参数
     * @ApiImplicitParam 对接口参数的描述
     * @SysLog 通过切面的方式打印日志信息
     * @RequestParam 请求的参数
     */
    @PostMapping("/userRegister")
    @ApiOperation("用户注册的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phone", value = "手机号码"),
            @ApiImplicitParam(name = "password", value = "密码")
    })
    @SysLog(BusinessName = "用户注册的接口")
    public String userRegister(@RequestParam String phone, @RequestParam String password) {
        //调用登录模块用户注册方法
        String registerResult = loginService.userRegister(phone, password);
        //返回注册的结果
        return registerResult;
    }

    /**
     * 用户登录
     *
     * @param auto_login   自动登录
     * @param rememberPass 记住密码
     * @param account      账号
     * @param password     密码
     * @return 登录的结果
     * @PostMapping 获取post请求的地址映射的注解
     * @ApiOperation 对某个方法/接口进行描述
     * @ApiImplicitParams 描述多个参数
     * @ApiImplicitParam 对接口参数的描述
     * @SysLog 通过切面的方式打印日志信息
     * @ApiIgnore 是方法/参数不显示在swagger中
     */
    @PostMapping("/userLogin")
    @ApiOperation("用户登录的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "auto_login", value = "是否自动登录"),
            @ApiImplicitParam(name = "rememberPass", value = "是否记住密码"),
            @ApiImplicitParam(name = "account", value = "账号"),
            @ApiImplicitParam(name = "password", value = "密码")
    })
    @SysLog(BusinessName = "用户登录的接口")
    public String userLogin(@ApiIgnore HttpServletRequest request, @ApiIgnore HttpServletResponse response) {
        //获取用户的账号
        String account = request.getParameter("account");
        //获取用户的密码
        String password = request.getParameter("password");
        //获取subject对象
        Subject subject = SecurityUtils.getSubject();
        //创建UsernamePasswordToken对象,传入用户的账号密码
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(account, password);
        try {
            //将usernamePasswordToken传入,如果出现异常,则登录失败
            subject.login(usernamePasswordToken);
            //调用业务层是否记住密码和自动登录的方法
            loginService.ifAutoLoginAndRememberPassword(request, response);
            //返回登录结果
            return "登录成功";
        } catch (Exception e) {
            //返回登录结果
            return "登录失败";
        }
    }

    /**
     * 获取登录的cookie信息
     *
     * @param account    账号
     * @param password   密码
     * @param auto_login 是否自动登录
     * @return cookie的信息
     * @GetMapping 获取get请求的地址映射的注解
     * @ApiOperation 对某个方法/接口进行描述
     * @ApiImplicitParams 描述多个参数
     * @ApiImplicitParam 对接口参数的描述
     * @SysLog 通过切面的方式打印日志信息
     * @CookieValue 获取cookie信息
     */
    @GetMapping("/getAllCookie")
    @ApiOperation("获取用户账号自动登录或者记住密码的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "account", value = "账号"),
            @ApiImplicitParam(name = "password", value = "密码"),
            @ApiImplicitParam(name = "auto_login", value = "是否自动登录"),
    })
    @SysLog(BusinessName = "获取用户账号自动登录或者记住密码的接口")
    public HashMap<String, String> getAllCookie(@CookieValue("account") String account, @CookieValue("password") String password, @CookieValue("auto_login") String auto_login) {
        //创建map集合对象
        HashMap<String, String> map = new HashMap<>();
        //放入账号
        map.put("account", account);
        //放入密码
        map.put("password", password);
        //放入自动登录
        map.put("auto_login", auto_login);
        //将数据返回
        return map;
    }

    /**
     * 获取所有验证码图片路径的接口
     *
     * @return 所有图片路径
     * @GetMapping 获取get请求的地址映射的注解
     * @ApiOperation 对某个方法/接口进行描述
     * @SysLog 通过切面的方式打印日志信息
     */
    @GetMapping("/getAllImgCodeUrl")
    @ApiOperation("获取所有验证码图片路径的接口")
    @SysLog(BusinessName = "获取所有验证码图片路径的接口")
    public List<String> getAllImgCodeUrl() {
        //调用业务层的获取验证码图片路径的方法
        List<String> imgUrls = loginService.getAllImgCodeUrl();
        //返回所有的路径
        return imgUrls;
    }

    /**
     * 判断账号是否存在
     *
     * @param account 账号
     * @return 存在的结果
     * @GetMapping 获取get请求的地址映射的注解
     * @ApiOperation 对某个方法/接口进行描述
     * @ApiImplicitParam 对单个参数的描述
     * @SysLog 通过切面的方式打印日志信息
     * @PathVariable 可以将 URL 中占位符参数绑定到控制器处理方法的入参中:URL 中的 {xxx} 占位符可以通过
     */
    @GetMapping("/selectAccountIfExist/{account}")
    @ApiOperation("忘记密码判断账号是否存在的接口")
    @ApiImplicitParam(name = "account", value = "账号")
    @SysLog(BusinessName = "忘记密码判断账号是否存在的接口")
    public String selectAccountIfExist(@PathVariable("account") String account) {
        //调用业务层的方法
        String result = loginService.selectAccountIfExist(account);
        //返回结果
        return result;
    }

    /**
     * 找回密码获取手机验证码
     *
     * @param account 手机账号
     * @return 手机验证码
     * @GetMapping 获取get请求的地址映射的注解
     * @ApiOperation 对某个方法/接口进行描述
     * @ApiImplicitParam 对单个参数的描述
     * @SysLog 通过切面的方式打印日志信息
     * @PathVariable 可以将 URL 中占位符参数绑定到控制器处理方法的入参中:URL 中的 {xxx} 占位符可以通过
     */
    @GetMapping("/sendPhoneCode/{account}")
    @ApiOperation("找回密码获取手机验证码的接口")
    @ApiImplicitParam(name = "account", value = "手机号")
    @SysLog(BusinessName = "找回密码获取手机验证码的接口")
    public String sendPhoneCode(@PathVariable("account") String account) {
        //调用业务成发送手机号验证码的方法
        String phoneCode = loginService.sendPhoneCode(account);
        //返回验证
        return phoneCode;
    }

    /**
     * 找回密码获取邮箱证码
     *
     * @param account 手机账号
     * @return 手机验证码
     * @GetMapping 获取get请求的地址映射的注解
     * @ResponseBody 返回请求的信息
     * @ApiOperation 对某个方法/接口进行描述
     * @ApiImplicitParam 对单个参数的描述
     * @SysLog 通过切面的方式打印日志信息
     * @PathVariable 可以将 URL 中占位符参数绑定到控制器处理方法的入参中:URL 中的 {xxx} 占位符可以通过
     */
    @GetMapping("/sendEmailCode/{account}")
    @ApiOperation("找回密码获取邮箱验证码的接口")
    @ApiImplicitParam(name = "account", value = "邮箱账号")
    @SysLog(BusinessName = "找回密码获取邮箱验证码的接口")
    public String sendEmailCode(@PathVariable("account") String account) {
        //调用业务成发送邮箱验证码的方法
        String emailCode = loginService.sendEmailCode(account);
        //返回验证码
        return emailCode;
    }

    /**
     * 修改密码
     *
     * @param password 修改的密码
     * @param account  被修改密码的账号
     * @return 修改的结果
     * @PutMapping 获取put请求的地址映射的注解
     * @ApiOperation 对某个方法/接口进行描述
     * @ApiImplicitParams 对多个参数的描述
     * @ApiImplicitParam 对单个参数的描述
     * @SysLog 通过切面的方式打印日志信息
     * @RequestParam 请求的参数
     */
    @PutMapping("/changePass")
    @ApiOperation("修改密码获的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "password", value = "修改的密码"),
            @ApiImplicitParam(name = "account", value = "被修改密码的账号")
    })
    public String changePass(@RequestParam String password, @RequestParam String account) {
        //调用业务层修改密码的方法
        String changeResult = loginService.changePass(password, account);
        //修改的结果
        return changeResult;
    }
}

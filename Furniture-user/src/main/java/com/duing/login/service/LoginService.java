package com.duing.login.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.duing.login.dao.UserDao;
import com.duing.login.domain.F_user;
import com.duing.login.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 做登录模块的业务层
 * 做业务逻辑判断的
 *
 * @Service 说明这是一个控制层对象, 将这个控制层交给spring来管理, 底层实际用的是@Component注解,为了让层次分明,让调用者可读性强,就包装成@Service注解
 * @SuppressWarnings 不扫描本类规范
 */
@Service
@SuppressWarnings("all")
public class LoginService {

    /**
     * 获取发送邮箱的工具类
     *
     * @Autowired 对象自动注入
     */
    @Autowired
    private SendEmail sendEmail;

    /**
     * 获取手机验证码对象
     *
     * @Autowired 自动注入对象
     */
    @Autowired
    private GetPhoneVerificationCode getPhoneVerificationCode;

    /**
     * 获取登录模块dao层对象
     *
     * @Autowired 自动注入对象
     */
    @Autowired
    private UserDao userDao;

    /**
     * 获取加密工具类对象
     *
     * @Autowired 自动注入对象
     */
    @Autowired
    private JasyptUtil jasyptUtil;

    /**
     * 获取随机生成账号对象
     *
     * @Autowired 自动注入对象
     */
    @Autowired
    private RandomlyGeneratedAccount randomlyGeneratedAccount;

    /**
     * 获取redis的工具类
     *
     * @Autowired 自动注入对象
     */
    @Autowired
    private RedisUtils redisUtils;

    /**
     * 判断手机号是否被注册
     *
     * @param phone 手机号
     * @return 注册的结果
     */
    public String selectPhoneExist(String phone) {
        //通过手机号做key,去redis获取值
        Object value = redisUtils.get(phone);
        //如果有
        if (value != null) {
            //如果有,返回手机号已被注册
            return "手机号已被注册";
        } else {
            //创建QueryWrapper对象
            QueryWrapper<F_user> queryWrapper = new QueryWrapper<>();
            //判断phone这个列是否有phone这个值
            queryWrapper.eq("phone", phone);
            //进行查询
            F_user user = userDao.selectOne(queryWrapper);
            //判断查询的用户是否有值
            if (user != null) {
                //如果有,返回手机号已被注册
                return "手机号已被注册";
            } else {
                //如果没有,返回手机号未被注册
                return "手机号未被注册";
            }
        }
    }

    /**
     * 用户注册
     *
     * @param phone    手机号
     * @param password 密码
     * @return 注册的结果
     */
    public String userRegister(String phone, String password) {
        //判断phone和password是否为空
        Boolean isEmpty = StringUtils.isEmpty(phone) || StringUtils.isEmpty(phone);
        //如果不为空
        if (!isEmpty) {
            //创建f_user对象
            F_user f_user = new F_user();
            //给phone属性赋值
            f_user.setPhone(phone);
            //给大图赋值,默认头像
            f_user.setImgUrl("tn36lqujRd.jpeg");
            //获取账号
            String account = randomlyGeneratedAccount.getAccount();
            //给account属性赋值
            f_user.setAccount(account);
            //给password加密
            String userPass = jasyptUtil.encryptText(password);
            //将加密后的密码放入password属性中
            f_user.setPassword(userPass);
            //执行redis新增操作
            redisUtils.set(phone, f_user);
            //执行mysql新增的操作,返回数据库受影响的行数
            int count = userDao.insert(f_user);
            //如果受影响的行数不等于0
            if (count != 0) {
                //返回注册成功
                return "注册成功";
                //如果受影响的行数等于0
            } else {
                //返回注册失败
                return "注册失败";
            }
            //如果为空
        } else {
            //返回注册失败
            return "注册失败";
        }
    }

    /**
     * 查询是否有account
     *
     * @param account 账号
     * @return 查询到的user对象
     */
    public F_user selectUserByAccount(String account) {
        //查询redis是否有账号
        F_user f_user = (F_user) redisUtils.get(account);
        //如果不为空
        if (f_user != null) {
            //返回查询到的对象
            return f_user;
        } else {
            //去数据库查询
            F_user user = userDao.selectUserByAccount(account);
            //如果不为空
            if (user != null) {
                //返回user对象
                return user;
            } else {
                //返回空
                return null;
            }
        }
    }

    /**
     * 存储cookie
     * 是ifAutoLoginAndRememberPassword的小弟
     *
     * @param response 响应对象
     * @param cookie   cookie对象
     */
    public void stockUserInfo(HttpServletResponse response, List<Cookie> cookies) {
        //存入所有需要存储的cookie至浏览器
        for (Cookie cookie : cookies) {
            //设置cookie的失效时间(一个月)
            cookie.setMaxAge(3600 * 24 * 30);
            //存储cookie
            response.addCookie(cookie);
        }
    }

    /**
     * 使cookie失效
     *
     * @param cookies 所有的cookie
     * @param name    cookie的key
     */
    public void invalidationCookie(Cookie[] cookies, String name) {
        //遍历所有
        for (Cookie cookie : cookies) {
            //获取每个cookie的key
            String cookieKey = cookie.getName();
            //如何cookie的key和需要让失效的值一致时
            if (name.equals(cookieKey)) {
                //将cookie的失效时间设置为浏览器关闭时,cookie随之失效
                cookie.setMaxAge(-1);
                //终止循环
                break;
            }
        }
    }

    /**
     * 用来判断用户是否自动登录或者记住密码
     *
     * @param request  HttpServletRequest对象
     * @param response HttpServletResponse对象
     */
    public void ifAutoLoginAndRememberPassword(HttpServletRequest request, HttpServletResponse response) {
        List<Cookie> cookieList = new ArrayList<>();
        //获取所有的cookie
        Cookie[] cookies = request.getCookies();
        //获取用户的账号
        String account = request.getParameter("account");
        //获取用户的密码
        String password = request.getParameter("password");
        //获取记住密码的结果
        Boolean rememberPass = Boolean.parseBoolean(request.getParameter("rememberPass"));
        //获取自动登录的结果
        Boolean auto_login = Boolean.parseBoolean(request.getParameter("auto_login"));
        //创建cookie对象,传入用户的账号
        Cookie cookieAccount = new Cookie("account", account);
        //创建cookie对象,传入用户自动登录的booolean值
        Cookie cookieAuto_login = new Cookie("auto_login", auto_login.toString());
        //将cookie放入集合中
        cookieList.add(cookieAccount);
        cookieList.add(cookieAuto_login);
        //判断是否记住密码
        if (rememberPass) {
            //创建cookie对象,传入用户的密码
            Cookie cookiePassword = new Cookie("password", password);
            //将cookie放入集合中
            cookieList.add(cookiePassword);
        } else {
            //调用让指定cookie失效的方法
            invalidationCookie(cookies, "rememberPass");
        }
        //调用存取cookie的方法
        stockUserInfo(response, cookieList);
    }

    /**
     * 获取所有验证码图片路径
     *
     * @return 所有的图片路径
     */
    public List<String> getAllImgCodeUrl() {
        //创建file对象
        File file = new File("E:\\IdeaProject\\Furniture\\Furniture-web\\src\\main\\resources\\static\\img\\code");
        //获取所有子文件
        File[] files = file.listFiles();
        //创建集合对象,用来村粗图片路径
        List<String> imgUrls = new ArrayList<>();
        //循环遍历文件
        for (File file1 : files) {
            //获取文件的名字,并装入集合中
            imgUrls.add(file1.getName());
        }
        //所有的图片路径
        return imgUrls;
    }

    /**
     * 判断账号是否存在
     *
     * @param account 账号
     * @return 是否存在
     */
    public String selectAccountIfExist(String account) {
        //查询redis是否有账号
        F_user f_user = (F_user) redisUtils.get(account);
        //如果不为空
        if (f_user != null) {
            //查询的结果
            return "账号存在";
        } else {
            //去数据库查询
            F_user user = userDao.selectUserByAccount(account);
            //如果不为空
            if (user != null) {
                //查询的结果
                return "账号存在";
            } else {
                //查询的结果
                return "账号不存在";
            }
        }
    }

    /**
     * 获取手机号验证码
     *
     * @param phone 手机号
     * @return 验证码
     */
    public String sendPhoneCode(String phone) {
        //调用发送手机验证码的工具类,获取验证
        String code = getPhoneVerificationCode.VerificationCode(phone);
        //返回验证码
        return code;
    }

    /**
     * 获取邮箱验证码
     *
     * @param emailAccount 邮箱账号
     * @return 验证码
     */
    public String sendEmailCode(String emailAccount) {
        //异常处理
        try {
            //获取邮箱的工具类
            String emailCode = sendEmail.sendToUserEmail(emailAccount);
            //返回验证码
            return emailCode;
        } catch (Exception e) {
            e.printStackTrace();
        }
        //返回空
        return null;
    }

    /**
     * 修改密码
     *
     * @param password 需要修改的密码
     * @param account  需要被修改密码的账号
     * @return 修改的结果
     */
    public String changePass(String password, String account) {
        //创建F_user对象
        F_user f_user = new F_user();
        //对象密码进行加密
        String encryptPass = jasyptUtil.encryptText(password);
        //将加密后的密码放入对象中
        f_user.setPassword(encryptPass);
        //redis进行新增操作
        redisUtils.set(account, f_user);
        //调用dao层修改密码的方法
        int count = userDao.changePass(encryptPass, account);
        //如果数据库受影响的行数超过0条
        if (count != 0) {
            //返回修改成功
            return "修改成功";
        }
        //返回修改失败
        return "修改失败";
    }
}

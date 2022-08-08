package com.duing.login.util;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.duing.login.dao.UserDao;
import com.duing.login.domain.F_user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 随机生成账号
 *
 * @Component 将这个工具类交给spring管理
 * @SuppressWarnings 不扫描本类规范
 */
@Component
@SuppressWarnings("all")
public class RandomlyGeneratedAccount {

    /**
     * 获取登录模块的业务成对象
     *
     * @Autowired 自动注入对象
     */
    @Autowired
    private UserDao UserDao;

    /**
     * 随机生成账号
     *
     * @return 返回账号
     */
    public String getAccount() {
        //账号zBest + 6位数随机数
        String account = String.valueOf(Math.random()).substring(2, 8);
        //获取QueryWrapper对象
        QueryWrapper<F_user> queryWrapper = new QueryWrapper();
        //判断数据库账号是否有和"zBest" + account相等的
        queryWrapper.eq("account", "zBest" + account);
        //查询返回对象
        F_user user = UserDao.selectOne(queryWrapper);
        //如果有
        while (user != null) {
            //重新生成
            account = String.valueOf(Math.random()).substring(2, 8);
            //判断数据库账号是否有和"zBest" + account相等的
            queryWrapper.eq("account", "zBest" + account);
            //查询返回对象
            user = UserDao.selectOne(queryWrapper);
        }
        //返回账号
        return "zBest" + account;
    }
}

package com.duing.login.config;

import com.duing.login.domain.F_user;
import com.duing.login.service.LoginService;
import com.duing.login.util.JasyptUtil;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class MyRealm extends AuthorizingRealm {

    /**
     * 获取userService对象
     *
     * @Autowired 自动注入对象
     */
    @Autowired
    private LoginService loginService;

    /**
     * 获取jasyptUtil对象
     *
     * @Autowired 自动注入对象
     */
    @Autowired
    private JasyptUtil jasyptUtil;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //从被shiro封装成的token中取出我们传入的username
        String username = (String) authenticationToken.getPrincipal();
        //通过账号查询用户的信息
        F_user f_user = loginService.selectUserByAccount(username);
        //如果f_user为空,则报错用户名不存在。
        if (f_user == null) {
            throw new UnknownAccountException("账号不存在");
        }
        //获取密码
        String password = f_user.getPassword();
        //解密密码
        String decryptPass = jasyptUtil.decryptText(password);
        //返回一个新封装的认证实体，传入的是用户名，数据库查出来的密码，和当前Realm的名字
        return new SimpleAuthenticationInfo(username, decryptPass, this.getName());
    }
}

package com.duing.login.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.duing.login.dao.AddressDao;
import com.duing.login.domain.F_user;
import com.duing.login.domain.F_user_address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 做地址模块的业务层
 * 做业务逻辑判断的
 *
 * @Service 说明这是一个控制层对象, 将这个控制层交给spring来管理, 底层实际用的是@Component注解,为了让层次分明,让调用者可读性强,就包装成@Service注解
 * @SuppressWarnings 不扫描本类规范
 */
@Service
@SuppressWarnings("all")
public class AddressService {

    /**
     * 获取地址dao层对象
     *
     * @Autowired 自动注入对象
     */
    @Autowired
    private AddressDao addressDao;

    /**
     * 用户添加收货地址
     *
     * @param address 地址对象
     * @param account 账号
     * @return 添加地址的结果
     */
    public void addAddress(F_user_address address, String account) {
        //调用dao层查询用户的方法,通过账号查询用户
        F_user f_user = addressDao.selectUser(account);
        //查询用户的id放入地址实体类
        address.setUserId(f_user.getUserId());
        //设置添加地址的当前时间
        address.setCreateTime(new Date(System.currentTimeMillis()));
        //调用dao层添加地址的方法
        addressDao.insertAddress(address);
    }

    /**
     * 获取用户所用的地址
     *
     * @param account 用户的账号
     * @return 所有的地址对象
     */
    public List<F_user_address> getAllUserAddress(String account) {
        //调用dao层通过账号获取用户的ID
        F_user f_user = addressDao.selectUser(account);
        //创建queryWrapper对象
        QueryWrapper<F_user_address> queryWrapper = new QueryWrapper<>();
        //判断user_id等于查询到用户的ID
        queryWrapper.eq("user_id", f_user.getUserId());
        //调用mybatisPlus的查询所有的方法,并且返回查询到的信息
        return addressDao.selectList(queryWrapper);
    }

    /**
     * 删除用户的收货地址
     *
     * @param addressId 地址的id
     */
    public void deleteUserAddress(Integer addressId) {
        //调用mybatisPlus的通过主键删除的方法
        addressDao.deleteById(addressId);
    }
}

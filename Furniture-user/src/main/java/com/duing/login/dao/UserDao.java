package com.duing.login.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.duing.login.dnamic.UserDnamic;
import com.duing.login.domain.F_user;
import org.apache.ibatis.annotations.*;

/**
 * 用户的dao层
 *
 * @Mapper 表示这是dao层的接口
 * @SuppressWarnings 不扫描本类规范
 */
@Mapper
@SuppressWarnings("all")
public interface UserDao extends BaseMapper<F_user> {


    /**
     * 通过账号查询用户的信息
     *
     * @param account 账号
     * @return 查询到的对象
     * @Select 对数据库进行查询操作
     * @Param sql语句上面的参数
     */
    @Select("select * from f_user where phone = #{account} or email = #{account}")
    public F_user selectUserByAccount(@Param("account") String account);

    /**
     * 修改用户密码
     *
     * @param password 修改的密码
     * @param account  修改密码的账号
     * @return
     * @Update 对数据进行修改的操作
     * @Param sql语句上面的参数
     */
    @Update("update f_user set password = #{password} where phone = #{account} or email = #{account}")
    public int changePass(@Param("password") String password, @Param("account") String account);

    /**
     * 通过账号查询用户的信息1
     *
     * @param account 账号
     * @return 查询到的对象
     * @Select 对数据库进行查询操作
     * @Param sql语句上面的参数
     */
    @Select("select * from f_user where phone = #{account} or email = #{account}")
    public F_user getUserInfo(@Param("account") String account);

    /**
     * 用户的头像
     *
     * @param fileName 图片的名称
     * @param account  用户的账号
     * @Update 对数据库进行修改操作
     * @Param sql语句上面的参数
     */
    @Update("update f_user set img_url = #{fileName} where phone = #{account} or email = #{account}")
    public void uploadUserImgUrl(@Param("fileName") String fileName, @Param("account") String account);

    /**
     * 用户信息修改
     *
     * @param birthday 生日
     * @param nickName 昵称
     * @param sex      性别
     * @param account  账号
     * @UpdateProvider 修改的动态sql拼接
     * @Param sql语句对应的参数
     */
    @UpdateProvider(value = UserDnamic.class, type = UserDnamic.class)
    public void changeUserInfo(@Param("birthday") String birthday, @Param("nickName") String nickName, @Param("sex") String sex, @Param("account") String account);

    /**
     * 修改个人账号地区
     *
     * @param region  地区
     * @param account 账号
     * @Param sql语句对应的参数
     * @Update 对数据库进行修改操作
     */
    @Update("update f_user set account_region = #{region} where phone = #{account} or email = #{account}")
    public void changeUserRegion(@Param("region") String region, @Param("account") String account);

    /**
     * 查询用户
     *
     * @param account 账号
     * @Param sql语句对应的参数
     * @Select 对数据库进行查询操作
     */
    @Select("select * from f_user where phone = #{account} or email = #{account}")
    public F_user selectPasswordIsTure(@Param("account") String account);
}

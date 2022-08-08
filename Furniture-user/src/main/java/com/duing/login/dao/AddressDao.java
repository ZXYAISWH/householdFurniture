package com.duing.login.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.duing.login.domain.F_user;
import com.duing.login.domain.F_user_address;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * 地址的dao层
 *
 * @Mapper 表示这是dao层的接口
 * @SuppressWarnings 不扫描本类规范
 */
@Mapper
@SuppressWarnings("all")
public interface AddressDao extends BaseMapper<F_user_address> {

    @Select("select * from f_user where phone = #{account} or email = #{account}")
    public F_user selectUser(String account);

    @Insert("insert into f_user_address(address_name,address_phone,address_province,address_city,address_county,address_detail,address_zip_code,user_id,create_time) values(#{addressName},#{addressPhone},#{addressProvince},#{addressCity},#{addressCounty},#{addressDetail},#{addressZipCode},#{userId},#{createTime})")
//    insert into f_user_address(address_name,address_phone,address_province,address_city,address_county,address_detail,address_zip_code) values(#{addressName},#{addressPhone},#{addressProvince},#{addressCity},#{addressCounty},#{addressDetail},#{addressZipCode})
    public int insertAddress(F_user_address address);
}

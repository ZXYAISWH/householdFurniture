package com.duing.login.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.duing.login.domain.F_user_address;
import com.duing.login.domain.F_user_order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface OrderDao extends BaseMapper<F_user_order> {

    @Select("SELECT `user_id` FROM `f_user` WHERE `phone` = #{account} or email = #{account}")
    public Integer getUserId(@Param("account") String account);

    @Select("SELECT * FROM `f_user_address` WHERE `user_id` = #{uId}")
    public List<F_user_address> getUserAddress(@Param("uId") Integer uId);

    @Select("SELECT * FROM `f_furniture` WHERE `furniture_id` = #{furnitureId}")
    public HashMap<String, String> selectFurniture(@Param("furnitureId") Integer furnitureId);

    @Select("SELECT * FROM `f_furniture_property` WHERE `furniture_id` = #{furnitureId}")
    public HashMap<String, Integer> selectFurnitureDetail(@Param("furnitureId") Integer furnitureId);


    @Select("SELECT * FROM `f_furniture_property_key` WHERE `property_key_id` = #{propertyKeyId}")
    public HashMap<String, String> selectPropertyKey(@Param("propertyKeyId") Integer propertyKeyId);

    @Select("SELECT * FROM `f_furniture_property_value` WHERE `property_value_id` = #{propertyValueId}")
    public HashMap<String, String> selectPropertyValue(@Param("propertyValueId") Integer propertyValueId);

    @Update("UPDATE `f_furniture` SET `clicks` = `clicks` + #{number} WHERE `furniture_id` = #{id}")
    public void addClicks(@Param("number")Integer number,@Param("id") Integer id);

    @Update("UPDATE `f_furniture_inventory` SET `furniture_inventory` = `furniture_inventory` - #{number} WHERE `furniture_id` = ${id}")
    public void reduceInventory(@Param("number")Integer number,@Param("id") Integer id);
}

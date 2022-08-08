package com.duing.login.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.duing.login.domain.F_user_order_furniture;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface OrderFurnitureDao extends BaseMapper<F_user_order_furniture> {

    @Select("SELECT * FROM `f_user_order_furniture` WHERE `order_id` = #{orderId}")
    public F_user_order_furniture selectOrderFurnitureByOrderId(@Param("orderId") Integer orderId);

    @Update("UPDATE `f_user_order_furniture` SET `pay_type` = #{payType} where `order_id` = #{orderId}")
    public void updateOrderFurnitureInfo(@Param("payType") String payType, @Param("orderId") Integer orderId);
}

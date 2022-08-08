package com.duing.login.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.duing.login.domain.F_user_shopping_car;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CartDao extends BaseMapper<F_user_shopping_car> {

    @Select("SELECT `furniture_price`  FROM `f_furniture_inventory` WHERE `furniture_id` = #{furnitureId}")
    public Double selectFurniturePrice(@Param("furnitureId") Integer furnitureId);
}

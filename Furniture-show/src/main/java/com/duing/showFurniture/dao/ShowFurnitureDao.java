package com.duing.showFurniture.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.duing.showFurniture.dnamic.FurnitureDnamic;
import com.duing.showFurniture.domain.F_furniture;
import com.duing.showFurniture.domain.F_furniture_inventory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface ShowFurnitureDao extends BaseMapper<F_furniture> {

    @Select("SELECT `furniture_price` FROM `f_furniture_inventory` WHERE `furniture_id` = #{furnitureId}")
    public Double getFurniturePrice(@Param("furnitureId") Integer furnitureId);

    @Select("SELECT * FROM `f_furniture` WHERE `furniture_id` = #{furnitureId}")
    public F_furniture getFurniture(@Param("furnitureId") Integer furnitureId);

    @Select("SELECT `small_img_url` FROM `f_furniture_small_image` WHERE `furniture_id` = #{furnitureId}")
    public List<String> getAllSmallUrl(@Param("furnitureId") Integer furnitureId);

    @Select("SELECT * FROM `f_furniture_inventory` WHERE `furniture_id` = #{furnitureId}")
    public F_furniture_inventory getFurnitureInventoryInfo(@Param("furnitureId") Integer furnitureId);

    @SelectProvider(type = FurnitureDnamic.class)
    public List<F_furniture> selectListOrderBy(@Param("value") String value);

    @Select("SELECT `classify_id` FROM `f_furniture_classify` WHERE `classify_name` = #{furnitureType} ")
    public Integer selectFurnitureClassifyId(@Param("furnitureType") String furnitureType);

    @SelectProvider(type = FurnitureDnamic.class, method = "dnamicToVaseProList")
    public List<F_furniture> selectListToProListOrderBy(@Param("value") String value);

    @SelectProvider(type = FurnitureDnamic.class, method = "dnamicToZbProList")
    public List<F_furniture> selectListToZbProListOrderBy(@Param("value") String value);

    @SelectProvider(type = FurnitureDnamic.class, method = "dnamicToBzProList")
    public List<F_furniture> selectListToBzProListOrderBy(@Param("value") String value);

    @Select("SELECT * FROM `f_furniture` ORDER BY `clicks` DESC LIMIT 0,22")
    public List<F_furniture> selectFurnitureByClicks();

    @Select("SELECT * FROM `f_furniture_comment` WHERE `furniture_id` = #{furnitureId}")
    public List<HashMap<String, Object>> getFurnitureComment(@Param("furnitureId") Integer furnitureId);

    @Select("SELECT * FROM `f_user` WHERE `user_id` = #{userId}")
    public HashMap<String,String> getUserByUserId(@Param("userId") Integer userId);

    @Select("SELECT * FROM `f_furniture` WHERE `key_word` LIKE CONCAT('%',#{value},'%')")
    public List<F_furniture> getFurnitureByKeyWord(@Param("value") String value);
}


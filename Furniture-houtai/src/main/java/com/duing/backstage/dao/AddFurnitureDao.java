package com.duing.backstage.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.duing.backstage.domain.F_furniture;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * 添加家具的dao层
 *
 * @Mapper 通过代理对象创建对象
 */
@Mapper
public interface AddFurnitureDao extends BaseMapper<F_furniture> {

    @Update("UPDATE `f_furniture` SET `status` = 1 WHERE `furniture_id` = #{id}")
    public void soldOutFurniture(@Param("id") Integer id);

    @Update("UPDATE `f_furniture` SET `status` = 0 WHERE `furniture_id` = #{id}")
    public void soldInFurniture(@Param("id") Integer id);

    @Delete("DELETE FROM `f_furniture` WHERE `furniture_id` = #{id}")
    public void deleteFurniture(@Param("id") Integer id);
}

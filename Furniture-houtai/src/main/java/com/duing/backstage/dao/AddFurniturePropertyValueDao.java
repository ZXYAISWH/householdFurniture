package com.duing.backstage.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.duing.backstage.domain.F_furniture_property_value;
import org.apache.ibatis.annotations.Mapper;

/**
 * 添加家具属性value的dao层
 *
 * @Mapper 通过代理对象创建对象
 */
@Mapper
public interface AddFurniturePropertyValueDao extends BaseMapper<F_furniture_property_value> {

}

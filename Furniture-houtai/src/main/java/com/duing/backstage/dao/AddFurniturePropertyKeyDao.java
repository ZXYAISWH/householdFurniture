package com.duing.backstage.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.duing.backstage.domain.F_furniture_property_key;
import org.apache.ibatis.annotations.Mapper;

/**
 * 添加家具属性key的dao层
 *
 * @Mapper 通过代理对象创建对象
 */
@Mapper
public interface AddFurniturePropertyKeyDao extends BaseMapper<F_furniture_property_key> {

}

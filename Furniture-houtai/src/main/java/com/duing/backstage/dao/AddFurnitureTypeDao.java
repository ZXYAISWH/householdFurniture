package com.duing.backstage.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.duing.backstage.domain.F_furniture_classify;
import org.apache.ibatis.annotations.Mapper;

/**
 * 添加家具类型的dao层
 *
 * @Mapper 通过代理对象创建对象
 */
@Mapper
public interface AddFurnitureTypeDao extends BaseMapper<F_furniture_classify> {

}

package com.duing.backstage.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.duing.backstage.domain.F_furniture_small_image;
import org.apache.ibatis.annotations.Mapper;

/**
 * 添加家具小图的dao层
 *
 * @Mapper 通过代理对象创建对象
 */
@Mapper
public interface AddFurnitureSmallImgDao extends BaseMapper<F_furniture_small_image> {

}

package com.duing.login.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.duing.login.domain.F_furniture_comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CommentDao extends BaseMapper<F_furniture_comment> {

    @Select("select * from f_user where phone = #{account} or email = #{account}")
    public Integer selectUserId(String account);
}

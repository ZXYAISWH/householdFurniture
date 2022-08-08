package com.duing.login.dnamic;

import org.apache.ibatis.annotations.Param;

/**
 * 用户表的动态sql拼接
 */
public class UserDnamic {

    /**
     * sql拼接
     *
     * @param birthday 生日
     * @param nickName 昵称
     * @param sex      性别
     * @param account  账号
     * @return sql语句
     */
    public String provideSql(@Param("birthday") String birthday, @Param("nickName") String nickName, @Param("sex") String sex, @Param("account") String account) {
        StringBuffer sb = new StringBuffer();
        sb.append("update f_user set ");
        if (birthday != null && birthday != "") {
            sb.append("birthday = #{birthday},");
        }
        if (nickName != null && nickName != "") {
            sb.append("nick_name = #{nickName},");
        }
        if (sex != null && sex != "") {
            sb.append("sex = #{sex} ");
        }
        sb.append("where phone = #{account} or email = #{account}");
        return sb.toString();
    }
}

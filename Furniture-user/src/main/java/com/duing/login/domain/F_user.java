package com.duing.login.domain;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 和数据库的f_user表的列对应
 * 用来存储用户的基本数据的
 *
 * @Data 给属性自动生成get和set方法
 * @AllArgsConstructor 自动生成全参构造器
 * @NoArgsConstructor 自动生成无参构造器
 * @ApiModel 描述这是用户的信息
 * @TableName 使用mybatisPlus 自动生成sql 告诉表的名字
 * @SuppressWarnings 不扫描本类规范
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("用户的信息")

@TableName("f_user")
@SuppressWarnings("all")
public class F_user {
    /**
     * 用户的ID
     *
     * @TableId 表示这是主键 列名是user_id
     * @ApiModelProperty 描述属性
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    @ApiModelProperty("用户的ID")
    private Integer userId;

    /**
     * 用户的性别
     *
     * @TableField 表示这是表格的列  列名是sex
     * @ApiModelProperty 描述属性
     */
    @TableField(value = "sex")
    @ApiModelProperty("用户的性别")
    private String sex;

    /**
     * 用户的喜好
     *
     * @TableField 表示这是表格的列名  列名是hobby
     * @ApiModelProperty 描述属性
     */
    @TableField(value = "hobby")
    @ApiModelProperty("用户的喜好")
    private String hobby;

    /**
     * 用户的账号
     *
     * @TableField 表示这是表格的列  列名是account
     * @ApiModelProperty 描述属性
     */
    @TableField(value = "account")
    @ApiModelProperty("用户的账号")
    private String account;

    /**
     * 用户的昵称
     *
     * @TableField 表示这是表格的列  列名是nick_name
     * @ApiModelProperty 描述属性
     */
    @TableField(value = "nick_name")
    @ApiModelProperty("用户的昵称")
    private String nickName;

    /**
     * 用户的邮箱
     *
     * @TableField 表示这是表格的列  列名是email
     * @ApiModelProperty 描述属性
     */
    @TableField(value = "email")
    @ApiModelProperty("用户的邮箱")
    private String email;

    /**
     * 用户的电话
     *
     * @TableField 表示这是表格的列  列名是phone
     * @ApiModelProperty 描述属性
     */
    @TableField(value = "phone")
    @ApiModelProperty("用户的电话")
    private String phone;

    /**
     * 用户的密码
     *
     * @TableField 表示这是表格的列  列名是password
     * @ApiModelProperty 描述属性
     */
    @TableField(value = "password")
    @ApiModelProperty("用户的密码")
    private String password;

    /**
     * 用户的生日
     *
     * @TableField 表示这是表格的列  列名是birthday
     * @ApiModelProperty 描述属性
     */
    @TableField(value = "birthday")
    @ApiModelProperty("用户的生日")
    private String birthday;

    /**
     * 用户的头像url
     *
     * @TableField 表示这是表格的列  列名是img_url
     * @ApiModelProperty 描述属性
     */
    @TableField(value = "img_url")
    @ApiModelProperty("用户的头像url")
    private String imgUrl;

    /**
     * 用户的账号地区
     *
     * @TableField 表示这是表格的列  列名是account_region
     * @ApiModelProperty 描述属性
     */
    @TableField(value = "account_region")
    @ApiModelProperty("用户的账号地区")
    private String accountRegion;

}

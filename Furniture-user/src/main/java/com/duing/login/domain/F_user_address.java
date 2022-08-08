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

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("f_user_address")
@ApiModel("用户收获地址的信息")
@SuppressWarnings("all")
public class F_user_address {

    /**
     * 地址的ID
     *
     * @TableId 表示这是主键 列名是address_id
     * @ApiModelProperty 描述属性
     */
    @TableId(value = "address_id", type = IdType.AUTO)
    @ApiModelProperty("地址的ID")
    private Integer addressId;

    /**
     * 收货人姓名
     *
     * @TableField 表示这是表格的列  列名是address_name
     * @ApiModelProperty 描述属性
     */
    @TableField(value = "address_name")
    @ApiModelProperty("收货人姓名")
    private String addressName;

    /**
     * 收货人电话
     *
     * @TableField 表示这是表格的列  列名是address_phone
     * @ApiModelProperty 描述属性
     */
    @TableField(value = "address_phone")
    @ApiModelProperty("收货人电话")
    private String addressPhone;

    /**
     * 收货人的省份
     *
     * @TableField 表示这是表格的列  列名是address_province
     * @ApiModelProperty 描述属性
     */
    @TableField(value = "address_province")
    @ApiModelProperty("收货人的省份")
    private String addressProvince;

    /**
     * 收货人的市
     *
     * @TableField 表示这是表格的列  列名是address_city
     * @ApiModelProperty 描述属性
     */
    @TableField(value = "address_city")
    @ApiModelProperty("收货人的市")
    private String addressCity;

    /**
     * 收货人的县
     *
     * @TableField 表示这是表格的列  列名是address_county
     * @ApiModelProperty 描述属性
     */
    @TableField(value = "address_county")
    @ApiModelProperty("收货人的县")
    private String addressCounty;

    /**
     * 收货人地区
     *
     * @TableField 表示这是表格的列  列名是address_area
     * @ApiModelProperty 描述属性
     */
    @TableField(value = "address_area")
    @ApiModelProperty("收货人地区")
    private String addressArea;

    /**
     * 收货人详细信息
     *
     * @TableField 表示这是表格的列  列名是address_detail
     * @ApiModelProperty 描述属性
     */
    @TableField(value = "address_detail")
    @ApiModelProperty("收货人详细信息")
    private String addressDetail;

    /**
     * 邮政编码
     *
     * @TableField 表示这是表格的列  列名是address_zip_code
     * @ApiModelProperty 描述属性
     */
    @TableField(value = "address_zip_code")
    @ApiModelProperty("邮政编码")
    private Integer addressZipCode;

    /**
     * 是否是默认收货地址
     *
     * @TableField 表示这是表格的列  列名是is_default_address
     * @ApiModelProperty 描述属性
     */
    @TableField(value = "is_default_address")
    @ApiModelProperty("是否是默认收货地址 0.是 1.不是")
    private Byte isDefaultAddress;

    /**
     * 创建时间
     *
     * @TableField 表示这是表格的列  列名是create_time
     * @ApiModelProperty 描述属性
     */
    @TableField(value = "create_time")
    @ApiModelProperty("创建时间")
    private Date createTime;

    /**
     * 用户信息
     *
     * @TableField 表示这是表格的列  列名是user_id
     * @ApiModelProperty 描述属性
     */
    @TableField(value = "user_id")
    @ApiModelProperty("用户信息")
    private Integer userId;

}

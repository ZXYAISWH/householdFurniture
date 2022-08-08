package com.duing.login.domain;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("f_user_order_logistics")
public class F_user_order_logistics {

    @TableId(value = "order_logistics_id", type = IdType.AUTO)
    private Integer orderLogisticsId;

    @TableField(value = "logistics_order_no")
    private String logisticsOrderNo;

    @TableField(value = "logistics_no")
    private String logisticsNo;

    @TableField(value = "logistics_type")
    private String logisticsType;

    @TableField(value = "logistics_create_time")
    private Date logisticsCreateTime;

    @TableField(value = "logistics_address_name")
    private String logisticsAddressName;

    @TableField(value = "logistics_address_phone")
    private String logisticsAddressPhone;

    @TableField(value = "logistics_address_province")
    private String logisticsAddressProvince;

    @TableField(value = "logistics_address_city")
    private String logisticsAddressCity;

    @TableField(value = "logistics_address_county")
    private String logisticsAddressCounty;

    @TableField(value = "logistics_address_area")
    private String logisticsAddressArea;

    @TableField(value = "logistics_address_detail")
    private String logisticsAddressDetail;

    @TableField(value = "logistics_address_zip_code")
    private Integer logisticsAddressZipCode;

    @TableField(value = "logistics_fee")
    private Double logisticsFee;

    @TableField(value = "logistics_status")
    private String logisticsStatus;

    @TableField(value = "logistics_description")
    private String logisticsDescription;

    @TableField(value = "logistics_update_time")
    private Date logisticsUpdateTime;

    @TableField(value = "logistics_settlement_time")
    private Date logisticsSettlementTime;

    @TableField(value = "order_furniture_id")
    private Integer orderFurnitureId;
}

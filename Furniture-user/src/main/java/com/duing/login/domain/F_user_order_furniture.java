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
@TableName("f_user_order_furniture")
public class F_user_order_furniture {

    @TableId(value = "order_furniture_id", type = IdType.AUTO)
    private Integer orderFurnitureId;

    @TableField(value = "furniture_number")
    private Integer furnitureNumber;

    @TableField(value = "furniture_price")
    private Double furniturePrice;

    @TableField(value = "create_time")
    private Date createTime;

    @TableField(value = "pay_type")
    private String payType;

    @TableField(value = "order_id")
    private Integer orderId;

    @TableField(value = "furniture_id")
    private Integer furnitureId;

}

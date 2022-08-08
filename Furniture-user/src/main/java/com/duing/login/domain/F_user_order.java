package com.duing.login.domain;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("f_user_order")
public class F_user_order {
    @TableId(value = "order_id", type = IdType.AUTO)
    private Integer orderId;

    @TableField(value = "order_no")
    private String orderNo;

    @TableField(value = "pay_price")
    private Double payPrice;

    @TableField(value = "is_pay")
    private Byte isPay;

    @TableField(value = "is_ship")
    private Byte isShip;

    @TableField(value = "is_comment")
    private Byte isComment;

    @TableField(value = "pay_time")
    private java.util.Date payTime;


    @TableField(value = "ship_number")
    private String shipNumber;

    @TableField(value = "receipt_time")
    private java.util.Date receiptTime;

    @TableField(value = "turnover_time")
    private java.util.Date turnoverTime;

    @TableField(value = "create_time")
    private java.util.Date createTime;

    @TableField(value = "user_id")
    private Integer userId;

}

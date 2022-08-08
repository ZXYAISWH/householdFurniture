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
@TableName("f_user_shopping_car")
public class F_user_shopping_car {
    @TableId(value = "car_id", type = IdType.AUTO)
    private Integer carId;

    @TableField(value = "furniture_img")
    private String furnitureImg;

    @TableField(value = "furniture_number")
    private Integer furnitureNumber;

    @TableField(value = "create_time")
    private Date createTime;

    @TableField(value = "update_time")
    private Date updateTime;

    @TableField(value = "user_id")
    private Integer userId;

    @TableField(value = "furniture_id")
    private Integer furnitureId;

}

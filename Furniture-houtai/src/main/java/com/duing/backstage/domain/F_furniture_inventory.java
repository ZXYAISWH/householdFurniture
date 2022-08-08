package com.duing.backstage.domain;

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
 * 和数据库的f_furniture_inventory表的列对应
 * 用来存储家具库存的基本数据的
 *
 * @Data 给属性自动生成get和set方法
 * @AllArgsConstructor 自动生成全参构造器
 * @NoArgsConstructor 自动生成无参构造器
 * @ApiModel 描述这是家具库存表的信息
 * @TableName 使用mybatisPlus 自动生成sql 告诉表的名字
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("家具库存表的信息")
@TableName("f_furniture_inventory")
@SuppressWarnings("all")
public class F_furniture_inventory {
    /**
     * 家具库存表的ID
     *
     * @TableId 表示这是主键 列名是furniture_inventory_id
     * @ApiModelProperty 描述属性
     */
    @TableId(value = "furniture_inventory_id", type = IdType.AUTO)
    @ApiModelProperty("家具库存表的ID")
    private Integer furnitureInventoryId;

    /**
     * property_key:property_value 关联两张表的ID
     *
     * @TableField 表示这是表格的列  列名是furniture_properties
     * @ApiModelProperty 描述属性
     */
    @TableField(value = "furniture_properties")
    @ApiModelProperty("property_key:property_value 关联两张表的ID")
    private String furnitureProperties;

    /**
     * 家具的库存
     *
     * @TableField 表示这是表格的列  列名是furniture_inventory
     * @ApiModelProperty 描述属性
     */
    @TableField(value = "furniture_inventory")
    @ApiModelProperty("家具的库存")
    private Integer furnitureInventory;

    /**
     * 家具的重量
     *
     * @TableField 表示这是表格的列  列名是furniture_weight
     * @ApiModelProperty 描述属性
     */
    @TableField(value = "furniture_weight")
    @ApiModelProperty("家具的重量")
    private Double furnitureWeight;

    /**
     * 家具的单价
     *
     * @TableField 表示这是表格的列  列名是furniture_price
     * @ApiModelProperty 描述属性
     */
    @TableField(value = "furniture_price")
    @ApiModelProperty("家具的单价")
    private Double furniturePrice;

    /**
     * 家具的成本
     *
     * @TableField 表示这是表格的列  列名是furniture_cost
     * @ApiModelProperty 描述属性
     */
    @TableField(value = "furniture_cost")
    @ApiModelProperty("家具的成本")
    private Double furnitureCost;

    /**
     * 家具表的外键
     *
     * @TableField 表示这是表格的列  列名是furniture_id
     * @ApiModelProperty 描述属性
     */
    @TableField(value = "furniture_id")
    @ApiModelProperty("家具表的外键")
    private Integer furnitureId;

}

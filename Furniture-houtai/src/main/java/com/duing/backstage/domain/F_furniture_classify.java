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

import java.util.Date;

/**
 * 和数据库的f_furniture_classify表的列对应
 * 用来存储家具类型的基本数据的
 *
 * @Data 给属性自动生成get和set方法
 * @AllArgsConstructor 自动生成全参构造器
 * @NoArgsConstructor 自动生成无参构造器
 * @ApiModel 描述这是家具类型的信息
 * @TableName 使用mybatisPlus 自动生成sql 告诉表的名字
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("家具类型的信息")
@TableName("f_furniture_classify")
@SuppressWarnings("all")
public class F_furniture_classify {

    /**
     * 家具类型的ID
     *
     * @TableId 表示这是主键 列名是classify_id
     * @ApiModelProperty 描述属性
     */
    @TableId(value = "classify_id", type = IdType.AUTO)
    @ApiModelProperty("家具类型的ID")
    private Integer classifyId;

    /**
     * 家具类型的名字
     *
     * @TableField 表示这是表格的列  列名是classify_name
     * @ApiModelProperty 描述属性
     */
    @TableField(value = "classify_name")
    @ApiModelProperty("家具类型的名称")
    private String classifyName;

    /**
     * 家具类型的库存
     *
     * @TableField 表示这是表格的列  列名是classify_inventory
     * @ApiModelProperty 描述属性
     */
    @TableField(value = "classify_inventory")
    @ApiModelProperty("家具类型的库存")
    private Integer classifyInventory;

    /**
     * 家具类型的添加时间
     *
     * @TableField 表示这是表格的列  列名是classify_add_time
     * @ApiModelProperty 描述属性
     */
    @TableField(value = "classify_add_time")
    @ApiModelProperty("家具类型的添加时间")
    private Date classifyAddTime;

}

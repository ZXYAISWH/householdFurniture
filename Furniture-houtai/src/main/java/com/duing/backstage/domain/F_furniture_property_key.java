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
 * 和数据库的f_furniture_property_key表的列对应
 * 用来存储家具属性的基本数据的
 *
 * @Data 给属性自动生成get和set方法
 * @AllArgsConstructor 自动生成全参构造器
 * @NoArgsConstructor 自动生成无参构造器
 * @ApiModel 描述这是家具属性表的信息
 * @TableName 使用mybatisPlus 自动生成sql 告诉表的名字
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("家具属性表的信息")
@TableName("f_furniture_property_key")
@SuppressWarnings("all")
public class F_furniture_property_key {
    /**
     * 家具属性详情表的主键
     *
     * @TableId 表示这是主键 列名是property_key_id
     * @ApiModelProperty 描述属性
     */
    @TableId(value = "property_key_id", type = IdType.AUTO)
    @ApiModelProperty("家具属性详情表的主键")
    private Integer propertyKeyId;

    /**
     * 家具的属性：例如:颜色 尺寸
     *
     * @TableField 表示这是表格的列  列名是property_key_title
     * @ApiModelProperty 描述属性
     */
    @TableField(value = "property_key_title")
    @ApiModelProperty("家具的属性：例如:颜色 尺寸")
    private String propertyKeyTitle;

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

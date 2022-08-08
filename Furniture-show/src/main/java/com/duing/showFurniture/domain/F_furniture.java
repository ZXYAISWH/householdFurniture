package com.duing.showFurniture.domain;

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
 * 和数据库的f_furniture表的列对应
 * 用来存储家具的基本数据的
 *
 * @Data 给属性自动生成get和set方法
 * @AllArgsConstructor 自动生成全参构造器
 * @NoArgsConstructor 自动生成无参构造器
 * @ApiModel 描述这是家具表的信息
 * @TableName 使用mybatisPlus 自动生成sql 告诉表的名字
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("家具表的信息")
@TableName("f_furniture")
public class F_furniture {

    /**
     * 家具表的主键
     *
     * @TableId 表示这是主键 列名是furniture_id
     * @ApiModelProperty 描述属性
     */
    @TableId(value = "furniture_id", type = IdType.AUTO)
    @ApiModelProperty("家具表的主键")
    private Integer furnitureId;

    /**
     * 家具的名称
     *
     * @TableField 表示这是表格的列  列名是furniture_name
     * @ApiModelProperty 描述属性
     */
    @TableField(value = "furniture_name")
    @ApiModelProperty("家具的名称")
    private String furnitureName;

    /**
     * 家具的编号
     *
     * @TableField 表示这是表格的列  列名是furniture_no
     * @ApiModelProperty 描述属性
     */
    @TableField(value = "furniture_no")
    @ApiModelProperty("家具的编号")
    private String furnitureNo;

    /**
     * 关键字(方便搜索)
     *
     * @TableField 表示这是表格的列  列名是key_word
     * @ApiModelProperty 描述属性
     */
    @TableField(value = "key_word")
    @ApiModelProperty("关键字(方便搜索)")
    private String keyWord;

    /**
     * 家具的主图
     *
     * @TableField 表示这是表格的列  列名是furniture_img
     * @ApiModelProperty 描述属性
     */
    @TableField(value = "furniture_img")
    @ApiModelProperty("家具的主图")
    private String furnitureImg;

    /**
     * 家具描述
     *
     * @TableField 表示这是表格的列  列名是description
     * @ApiModelProperty 描述属性
     */
    @TableField(value = "description")
    @ApiModelProperty("家具描述")
    private String description;

    /**
     * 家具的点击量
     *
     * @TableField 表示这是表格的列  列名是clicks
     * @ApiModelProperty 描述属性
     */
    @TableField(value = "clicks")
    @ApiModelProperty("家具的点击量")
    private Integer clicks;

    /**
     * 家具的添加时间
     *
     * @TableField 表示这是表格的列  列名是add_time
     * @ApiModelProperty 描述属性
     */
    @TableField(value = "add_time")
    @ApiModelProperty("家具的添加时间")
    private Date addTime;

    /**
     * 家具的状态
     *
     * @TableField 表示这是表格的列  列名是status
     * @ApiModelProperty 描述属性
     */
    @TableField(value = "status")
    @ApiModelProperty("家具的状态")
    private Byte status;

    /**
     * 家具分类表的主键
     *
     * @TableField 表示这是表格的列  列名是classify_id
     * @ApiModelProperty 描述属性
     */
    @TableField(value = "classify_id")
    @ApiModelProperty("家具分类表的主键")
    private Integer classifyId;

}

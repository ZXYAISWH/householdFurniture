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
 * 和数据库的f_furniture_small_image表的列对应
 * 用来存储家具小图的基本数据的
 *
 * @Data 给属性自动生成get和set方法
 * @AllArgsConstructor 自动生成全参构造器
 * @NoArgsConstructor 自动生成无参构造器
 * @ApiModel 描述这是家具小图表的信息
 * @TableName 使用mybatisPlus 自动生成sql 告诉表的名字
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("家具小图表的信息")
@TableName("f_furniture_small_image")
@SuppressWarnings("all")
public class F_furniture_small_image {

    /**
     * 家具图片表的主键
     *
     * @TableId 表示这是主键 列名是small_image_id
     * @ApiModelProperty 描述属性
     */
    @TableId(value = "small_image_id", type = IdType.AUTO)
    @ApiModelProperty("家具图片表的主键")
    private Integer smallImageId;

    /**
     * 家具小图
     *
     * @TableField 表示这是表格的列  列名是small_img_url
     * @ApiModelProperty 描述属性
     */
    @TableField(value = "small_img_url")
    @ApiModelProperty("家具小图")
    private String smallImgUrl;

    /**
     * 图片添加时间
     *
     * @TableField 表示这是表格的列  列名是img_add_time
     * @ApiModelProperty 描述属性
     */
    @TableField(value = "img_add_time")
    @ApiModelProperty("图片添加时间")
    private Date imgAddTime;

    /**
     * 图片名称
     *
     * @TableField 表示这是表格的列  列名是small_image_name
     * @ApiModelProperty 描述属性
     */
    @TableField(value = "small_image_name")
    @ApiModelProperty("图片名称")
    private String smallImageName;

    /**
     * 图片大小
     *
     * @TableField 表示这是表格的列  列名是img_size
     * @ApiModelProperty 描述属性
     */
    @TableField(value = "img_size")
    @ApiModelProperty("图片大小")
    private Integer imgSize;

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

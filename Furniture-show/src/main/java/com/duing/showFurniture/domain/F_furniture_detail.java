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

/**
 * 和数据库的f_furniture_detail表的列对应
 * 用来存储家具详情的基本数据的
 *
 * @Data 给属性自动生成get和set方法
 * @AllArgsConstructor 自动生成全参构造器
 * @NoArgsConstructor 自动生成无参构造器
 * @ApiModel 描述这是家具详情的信息
 * @TableName 使用mybatisPlus 自动生成sql 告诉表的名字
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("家具详情表的信息")
@TableName("f_furniture_detail")
public class F_furniture_detail {
    /**
     * 家具详情表的ID
     *
     * @TableId 表示这是主键 列名是furniture_detail_id
     * @ApiModelProperty 描述属性
     */
    @TableId(value = "furniture_detail_id", type = IdType.AUTO)
    @ApiModelProperty("家具详情表的ID")
    private Integer furnitureDetailId;

    /**
     * 家具的详情json
     *
     * @TableField 表示这是表格的列  列名是furniture_detail_contexts
     * @ApiModelProperty 描述属性
     */
    @TableField(value = "furniture_detail_contexts")
    @ApiModelProperty("家具的详情json")
    private String furnitureDetailContexts;

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

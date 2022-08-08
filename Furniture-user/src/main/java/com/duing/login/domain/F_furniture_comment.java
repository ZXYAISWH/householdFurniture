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
@TableName("f_furniture_comment")
public class F_furniture_comment {

    @TableId(value = "furniture_comment_id", type = IdType.AUTO)
    private Integer furnitureCommentId;

    @TableField(value = " furniture_comment_content")
    private String furnitureCommentContent;

    @TableField(value = " furniture_comment_scores")
    private Double furnitureCommentScores;

    @TableField(value = " furniture_comment_time")
    private Date furnitureCommentTime;

    @TableField(value = " user_id")
    private Integer userId;

    @TableField(value = " furniture_id")
    private Integer furnitureId;

}

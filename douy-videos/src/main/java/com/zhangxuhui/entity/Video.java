package com.zhangxuhui.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: AmberZxh
 * @DateTime: 2021/12/26 8:23 上午
 * @Description: $description
*/
/**
    * 视频
    */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "video")
public class Video implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 标题
     */
    @TableField(value = "title")
    private String title;

    /**
     * 简介
     */
    @TableField(value = "intro")
    private String intro;

    /**
     * up主id
     */
    @TableField(value = "`uid`")
    private Integer uid;

    /**
     * 视频封面链接
     */
    @TableField(value = "cover")
    private String cover;

    /**
     * 视频播放链接
     */
    @TableField(value = "link")
    private String link;

    /**
     * 分类id
     */
    @TableField(value = "category_id")
    private Integer categoryId;

    @TableField(value = "created_at")
    private Date createdAt;

    @TableField(value = "updated_at")
    private Date updatedAt;

    @TableField(value = "deleted_at")
    private Date deletedAt;

    private static final long serialVersionUID = 1L;
}
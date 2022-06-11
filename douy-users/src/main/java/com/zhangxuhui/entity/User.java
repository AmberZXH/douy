package com.zhangxuhui.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: AmberZxh
 * @DateTime: 2021/12/25 7:44 下午
 * @Description: $description
*/

/**
 * 用户
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "`user`")
public class User  implements Serializable  {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户名
     */
    @TableField(value = "`name`")
    private String name;

    /**
     * 头像链接
     */
    @TableField(value = "avatar")
    private String avatar;

    /**
     * 简介
     */
    @TableField(value = "intro")
    private String intro;

    /**
     * 手机号
     */
    @TableField(value = "phone")
    private String phone;

    /**
     * 是否绑定手机号
     */
    @TableField(value = "phone_linked")
    private Boolean phoneLinked;

    /**
     * 微信openid
     */
    @TableField(value = "openid")
    private String openid;

    /**
     * 是否绑定微信
     */
    @TableField(value = "wechat_linked")
    private Boolean wechatLinked;

    /**
     * 关注数
     */
    @TableField(value = "following_count")
    private Integer followingCount;

    /**
     * 粉丝数
     */
    @TableField(value = "followers_count")
    private Integer followersCount;

    @TableField(value = "created_at")
    private Date createdAt;

    @TableField(value = "updated_at")
    private Date updatedAt;

    @TableField(value = "deleted_at")
    private Date deletedAt;

    private static final long serialVersionUID = 1L;
}

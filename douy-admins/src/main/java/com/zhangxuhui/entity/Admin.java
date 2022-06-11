package com.zhangxuhui.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @Author: AmberZxh
 * @DateTime: 2021/12/7 6:13 下午
 * @Description: $description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@TableName(value = "`admin`")
public class Admin implements Serializable {
    private static final long serialVersionUID = -997230527737711895L;
    /**
     * 用户id
     */
    @TableId(value = "id", type = IdType.INPUT)
    private Integer id;

    /**
     * 用户名
     */
    @TableField(value = "username")
    private String username;

    /**
     * 用户密码
     */
    @TableField(value = "`password`")
    private String password;

    /**
     * 用户头像地址
     */
    @TableField(value = "avatar")
    private String avatar;

    /**
     * 创建时间
     */
    @TableField(value = "created_at")
    private Date createdAt;

    /**
     * 更新时间
     */
    @TableField(value = "updated_at")
    private Date updatedAt;

    /**
     * 删除时间
     */
    @TableField(value = "deleted_at")
    private Date deletedAt;

    public static final String COL_ID = "id";

    public static final String COL_USERNAME = "username";

    public static final String COL_PASSWORD = "password";

    public static final String COL_AVATAR = "avatar";

    public static final String COL_CREATED_AT = "created_at";

    public static final String COL_UPDATED_AT = "updated_at";

    public static final String COL_DELETED_AT = "deleted_at";
}

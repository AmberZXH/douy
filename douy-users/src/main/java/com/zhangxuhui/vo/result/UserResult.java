package com.zhangxuhui.vo.result;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @Author: AmberZxh
 * @DateTime: 2021/12/25 7:33 下午
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class UserResult {
    private Integer id;

    /**
     * 用户名
     */
    private String name;

    /**
     * 头像链接
     */
    private String avatar;

    /**
     * 简介
     */
    private String intro;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 是否绑定手机号
     */
    private Boolean phoneLinked;

    /**
     * 微信openid
     */
    private String openid;

    /**
     * 是否绑定微信
     */
    private Boolean wechatLinked;

}

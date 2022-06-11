package com.zhangxuhui.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @Author: AmberZxh
 * @DateTime: 2021/12/26 8:34 上午
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Uploader {
    String id ;
    String name;
    String avatar;
    String intro;
    String phone;
    boolean phone_linked;
    String openid;
    boolean wechat_linked;

}

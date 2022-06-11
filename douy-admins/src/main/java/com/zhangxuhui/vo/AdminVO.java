package com.zhangxuhui.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: AmberZxh
 * @DateTime: 2021/12/9 4:36 下午
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminVO {
    @JsonProperty("name")
    String username;

    String avatar;
}

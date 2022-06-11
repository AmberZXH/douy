package com.zhangxuhui.vo.param;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @Author: AmberZxh
 * @DateTime: 2021/12/26 8:36 上午
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class VideoQuery {
    String token;
    Integer id;
    String name;
    Integer category_id;
    String uploader_name;
}

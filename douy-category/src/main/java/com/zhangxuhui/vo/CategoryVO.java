package com.zhangxuhui.vo;

import com.zhangxuhui.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @Author: AmberZxh
 * @DateTime: 2021/12/10 10:30 下午
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class CategoryVO {
    String id;
    String name;

    List<Category> children;

}

package com.zhangxuhui.entity.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @Author: AmberZxh
 * @DateTime: 2021/12/25 8:00 下午
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Pagination<E>{
    long total_count;
    List<E> items;
}

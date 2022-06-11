package com.zhangxuhui.service;

import com.zhangxuhui.entity.Category;
import com.zhangxuhui.vo.CategoryVO;

import java.util.List;

/**
 * @Author: AmberZxh
 * @DateTime: 2021/12/9 8:12 下午
 * @Description:
 */

public interface CategoryService {
    /**
     * 查询类别
     * @return
     */
    List<CategoryVO> queryByFirstLevel();

    Category update(Category category);

    Category insert(Category category);

    void deleteById(Integer id);
}

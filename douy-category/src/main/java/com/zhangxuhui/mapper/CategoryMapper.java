package com.zhangxuhui.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhangxuhui.entity.Category;
import com.zhangxuhui.vo.CategoryVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: AmberZxh
 * @DateTime: 2021/12/9 8:10 下午
 * @Description: $description
*/
@Mapper
public interface CategoryMapper extends BaseMapper<Category> {

    List<CategoryVO> queryByFirstLevel();
}


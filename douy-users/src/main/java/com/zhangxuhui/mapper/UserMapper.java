package com.zhangxuhui.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhangxuhui.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: AmberZxh
 * @DateTime: 2021/12/25 7:44 下午
 * @Description: $description
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}

package com.zhangxuhui.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhangxuhui.entity.Admin;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: AmberZxh
 * @DateTime: 2021/12/7 6:13 下午
 * @Description: $description
 */
@Mapper
public interface AdminMapper extends BaseMapper<Admin> {
    int deleteByPrimaryKey(Integer id);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);

}

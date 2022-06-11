package com.zhangxuhui.service.impl;

import cn.hutool.crypto.SecureUtil;
import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zhangxuhui.dao.AdminMapper;
import com.zhangxuhui.entity.Admin;
import com.zhangxuhui.service.AdminService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;

/**
 * @Author: AmberZxh
 * @DateTime: 2021/12/7 5:20 下午
 * @Description:
 */
@Service("adminService")
@Transactional
public class AdminServiceImpl implements AdminService {
    @Resource
    private AdminMapper adminMapper;


    @Override
    public Admin login(Admin admin) {
        //根据用户名查询用户
        Admin adminDB = adminMapper.selectOne(new LambdaQueryWrapper<Admin>().eq(Admin::getUsername, admin.getUsername()));

        //判断adminDB是否为空
        if (ObjectUtils.isEmpty(adminDB))
            throw new RuntimeException("用户名错误");

        //不为空，继续判断密码
        if(!StringUtils.equals(adminDB.getPassword(), SecureUtil.md5(admin.getPassword())))
            throw new RuntimeException("密码输入错误");


        return adminDB;
    }
}

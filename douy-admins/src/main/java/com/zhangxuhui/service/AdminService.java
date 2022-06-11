package com.zhangxuhui.service;

import com.zhangxuhui.entity.Admin;

/**
 * @Author: AmberZxh
 * @DateTime: 2021/12/7 5:20 下午
 * @Description:
 */

public interface AdminService {
    /**
     * 登陆方法
     * @param admin
     * @return
     */
     Admin login(Admin admin);
}

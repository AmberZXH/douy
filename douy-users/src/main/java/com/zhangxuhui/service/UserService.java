package com.zhangxuhui.service;

import com.zhangxuhui.entity.page.Pagination;
import com.zhangxuhui.vo.param.UserQuery;
import com.zhangxuhui.vo.result.UserResult;

/**
 * @Author: AmberZxh
 * @DateTime: 2021/12/25 7:44 下午
 * @Description:
 */
public interface UserService {
    /**
     * 分页查询 用户
     * @param page
     * @param per_page
     * @param query
     */
    Pagination<UserResult> queryByPage(Integer page, Integer per_page, UserQuery query);
}

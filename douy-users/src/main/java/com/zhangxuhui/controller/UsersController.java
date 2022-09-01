package com.zhangxuhui.controller;

import com.zhangxuhui.entity.page.Pagination;
import com.zhangxuhui.service.UserService;
import com.zhangxuhui.vo.param.UserQuery;
import com.zhangxuhui.vo.result.UserResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Nullable;

/**
 * @Author: AmberZxh
 * @DateTime: 2021/12/25 7:13 下午
 * @Description:
 */
@RestController
@RequestMapping("users")
public class UsersController {
    private static final Logger log = LoggerFactory.getLogger(UsersController.class);

    @Autowired
    UserService userService;

    @GetMapping
    public Pagination<UserResult> usersList(Integer page, Integer per_page, @Nullable UserQuery query) {
        return userService.queryByPage(page, per_page, query);
    }


    @GetMapping("test")
    public String tet(){
        return "helloWorldasssss";
    }

}

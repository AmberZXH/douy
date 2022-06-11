package com.zhangxuhui.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhangxuhui.entity.User;
import com.zhangxuhui.entity.page.Pagination;
import com.zhangxuhui.mapper.UserMapper;
import com.zhangxuhui.service.UserService;
import com.zhangxuhui.vo.param.UserQuery;
import com.zhangxuhui.vo.result.UserResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: AmberZxh
 * @DateTime: 2021/12/25 7:44 下午
 * @Description:
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    UserMapper userMapper;

    @Override
    public Pagination<UserResult> queryByPage(Integer page, Integer per_page, UserQuery query) {

        if (ObjectUtils.isEmpty(page) || ObjectUtils.isEmpty(per_page)) {
            log.error("分页参数为空");
        }

        try {
            IPage<User> p = new Page<>(page, per_page);
            Pagination<UserResult> pagination = new Pagination<>();
            IPage<User> userIPage = userMapper.selectPage(p, new LambdaQueryWrapper<User>().eq(query.getId() != null, User::getId, query.getId())
                    .eq(query.getName() != null, User::getName, query.getName())
                    .eq(query.getPhone() != null, User::getPhone, query.getPhone()));

            List<User> records = userIPage.getRecords();
            List<UserResult> collect = records.stream().map(m -> {
                UserResult userResult = new UserResult();
                BeanUtils.copyProperties(m, userResult);
                return userResult;
            }).collect(Collectors.toList());

            log.info("当前list中的总数：{}",userIPage.getTotal());
            log.info("当前list中符合条件的总数：{}",userIPage.getRecords().size());
            log.info("当前页：{}",userIPage.getCurrent());
            log.info("当前页大小：{}",userIPage.getSize());

            pagination.setItems(collect).setTotal_count(userIPage.getTotal());
            return pagination;
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            throw new RuntimeException("查询用户信息错误");
        }
    }
}

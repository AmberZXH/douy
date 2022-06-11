package com.zhangxuhui.controller;

import cn.hutool.json.JSONUtil;
import com.zhangxuhui.douyu.constants.RedisPrefix;
import com.zhangxuhui.entity.Admin;
import com.zhangxuhui.service.AdminService;
import com.zhangxuhui.vo.AdminVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;


/**
 * @Author: AmberZxh
 * @DateTime: 2021/12/6 4:58 下午
 * @Description:
 */
@RestController
public class AdminController {

    private static final Logger log = LoggerFactory.getLogger(AdminController.class);
    @Autowired
    private AdminService adminService;
    @Autowired
    private RedisTemplate redisTemplate;


    /**
     * 退出登陆
     * @param token
     * @return
     */
    @DeleteMapping("/tokens/{token}")
    public void logout(@PathVariable String token){
       // redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.delete(RedisPrefix.TOKEN_KEY+token);
    }

    /**
     * 获取用户信息
     *
     * @param token
     * @return
     */
    @GetMapping("admin-user")
    public AdminVO getUserInfo(String token) {
        log.info("当前的token信息：{}", token);
        // 从redis中 获得用户信息
       // redisTemplate.setKeySerializer(new StringRedisSerializer());
        Admin admin = (Admin) redisTemplate.opsForValue().get(RedisPrefix.TOKEN_KEY+token);
        AdminVO adminVO = new AdminVO();
        if (!ObjectUtils.isEmpty(admin)) {
            BeanUtils.copyProperties(admin, adminVO);
        }else{
            throw new RuntimeException("admin为空");
        }

        return adminVO;
    }

    /**
     * 登陆
     *
     * @param admin
     * @param session
     * @return
     */
    @PostMapping("/tokens")
    public Map<String, String> tokens(@RequestBody Admin admin, HttpSession session) {
        Map<String, String> result = new HashMap<>();
        log.info("接收到的对象 : {}", JSONUtil.toJsonStr(admin));

        //进行登陆
        Admin adminDB = adminService.login(admin);
        // 登陆成功
        String token = session.getId();

        // 将 token 存入 redis
       // redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.opsForValue().set(RedisPrefix.TOKEN_KEY +token, adminDB, 5, TimeUnit.HOURS);

        result.put("token", token);


        return result;

    }
}

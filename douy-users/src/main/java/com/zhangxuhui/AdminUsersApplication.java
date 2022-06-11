package com.zhangxuhui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: AmberZxh
 * @DateTime: 2021/12/6 3:05 下午
 * @Description:
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AdminUsersApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdminUsersApplication.class, args);
    }
}

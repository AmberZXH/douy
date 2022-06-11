package com.zhangxuhui;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: AmberZxh
 * @DateTime: 2021/12/6 3:02 下午
 * @Description:
 */
@SpringBootApplication
//@MapperScan("com.zhangxuhui.dao")
public class AdminsApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdminsApplication.class,args);
    }
}

package com.zhangxuhui.config;

import cn.hutool.json.JSONUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhangxuhui.douyu.constants.LoggerConst;
import com.zhangxuhui.douyu.exceptions.IllegalTokenException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.reactive.error.ErrorWebExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: AmberZxh
 * @DateTime: 2022/6/12 10:27
 * @Description:
 */
@Order(-1)
@Configuration
public class GlobalExceptionConfiguration implements ErrorWebExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionConfiguration.class);


    @Override
    public Mono<Void> handle(ServerWebExchange exchange, Throwable ex) {

        Map<String, String> results = new HashMap<>();

        ServerHttpResponse response = exchange.getResponse();

        // 多个异常处理时
        if (response.isCommitted()) {
            return Mono.error(ex);
        }

        // 设置响应头类型
        response.getHeaders().setContentType(MediaType.APPLICATION_JSON);

        //设置响应状态码
        if (ex instanceof IllegalTokenException) {
            response.setStatusCode(HttpStatus.FORBIDDEN);
        } else {
            response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return response.writeWith(Mono.fromSupplier(() -> {

            DataBufferFactory dataBufferFactory = response.bufferFactory();
            results.put("msg", ex.getMessage());

            ObjectMapper objectMapper = new ObjectMapper();

            try {
                return dataBufferFactory.wrap(objectMapper.writeValueAsBytes(results));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                return null;
            }
        }));


    }
}

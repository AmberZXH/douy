package com.zhangxuhui.exception;

import com.zhangxuhui.douyu.constants.LoggerConst;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: AmberZxh
 * @DateTime: 2022/6/12 10:14
 * @Description: 异常处理
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler
    @ResponseBody
    public Map<String, String> exceptionHandler(Exception e) {

        Map<String, String> result = new HashMap<>();
        log.info(LoggerConst.PRINT_LINE + "Exception: {}", e.getMessage());
        result.put("msg", e.getMessage());
        return result;
    }
}

package com.zhangxuhui.gateway.filter.factory;

import com.zhangxuhui.douyu.constants.LoggerConst;
import com.zhangxuhui.douyu.constants.RedisPrefix;
import com.zhangxuhui.douyu.exceptions.IllegalTokenException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @Author: AmberZxh
 * @DateTime: 2022/6/11 23:41
 * @Description: token filter
 */
@Component
public class TokenGatewayFilterFactory extends AbstractGatewayFilterFactory<TokenGatewayFilterFactory.Config> {


    private static final Logger log = LoggerFactory.getLogger(TokenGatewayFilterFactory.class);

    @Autowired
    RedisTemplate redisTemplate;

    public TokenGatewayFilterFactory() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {

            log.info(LoggerConst.PRINT_LINE + "Enter TokenGateway Filter");

            log.info("Config Required Token {} ", config.isRequireToken());


            if (config.isRequireToken()) {
                // 判断 token 是否为空
                Optional.ofNullable(exchange.getRequest().getQueryParams().get("token")).orElseThrow(() -> new IllegalTokenException("非法令牌"));

                String token = exchange.getRequest().getQueryParams().get("token").get(0);
                log.info("token: {}", token);

                // 验证token是否合法
                if (Boolean.FALSE.equals(redisTemplate.hasKey(RedisPrefix.TOKEN_KEY + token))) {
                    throw new IllegalTokenException("不合法的令牌");
                }
            }


            return chain.filter(exchange);
        };
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList("requireToken");
    }

    public static class Config {
        private boolean requireToken;

        public boolean isRequireToken() {
            return requireToken;
        }

        public void setRequireToken(boolean requireToken) {
            this.requireToken = requireToken;
        }
    }
}

package com.rpc.redis;

import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ToString
@Slf4j
@Data
public class ShareClusterRedisProperties {
    @Value("${spring.share.redis.timeout}")
    private Integer redisTimeout;
    @Value("${spring.share.redis.jedis.pool.max-active}")
    private Integer poolMaxActive;
    @Value("${spring.share.redis.jedis.pool.max-idle}")
    private Integer poolMaxIdle;
    @Value("${spring.share.redis.jedis.pool.min-idle}")
    private Integer poolMinIdle;
    @Value("${spring.share.redis.jedis.pool.max-wait}")
    private Integer poolMaxWait;
    @Value("${spring.share.redis.cluster.nodes}")
    private List<String> clusterNodes;
    @Value("${spring.share.redis.cluster.max-redirects}")
    private Integer clusterMaxRedirects;
    @Value("${spring.share.redis.password}")
    private String password;

}

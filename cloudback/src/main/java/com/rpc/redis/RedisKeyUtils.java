package com.rpc.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Component
@Slf4j
public class RedisKeyUtils {
    @Resource
    private JedisCluster jedisCluster;

    public int keys(final String pattern) {
        try {
            final Set<String> keySet = new HashSet();
            final Map<String, JedisPool> nodes = jedisCluster.getClusterNodes();
            for (String k : nodes.keySet()) {
                JedisPool pool = nodes.get(k);
                //获取Jedis对象，Jedis对象支持keys模糊查询
                Jedis jedis = pool.getResource();
                final Set<String> set = jedis.keys(pattern);
                keySet.addAll(set);
            }

            return keySet.size();
        } catch (Exception e) {
            log.error("异常信息", e);
            throw e;
        }
    }

    /**
     * 模糊查询给定的pattern的所有keys列表
     *
     * @param pattern 模糊查询
     * @return 返回当前pattern可匹配的对象keys列表
     */
    public Set<String> keyList(final String pattern) {

        try {
            final Set<String> keySet = new HashSet<String>();
            final Map<String, JedisPool> nodes = jedisCluster.getClusterNodes();
            for (String k : nodes.keySet()) {
                JedisPool pool = nodes.get(k);
                //获取Jedis对象，Jedis对象支持keys模糊查询
                Jedis jedis = pool.getResource();
                final Set<String> set = jedis.keys(pattern);
                keySet.addAll(set);
            }
            return keySet;
        } catch (Exception e) {
            log.error("异常信息", e);
            throw e;
        }


    }
}

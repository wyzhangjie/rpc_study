package com.rpc.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.Pipeline;


@Component
public class SimpleRateLimiter {
    @Autowired
    private JedisCluster jedis;

    public boolean isActionAllowed(String userId, String actionKey, int period, int maxCount) {
     /*   String key = String.format("hist:%s:%s", userId, actionKey);
        long nowTs = System.currentTimeMillis();
        ClusterPipeline pipe = jedis.mul();
        pipe.multi();
        pipe.zadd(key, nowTs, "" + nowTs);
        pipe.zremrangeByScore(key, 0, nowTs - period * 1000);
        Long count = jedis.zcard(key);
        jedis.expire(key, period + 1);
        jedis.exec();
        return count.get() <= maxCount;*/
        return false;
    }
    public static void main(String[] args) {
        /*Jedis jedis = new Jedis();
        SimpleRateLimiter limiter = new SimpleRateLimiter(jedis);
        for(int i=0;i<20;i++) {
            System.out.println(limiter.isActionAllowed("laoqian", "reply", 60, 5));
        }*/
    }
}

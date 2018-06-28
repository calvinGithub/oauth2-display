package com.hand.hmall.service;

import com.hand.hmall.config.RedisConfig;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @Title HepOauth2RedisTokenService
 * @Description ${DESCRIPTION}
 * @author calvin
 * @date: 2018/6/28 上午1:50 
 */

@Service
public class HepOauth2RedisTokenService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

//    public void setCode(String key, String code) {
//        stringRedisTemplate.opsForValue().set(key, code, 60, TimeUnit.SECONDS);
//    }

    public String getCode(String key) {
        Set<String> set = stringRedisTemplate.keys(key + "*");
        String accessKey = null;
        for (String str : set) {
            accessKey = str;
            break;
        }
        System.out.println("====accessKey=====" + accessKey);
        return stringRedisTemplate.boundValueOps(accessKey).get();
    }

    public Long getExpire(String key) {
        Set<String> set = stringRedisTemplate.keys(key + "*");
        String accessKey = null;
        for (String str : set) {
            accessKey = str;
            break;
        }
        System.out.println("====accessKey=====" + accessKey);
        return stringRedisTemplate.getExpire(accessKey, TimeUnit.SECONDS);
    }


}

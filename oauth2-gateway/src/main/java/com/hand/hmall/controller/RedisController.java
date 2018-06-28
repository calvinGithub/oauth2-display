package com.hand.hmall.controller;

import com.hand.hmall.service.HepOauth2RedisTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title RedisController
 * @Description ${DESCRIPTION}
 * @author calvin
 * @date: 2018/6/28 上午1:53 
 */

@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private HepOauth2RedisTokenService hepOauth2RedisTokenService;

    @GetMapping("getToken")
    public String getToken() {
        return hepOauth2RedisTokenService.getCode("access:");
    }

    @GetMapping("getExpireTime")
    public Long getExpireTime() {
        Long expireTime = hepOauth2RedisTokenService.getExpire("access:");
        if (!expireTime.equals(0L)) {
            System.out.println("===没有过期=====");
        }
        return expireTime;
    }

}

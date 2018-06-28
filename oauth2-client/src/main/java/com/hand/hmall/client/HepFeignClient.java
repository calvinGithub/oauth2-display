package com.hand.hmall.client;


import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author calvin
 * @Title FeignServer
 * @Description Feign客户端
 * @date: 2018/6/26 下午5:48
 */

@FeignClient(name = "oauth2-server")
public interface HepFeignClient {

    @GetMapping(value = "/server/product/{id}")
    String getProductId(@PathVariable("id") String id);

    @GetMapping(value = "/server/order/{id}")
    String getOrerId(@PathVariable("id") String id,
            @RequestParam("access_token") String access_token);

}

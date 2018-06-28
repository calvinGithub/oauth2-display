package com.hand.hmall.controller;

import com.hand.hmall.client.HepFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author calvin
 * @Title HepClientSecurityController
 * @Description 测试授权功能的客户端接口
 * @date: 2018/6/26 上午10:28
 */

@RestController
@RequestMapping(value = "/client")
public class HepClientSecurityController {

    @Autowired
    private HepFeignClient hepFeignClient;

    @GetMapping("/product/getProduct/{id}")
    public String getProduct(@PathVariable("id") String id) {
        String productId = hepFeignClient.getProductId(id);
        return "FeignProductId:" + productId;
    }

    @GetMapping("/order/getOrder/{id}")
    public String getOrder(@PathVariable("id") String id,
            @RequestParam(value = "access_token", required = false) String access_token) {
        String orderId = hepFeignClient.getOrerId(id, access_token);
        return "FeignOrderId:" + orderId;
    }

}

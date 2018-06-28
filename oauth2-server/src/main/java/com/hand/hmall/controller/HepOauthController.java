package com.hand.hmall.controller;

// import org.springframework.security.core.Authentication;
// import org.springframework.security.core.context.SecurityContextHolder;

import com.hand.hmall.dataobject.OrderInfo;
import com.hand.hmall.dataobject.RequestOrderInfo;
import com.hand.hmall.repository.OrderInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author calvin
 * @Title HepOauthController
 * @Description 测试权限
 * @date: 2018/6/24 上午10:33
 */

@RestController
@RequestMapping(value = "/server")
public class HepOauthController {

    @Autowired
    private OrderInfoRepository orderInfoRepository;

    @GetMapping("/product/{id}")
    public String getProduct(@PathVariable("id") String id) {
        return "product id : " + id;
    }

    @GetMapping("/order/{id}")
    public String getOrder(@PathVariable("id") String id) {
        return "order id : " + id;
    }

    /**
     * 保存订单信息
     * @param requestOrderInfo
     */
    @PutMapping("/order/save")
    public OrderInfo saveOrderData(@RequestBody RequestOrderInfo requestOrderInfo) {
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setOrderId(requestOrderInfo.getOrderId());
        orderInfo.setBuyerName(requestOrderInfo.getBuyerName());
        orderInfo.setBuyerPhone(requestOrderInfo.getBuyerPhone());
        orderInfo.setProductName(requestOrderInfo.getProductName());
        orderInfoRepository.save(orderInfo);
        return orderInfo;
    }

}

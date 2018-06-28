package com.hand.hmall.controller;

import com.hand.hmall.dataobject.OrderInfo;
import com.hand.hmall.repository.OrderInfoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HepOauthControllerTest {

    @Autowired
    private OrderInfoRepository orderInfoRepository;

    @Test
    public void saveOrder() {
        String orderId = "0001";
        String buyerName = "calvin";
        String buyerPhone = "15156855792";
        String productName = "青椒炒肉丝";
        OrderInfo orderInfo = new OrderInfo(orderId, buyerName, buyerPhone, productName);
        orderInfoRepository.save(orderInfo);
    }

}
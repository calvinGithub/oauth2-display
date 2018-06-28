package com.hand.hmall.dataobject;

import lombok.Data;

/**
 * @Title OrderInfo
 * @Description 订单表
 * @author calvin
 * @date: 2018/6/27 下午3:59 
 */

@Data
public class RequestOrderInfo {

    // 订单编号
    private String orderId;

    // 用户姓名
    private String buyerName;

    // 买家电话
    private String buyerPhone;

    // 商品名称
    private String productName;

}

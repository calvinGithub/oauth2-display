package com.hand.hmall.dataobject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.annotations.DynamicUpdate;

/**
 * @Title OrderInfo
 * @Description 订单表
 * @author calvin
 * @date: 2018/6/27 下午3:59 
 */

@Entity
@DynamicUpdate
@Data  // 生成set，get方法
@NoArgsConstructor  // 生成无参构造
@AllArgsConstructor  // 生成所有参数的构造
@Accessors(chain = true)
public class OrderInfo {

    // 订单编号
    @Id
    private String orderId;

    // 用户姓名
    private String buyerName;

    // 买家电话
    private String buyerPhone;

    // 商品名称
    private String productName;

}

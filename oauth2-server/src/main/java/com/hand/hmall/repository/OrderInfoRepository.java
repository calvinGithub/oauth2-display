package com.hand.hmall.repository;

import com.hand.hmall.dataobject.OrderInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Title OrderInfoRepository
 * @Description 订单操作接口
 * @author calvin
 * @date: 2018/6/27 下午4:18 
 */
public interface OrderInfoRepository extends JpaRepository<OrderInfo, String> {

}

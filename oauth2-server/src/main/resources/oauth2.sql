/* 订单表 */
DROP TABLE IF EXISTS order_info;
CREATE TABLE order_info(
  order_id VARCHAR(32) NOT NULL COMMENT '订单编号',
  buyer_name VARCHAR(32) NOT NULL COMMENT '买家姓名',
  buyer_phone VARCHAR(32) NOT NULL COMMENT '买家电话',
  product_name VARCHAR(32) NOT NULL COMMENT '商品名称',
  PRIMARY KEY (order_id),
  KEY idx_order_id (order_id)
) COMMENT '订单表';
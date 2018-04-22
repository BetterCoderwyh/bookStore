package com.book.online.order.mapper;

import com.book.online.entity.Order;
import com.book.online.entity.OrderItem;

public interface OrderItemMapper {
    /**
     * 保存订单明细
     * @param o
     */
    public void save(OrderItem o);
    /**
     * 通过订单编号删除订单明细
     * @param orderId
     */
    public void deleteById(Long orderId);
    /**
     * 根据订单删除
     * @param o
     */
    public void deleteByOrder(Order o);
    
}

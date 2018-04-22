package com.book.online.order.service;

import java.util.List;

import com.book.online.entity.Order;
import com.book.online.entity.OrderItem;
import com.book.online.entity.User;
import com.book.online.vo.PageBean;

public interface IOrderService {
    /**
     * 保存订单对象及订单明细
     * @param o
     */
    public void save(Order o);
    /**
     * 删除订单对象及订单明细
     * @param o
     */
    public void delete(Order o);
    /**
     * 删除订单对应的订单明细 
     * @param o
     */
    public void deleteItem(Order o);
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public Order findById(Long id);
    /**
     * 根据用户查询订单
     * @param user
     * @param pageNow
     * @param pageSize
     * @return
     */
    public PageBean<Order> queryByPage(User user,Integer pageNow,Integer pageSize);
    /**
     * 保存订单明细
     * @param o
     */
    public void saveOrderItem(OrderItem o);
    /**
     * 根据用户查询所有订单
     * @param user
     */
    public List<Order> queryOrdersByUser(User user);
}

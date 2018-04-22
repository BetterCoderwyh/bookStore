package com.book.online.order.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.book.online.entity.Order;
import com.book.online.entity.User;

public interface OrderMapper {
    /**
     * 保存订单信息
     * @param o
     */
    public void save(Order o);
    /**
     * 按照订单Id查询
     * @param id
     * @return
     */
    public Order findById(Long id);
    /**
     * 删除订单
     * @param o
     */
    public void delete(Order o);
    /**
     * 根据用户分页查询
     * @param user
     * @param pageNow
     * @param pageSize
     * @return
     */
    public List<Order> selectByPage(@Param("user")User user,@Param("pageNow")Integer pageNow,@Param("pageSize")Integer pageSize);
    /**
     * 获取当前用户总订单数
     * @param user
     * @return
     */
    public int getRows(User user);
    
    /**
     * 根据用户查询所有订单信息
     * @param user
     * @return
     */
    public List<Order> getAllOrders(User user);
}

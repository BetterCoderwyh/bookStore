package com.book.online.order.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.book.online.entity.Order;
import com.book.online.entity.OrderItem;
import com.book.online.entity.User;
import com.book.online.order.mapper.OrderItemMapper;
import com.book.online.order.mapper.OrderMapper;
import com.book.online.order.service.IOrderService;
import com.book.online.util.SqlSessionUtil;
import com.book.online.vo.PageBean;

public class IOrderServiceImpl implements IOrderService{

    private SqlSession session;
    private OrderMapper ordermapper;
    private OrderItemMapper orderitemmapper;
    private void init1() {
        session=SqlSessionUtil.getSqlSession();
        ordermapper=session.getMapper(OrderMapper.class);
    }
    private void init2() {
        session=SqlSessionUtil.getSqlSession();
        orderitemmapper=session.getMapper(OrderItemMapper.class);
    }
    private void release() {
        session.close();
    }
    @Override
    public void save(Order o) {
        init1();
        ordermapper.save(o);
        session.commit();
        release();
    }

    @Override
    public void delete(Order o) {
        init1();
        ordermapper.delete(o);
        session.commit();
        release();
    }

    @Override
    public Order findById(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public PageBean<Order> queryByPage(User user, Integer pageNow, Integer pageSize) {
        PageBean<Order> pageOrder=new PageBean<>();
        pageOrder.setPageSize(pageSize);
        pageOrder.setPageNow(pageNow);
        init1();
        int rows = ordermapper.getRows(user);
        pageOrder.setRows(rows);
        List<Order> datas = ordermapper.selectByPage(user, pageNow, pageSize);
        pageOrder.setDatas(datas);
        release();
        int count=0;
        count=rows/pageSize;
        if(rows%pageSize!=0)
            count++;
        pageOrder.setPageCounts(count);
        return pageOrder;
    }
    
    @Override
    public void saveOrderItem(OrderItem o) {
        init2();
        orderitemmapper.save(o);
        session.commit();
        release();
        
    }
    @Override
    public void deleteItem(Order o) {
        init2();
        orderitemmapper.deleteByOrder(o);
        session.commit();
        release();
    }
    @Override
    public List<Order> queryOrdersByUser(User user) {
        init1();
        List<Order> allOrders = ordermapper.getAllOrders(user);
        release();
        return allOrders;
    }

}

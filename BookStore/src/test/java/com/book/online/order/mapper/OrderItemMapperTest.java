package com.book.online.order.mapper;

import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.book.online.entity.Order;
import com.book.online.entity.OrderItem;
import com.book.online.util.SqlSessionUtil;

public class OrderItemMapperTest {
    private SqlSession session;
    private OrderItemMapper mapper;
    @BeforeMethod
    public void init()
    {
        session=SqlSessionUtil.getSqlSession();
        mapper=session.getMapper(OrderItemMapper.class);
    }
    @AfterMethod
    public void release()
    {
        session.close();
    }
  @Test
  public void deleteById() {
      mapper.deleteById(3L);
      session.commit();
  }

  @Test
  public void save() {
      Order od=new Order();
      od.setOrderId(1L);
      OrderItem o=new OrderItem("aaaaa", "zzzz", "zzzz", "asda", 4, 66, 3, od);
      o.setBook_imgurl("1.jsp");
      o.setBook_price(20);
      mapper.save(o);
      session.commit();
  }
}

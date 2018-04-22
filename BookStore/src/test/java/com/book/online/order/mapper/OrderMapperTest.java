package com.book.online.order.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.book.online.entity.Order;
import com.book.online.entity.User;
import com.book.online.util.SqlSessionUtil;

public class OrderMapperTest {

    private SqlSession session;
    private OrderMapper mapper;
    @BeforeMethod
    public void init()
    {
        session=SqlSessionUtil.getSqlSession();
        mapper=session.getMapper(OrderMapper.class);
    }
    @AfterMethod
    public void release()
    {
        session.close();
    }
  @Test
  public void delete() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void findById() {
      Order order = mapper.findById(1L);
      System.out.println(order);
      System.out.println(order.getAddress());
      System.out.println(order.getOrderStatus());
      System.out.println(order.getUser());
      
      }

  @Test
  public void getRows() {
      User user=new User();
      user.setUserId(1L);
      int rows = mapper.getRows(user);
      System.out.println(rows);
  }
  
  @Test
  public void getAllOrders() {
      User user=new User();
      user.setUserId(1L);
      List<Order> rows = mapper.getAllOrders(user);
      System.out.println(rows);
  }

  @Test
  public void save() {
      Order order = mapper.findById(1L);
      Order o= order;
      o.setOrderNum("aasaaaaad");
      mapper.save(o);
      session.commit();
  }

  @Test
  public void selectByPage() {
      User user=new User();
      user.setUserId(2L);
      List<Order> page = mapper.selectByPage(user, 1, 6);
      System.out.println(page.size());
//     for (Order order : page) {
//         System.out.println(order);
//         System.out.println(order.getAddress());
//         System.out.println(order.getOrderStatus());
//         System.out.println(order.getUser());
//    }      
  }
}

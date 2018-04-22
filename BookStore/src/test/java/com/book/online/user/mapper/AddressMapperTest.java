package com.book.online.user.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.book.online.entity.Address;
import com.book.online.entity.User;
import com.book.online.util.SqlSessionUtil;

public class AddressMapperTest {

    private SqlSession session;
    private AddressMapper mapper;
    @BeforeMethod
    public void init()
    {
        session=SqlSessionUtil.getSqlSession();
        mapper=session.getMapper(AddressMapper.class);
    }
    @AfterMethod
    public void release()
    {
        session.close();
    }
  @Test
  public void deleteById() {
      mapper.deleteById(3l);
      session.commit();
  }

  @Test
  public void findById() {
    Address address = mapper.findById(1L);
    System.out.println(address);
    System.out.println(address.getUser());
  }

  @Test
  public void findByUserId() {
      List<Address> list = mapper.findByUserId(1L);
      list.forEach(System.out::println);
  }

  @Test
  public void save() {
      User user=new User();
      user.setUserId(1L);
      Address a=new Address("test2", "test2", "test2", "test2", "test2", "test2", user);
      mapper.save(a);
      session.commit();
      System.out.println(a.getAddressId());
  }

  @Test
  public void update() {
      User user=new User();
      user.setUserId(5L);
      Address a=new Address("update", "update", "update", "update", "update", "update", user);
      a.setAddressId(3L);
      mapper.update(a);
      session.commit();
  }
}

package com.book.online.user.service.impl;

import org.testng.annotations.Test;

import com.book.online.entity.User;
import com.book.online.util.BeansFactory;

public class IUserServiceImplTest {

  private IUserServiceImpl iuser=(IUserServiceImpl) BeansFactory.newInstance("UserService");
  @Test
  public void addAddress() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void delAddressById() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void getAddrById() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void getAddressByUser() {
      
  }

  @Test
  public void login() {
      User login = iuser.login("admin");
      System.out.println(login);
  }

  @Test
  public void register() {
      User user=new User("admin1", "admin1", "admin1", "admin1", "admin1", "admin1");
      iuser.register(user);
  }

  @Test
  public void updAddress() {
     
  }

  @Test
  public void validate() {
    throw new RuntimeException("Test not implemented");
  }
}

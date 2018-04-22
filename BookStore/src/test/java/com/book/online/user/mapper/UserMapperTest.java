package com.book.online.user.mapper;

import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.book.online.entity.User;
import com.book.online.util.SqlSessionUtil;

public class UserMapperTest {

    private SqlSession session;
    private UserMapper mapper;
    @BeforeMethod
    public void init()
    {
        session=SqlSessionUtil.getSqlSession();
        mapper=session.getMapper(UserMapper.class);
    }
    @AfterMethod
    public void release()
    {
        session.close();
    }
  @Test
  public void save() {
      User user=new User("admin", "12222", "w5555", "w5555", "w5555", "w5555");
      System.out.println(user);
      mapper.save(user);
      session.commit();
  }

  @Test
  public void selectByName() {
      User user = mapper.selectByName("admin");
      System.out.println(user);
  }
  

  @Test
  public void update() {
      User user=new User("jack3", "jack", "jack", "jack", "jack", "jack");
      user.setUserId(5L);
      mapper.update(user);
      session.commit();
  }
}

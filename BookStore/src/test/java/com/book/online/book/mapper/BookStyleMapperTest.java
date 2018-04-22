package com.book.online.book.mapper;

import org.testng.annotations.Test;

import com.book.online.entity.BookStyle;
import com.book.online.util.SqlSessionUtil;

import org.testng.annotations.BeforeMethod;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.AfterMethod;

public class BookStyleMapperTest {
    private SqlSession session;
    private BookStyleMapper mapper;
    @BeforeMethod
    public void init()
    {
        session=SqlSessionUtil.getSqlSession();
        mapper=session.getMapper(BookStyleMapper.class);
    }
    @AfterMethod
    public void release()
    {
        session.close();
    }


  @Test
  public void findAll() {
    List<BookStyle> list = mapper.findAll();
    list.forEach(System.out::println);
  }

  @Test
  public void findById() {
    BookStyle bookStyle = mapper.findById(1L);
    System.out.println(bookStyle);
  }
}

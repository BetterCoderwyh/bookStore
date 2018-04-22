package com.book.online.book.mapper;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.book.online.entity.Book;
import com.book.online.util.SqlSessionUtil;

public class BookMapperTest {

    private SqlSession session;
    private BookMapper mapper;
    @BeforeMethod
    public void init()
    {
        session=SqlSessionUtil.getSqlSession();
        mapper=session.getMapper(BookMapper.class);
    }
    @AfterMethod
    public void release()
    {
        session.close();
    }
    @Test
    public void testFindById() {
       Book book = mapper.findById(1L);
       System.out.println(book.getStyle_id());
    }

    @Test
    public void testFindByCondition() {
        List<Book> list = mapper.findByCondition(1, 3, "", 1L);
        list.forEach(System.out::println);
    }

    @Test
    public void testGetRows() {
        int rows = mapper.getRows("", 2L);
        System.out.println(rows);
    }

}

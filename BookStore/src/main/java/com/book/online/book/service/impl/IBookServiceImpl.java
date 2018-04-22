package com.book.online.book.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.book.online.book.mapper.BookMapper;
import com.book.online.book.mapper.BookStyleMapper;
import com.book.online.book.service.IBookService;
import com.book.online.entity.Book;
import com.book.online.entity.BookStyle;
import com.book.online.util.SqlSessionUtil;
import com.book.online.vo.PageBean;

public class IBookServiceImpl implements IBookService{

    private SqlSession session;
    private BookMapper bookmapper;
    private BookStyleMapper bookstylemapper;
    private void init1() {
        session=SqlSessionUtil.getSqlSession();
        bookmapper=session.getMapper(BookMapper.class);
    }
    private void init2() {
        session=SqlSessionUtil.getSqlSession();
        bookstylemapper=session.getMapper(BookStyleMapper.class);
    }
    private void release() {
        session.close();
    }
    @Override
    public PageBean<Book> queryByCondition(Integer pageNow, Integer pageSize, String bookName, Long styleId) {
        init1();
        PageBean<Book> pageBean=new PageBean<>();
        pageBean.setPageNow(pageNow);
        pageBean.setPageSize(pageSize);
        List<Book> list = bookmapper.findByCondition(pageNow, pageSize, bookName, styleId);
        int rows = bookmapper.getRows(bookName, styleId);
        release();
        pageBean.setDatas(list);
        pageBean.setRows(rows);
        int count=0;
        count=rows/pageSize;
        if(rows%pageSize!=0)
        {
            count++;
        }
        pageBean.setPageCounts(count);
        return pageBean;
    }

    @Override
    public Book queryById(Long id) {
        init1();
        Book book = bookmapper.findById(id);
        release();
        return book;
    }

    @Override
    public List<BookStyle> getAllBookStyles() {
        init2();
        List<BookStyle> list = bookstylemapper.findAll();
        release();
        return list;
    }
    @Override
    public BookStyle queryStyleById(Long id) {
        init2();
        BookStyle bookStyle = bookstylemapper.findById(id);
        release();
        return bookStyle;
    }

}

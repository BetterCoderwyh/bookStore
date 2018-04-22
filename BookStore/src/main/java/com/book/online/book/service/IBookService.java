package com.book.online.book.service;

import java.util.List;

import com.book.online.entity.Book;
import com.book.online.entity.BookStyle;
import com.book.online.vo.PageBean;

public interface IBookService {
    /**
     * 根据条件查询并进行分页
     * @param pageNow
     * @param pageSize
     * @param bookName
     * @param styleId
     * @return
     */
    public PageBean<Book> queryByCondition(Integer pageNow,Integer pageSize,String bookName,Long styleId);
    /**
     * 根据图书ID查询图书
     * @param id
     * @return
     */
    public Book queryById(Long id);
    /**
     * 获取所有图书种类
     * @return
     */
    public List<BookStyle> getAllBookStyles();
    /**
     * 根据图书类型id获取图书类型对象
     * @param id
     * @return
     */
    public BookStyle queryStyleById(Long id);
}

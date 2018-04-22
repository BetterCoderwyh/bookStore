package com.book.online.book.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.book.online.entity.Book;

public interface BookMapper {
    /**
     * 根据图书的ID查询图书
     * @param id
     * @return
     */
    public Book findById(Long id);
    
    /**
     * 根据商品信息分页查询
     * @param pageNow
     * @param pageSize
     * @param bookName
     * @param styleId
     * @return
     */
    public List<Book> findByCondition(@Param("pageNow")Integer pageNow,@Param("pageSize")Integer pageSize,@Param("bookName")String bookName,@Param("styleId")Long styleId);
    
    /**
     * 获取条件查询出的商品总条数
     * @param bookName
     * @param styleId
     * @return
     */
    public int getRows(@Param("bookName")String bookName,@Param("styleId")Long styleId);
}

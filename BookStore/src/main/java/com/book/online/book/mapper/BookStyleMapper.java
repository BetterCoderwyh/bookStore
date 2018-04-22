package com.book.online.book.mapper;

import java.util.List;

import com.book.online.entity.BookStyle;

public interface BookStyleMapper {
    /**
     * 根据图书类型的ID查询图书种类
     * @param id
     * @return
     */
    public BookStyle findById(Long id);
    
    public List<BookStyle> findAll();
    
  
}

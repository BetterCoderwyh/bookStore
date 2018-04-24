package com.book.online.book.action;

import com.book.online.book.service.impl.IBookServiceImpl;
import com.book.online.entity.Book;
import com.book.online.entity.BookStyle;
import com.book.online.vo.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by wyh on 2018/4/24.
 */
@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private IBookServiceImpl ibook;
    @RequestMapping("/jingxuanlist")
    public String jingxuanList(Model model, Integer pageNow, Integer pageSize){
        if(pageNow==null)
        {
            pageNow=1;
        }
        if(pageSize==null)
        {
            pageSize=4;
        }
        BookStyle bookStyle = ibook.queryStyleById(1L);
        PageBean<Book> pageBean = ibook.queryByCondition(pageNow, pageSize, null, 1L);
        model.addAttribute("pageBean",pageBean);
        model.addAttribute("bookStyle",bookStyle);
        return "book/pageBean1";
    }
    @RequestMapping("/tuijianlist")
    public String tuijianList(Model model, Integer pageNow, Integer pageSize){
        if(pageNow==null)
        {
            pageNow=1;
        }
        if(pageSize==null)
        {
            pageSize=4;
        }
        BookStyle bookStyle = ibook.queryStyleById(2L);
        PageBean<Book> pageBean = ibook.queryByCondition(pageNow, pageSize, null, 2L);
        model.addAttribute("pageBean",pageBean);
        model.addAttribute("bookStyle",bookStyle);
        return "book/pageBean2";
    }
    @RequestMapping("/tejialist")
    public String tejiaList(Model model, Integer pageNow, Integer pageSize){
        if(pageNow==null)
        {
            pageNow=1;
        }
        if(pageSize==null)
        {
            pageSize=4;
        }
        BookStyle bookStyle = ibook.queryStyleById(3L);
        PageBean<Book> pageBean = ibook.queryByCondition(pageNow, pageSize, null, 3L);
        model.addAttribute("pageBean",pageBean);
        model.addAttribute("bookStyle",bookStyle);
        return "book/pageBean3";
    }
    @RequestMapping("/navlist")
    public String navList(Model model){
        List<BookStyle> bookStyles = ibook.getAllBookStyles();
        model.addAttribute("bookStyles",bookStyles);
        return "common/nav";
    }
    @RequestMapping("/detail")
    public String detail(Model model,Long bookId){
        Book book = ibook.queryById(bookId);
        model.addAttribute("book",book);
        return "book/bookDetail";
    }
    @RequestMapping("/booklist")
    public String bookList(Model model,Integer pageNow,Integer pageSize,String bookName,Long styleId){
        if(pageNow==null)
        {
            pageNow=1;
        }
        if(pageSize==null)
        {
            pageSize=2;
        }
        PageBean<Book> pageBean = ibook.queryByCondition(pageNow,pageSize, bookName, styleId);
        if(styleId!=null){
        BookStyle style = ibook.queryStyleById(styleId);
        model.addAttribute("style",style);}
        model.addAttribute("pageBean",pageBean);
        model.addAttribute("bookName",bookName);
        return "book/booklist";
    }

}

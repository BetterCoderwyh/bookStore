package com.book.online.book.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.online.book.service.impl.IBookServiceImpl;
import com.book.online.entity.Book;
import com.book.online.entity.BookStyle;
import com.book.online.util.BeansFactory;
import com.book.online.vo.PageBean;

/**
 * Servlet implementation class BookListAction
 */
@WebServlet(urlPatterns="/book/list")
public class BookListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IBookServiceImpl ibook=(IBookServiceImpl) BeansFactory.newInstance("BookService");
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	    String pageNow= request.getParameter("pageNow");
	    String pageSize= request.getParameter("pageSize");
	    String bookName = request.getParameter("bookName");
	    String styleId = request.getParameter("styleId");
	    Long sid=null;
	    if(pageNow==null||pageNow.trim().length()==0)
	    {
	        pageNow="1";
	    }
	    if(pageSize==null||pageSize.trim().length()==0)
        {
	        pageSize="2";
        }
	    if(styleId!=null&&styleId.trim().length()>0)
	    {
	        sid=Long.parseLong(styleId);
	        BookStyle style = ibook.queryStyleById(sid);
	        request.setAttribute("style", style);
	    }
	    
	    PageBean<Book> pageBean = ibook.queryByCondition(Integer.parseInt(pageNow),Integer.parseInt(pageSize), bookName, sid);
	    request.setAttribute("pageBean", pageBean);
        request.setAttribute("bookName", bookName);
        request.getRequestDispatcher("/jsp/book/booklist.jsp").forward(request, response);
	}
}

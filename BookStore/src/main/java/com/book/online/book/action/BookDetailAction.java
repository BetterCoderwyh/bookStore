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
@WebServlet(urlPatterns="/book/detail")
public class BookDetailAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IBookServiceImpl ibook=(IBookServiceImpl) BeansFactory.newInstance("BookService");
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	    String bookId= request.getParameter("bookId");
	    if(bookId!=null&bookId.trim().length()>0)
	    {
	        Book book = ibook.queryById(Long.parseLong(bookId));
	        request.setAttribute("book", book);
	    }
        request.getRequestDispatcher("/jsp/book/bookDetail.jsp").forward(request, response);
	}
}

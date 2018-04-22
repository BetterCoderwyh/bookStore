package com.book.online.book.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.online.book.service.impl.IBookServiceImpl;
import com.book.online.entity.BookStyle;
import com.book.online.util.BeansFactory;

/**
 * Servlet implementation class BookListAction
 */
@WebServlet(urlPatterns="/book/nav")
public class BookNavAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IBookServiceImpl ibook=(IBookServiceImpl) BeansFactory.newInstance("BookService");
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	    List<BookStyle> bookStyles = ibook.getAllBookStyles();
        request.setAttribute("bookStyles", bookStyles);
        request.getRequestDispatcher("/jsp/common/nav.jsp").forward(request, response);
	}
}

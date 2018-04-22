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
@WebServlet(urlPatterns="/jingxuan/list")
public class JingxuanListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IBookServiceImpl ibook=(IBookServiceImpl) BeansFactory.newInstance("BookService");
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String pageNow = request.getParameter("pageNow");
	    Integer page;
	    if(pageNow==null||pageNow.trim().length()==0)
	    {
	        pageNow="1";
	    }
	    page=Integer.parseInt(pageNow);
	    if(page<1)
	        page=1;
	    BookStyle bookStyle = ibook.queryStyleById(1l);
        PageBean<Book> pageBean=ibook.queryByCondition(page, 4, null,1l);
        if(page>pageBean.getPageCounts())
        {
            page=pageBean.getPageCounts();
            pageBean=ibook.queryByCondition(page, 4, null,1l);
        }
        request.setAttribute("pageBean", pageBean);
        request.setAttribute("bookStyle", bookStyle);
        request.getRequestDispatcher("/jsp/book/pageBean1.jsp").forward(request, response);
	}

}

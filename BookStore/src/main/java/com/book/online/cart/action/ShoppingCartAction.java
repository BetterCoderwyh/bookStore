package com.book.online.cart.action;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.online.book.service.impl.IBookServiceImpl;
import com.book.online.cart.ShoppingCart;
import com.book.online.entity.Book;
import com.book.online.entity.OrderItem;
import com.book.online.util.BeansFactory;

/**
 * Servlet implementation class BookListAction
 */
@WebServlet(urlPatterns="/cart/*")
public class ShoppingCartAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IBookServiceImpl ibook=(IBookServiceImpl) BeansFactory.newInstance("BookService");
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   
	    response.setContentType("application/json;charset=utf-8");
	    PrintWriter out = response.getWriter();
	    String info = request.getPathInfo();
	    String bookId=request.getParameter("bookId");
	    String count=request.getParameter("shopcount");
	    String bisbn=request.getParameter("bisbn");
	    String bname=request.getParameter("bname");
	    ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("cart");
	    OrderItem  oi=new OrderItem();
	    switch (info) {
        case "/add":
            Book book = ibook.queryById(Long.parseLong(bookId));
            if(book!=null)
            {
                oi.setBook_isbn(book.getIsbn());
                oi.setBook_name(book.getBookName());
                oi.setBook_imgurl(book.getImageUrl());
                oi.setBook_author(book.getAuthor());
                oi.setBook_price(book.getNewPrice());
                oi.setCount(Integer.parseInt(count));
                oi.setAllPrice(Integer.parseInt(count)*book.getNewPrice());
            }
                if(cart==null)
                {
                        cart=new ShoppingCart();
                        cart.addTocart(oi);
                        request.getSession().setAttribute("cart", cart);
                       response.sendRedirect(request.getContextPath()+"/jsp/cart/mycart.jsp");
                }
                else
                {
                    cart.addTocart(oi);
                    request.getSession().setAttribute("cart", cart);
                    response.sendRedirect(request.getContextPath()+"/jsp/cart/mycart.jsp");
                }
            System.out.println(cart);
            break;
        case "/addnum":
            if(bisbn!=null&&bname!=null)
            {
                oi.setBook_isbn(bisbn);
                oi.setBook_name(bname);
                oi.setCount(Integer.parseInt(count));
                cart.addNum(oi);
                request.getSession().setAttribute("cart", cart);
                out.print(cart.getTotalcount()+":"+cart.getTotalprice());
            }
            System.out.println(cart);
            break;
        case "/del":
            if(bisbn!=null&&bname!=null)
            {
                oi.setBook_isbn(bisbn);
                oi.setBook_name(bname);
                cart.delFromCart(oi);
                request.getSession().setAttribute("cart", cart);
                out.print(cart.getTotalcount()+":"+cart.getTotalprice());
            }
            
            break;

        default:
            break;
        }
	}

}

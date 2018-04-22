package com.book.online.order.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.online.book.service.impl.IBookServiceImpl;
import com.book.online.cart.ShoppingCart;
import com.book.online.entity.Address;
import com.book.online.entity.Order;
import com.book.online.entity.OrderItem;
import com.book.online.entity.OrderStatus;
import com.book.online.entity.User;
import com.book.online.order.service.impl.IOrderServiceImpl;
import com.book.online.user.service.impl.IUserServiceImpl;
import com.book.online.util.BeansFactory;
import com.book.online.vo.PageBean;

/**
 * Servlet implementation class BookListAction
 */
@WebServlet(urlPatterns="/myorder/handler/*")
public class OrderHandlerAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IBookServiceImpl ibook=(IBookServiceImpl) BeansFactory.newInstance("BookService");
	 private IUserServiceImpl iuser=(IUserServiceImpl) BeansFactory.newInstance("UserService");
	 private IOrderServiceImpl iorder=(IOrderServiceImpl) BeansFactory.newInstance("OrderService");
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String info=request.getPathInfo();
	    response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        User user=(User) request.getSession().getAttribute("user");
	    switch (info) {
        case "/delete":
            String orderIds=request.getParameter("orderIds");
            String count=request.getParameter("count");
            if(orderIds!=null&&orderIds.length()>0)
            {
                String[] split = orderIds.split(":");
                if(split!=null&&split.length>0)
                {
                    for (String string : split) {
                        Order o=new Order();
                        o.setOrderId(Long.parseLong(string));
                        iorder.deleteItem(o);
                        iorder.delete(o);
                    }
                    out.print(count.substring(0, count.length()-1));
                }
            }
            
            break;
        case "/clear":
            List<Order> orders = iorder.queryOrdersByUser(user);
            if(orders!=null&&orders.size()>0)
            {
                 for (Order order : orders) {
                     iorder.deleteItem(order);
                     iorder.delete(order);
                }
                 out.print("1");
            }
            
            break;    
         
            

        default:
            break;
        }

	}
}

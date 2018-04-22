package com.book.online.order.action;

import java.io.IOException;
import java.util.HashSet;
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
import com.book.online.entity.OrderItem;
import com.book.online.entity.User;
import com.book.online.user.service.impl.IUserServiceImpl;
import com.book.online.util.BeansFactory;

/**
 * Servlet implementation class BookListAction
 */
@WebServlet(urlPatterns="/order/list")
public class OrderItemAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IBookServiceImpl ibook=(IBookServiceImpl) BeansFactory.newInstance("BookService");
	 private IUserServiceImpl iuser=(IUserServiceImpl) BeansFactory.newInstance("UserService");
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("cart");
	ShoppingCart order=new ShoppingCart();
    User user = (User) request.getSession().getAttribute("user");
    if(user!=null) {
    List<Address> adds = iuser.getAddressByUser(user);
    if(adds!=null)
    {
        request.setAttribute("adds", adds);
    }
    }
	if(cart.getCart()!=null)
	{
	    order.setTotalprice(cart.getTotalprice());
	    order.setTotalcount(cart.getTotalcount());
	    Set<OrderItem> items = new HashSet<>();
	    for(OrderItem i:cart.getCart()) {
	        items.add(i);
	    }
	    order.setCart(items);
	}
	String orderIds = request.getParameter("orderIds");
	  if(orderIds==null||orderIds.trim().length()==0) {
	      request.getSession().setAttribute("order", order);
	      request.getRequestDispatcher("/jsp/order/confirmOrder.jsp").forward(request, response);;
	  }else
	  {
	      String[] split = orderIds.split(":");
	      if(split!=null&&split.length>0)
	      {
	          for(int i=0;i<split.length;i++)
	          {
	              OrderItem o=new OrderItem();
	              o.setItemId(Long.parseLong(split[i]));
	              order.delFromCart(o);
	          }
	      }
	      request.getSession().setAttribute("order", order);
          request.getRequestDispatcher("/jsp/order/confirmOrder.jsp").forward(request, response);;
	  }
}
}

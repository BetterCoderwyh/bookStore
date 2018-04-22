package com.book.online.order.action;

import java.io.IOException;
import java.util.Date;
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
@WebServlet(urlPatterns="/myorder/*")
public class OrderSubmitAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IBookServiceImpl ibook=(IBookServiceImpl) BeansFactory.newInstance("BookService");
	 private IUserServiceImpl iuser=(IUserServiceImpl) BeansFactory.newInstance("UserService");
	 private IOrderServiceImpl iorder=(IOrderServiceImpl) BeansFactory.newInstance("OrderService");
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	ShoppingCart order = (ShoppingCart) request.getSession().getAttribute("order");
	ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("cart");
	User user = (User) request.getSession().getAttribute("user");
	String addrId=request.getParameter("addrId");
    String pageSize= request.getParameter("pageSize");  
    String pageNow= request.getParameter("pageNow");
     if(pageSize==null||"-1".equals(pageSize))
     {
         pageSize="2";
     }
     if(pageNow==null){
         pageNow = "1";
     }
	
	Address address=null;
	String info=request.getPathInfo();
	if("/submit".equals(info)) {
	if(addrId!=null&&addrId.trim().length()>0)
	{
	     address = iuser.getAddrById(Long.parseLong(addrId));
	}
    	Order o=new Order();
    	o.setAddress(address);
    	o.setCreateDate(new Date());
    	Long orderNum=new Date().getTime();
    	o.setOrderNum(orderNum.toString());
    	o.setItems(order.getCart());
    	o.setOrderStatus(OrderStatus.交易成功);
    	o.setUser(user);
    	iorder.save(o);
    	Set<OrderItem> items = o.getItems();
    	for (OrderItem orderItem : items) {
            orderItem.setOrder(o);
            iorder.saveOrderItem(orderItem);
        }
    	Set<OrderItem> odercart = order.getCart();
    	for (OrderItem orderItem : odercart) {
            cart.delFromCart(orderItem);
        }
    	request.getSession().setAttribute("cart", cart);
	    }
    	PageBean<Order> pageOrder = iorder.queryByPage(user, Integer.parseInt(pageNow), Integer.parseInt(pageSize));
    	request.getSession().setAttribute("pageOrder", pageOrder);
    	response.sendRedirect(request.getContextPath()+"/jsp/order/myorder.jsp");
	}
}

package com.book.online.order.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.online.entity.Address;
import com.book.online.entity.User;
import com.book.online.user.service.impl.IUserServiceImpl;
import com.book.online.util.BeansFactory;

/**
 * Servlet implementation class BookListAction
 */
@WebServlet(urlPatterns="/address/add")
public class AddressAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IUserServiceImpl iuser=(IUserServiceImpl) BeansFactory.newInstance("UserService");
  
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setContentType("application/json;charset=utf-8");
	    PrintWriter out = response.getWriter();
	    User user=(User) request.getSession().getAttribute("user");
	    String province = request.getParameter("p");
	    String city = request.getParameter("c");
	    String district = request.getParameter("d");
	    String details = request.getParameter("details");
	    String emailcode = request.getParameter("emailcode");
	    String phone = request.getParameter("phone");
	    String reciver = request.getParameter("reciver");
	    String isDefault = request.getParameter("isDefault");
	    String area=province+city+district;
	    Address a=new Address(area, details, emailcode, reciver, phone, isDefault, user);
	    if("是".equals(isDefault)) {
	    iuser.updateDefaultAddress(a);
	    out.print("0:"+a.getAddressId());
	    }else {
	        iuser.addAddress(a);
	        List<Address> add = iuser.getAddressByUser(user);
	        if(add.size()==1)
	            out.print("0:"+a.getAddressId());
	        out.print("1:"+a.getAddressId());
	    }

	    
	}
}

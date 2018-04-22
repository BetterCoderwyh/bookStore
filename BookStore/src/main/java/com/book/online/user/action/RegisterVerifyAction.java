package com.book.online.user.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.online.entity.User;
import com.book.online.user.service.impl.IUserServiceImpl;
import com.book.online.util.BeansFactory;

/**
 * Servlet implementation class RegisterCIAction
 */
@WebServlet(urlPatterns="/register/verify")
public class RegisterVerifyAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IUserServiceImpl iuser=(IUserServiceImpl) BeansFactory.newInstance("UserService");
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
	response.setContentType("application/json;charset=utf-8");
	PrintWriter out = response.getWriter();
	String username=request.getParameter("username");
	if(username!=null&&username.trim().length()>0)
	{
	    boolean b = iuser.validate(username);
	    if(b)
	        out.print("0");
	    else
	        out.print("1");
	}

}
}
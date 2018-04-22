package com.book.online.user.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.online.entity.User;
import com.book.online.user.service.impl.IUserServiceImpl;
import com.book.online.util.BeansFactory;

/**
 * Servlet implementation class LoginCIAction
 */
@WebServlet(urlPatterns="/user/login")
public class LoginCIAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IUserServiceImpl iuser=(IUserServiceImpl) BeansFactory.newInstance("UserService");
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    resp.setContentType("application/json;charset=utf-8");
	    PrintWriter out = resp.getWriter();
	    String username = req.getParameter("lousername");
	    String password =req.getParameter("lopassword");
	    String rem = req.getParameter("rem");
	    if(username!=null&&username.trim().length()>0)
	    {
	        User user = iuser.login(username);
	        if(user!=null) {
	            if(user.getPassWord().equals(password))
	            {
	                req.getSession().setAttribute("user", user);
	                if("true".equals(rem)) {
	                Cookie c=new Cookie("userinfo", username+"-"+password);
	                c.setPath("/");
	                c.setMaxAge(60000);
	                resp.addCookie(c);
	                }
	                out.print("2");
	            }
	            else {
//	                Cookie c=new Cookie("userinfo", "-");
//                    c.setPath("/");
//                    c.setMaxAge(1);
//                    resp.addCookie(c);
	                out.print("1");
	            }
	        }else {
	            out.print("0");
	        }
	    }
	
	}

}

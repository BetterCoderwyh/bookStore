package com.book.online.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.online.entity.User;


@WebFilter(urlPatterns="/stu/*")
public class CheckLoginFilter implements Filter{


	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest) arg0;
		HttpServletResponse resp=(HttpServletResponse) arg1;
		 User user = (User) req.getSession().getAttribute("user");
		 if(null!=user)
		 {
			 chain.doFilter(req, resp);
		 }
		 else
		 {
			 resp.sendRedirect(req.getContextPath()+"/user/LoginView");
		 }
	}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}


}

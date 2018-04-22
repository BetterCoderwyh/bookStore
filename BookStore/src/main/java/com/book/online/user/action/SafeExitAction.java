package com.book.online.user.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.online.user.service.impl.IUserServiceImpl;
import com.book.online.util.BeansFactory;
@WebServlet(urlPatterns="/user/SafeExit")
public class SafeExitAction extends HttpServlet{

	private static final long serialVersionUID = -1827688398615703117L;
	IUserServiceImpl iuser=(IUserServiceImpl) BeansFactory.newInstance("UserService");
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
						req.getSession().invalidate();
						resp.sendRedirect(req.getContextPath()+"/jsp/book/index.jsp");
	}

}

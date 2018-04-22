package com.book.online.user.action;

import java.io.IOException;

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
@WebServlet(urlPatterns="/user/register")
public class RegisterCIAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IUserServiceImpl iuser=(IUserServiceImpl) BeansFactory.newInstance("UserService");
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String username=request.getParameter("reusername");
	    String password=request.getParameter("repassword");
	    String pwd=request.getParameter("repwd");
	    String email=request.getParameter("reemail");
	    String phone=request.getParameter("rephone");
	    String company=request.getParameter("recompany");
	    String address=request.getParameter("readdress");
	    String mobile = "^1[34578]//d{9}$";
	    String regex = "^([//w-//.]+)@((//[[0-9]{1,3}//.[0-9]{1,3}//.[0-9]{1,3}//.)|(([//w-]+//.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(//]?)$";
	    boolean flag= true;
	    System.out.println(username+":"+password+":"+email+":"+phone+":"+company+":"+address);
	    if(username!=null&&username.trim().length()>0)
	    {
//	        boolean b = iuser.validate(username);
	        if(true)
	        {
	            if(password!=null&&pwd!=null&&password.equals(pwd))
	            {
	                if(email!=null&&phone!=null&&company!=null&&address!=null)
	                {
	                    User user=new User(username, password, email, phone, company, address);
	                    iuser.register(user);
	                    flag=false;
	                    response.sendRedirect(request.getContextPath()+"/jsp/user/success.jsp");
	            }
	        }
	    }
	    if(flag)
	        response.sendRedirect(request.getContextPath()+"/jsp/user/fail.jsp");
	    
	}

}
}
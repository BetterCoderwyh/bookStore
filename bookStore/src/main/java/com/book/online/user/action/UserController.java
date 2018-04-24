package com.book.online.user.action;

import com.book.online.entity.User;
import com.book.online.user.service.impl.IUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wyh on 2018/4/24.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserServiceImpl iuser;
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String test(Model model, @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("user", user);
            model.addAttribute("errors", getErrorMap(bindingResult));
            return "user/register";
        }
        model.addAttribute("user", user);
        return "user/success";
    }
    /**
     * 将参数错误信息封装到 map
     */
    private Object getErrorMap(BindingResult bindingResult) {
        Map<String, String> errorMap = new HashMap<>();
        for (ObjectError objectError : bindingResult.getAllErrors()) {
            FieldError fieldError = (FieldError) objectError;
            String field = fieldError.getField();
            String error = fieldError.getDefaultMessage();
            errorMap.put(field, error);
        }
        return errorMap;
    }
    @RequestMapping(value = "/login",produces = "text/plain")
    @ResponseBody
    public String login(String lousername, String lopassword, String rem, HttpSession session, HttpServletResponse resp){
        if(lousername!=null&&lousername.trim().length()>0)
        {
            User user = iuser.login(lousername);
            if(user!=null) {
                if(user.getPassWord().equals(lopassword))
                {
                    session.setAttribute("user", user);
                    if("true".equals(rem)) {
                        Cookie c=new Cookie("userinfo", lousername+"-"+lopassword);
                        c.setPath("/");
                        c.setMaxAge(60000);
                       resp.addCookie(c);
                    }
                    return "2";
                }
                else {
//	                Cookie c=new Cookie("userinfo", "-");
//                    c.setPath("/");
//                    c.setMaxAge(1);
//                    resp.addCookie(c);
                    return "1";
                }
            }else {
                return "0";
            }
        }
        return "2";
    }
    @RequestMapping("/exit")
    public String safeExit(HttpSession session){
        session.invalidate();
        return "redirect:/index";
    }
}

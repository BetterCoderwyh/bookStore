package com.book.online.order.action;

import com.book.online.cart.ShoppingCart;
import com.book.online.entity.Address;
import com.book.online.entity.OrderItem;
import com.book.online.entity.User;
import com.book.online.user.service.impl.IUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by wyh on 2018/4/24.
 */
@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private IUserServiceImpl iuser;
    @RequestMapping("list")
    public String orderList(Model model, HttpSession session,String orderIds){
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
        ShoppingCart order=new ShoppingCart();
        User user = (User) session.getAttribute("user");
        if(user!=null) {
            List<Address> adds = iuser.getAddressByUser(user);
            if(adds!=null)
            {
                model.addAttribute("adds", adds);
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
        if(orderIds==null||orderIds.trim().length()==0) {
           session.setAttribute("order", order);
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
            session.setAttribute("order", order);
        }
        return "order/confirmOrder";
    }
}

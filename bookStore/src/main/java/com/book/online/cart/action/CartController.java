package com.book.online.cart.action;

import com.book.online.book.service.impl.IBookServiceImpl;
import com.book.online.cart.ShoppingCart;
import com.book.online.entity.Book;
import com.book.online.entity.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by wyh on 2018/4/24.
 */
@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private IBookServiceImpl ibook;
    @RequestMapping("/add")
    public String addToCart(HttpSession session,Long bookId,Integer shopcount){
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
        OrderItem oi=new OrderItem();
        Book book = ibook.queryById(bookId);
        if(book!=null)
        {
            oi.setBook_isbn(book.getIsbn());
            oi.setBook_name(book.getBookName());
            oi.setBook_imgurl(book.getImageUrl());
            oi.setBook_author(book.getAuthor());
            oi.setBook_price(book.getNewPrice());
            oi.setCount(shopcount);
            oi.setAllPrice(shopcount*book.getNewPrice());
        }
        if(cart==null)
        {
            cart=new ShoppingCart();
            cart.addTocart(oi);
            session.setAttribute("cart", cart);
        }
        else
        {
            cart.addTocart(oi);
            session.setAttribute("cart", cart);
        }
        return "cart/mycart";
    }

}

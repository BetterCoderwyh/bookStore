package com.book.online.cart;

import java.util.HashSet;
import java.util.Set;

import com.book.online.entity.OrderItem;

public class ShoppingCart {
    private Set<OrderItem> cart;
    private int totalcount;
    private double totalprice;
    
    @Override
    public String toString() {
        return "ShoppingCart [cart=" + cart + ", totalcount=" + totalcount + ", totalprice=" + totalprice + "]";
    }

    public Set<OrderItem> getCart() {
        return cart;
    }

    public void setCart(Set<OrderItem> cart) {
        this.cart = cart;
    }

    public int getTotalcount() {
        return totalcount;
    }

    public void setTotalcount(int totalcount) {
        this.totalcount = totalcount;
    }

    public double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(double totalprice) {
        this.totalprice = totalprice;
    }

    public void addTocart(OrderItem oi)
    {
        boolean flag=true;
        if(cart!=null&&cart.size()>0&&oi!=null)
        {
            OrderItem orderitem=new OrderItem();
            for (OrderItem o : cart) {
                if(o.getBook_isbn().equals(oi.getBook_isbn()))
                {
                    orderitem=o;
                    totalcount+=oi.getCount();
                    totalprice+=oi.getAllPrice();
                    flag=false;
                    break;
                }
            }
            if(!flag)
            {
                cart.remove(orderitem);
                orderitem.setCount(orderitem.getCount()+oi.getCount());
                orderitem.setAllPrice(orderitem.getAllPrice()+oi.getAllPrice());
                cart.add(orderitem);
                
            }else
            {
                oi.setItemId();
                cart.add(oi);
                totalcount+=oi.getCount();
                totalprice+=oi.getAllPrice();
            }
        }else {
                cart=new HashSet<>();
                oi.setItemId();
                cart.add(oi);
                totalcount=oi.getCount();
                totalprice=oi.getAllPrice();
        }
       
        
    }
    
    public void addNum(OrderItem oi)
    {
       for (OrderItem o : cart) {
         if(oi.getBook_isbn().equals(o.getBook_isbn()))
         {
            oi.setBook_imgurl(o.getBook_imgurl());
            oi.setBook_author(o.getBook_author());
            oi.setBook_price(o.getBook_price());
            oi.setAllPrice(oi.getCount()*oi.getBook_price());
            oi.setItemId(o.getItemId());
            totalcount+=(oi.getCount()-o.getCount());
            totalprice+=(oi.getAllPrice()-o.getAllPrice());
            break;
         }
       }
         cart.remove(oi);
         cart.add(oi);
        
    }
    
    public void delFromCart(OrderItem oi)
    {
        boolean flag=true;

        if(cart!=null&&cart.size()>0&&oi!=null)
        {
            OrderItem orderitem=new OrderItem();
            
            for (OrderItem o : cart) {
                if(oi.getBook_isbn()!=null&&o.getBook_isbn().equals(oi.getBook_isbn()))
                {
                    orderitem=o;
                    flag=false;
                    break;
                }
                if(oi.getItemId()!=null&&o.getItemId().equals(oi.getItemId()))
                {
                    orderitem=o;
                    System.out.println("=========="+orderitem);
                    flag=false;
                    break;
                }
            }
            if(!flag)
            {
                totalcount-=orderitem.getCount();
                totalprice-=orderitem.getAllPrice();
                cart.remove(orderitem);
            }
        }
    }

    public static void main(String[] args) {
        ShoppingCart s=new ShoppingCart();
        ShoppingCart s1=new ShoppingCart();
        s.setTotalcount(1);
        s1.setTotalcount(1);
        System.out.println(s1==s);
    }
}

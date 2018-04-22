package com.book.online.entity;

import java.io.Serializable;

public class OrderItem implements Serializable{
    private static final long serialVersionUID = 3745476412723447784L;
    private Long itemId;
    private String book_isbn;
    private String book_imgurl;
    private String book_name;
    private String book_author;
    private double book_price;
    private int count;
    private double allPrice;
    private Order order;
    private static Long id=1L;
    public OrderItem() {
        super();
        
    }

    public OrderItem(String book_isbn, String book_imgurl, String book_name, String book_author, double book_price,
            int count, double allPrice, Order order) {
        super();
        this.book_isbn = book_isbn;
        this.book_imgurl = book_imgurl;
        this.book_name = book_name;
        this.book_author = book_author;
        this.book_price = book_price;
        this.count = count;
        this.allPrice = allPrice;
        this.order = order;
    }

    public double getBook_price() {
        return book_price;
    }
    public void setBook_price(double book_price) {
        this.book_price = book_price;
    }
    public String getBook_imgurl() {
        return book_imgurl;
    }
    public void setBook_imgurl(String book_imgurl) {
        this.book_imgurl = book_imgurl;
    }
    public Long getItemId() {
        return itemId;
    }
    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }
    public void setItemId() {
        this.itemId = id;
        id++;
    }
    public String getBook_isbn() {
        return book_isbn;
    }
    public void setBook_isbn(String book_isbn) {
        this.book_isbn = book_isbn;
    }
    public String getBook_name() {
        return book_name;
    }
    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }
    public String getBook_author() {
        return book_author;
    }
    public void setBook_author(String book_author) {
        this.book_author = book_author;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public double getAllPrice() {
        return allPrice;
    }
    public void setAllPrice(double allPrice) {
        this.allPrice = allPrice;
    }
    public Order getOrder() {
        return order;
    }
    public void setOrder(Order order) {
        this.order = order;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((book_isbn == null) ? 0 : book_isbn.hashCode());
        result = prime * result + ((book_name == null) ? 0 : book_name.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        OrderItem other = (OrderItem) obj;
        if (book_isbn == null) {
            if (other.book_isbn != null)
                return false;
        } else if (!book_isbn.equals(other.book_isbn))
            return false;
        if (book_name == null) {
            if (other.book_name != null)
                return false;
        } else if (!book_name.equals(other.book_name))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "OrderItem [itemId=" + itemId + ", book_isbn=" + book_isbn + ", book_imgurl=" + book_imgurl
                + ", book_name=" + book_name + ", book_author=" + book_author + ", book_price=" + book_price
                + ", count=" + count + ", allPrice=" + allPrice + ", order=" + order + "]";
    }
 
}

package com.book.online.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public class Order implements Serializable{
    private static final long serialVersionUID = 9109641745561250510L;
    private Long orderId;
    private String orderNum;
    private Date createDate;
    private Set<OrderItem> items;
    private User user;
    private Address address;
    private OrderStatus orderStatus;
    public Order() {
        super();
    }
    public Order(String orderNum, Date createDate, Set<OrderItem> items, User user, Address address,
            OrderStatus orderStatus) {
        super();
        this.orderNum = orderNum;
        this.createDate = createDate;
        this.items = items;
        this.user = user;
        this.address = address;
        this.orderStatus = orderStatus;
    }
    public Long getOrderId() {
        return orderId;
    }
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
    public String getOrderNum() {
        return orderNum;
    }
    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }
    public Date getCreateDate() {
        return createDate;
    }
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    public Set<OrderItem> getItems() {
        return items;
    }
    public void setItems(Set<OrderItem> items) {
        this.items = items;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
    public OrderStatus getOrderStatus() {
        return orderStatus;
    }
    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((createDate == null) ? 0 : createDate.hashCode());
        result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
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
        Order other = (Order) obj;
        if (createDate == null) {
            if (other.createDate != null)
                return false;
        } else if (!createDate.equals(other.createDate))
            return false;
        if (orderId == null) {
            if (other.orderId != null)
                return false;
        } else if (!orderId.equals(other.orderId))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "Order [orderId=" + orderId + ", orderNum=" + orderNum + ", createDate=" + createDate + "]";
    }
  
    
}

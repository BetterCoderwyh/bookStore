package com.book.online.entity;

import java.io.Serializable;

public class User implements Serializable{
    private static final long serialVersionUID = 663702922973600239L;
    private Long userId;
    private String userName;
    private String passWord;
    private String email;
    private String phone;
    private String company;
    private String address;
    public User() {
        super();
    }
    public User(String userName, String passWord, String email, String phone, String company, String address) {
        super();
        this.userName = userName;
        this.passWord = passWord;
        this.email = email;
        this.phone = phone;
        this.company = company;
        this.address = address;
    }
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassWord() {
        return passWord;
    }
    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getCompany() {
        return company;
    }
    public void setCompany(String company) {
        this.company = company;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((userId == null) ? 0 : userId.hashCode());
        result = prime * result + ((userName == null) ? 0 : userName.hashCode());
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
        User other = (User) obj;
        if (userId == null) {
            if (other.userId != null)
                return false;
        } else if (!userId.equals(other.userId))
            return false;
        if (userName == null) {
            if (other.userName != null)
                return false;
        } else if (!userName.equals(other.userName))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "User [userId=" + userId + ", userName=" + userName + ", passWord=" + passWord + ", email=" + email
                + ", phone=" + phone + ", company=" + company + ", address=" + address + "]";
    }
    
}

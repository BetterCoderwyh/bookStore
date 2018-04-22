package com.book.online.entity;

import java.io.Serializable;

public class Address implements Serializable{

    private static final long serialVersionUID = -924017947571097413L;
    private Long AddressId;
    private String area;
    private String detailAddress;
    private String emailCode;
    private String reciver;
    private String tel;
    private String isDefault;
    private User user;
    public Address() {
        super();
    }
    public Address(String area, String detailAddress, String emailCode, String reciver, String tel, String isDefault,
            User user) {
        super();
        this.area = area;
        this.detailAddress = detailAddress;
        this.emailCode = emailCode;
        this.reciver = reciver;
        this.tel = tel;
        this.isDefault = isDefault;
        this.user = user;
    }
    @Override
    public String toString() {
        return "Address [AddressId=" + AddressId + ", area=" + area + ", detailAddress=" + detailAddress
                + ", emailCode=" + emailCode + ", reciver=" + reciver + ", tel=" + tel + ", isDefault=" + isDefault
                + "]";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((AddressId == null) ? 0 : AddressId.hashCode());
        result = prime * result + ((area == null) ? 0 : area.hashCode());
        result = prime * result + ((detailAddress == null) ? 0 : detailAddress.hashCode());
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
        Address other = (Address) obj;
        if (AddressId == null) {
            if (other.AddressId != null)
                return false;
        } else if (!AddressId.equals(other.AddressId))
            return false;
        if (area == null) {
            if (other.area != null)
                return false;
        } else if (!area.equals(other.area))
            return false;
        if (detailAddress == null) {
            if (other.detailAddress != null)
                return false;
        } else if (!detailAddress.equals(other.detailAddress))
            return false;
        return true;
    }
    public Long getAddressId() {
        return AddressId;
    }
    public void setAddressId(Long addressId) {
        AddressId = addressId;
    }
    public String getArea() {
        return area;
    }
    public void setArea(String area) {
        this.area = area;
    }
    public String getDetailAddress() {
        return detailAddress;
    }
    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }
    public String getEmailCode() {
        return emailCode;
    }
    public void setEmailCode(String emailCode) {
        this.emailCode = emailCode;
    }
    public String getReciver() {
        return reciver;
    }
    public void setReciver(String reciver) {
        this.reciver = reciver;
    }
    public String getTel() {
        return tel;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }
    public String getIsDefault() {
        return isDefault;
    }
    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public static long getSerialversionuid() {
        return serialVersionUID;
    }
}

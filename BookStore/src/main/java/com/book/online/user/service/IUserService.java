package com.book.online.user.service;

import java.util.List;

import com.book.online.entity.Address;
import com.book.online.entity.User;

public interface IUserService {
    /**
     * 验证用户是否合法
     * @param name
     * @param pwd
     * @return
     */
   public User login(String name);
   /**
    * 完成用户的注册功能
    * @param user
    */
   public void register(User user);
   /**
    * 验证某个用户名是否可用,可用返回true
    * @param name
    * @return
    */
   public boolean validate(String name);
   /**
    * 添加地址
    * @param a
    */
   public void addAddress(Address a);
   /**
    * 删除地址
    * @param a
    */
   public void delAddressById(Long id);
   /**
    * 更新指定的地址信息
    * @param a
    */
   public void updAddress(Address a);
   /**
    * 根据用户查询此用户所有地址
    * @param user
    * @return
    */
   public List<Address> getAddressByUser(User user);
   /**
    * 按主键查询地址
    * @param id
    * @return
    */
   public Address getAddrById(Long id);
   
   /**
    * 更新用户的默认地址
    * @param a
    */
   public void updateDefaultAddress(Address a);
}

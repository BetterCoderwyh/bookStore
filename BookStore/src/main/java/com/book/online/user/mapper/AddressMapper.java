package com.book.online.user.mapper;

import java.util.List;

import com.book.online.entity.Address;

public interface AddressMapper {
   /**
    * 保存新地址
    * @param a
    */
   public void save(Address a);
   /**
    * 查询指定用户ID的所有地址
    * @param userId
    * @return
    */
   public List<Address> findByUserId(Long userId);
   /**
    * 根据ID删除某个地址
    * @param id
    */
   public void deleteById(Long id);
   /**
    * 根据ID查询地址
    * @param id
    * @return
    */
   public Address findById(Long id);
   /**
    * 更新地址
    * @param a
    */
   public void update(Address a);
   /**
    * 根据用户属性查找对象
    */
   public Address findByAddConditon(String isDefault);
   
}

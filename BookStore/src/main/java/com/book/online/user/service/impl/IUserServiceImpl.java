package com.book.online.user.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.book.online.entity.Address;
import com.book.online.entity.User;
import com.book.online.user.mapper.AddressMapper;
import com.book.online.user.mapper.UserMapper;
import com.book.online.user.service.IUserService;
import com.book.online.util.SqlSessionUtil;

public class IUserServiceImpl implements IUserService{
    private SqlSession session;
    private UserMapper usermapper;
    private AddressMapper addressmapper;
    private void init1() {
        session=SqlSessionUtil.getSqlSession();
        usermapper=session.getMapper(UserMapper.class);
    }
    private void init2() {
        session=SqlSessionUtil.getSqlSession();
        addressmapper=session.getMapper(AddressMapper.class);
    }
    private void release() {
        session.close();
    }
    @Override
    public User login(String name) {
        init1();
        User user = usermapper.selectByName(name);
        release();
        return user;
    }

    @Override
    public void register(User user) {
        session=SqlSessionUtil.getSqlSession();
        usermapper=session.getMapper(UserMapper.class);
        usermapper.save(user);
        session.commit();
        release();
    }

    @Override
    public boolean validate(String name) {
        init1();
        User user = usermapper.selectByName(name);
        if(user==null)
            return true;
        release();
        return false;
    }

    @Override
    public void addAddress(Address a) {
        init2();
        List<Address> list = addressmapper.findByUserId(a.getUser().getUserId());
        if(list==null||list.size()==0)
        {
            a.setIsDefault("是");
        }
        addressmapper.save(a);
        session.commit();
        release();
    }

    @Override
    public void delAddressById(Long id) {
        init2();
        addressmapper.deleteById(id);
        session.commit();
        release();
        
    }

    @Override
    public void updAddress(Address a) {
        init2();
        addressmapper.update(a);
        session.commit();
        release();
        
    }

    @Override
    public List<Address> getAddressByUser(User user) {
        init2();
        List<Address> list = addressmapper.findByUserId(user.getUserId());
        session.commit();
        release();
        return list;
    }

    @Override
    public Address getAddrById(Long id) {
        init2();
        Address address = addressmapper.findById(id);
        release();
        return address;
    }
    
    public void updateDefaultAddress(Address a)
    {
        init2();
        try {
            Address add = addressmapper.findByAddConditon("是");
            if(add!=null)
            add.setIsDefault("否");
            addressmapper.update(add);
            addressmapper.save(a);
            session.commit();
        } catch (Exception e) {
            session.rollback();
        }
   
        release();
    }

}

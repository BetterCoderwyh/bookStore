package com.book.online.user.mapper;

import com.book.online.entity.User;

public interface UserMapper {

    /**
     * 根据用户名查询对象
     * @param username
     * @return
     */
    public User selectByName(String username);
    
    /**
     * 保存用户对象
     * @param user
     */
    public void save(User user);
    /**
     * 更新用户
     * @param user
     */
    public void update(User user);
    
}

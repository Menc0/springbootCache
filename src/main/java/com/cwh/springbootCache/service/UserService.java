package com.cwh.springbootCache.service;

import java.util.List;

import com.cwh.springbootCache.entity.User;

public interface UserService {
    public List<User> getUserInfo(int id);
    
    public void insert(User user);
    
    public void update(User user);
    
    public void delete(int id);
}

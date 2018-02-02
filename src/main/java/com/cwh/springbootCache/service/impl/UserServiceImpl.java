package com.cwh.springbootCache.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cwh.springbootCache.entity.User;
import com.cwh.springbootCache.mapper.UserMapper;
import com.cwh.springbootCache.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
    private UserMapper userMapper;
	
	public void insert(User user) {
		userMapper.addUserInfo(user);
	}

	@Override
	public List<User> getUserInfo(int id) {
		return userMapper.findUserInfo(id);
	}

	@Override
	public void update(User user) {
		userMapper.updateUserInfo(user);
		
	}

	@Override
	public void delete(int id) {
		userMapper.delUserInfo(id);
	}
}

package com.cwh.springbootCache.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cwh.springbootCache.entity.User;
import com.cwh.springbootCache.service.UserService;
  
@RestController  
@RequestMapping("/user")  
public class UserController {  
	@Autowired
	private UserService userService;
	
	@RequestMapping("/getUserInfo/{id}")
    public List<User> getUserInfo(@PathVariable("id")String id) {
		List<User> user = userService.getUserInfo(Integer.valueOf(id));
        System.out.println(user.toString());
        return user;
    }
	
	@RequestMapping("/addUserInfo")
    public String addUserInfo() {
		User user = new User();
		user.setId(4L);
		user.setName("cwh");
		userService.insert(user);
        return "success:"+user.toString();
    }
	
	@RequestMapping("/updateUserInfo")
	public String updateUserInfo() {
		User user = new User();
		user.setId(4L);
		user.setName("menco1");
		userService.update(user);
		return "success:"+user.toString();
	}
	
	@RequestMapping("/deleteUserInfo")
	public String deleteUserInfo() {
		userService.delete(4);
		return "success";
	}
	
	
}  

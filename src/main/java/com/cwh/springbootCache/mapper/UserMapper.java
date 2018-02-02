package com.cwh.springbootCache.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import com.cwh.springbootCache.entity.User;

@CacheConfig(cacheNames = "user")//缓存名
@Mapper
public interface UserMapper {

	
	/**
	 * #p0代表第一个参数，也就是id,
	 * 先从redis的user缓存对象里去查询key等于传过来的id的值。如果没有，就去查表
	 * @param id
	 * @return
	 */
	@Cacheable(key = "#p0")  
	public List<User> findUserInfo(int id);
	
	/**
	 * 代表往缓存里添加值，key为参数user的id属性，
	 * 这样当我们add一个User对象时，redis就会新增一个以id为key的User对象
	 * @param user
	 * @return
	 */
	@CachePut(key = "#p0.id")  
	public int addUserInfo(User user);
	
	/**
	 * 代表往缓存里修改值，key为参数user的id属性，
	 * 这样当我们update一个User对象时，redis就会修改一个以id为key的User对象，
	 * 如果id为key的User对象没有，redis则新增一个以id为key的User对象
	 * @param user
	 * @return
	 */
	@CachePut(key = "#p0.id")  
	public int updateUserInfo(User user);
	
	/**
	 * 删除缓存
	 * @param id
	 * @return
	 */
	@CacheEvict(key = "#p0")  
	public int delUserInfo(int id);
}

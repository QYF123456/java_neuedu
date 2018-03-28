package com.cro.dao;


import com.cro.entity.PageModel;
import com.cro.entity.User;

public interface UserDao {
	
	/**
	 * 分页查询所有的用户
	 * */
	PageModel<User> findUser(Integer pageNo,Integer pageSize);
	

}

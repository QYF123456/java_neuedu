package com.cro.dao;

import com.cro.entity.User;

public interface LoginDao {
	//判断用户名是否存在
		public int checkUserName(String username);
		//根据用户名和密码获取用户信息
		public User findUserandpwd (String username,String password);
		/**
		 * 根据id更新用户的tooken
		 * */
		public int updateUsertookenById(Integer id,String tooken);
		/**
		 * 根据tooken查询用户
		 * 
		 * */
		public User finUserBytooken(String tooken);
}

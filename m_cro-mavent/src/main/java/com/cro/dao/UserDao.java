package com.cro.dao;


import com.cro.entity.PageModel;
import com.cro.entity.User;

public interface UserDao {
	
	/**
	 * ��ҳ��ѯ���е��û�
	 * */
	PageModel<User> findUser(Integer pageNo,Integer pageSize);
	

}

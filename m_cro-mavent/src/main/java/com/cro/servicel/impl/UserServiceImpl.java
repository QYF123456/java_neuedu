package com.cro.servicel.impl;

import com.cro.dao.UserDao;
import com.cro.dao.batisimpl.UserDaoBatisImpl;
import com.cro.entity.PageModel;
import com.cro.entity.User;
import com.cro.service.UserService;

public class UserServiceImpl implements UserService {
	
	UserDao userdao=new UserDaoBatisImpl();

	@Override
	public PageModel<User> findUser(Integer pageNo, Integer pageSize) {
		// TODO Auto-generated method stub
		return userdao.findUser(pageNo, pageSize);
	}

}

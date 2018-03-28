package com.cro.service;

import com.cro.entity.PageModel;
import com.cro.entity.User;

public interface UserService {
	
	public PageModel<User> findUser(Integer pageNo, Integer pageSize);
}

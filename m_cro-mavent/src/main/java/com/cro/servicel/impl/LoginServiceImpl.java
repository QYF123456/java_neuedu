package com.cro.servicel.impl;

import com.cro.dao.LoginDao;
import com.cro.dao.batisimpl.LoginDaoBatisImpl;
import com.cro.dao.impl.LoginDaoImpl;
import com.cro.entity.User;
import com.cro.service.ILoginService;

public class LoginServiceImpl implements ILoginService {
	LoginDao loginDao=new LoginDaoBatisImpl();
	
	@Override
	public User login(String username, String password) {
		// TODO Auto-generated method stub
		
		//检查用户名是否存在
		int count=loginDao.checkUserName(username);
		if(count>0) { //用户名存在，返回用户名和密码,使用dao层Logindaoimpl来获取用户名和密码，并返回
			return loginDao.findUserandpwd(username, password);
		}else {  //用户名不存在，返回null
			
			return null;
		}
		
	}

	@Override
	public int updateUsertookenById(Integer id, String tooken) {
		// TODO Auto-generated method stub
		return loginDao.updateUsertookenById(id, tooken);
	}

	@Override
	public User finUserBytooken(String tooken) {
		// TODO Auto-generated method stub
		return loginDao.finUserBytooken(tooken);
	}

}

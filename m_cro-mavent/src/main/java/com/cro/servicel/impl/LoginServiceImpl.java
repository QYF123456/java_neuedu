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
		
		//����û����Ƿ����
		int count=loginDao.checkUserName(username);
		if(count>0) { //�û������ڣ������û���������,ʹ��dao��Logindaoimpl����ȡ�û��������룬������
			return loginDao.findUserandpwd(username, password);
		}else {  //�û��������ڣ�����null
			
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

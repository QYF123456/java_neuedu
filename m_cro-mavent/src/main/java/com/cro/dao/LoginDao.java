package com.cro.dao;

import com.cro.entity.User;

public interface LoginDao {
	//�ж��û����Ƿ����
		public int checkUserName(String username);
		//�����û����������ȡ�û���Ϣ
		public User findUserandpwd (String username,String password);
		/**
		 * ����id�����û���tooken
		 * */
		public int updateUsertookenById(Integer id,String tooken);
		/**
		 * ����tooken��ѯ�û�
		 * 
		 * */
		public User finUserBytooken(String tooken);
}

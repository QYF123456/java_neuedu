package com.cro.dao.batisimpl;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.cro.common.MyBatis;
import com.cro.dao.LoginDao;
import com.cro.entity.User;

public class LoginDaoBatisImpl implements LoginDao {
	
	@Override
	public int checkUserName(String username) {
		// TODO Auto-generated method stub
		
		SqlSessionFactory factory=MyBatis.getSqlSessionFactory();
		SqlSession session=factory.openSession();
		int i=session.selectOne("com.cro.entity.User.checkUserName",username);
		
		return i;
	}

	@Override
	public User findUserandpwd(String username, String password) {
		// TODO Auto-generated method stub
		SqlSessionFactory factory=MyBatis.getSqlSessionFactory();
		SqlSession session=factory.openSession();
		Map<String,String> map=new HashMap<String,String>();
		map.put("username", username);
		map.put("password", password);
		User user=session.selectOne("com.cro.entity.User.findUserandpwd",map);
		return user;
	}

	@Override
	public int updateUsertookenById(Integer id, String tooken) {
		// TODO Auto-generated method stub
		SqlSessionFactory factory=MyBatis.getSqlSessionFactory();
		SqlSession session=factory.openSession();
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("id", id);
		map.put("tooken",tooken);
		int i=session.update("com.cro.entity.User.updateUsertookenById", map);
		MyBatis.close(session);
		return i;
		
	}

	@Override
	public User finUserBytooken(String tooken) {
		// TODO Auto-generated method stub
		SqlSessionFactory factory=MyBatis.getSqlSessionFactory();
		SqlSession session=factory.openSession();
		User user=session.selectOne("com.cro.entity.User.finUserBytooken",tooken);
		return user;
	}

}

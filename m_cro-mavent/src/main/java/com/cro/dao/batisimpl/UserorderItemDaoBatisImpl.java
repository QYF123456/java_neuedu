package com.cro.dao.batisimpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.cro.common.MyBatis;
import com.cro.dao.UserorderItemDao;
import com.cro.entity.Userorder_item;

public class UserorderItemDaoBatisImpl implements UserorderItemDao {

	@Override
	public int insertUserorderItem(List<Userorder_item> userorder_items) {
		// TODO Auto-generated method stub
		SqlSessionFactory factory=MyBatis.getSqlSessionFactory();
		SqlSession session=factory.openSession(true);
		int i=session.insert("com.cro.entity.Userorder_item.insertUserorderItem", userorder_items);
		session.close();
		return i;
	}

	@Override
	public List<Userorder_item> findUserorderItemsByOrderNo(Long order_No) {
		// TODO Auto-generated method stub
		SqlSessionFactory factory=MyBatis.getSqlSessionFactory();
		SqlSession session=factory.openSession(true);
		List<Userorder_item> userorder_items=session.selectList("com.cro.entity.Userorder_item.findUserorderItemsByOrderNo", order_No);
		return userorder_items;
	}

}

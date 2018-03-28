package com.cro.dao.batisimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.cro.common.MyBatis;
import com.cro.dao.UserDao;

import com.cro.entity.PageModel;
import com.cro.entity.User;

public class UserDaoBatisImpl implements UserDao {

	@Override
	public PageModel<User> findUser(Integer pageNo, Integer pageSize) {
		// TODO Auto-generated method stub
		SqlSessionFactory factory= MyBatis.getSqlSessionFactory();
		SqlSession session= factory.openSession();
		//1.查询总的记录数
		int totalcount=session.selectOne("com.cro.entity.User.findTotalCount");
		//2.查询某页面的数据
		Map<Object, Object> map=new HashMap<Object,Object>();
		map.put("offset", (pageNo-1)*pageSize);
		map.put("pageSize", pageSize);
		List<User> user=session.selectList("com.cro.entity.User.findUser", map);
		PageModel<User> pageModel=new PageModel<User>();
		pageModel.setData(user);
		pageModel.setTotalPage((totalcount%pageSize)==0?totalcount/pageSize:(totalcount/pageSize+1));
		return pageModel;
	}

}

package com.cro.dao.batisimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.cro.common.MyBatis;
import com.cro.dao.UserorderDao;
import com.cro.entity.PageModel;
import com.cro.entity.Product;
import com.cro.entity.Userorder;

public class UserorderDaoBatisImpl implements UserorderDao {

	@Override
	public int InsertUserorder(Userorder userorder) {
		// TODO Auto-generated method stub
		SqlSessionFactory factory=MyBatis.getSqlSessionFactory();
		SqlSession session=factory.openSession(true);
		int i=session.insert("com.cro.entity.Userorder.InsertUserorder", userorder);
		return i;
	}

	@Override
	public PageModel<Userorder> findPageUserorder(Integer user_id, Integer pageNo, Integer pageSize) {
		// TODO Auto-generated method stub
		SqlSessionFactory factory=MyBatis.getSqlSessionFactory();
		SqlSession session=factory.openSession(true);
		//查询信息总记录数
		int totalcount=session.selectOne("com.cro.entity.Userorder.findTotalCount", user_id);
		//查询分页信息
		Map<String, Integer> map=new HashMap<String,Integer>();
		map.put("user_id", user_id);
		map.put("offset", (pageNo-1)*pageSize);
		map.put("pageSize", pageSize);
		List<Userorder> userorders=session.selectList("com.cro.entity.Userorder.findPageUserorder", map);
		PageModel<Userorder> pageModel=new PageModel<Userorder>();
		pageModel.setData(userorders);
		pageModel.setTotalPage((totalcount%pageSize)==0?totalcount/pageSize:(totalcount/pageSize+1));
		session.close();
		
		return pageModel;
	}

	@Override
	public PageModel<Userorder> findUserorderByOrderNo(Long order_no,Integer pageNo,Integer pageSize) {
		// TODO Auto-generated method stub
		SqlSessionFactory factory=MyBatis.getSqlSessionFactory();
		SqlSession session=factory.openSession(true);
		//查询信息总数
		int totalcount=session.selectOne("com.cro.entity.Userorder.findTotalCountitem_id",order_no);
		//查询分页数
		Map<String, Object> map=new HashMap<String,Object>();
		map.put("order_no", order_no);
		map.put("offset", (pageNo-1)*pageSize);
		map.put("pageSize", pageSize);
		List<Userorder> list=session.selectList("com.cro.entity.Userorder.findUserorderByOrderNo", map);
		PageModel<Userorder> pageModel=new PageModel<Userorder>();
		pageModel.setData(list);
		pageModel.setTotalPage((totalcount%pageSize)==0?totalcount/pageSize:(totalcount/pageSize+1));
		session.close();
		return pageModel;
	}

	@Override
	public int updateStatus(Long order_no,Integer status) {
		// TODO Auto-generated method stub
		SqlSessionFactory factory=MyBatis.getSqlSessionFactory();
		SqlSession session=factory.openSession(true);
		Map<String, Object> map=new HashMap<String,Object>();
		map.put("order_no", order_no);
		map.put("status", status);
		int i=session.update("com.cro.entity.Userorder.updateStatus", map);
		return i;
	}

	@Override
	public List<Product> SelectProductByUserorderItem(Long order_no) {
		// TODO Auto-generated method stub
		SqlSessionFactory factory=MyBatis.getSqlSessionFactory();
		SqlSession session=factory.openSession(true);
		List<Product> products=session.selectList("com.cro.entity.Userorder.SelectProductByUserorderItem", order_no);
		return products;
	}

}

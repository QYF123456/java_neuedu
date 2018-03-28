package com.cro.dao.batisimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.cro.common.MyBatis;
import com.cro.dao.AddressDao;
import com.cro.entity.Address;
import com.cro.entity.Category;
import com.cro.entity.PageModel;

public class AddressDaoBatisImpl implements AddressDao {

	private  static AddressDao address=null;
	public static AddressDao getInstance() {
		synchronized(AddressDaoBatisImpl.class) {
			if(address==null) {
				address=new AddressDaoBatisImpl();
			}
		}
		return address;
	}
	
	@Override
	public int addAddress(Integer user_id, Address address) {
		// TODO Auto-generated method stub
		SqlSessionFactory factory= MyBatis.getSqlSessionFactory();
		SqlSession session= factory.openSession(false);
		Map<Object, Object> map=new HashMap<Object,Object>();
		map.put("user_id",user_id);
		map.put("address", address);
		int i=session.insert("com.cro.entity.Address.addAddress", map);
		session.commit();
		return i;
		
		 
	}

	@Override
	public int deleteAddressByUserid(Integer id) {
		
		// TODO Auto-generated method stub
		SqlSessionFactory factory= MyBatis.getSqlSessionFactory();
		SqlSession session= factory.openSession(false);
		int i=session.delete("com.cro.entity.Address.deleteAddressByUserid",id);
		session.commit();
		session.close();
		return i;
	}
	@Override
	public Address findAddressByid(Integer id) {
		// TODO Auto-generated method stub
		SqlSessionFactory factory= MyBatis.getSqlSessionFactory();
		SqlSession session= factory.openSession(false);
		Address addresses= session.selectOne("com.cro.entity.Address.findAddressByid", id);
		session.commit();
		return addresses;
	}
	@Override
	public int updateUserAddressByUserid(Integer id, Address address) {
		// TODO Auto-generated method stub
		SqlSessionFactory factory= MyBatis.getSqlSessionFactory();
		SqlSession session= factory.openSession(false);
		Map<Object, Object> map=new HashMap<Object,Object>();
		map.put("id", id);
		map.put("address", address);
		int i=session.update("com.cro.entity.Address.updateUserAddressByUserid", map);
		session.commit();
		return i;
	}

	@Override
	public PageModel<Address> findUserAddress(Integer pageNo, Integer pageSize, Integer user_id) {
		// TODO Auto-generated method stub
		SqlSessionFactory factory= MyBatis.getSqlSessionFactory();
		SqlSession session= factory.openSession();
		Map<Object, Object> map=new HashMap<Object,Object>();
		map.put("user_id", user_id);
		map.put("offset", (pageNo-1)*pageSize);
		map.put("pageSize", pageSize);
		//1.查询总的记录数
		int totalcount=session.selectOne("com.cro.entity.Address.findTotalCount",map);
		//2.查询某页面的数据
		
		List<Address> addresses=session.selectList("com.cro.entity.Address.findUserAddress", map);
		PageModel<Address> pageModel=new PageModel<Address>();
		pageModel.setData(addresses);
		pageModel.setTotalPage((totalcount%pageSize)==0?totalcount/pageSize:(totalcount/pageSize+1));
		return pageModel;
	}

	

}

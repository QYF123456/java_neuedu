package com.cro.dao.batisimpl;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.cro.common.MyBatis;
import com.cro.dao.CartDao;
import com.cro.entity.Cart;
import com.cro.entity.PageModel;

public class CartDaoBatisImpl implements CartDao {
	
	@Override
	public PageModel<Cart> findUserCart(Integer pageNo, Integer pageSize, Integer user_id) {
		// TODO Auto-generated method stub
		SqlSessionFactory factory= MyBatis.getSqlSessionFactory();
		SqlSession session= factory.openSession();
		//1.查询总的记录数
		int totalcount=session.selectOne("com.cro.entity.Cart.findTotalCount",user_id);
		//2.查询某页面的数据
		Map<Object, Object> map=new HashMap<Object,Object>();
		map.put("offset", (pageNo-1)*pageSize);
		map.put("pageSize", pageSize);
		map.put("user_id", user_id);
		List<Cart> carts=session.selectList("com.cro.entity.Cart.findUserCart", map);
		PageModel<Cart> pageModel=new PageModel<Cart>();
		pageModel.setData(carts);
		pageModel.setTotalPage((totalcount%pageSize)==0?totalcount/pageSize:(totalcount/pageSize+1));
		return pageModel;
	}

	@Override
	public Cart findCartByUserIdAndProductId(Integer user_id, Integer product_id) {
		// TODO Auto-generated method stub
		SqlSessionFactory factory= MyBatis.getSqlSessionFactory();
		SqlSession session= factory.openSession(true);
		Map<Object, Object> map=new HashMap<Object,Object>();
		map.put("user_id", user_id);
		map.put("product_id", product_id);
		Cart cart=session.selectOne("com.cro.entity.Cart.findCartByUserIdAndProductId",map);
		
		return cart;
	}
	
	@Override
	public int updateCartByUserIdAndProductId(Integer user_id, Integer product_id, int quantity) {
		// TODO Auto-generated method stub
		SqlSessionFactory factory= MyBatis.getSqlSessionFactory();
		SqlSession session= factory.openSession(true);
		Map<Object, Object> map=new HashMap<Object,Object>();
		map.put("user_id", user_id);
		map.put("product_id", product_id);
		map.put("quantity", quantity);
		int i=session.update("com.cro.entity.Cart.updateCartByUserIdAndProductId",map);
		return i;
	}

	@Override
	public int addProducttoCart(Integer user_id,Cart cart) {
		// TODO Auto-generated method stub
		SqlSessionFactory factory= MyBatis.getSqlSessionFactory();
		SqlSession session= factory.openSession(true);
		Map<String, Object> map=new HashMap<String,Object>();
		map.put("user_id", user_id);
		map.put("cart", cart);
		int i=session.insert("com.cro.entity.Cart.addProducttoCart", map);
		return i;
	}

	@Override
	public int deleteCartByCartId(Integer id) {
		// TODO Auto-generated method stub
		SqlSessionFactory factory= MyBatis.getSqlSessionFactory();
		SqlSession session= factory.openSession(true);
		Map<String, Integer> map=new HashMap<String,Integer>();
		map.put("id",id);
		int i=session.delete("com.cro.entity.Cart.deleteCartByUserIdAndProductId", map);
		return i;
	}


	@Override
	public int findCartProductCountByCartQuantity(Integer user_id) {
		// TODO Auto-generated method stub
		SqlSessionFactory factory= MyBatis.getSqlSessionFactory();
		SqlSession session= factory.openSession(true);
		int num=session.selectOne("com.cro.entity.Cart.findCartProductCountByCartQuantity", user_id);
		
		return num;
		
	}
	@Override
	public int updateCartcheckedByUseridAndProductid(Integer user_id, Integer product_id, Integer checked) {
		// TODO Auto-generated method stub
		SqlSessionFactory factory= MyBatis.getSqlSessionFactory();
		SqlSession session= factory.openSession(true);
		Map<String, Integer> map=new HashMap<String ,Integer>();
		map.put("user_id", user_id);
		map.put("product_id", product_id);
		map.put("checked", checked);
		int i=session.update("com.cro.entity.Cart.updateCartcheckedByUseridAndProductid", map);
		session.close();
		return i;
	}


	@Override
	public List<Cart> findCheckCart(Integer user_id) {
		// TODO Auto-generated method stub
		SqlSessionFactory factory= MyBatis.getSqlSessionFactory();
		SqlSession session= factory.openSession(true);
		List<Cart> carts=session.selectList("com.cro.entity.Cart.findCheckCart", user_id);
		session.close();
		return carts;
	}


	@Override
	public int deleteCheckedCartByUserId(Integer user_id) {
		// TODO Auto-generated method stub
		SqlSessionFactory factory= MyBatis.getSqlSessionFactory();
		SqlSession session= factory.openSession(true);
		int i=session.delete("com.cro.entity.Cart.deleteCheckedCartByUserId", user_id);
		session.close();
		return i;
	}

	@Override
	public int findCartproductCountByUserId(Integer user_id) {
		// TODO Auto-generated method stub
		SqlSessionFactory factory= MyBatis.getSqlSessionFactory();
		SqlSession session= factory.openSession(true);
		int i=session.selectOne("com.cro.entity.Cart.findCartproductCountByUserId", user_id);
		return i;
	}

	



	


}

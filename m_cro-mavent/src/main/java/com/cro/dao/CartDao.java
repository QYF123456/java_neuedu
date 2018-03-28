package com.cro.dao;

import java.util.List;

import com.cro.entity.Cart;
import com.cro.entity.PageModel;

public interface CartDao {
	/**
	 * 分页查询购物车信息
	 * */
	PageModel<Cart> findUserCart(Integer pageNo,Integer pageSize,Integer user_id);
	
	
	/**
	 * 根据用户id和商品id查询购物车信息
	 * user_id  用户id
	 * product_id   商品id
	 * 返回类型   Cart
	 * */
	Cart findCartByUserIdAndProductId(Integer user_id,Integer product_id);
	
	/**
	 * 根据用户id和商品id更新购物车商品的数量
	 * user_id  用户id
	 * product_id   商品id
	 * quantity   商品数量
	 * */
	int updateCartByUserIdAndProductId(Integer user_id,Integer product_id,int quantity);
	/**
	 * 用户将商品添加到购物车
	 * */
	int addProducttoCart(Integer user_id,Cart cart);
	/**
	 * 移除购物车中的某个产品
	 * */
	int deleteCartByCartId(Integer id);
	/**
	 * 查询在购物车里面的商品所有选择数量
	 * */
	int findCartProductCountByCartQuantity(Integer user_id);
	/**
	 * 根据用户id和商品id选择其购物车下的某个商品
	 * */
	int updateCartcheckedByUseridAndProductid(Integer user_id,Integer product_id,Integer checked);

	/**
	 * 查询用户在购物车中已选中的商品
	 * */
	List<Cart> findCheckCart(Integer user_id);
	/**
	 * 根据user_id，清空用户购物车中被选中的商品
	 * */
	int deleteCheckedCartByUserId(Integer user_id);
	/**
	 * 查询在购物车下的商品数量
	 * */
	int findCartproductCountByUserId(Integer user_id);
}

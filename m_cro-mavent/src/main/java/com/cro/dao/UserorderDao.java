package com.cro.dao;

import java.util.List;

import com.cro.entity.PageModel;
import com.cro.entity.Product;
import com.cro.entity.Userorder;
import com.cro.entity.UserorderView;

public interface UserorderDao {
	/**
	 * 添加订单到数据库
	 * userorder  订单对象
	 * */
	public int InsertUserorder(Userorder userorder);
	/**
	 * 分页查询订单
	 * */
	public PageModel<Userorder> findPageUserorder(Integer user_id,Integer pageNo,Integer pageSize);
	/**
	 * 按订单号查询订单信息
	 * */
	
	public PageModel<Userorder> findUserorderByOrderNo(Long order_no,Integer pageNo,Integer pageSize);
	/**
	 * 订单发货。根据订单号更新发货状态
	 * */
	public int updateStatus (Long order_no,Integer status);
	/**
	 * 获取订单的商品信息
	 *根据 订单号，查找订单商品信息
	 * */
	public List<Product>  SelectProductByUserorderItem(Long order_no);
}

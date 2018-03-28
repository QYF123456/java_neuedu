package com.cro.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.cro.entity.PageModel;
import com.cro.entity.Product;
import com.cro.entity.Userorder;
import com.cro.entity.UserorderView;

public interface UserorderService {
/**
 * 用户下单
 * @param  user_id  用户id
 * @param  shipping_id   地址id
 * @throws Exception 
 * */
	Userorder createOrder(Integer user_id,HttpServletRequest request) throws Exception ;
	/**
	 * 分页显示用户的订单列表
	 * */
	public PageModel<UserorderView> findPageUserorder(Integer user_id, HttpServletRequest request);
	
	/**
	 * 根据订单编号查询订单的详细状况
	 * */
	public PageModel<UserorderView> findUserorderByOrderNo(Long order_no,Integer pageNo,Integer pageSize);
	/**
	 * 根据订单编号修改该订单的状态
	 * */
	public int updateStatus(Long order_no,Integer status);
	/**
	 * 根据订单编号获取商品信息
	 * */
	public List<Product> SelectProductByUserorderItem(Long order_no);
	
}

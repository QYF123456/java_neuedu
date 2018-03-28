package com.cro.dao;

import java.util.List;

import com.cro.entity.Userorder_item;

public interface UserorderItemDao {
	/**
	 * 将订单明细批量插入到数据库
	 * */
	public int insertUserorderItem(List<Userorder_item> userorder_items);
	/**
	 * 根据订单号查询订单明细
	 * */
	public List<Userorder_item> findUserorderItemsByOrderNo(Long order_No);

}

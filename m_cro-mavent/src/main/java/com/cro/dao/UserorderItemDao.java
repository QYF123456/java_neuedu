package com.cro.dao;

import java.util.List;

import com.cro.entity.Userorder_item;

public interface UserorderItemDao {
	/**
	 * ��������ϸ�������뵽���ݿ�
	 * */
	public int insertUserorderItem(List<Userorder_item> userorder_items);
	/**
	 * ���ݶ����Ų�ѯ������ϸ
	 * */
	public List<Userorder_item> findUserorderItemsByOrderNo(Long order_No);

}

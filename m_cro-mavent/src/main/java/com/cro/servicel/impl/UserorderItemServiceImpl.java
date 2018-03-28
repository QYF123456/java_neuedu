package com.cro.servicel.impl;

import java.util.ArrayList;
import java.util.List;

import com.cro.dao.UserorderItemDao;
import com.cro.dao.batisimpl.UserorderItemDaoBatisImpl;
import com.cro.entity.PageModel;
import com.cro.entity.UserorderItemView;
import com.cro.entity.Userorder_item;
import com.cro.service.UserorderItemsService;

public class UserorderItemServiceImpl implements UserorderItemsService {

	UserorderItemDao useritemdao=new UserorderItemDaoBatisImpl();
	@Override
	public List<UserorderItemView> findUserorderItemsByOrderNo(Long order_No) {
		// TODO Auto-generated method stub
		
		List<Userorder_item> userorder_items= useritemdao.findUserorderItemsByOrderNo(order_No);
		List<UserorderItemView> list=convertUerorderItemToUserorderItemView(userorder_items);
		return list;
	}

	/**
	 * ½«Userorder_item×ªÎªUserorderItemView
	 * 
	 * */
	private List<UserorderItemView> convertUerorderItemToUserorderItemView(List<Userorder_item> userorder_items) {
		 List<UserorderItemView> _list=new ArrayList<UserorderItemView>();
		if(userorder_items!=null) {
			for (Userorder_item userorderItems : userorder_items) {
				UserorderItemView userorderItemView=new UserorderItemView();
				userorderItemView.convertUerorderItemToUserorderItemView(userorderItems);
				_list.add(userorderItemView);
			}
		}
		return _list;
		
	}
}

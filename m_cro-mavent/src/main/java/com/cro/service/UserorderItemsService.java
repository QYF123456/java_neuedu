package com.cro.service;

import java.util.List;

import com.cro.entity.UserorderItemView;
import com.cro.entity.Userorder_item;

public interface UserorderItemsService {

	public List<UserorderItemView> findUserorderItemsByOrderNo(Long order_No);
}

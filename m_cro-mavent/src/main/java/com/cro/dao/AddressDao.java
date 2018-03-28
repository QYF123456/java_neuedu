package com.cro.dao;

import java.util.List;

import com.cro.entity.Address;
import com.cro.entity.PageModel;

/**
 * 用户地址管理
 * */
public interface AddressDao {
	/**
	 * 根据用户id，添加用户的收货地址
	 * */
	int addAddress(Integer user_id,Address address);
	/**
	 * 根据user_id删除地址id
	 * */
	int deleteAddressByUserid(Integer id);
	/**
	 * 根据user_id修改用户的地址信息
	 * */
	int updateUserAddressByUserid(Integer id,Address address);
	/**
	 * 根据id查询该用户的该地址信息
	 * */
	Address findAddressByid(Integer id);
	
	/**
	 * 分页查询用户的收货地址
	 * */
	PageModel<Address> findUserAddress(Integer pageNo,Integer pageSize,Integer user_id);
	
}

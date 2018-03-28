package com.cro.service;

import java.util.List;

import com.cro.entity.Address;
import com.cro.entity.PageModel;

public interface AddressService {

	
	public int addAddress(Integer user_id,Address address);
	
	PageModel<Address> findUserAddress(Integer pageNo,Integer pageSize,Integer user_id);
	public int deleteAddressByUserid(Integer id);
	public Address findAddressByid(Integer id);
	public int updateUserAddressByUserid(Integer id, Address address);
}

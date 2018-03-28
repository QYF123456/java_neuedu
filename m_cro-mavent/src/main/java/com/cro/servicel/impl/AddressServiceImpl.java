package com.cro.servicel.impl;

import java.util.List;

import com.cro.dao.AddressDao;
import com.cro.dao.batisimpl.AddressDaoBatisImpl;
import com.cro.entity.Address;
import com.cro.entity.PageModel;
import com.cro.service.AddressService;

public class AddressServiceImpl implements AddressService {
	
	AddressDao addressdao=new AddressDaoBatisImpl();

	@Override
	public int addAddress(Integer user_id, Address address) {
		// TODO Auto-generated method stub
		return addressdao.addAddress(user_id, address);
	}

	@Override
	public PageModel<Address> findUserAddress(Integer pageNo, Integer pageSize, Integer user_id) {
		// TODO Auto-generated method stub
		return addressdao.findUserAddress(pageNo, pageSize, user_id);
	}

	@Override
	public int deleteAddressByUserid(Integer id) {
		// TODO Auto-generated method stub
		return addressdao.deleteAddressByUserid(id);
	}

	@Override
	public Address findAddressByid(Integer id) {
		// TODO Auto-generated method stub
		return addressdao.findAddressByid(id);
	}

	@Override
	public int updateUserAddressByUserid(Integer id, Address address) {
		// TODO Auto-generated method stub
		return addressdao.updateUserAddressByUserid(id, address);
	}

}

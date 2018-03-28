package com.cro.dao;

import java.util.List;

import com.cro.entity.Address;
import com.cro.entity.PageModel;

/**
 * �û���ַ����
 * */
public interface AddressDao {
	/**
	 * �����û�id������û����ջ���ַ
	 * */
	int addAddress(Integer user_id,Address address);
	/**
	 * ����user_idɾ����ַid
	 * */
	int deleteAddressByUserid(Integer id);
	/**
	 * ����user_id�޸��û��ĵ�ַ��Ϣ
	 * */
	int updateUserAddressByUserid(Integer id,Address address);
	/**
	 * ����id��ѯ���û��ĸõ�ַ��Ϣ
	 * */
	Address findAddressByid(Integer id);
	
	/**
	 * ��ҳ��ѯ�û����ջ���ַ
	 * */
	PageModel<Address> findUserAddress(Integer pageNo,Integer pageSize,Integer user_id);
	
}

package com.cro.dao;

import java.util.List;

import com.cro.entity.PageModel;
import com.cro.entity.Product;
import com.cro.entity.Userorder;
import com.cro.entity.UserorderView;

public interface UserorderDao {
	/**
	 * ��Ӷ��������ݿ�
	 * userorder  ��������
	 * */
	public int InsertUserorder(Userorder userorder);
	/**
	 * ��ҳ��ѯ����
	 * */
	public PageModel<Userorder> findPageUserorder(Integer user_id,Integer pageNo,Integer pageSize);
	/**
	 * �������Ų�ѯ������Ϣ
	 * */
	
	public PageModel<Userorder> findUserorderByOrderNo(Long order_no,Integer pageNo,Integer pageSize);
	/**
	 * �������������ݶ����Ÿ��·���״̬
	 * */
	public int updateStatus (Long order_no,Integer status);
	/**
	 * ��ȡ��������Ʒ��Ϣ
	 *���� �����ţ����Ҷ�����Ʒ��Ϣ
	 * */
	public List<Product>  SelectProductByUserorderItem(Long order_no);
}

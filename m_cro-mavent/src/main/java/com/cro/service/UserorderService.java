package com.cro.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.cro.entity.PageModel;
import com.cro.entity.Product;
import com.cro.entity.Userorder;
import com.cro.entity.UserorderView;

public interface UserorderService {
/**
 * �û��µ�
 * @param  user_id  �û�id
 * @param  shipping_id   ��ַid
 * @throws Exception 
 * */
	Userorder createOrder(Integer user_id,HttpServletRequest request) throws Exception ;
	/**
	 * ��ҳ��ʾ�û��Ķ����б�
	 * */
	public PageModel<UserorderView> findPageUserorder(Integer user_id, HttpServletRequest request);
	
	/**
	 * ���ݶ�����Ų�ѯ��������ϸ״��
	 * */
	public PageModel<UserorderView> findUserorderByOrderNo(Long order_no,Integer pageNo,Integer pageSize);
	/**
	 * ���ݶ�������޸ĸö�����״̬
	 * */
	public int updateStatus(Long order_no,Integer status);
	/**
	 * ���ݶ�����Ż�ȡ��Ʒ��Ϣ
	 * */
	public List<Product> SelectProductByUserorderItem(Long order_no);
	
}

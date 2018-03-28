package com.cro.dao;

import java.util.List;

import com.cro.entity.Cart;
import com.cro.entity.PageModel;

public interface CartDao {
	/**
	 * ��ҳ��ѯ���ﳵ��Ϣ
	 * */
	PageModel<Cart> findUserCart(Integer pageNo,Integer pageSize,Integer user_id);
	
	
	/**
	 * �����û�id����Ʒid��ѯ���ﳵ��Ϣ
	 * user_id  �û�id
	 * product_id   ��Ʒid
	 * ��������   Cart
	 * */
	Cart findCartByUserIdAndProductId(Integer user_id,Integer product_id);
	
	/**
	 * �����û�id����Ʒid���¹��ﳵ��Ʒ������
	 * user_id  �û�id
	 * product_id   ��Ʒid
	 * quantity   ��Ʒ����
	 * */
	int updateCartByUserIdAndProductId(Integer user_id,Integer product_id,int quantity);
	/**
	 * �û�����Ʒ��ӵ����ﳵ
	 * */
	int addProducttoCart(Integer user_id,Cart cart);
	/**
	 * �Ƴ����ﳵ�е�ĳ����Ʒ
	 * */
	int deleteCartByCartId(Integer id);
	/**
	 * ��ѯ�ڹ��ﳵ�������Ʒ����ѡ������
	 * */
	int findCartProductCountByCartQuantity(Integer user_id);
	/**
	 * �����û�id����Ʒidѡ���乺�ﳵ�µ�ĳ����Ʒ
	 * */
	int updateCartcheckedByUseridAndProductid(Integer user_id,Integer product_id,Integer checked);

	/**
	 * ��ѯ�û��ڹ��ﳵ����ѡ�е���Ʒ
	 * */
	List<Cart> findCheckCart(Integer user_id);
	/**
	 * ����user_id������û����ﳵ�б�ѡ�е���Ʒ
	 * */
	int deleteCheckedCartByUserId(Integer user_id);
	/**
	 * ��ѯ�ڹ��ﳵ�µ���Ʒ����
	 * */
	int findCartproductCountByUserId(Integer user_id);
}

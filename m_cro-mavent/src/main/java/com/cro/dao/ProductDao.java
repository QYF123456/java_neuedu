package com.cro.dao;

import java.util.List;


import com.cro.entity.PageModel;
import com.cro.entity.Product;

public interface ProductDao {
	//��ҳ
	public PageModel<Product> FindAllProductByPage(int pageNo,int pageSize);
	//��ѯȫ����Ʒ��Ϣ
	public List<Product> FindAllProduct();
	//����idɾ����Ϣ
	public int deleteProductById(Integer id);
	//�����Ʒ��Ϣ
	public int insertProduct(Product pdt);
	//����id������Ʒ��Ϣ
	public Product findProductById(Integer id);
	//����id�޸���Ʒ��Ϣ
	public int updateProduct(Product pdt);
	//����id������Ʒ���
	public int findstock(Integer id);
	//���ݶ�����Ʒ�������¿��
	public int updatestock(Integer id,Integer quantity);
	

}

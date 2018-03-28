package com.cro.dao;

import java.util.List;


import com.cro.entity.PageModel;
import com.cro.entity.Product;

public interface ProductDao {
	//分页
	public PageModel<Product> FindAllProductByPage(int pageNo,int pageSize);
	//查询全部商品信息
	public List<Product> FindAllProduct();
	//根据id删除信息
	public int deleteProductById(Integer id);
	//添加商品信息
	public int insertProduct(Product pdt);
	//根据id查找商品信息
	public Product findProductById(Integer id);
	//根据id修改商品信息
	public int updateProduct(Product pdt);
	//根据id查找商品库存
	public int findstock(Integer id);
	//根据订单商品数量更新库存
	public int updatestock(Integer id,Integer quantity);
	

}

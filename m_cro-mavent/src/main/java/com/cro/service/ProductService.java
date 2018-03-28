package com.cro.service;

import java.util.List;

import com.cro.entity.PageModel;
import com.cro.entity.Product;

public interface ProductService {
	public PageModel<Product> FindAllProductByPage(int pageNo, int pageSize);
	public List<Product> FindAllProduct();
	public int deleteProductById(Integer id);
	public int insertProduct(Product pdt);
	public Product findProductById(Integer id);
	public int updateProduct(Product pdt);
}

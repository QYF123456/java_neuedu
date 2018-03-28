package com.cro.servicel.impl;

import java.util.List;

import com.cro.dao.ProductDao;
import com.cro.dao.impl.ProductImpl;
import com.cro.entity.PageModel;
import com.cro.entity.Product;
import com.cro.service.ProductService;

public class ProductServiceimpl implements ProductService {

	@Override
	public PageModel<Product> FindAllProductByPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		ProductDao pdt=new ProductImpl();
		return pdt.FindAllProductByPage(pageNo, pageSize);
	}
	@Override
	public List<Product> FindAllProduct() {
		// TODO Auto-generated method stub
		ProductDao pdt=new ProductImpl();
		return pdt.FindAllProduct();
	}

	@Override
	public int deleteProductById(Integer id) {
		// TODO Auto-generated method stub
		ProductDao pdt=new ProductImpl();
		return pdt.deleteProductById(id);
	}

	@Override
	public int insertProduct(Product pdt) {
		// TODO Auto-generated method stub
		ProductDao pdtDao=new ProductImpl();
		return pdtDao.insertProduct(pdt);
	}

	@Override
	public int updateProduct(Product pdt) {
		// TODO Auto-generated method stub
		ProductDao pdtDao=new ProductImpl();
		return pdtDao.updateProduct(pdt);
	}

	@Override
	public Product findProductById(Integer id) {
		// TODO Auto-generated method stub
		ProductDao pdtDao=new ProductImpl();
		return pdtDao.findProductById(id);
	}

	

}

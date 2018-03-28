package com.cro.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.cro.entity.Cart;
import com.cro.entity.CartCheckedVo;
import com.cro.entity.PageModel;
import com.cro.entity.view.Cartvo;

public interface CartService {
	
	public PageModel<Cartvo> findUserCart(Integer pageNo, Integer pageSize, Integer user_id);
	
	public Cart findCartByUserIdAndProductId(Integer user_id, Integer product_id);
	
	public Cart updateCartByUserIdAndProductId(Integer user_id,HttpServletRequest request);
	
	public int addProducttoCart(Integer user_id,Cart cart);
	
	public int deleteCartByCartId(Integer id);
	
	public int findCartProductCountByCartQuantity(Integer user_id);
	
	public CartCheckedVo updateCartcheckedByUseridAndProductid(Integer user_id,HttpServletRequest request) throws Exception;

	public int findCartproductCountByUserId(Integer user_id);
	
	
}

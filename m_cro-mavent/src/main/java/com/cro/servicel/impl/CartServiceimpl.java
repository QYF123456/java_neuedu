package com.cro.servicel.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.cro.dao.CartDao;
import com.cro.dao.batisimpl.CartDaoBatisImpl;
import com.cro.entity.Cart;
import com.cro.entity.CartCheckedVo;
import com.cro.entity.PageModel;
import com.cro.entity.view.Cartvo;
import com.cro.service.CartService;

public class CartServiceimpl implements CartService {
	
	CartDao cartdao=new CartDaoBatisImpl();
	
	@Override
	public Cart findCartByUserIdAndProductId(Integer user_id, Integer product_id) {
		// TODO Auto-generated method stub
		
		Cart cart=cartdao.findCartByUserIdAndProductId(user_id, product_id);
		
		return  cart;
	}

	@Override
	public Cart updateCartByUserIdAndProductId(Integer user_id, HttpServletRequest request) {
		// TODO Auto-generated method stub
		//Integer user_id, Integer product_id, Integer quantity,int value
		String value=request.getParameter("value");
		String product_id=request.getParameter("product_id");
		Integer _value=null;
		Integer _product_id=null;
		try {
			_value=Integer.parseInt(value);
			_product_id=Integer.parseInt(product_id);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		if(_value==null&&_value.equals("")) {
			try {
				throw new Exception("该字段必须输入");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			Cart cart=cartdao.findCartByUserIdAndProductId(user_id, _product_id);
			int _quantity=0;
			if(_value==1) {//增加数量
				_quantity=cart.getQuantity()+1;
			}else if (_value==0) {//减少数量
				if(cart.getQuantity()>1) {
				_quantity=cart.getQuantity()-1;
				}else {
				_quantity=cart.getQuantity();
				}
			}
			int i= cartdao.updateCartByUserIdAndProductId(user_id, _product_id, _quantity);
			if(i>0) {
			return	cartdao.findCartByUserIdAndProductId(user_id, _product_id);
			}
		}
		return null;
		
		
		
	}
	@Override
	public int addProducttoCart(Integer user_id, Cart cart) {
		// TODO Auto-generated method stub
		
		int _product_id=cart.getProduct_id();
		
		if(_product_id!=0) {//1.判断cart对象中的product_id是否存在
			Cart usercart=cartdao.findCartByUserIdAndProductId(user_id, _product_id);
			if(usercart!=null) {//2.如果存在，则根据cart中的user_id和product_id查询该商品是否存在
				int qu=usercart.getQuantity();
				int _quantity=cart.getQuantity();
				int totalquantity=_quantity+qu;
				return cartdao.updateCartByUserIdAndProductId(user_id, _product_id,totalquantity);//2.1 存在，则进行数量更新
			}else {
				return cartdao.addProducttoCart(user_id, cart); 	//2.2不存在，则进行商品添加
			}
		}
		return 0;
		
	}
	@Override
	public int deleteCartByCartId(Integer id) {
		// TODO Auto-generated method stub
		return cartdao.deleteCartByCartId(id);
	}
	
	@Override
	public int findCartProductCountByCartQuantity(Integer user_id) {
		// TODO Auto-generated method stub
		return cartdao.findCartProductCountByCartQuantity(user_id);
	}
	@Override
	public CartCheckedVo updateCartcheckedByUseridAndProductid(Integer user_id,HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		CartCheckedVo vo=new CartCheckedVo();
		String product_id=request.getParameter("product_id");
		Integer productid=null;
		if(product_id!=null) {
			try {
				productid=Integer.parseInt(product_id);
			} catch (NumberFormatException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		//checked
		String checked=request.getParameter("checked");
		if(checked==null||checked.equals("")) {
			throw new Exception("全选/取消全选checked参数必传");
		}
		Integer _checked=null;
		try {
			_checked=Integer.parseInt(checked);
		} catch (NumberFormatException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		int row=cartdao.updateCartcheckedByUseridAndProductid(user_id, productid, _checked);
		if(row>0) {
			vo.setErrno(CartCheckedVo.ERRNO_SUCCESS);
			vo.setProduct_id(productid);
			vo.setChecked(_checked);
		}
		return vo;
	}
	
	
	@Override
	public PageModel<Cartvo> findUserCart(Integer pageNo, Integer pageSize, Integer user_id) {
		// TODO Auto-generated method stub
		PageModel<Cart> pageModel= cartdao.findUserCart(pageNo, pageSize, user_id);
		PageModel<Cartvo> c=carStrDate(pageModel);
		 return c;
	}

	private PageModel<Cartvo> carStrDate(PageModel<Cart> pageModel) {
		PageModel<Cartvo> cartpageModel=new PageModel<Cartvo>();
		if(pageModel!=null) {
			List<Cartvo> carts=new ArrayList<Cartvo>();
			List<Cart> pCarts=pageModel.getData();
			for(Cart cart:pCarts) {
				Cartvo cart2=new Cartvo();
				cart2.converCartToCartVo(cart);
				carts.add(cart2);
			}
			cartpageModel.setData(carts);
			cartpageModel.setTotalPage(pageModel.getTotalPage());
		}
		return cartpageModel;
	}

	@Override
	public int findCartproductCountByUserId(Integer user_id) {
		// TODO Auto-generated method stub
		return cartdao.findCartproductCountByUserId(user_id);
	}

}

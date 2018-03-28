package com.cro.servicel.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.cro.Chli.Order;
import com.cro.dao.CartDao;
import com.cro.dao.ProductDao;
import com.cro.dao.UserorderDao;
import com.cro.dao.UserorderItemDao;
import com.cro.dao.batisimpl.CartDaoBatisImpl;
import com.cro.dao.batisimpl.UserorderDaoBatisImpl;
import com.cro.dao.batisimpl.UserorderItemDaoBatisImpl;
import com.cro.dao.impl.ProductImpl;
import com.cro.entity.Cart;
import com.cro.entity.PageModel;
import com.cro.entity.Product;
import com.cro.entity.Userorder;
import com.cro.entity.UserorderItemView;
import com.cro.entity.UserorderView;
import com.cro.entity.Userorder_item;
import com.cro.service.UserorderService;
import com.mysql.fabric.xmlrpc.base.Array;

public class UserorderServiceImpl implements UserorderService{
	CartDao cartDao=new CartDaoBatisImpl();
	ProductDao productDao=new ProductImpl();
	UserorderDao userorderDao=new UserorderDaoBatisImpl();
	UserorderItemDao userorderitemDao=new UserorderItemDaoBatisImpl();
	@Override
	public Userorder createOrder(Integer user_id, HttpServletRequest request) throws Exception  {
		// TODO Auto-generated method stub
		//1.��ַid �ķǿ��ж�
		String shipping_id=request.getParameter("shipping_id");
		if(shipping_id==null|| shipping_id.equals("")) {
			throw new Exception("��ַ�Ǳ�����");
		}
		Integer _shipping_id=0;
		try {
			_shipping_id=Integer.parseInt(shipping_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//2.��ѯ�û��ڹ��ﳵ����ѡ�е���Ʒ
		
		List<Cart> carts=cartDao.findCheckCart(user_id);
		
		//3.�����ﳵ����Ʒ����ת�ɶ�����ϸ����
		List<Userorder_item> userorder_items=converCartToUserorder(user_id, carts);
		//4.���㶩���ܼ۸�
		BigDecimal payment=gettotalprice(userorder_items);
		//5.����userid/shippingid���ջ���ַ��/totalprice���ܼ۸񣩴�������������ӵ����ݿ�
		Userorder userorder=craeteUserorder(user_id, _shipping_id, payment);
		if(userorder!=null) { //�����ɹ��������ݿ�
			//6.��������ϸ������ӵ����ݿ�
			addUserorderItem(userorder, userorder_items);
		}
		
		//7.������Ʒ���
		for(Userorder_item userorder_item:userorder_items) {
			productDao.updatestock(userorder_item.getProduct_id(), userorder_item.getQuantity());
		}
		
		//8.��չ��ﳵ
		cartDao.deleteCheckedCartByUserId(user_id);
		return null;
	}
	/**
	 * �����ﳵ����Ʒ����ת�ɶ�����ϸ����
	 * */
	private List<Userorder_item> converCartToUserorder(Integer user_id,List<Cart> carts){
		List<Userorder_item> list=new ArrayList<Userorder_item>();
		for(Cart cart:carts) {
			Userorder_item userorder_item=new Userorder_item();
			//������Ʒid��ȡ��Ʒ��Ϣ
			
			Product product=productDao.findProductById(cart.getProduct_id());
			if(product!=null) {
				userorder_item.setProduct_id(cart.getProduct_id());
				userorder_item.setProduct_name(product.getName());
				userorder_item.setProduct_image(product.getMain_image());
				userorder_item.setCurrent_unit_price(product.getPrice());
				//������Ʒ�ܵļ۸�
				userorder_item.setQuantity(cart.getQuantity());
				double total_price=(product.getPrice().doubleValue())*cart.getQuantity();
				userorder_item.setTotal_price(new BigDecimal(total_price));
				
				userorder_item.setUser_id(user_id);
				list.add(userorder_item);
			}
			
		}
		
		return list;
		
	}
	
	/**
	 * ��������
	 * */
	private Userorder craeteUserorder(Integer user_id,Integer shipping_id,BigDecimal payment) {
		Userorder userorder=new Userorder();
		userorder.setOrder_no(createOrder_no());
		userorder.setUser_id(user_id);
		userorder.setShipping_id(shipping_id);
		userorder.setPayment(payment);
		userorder.setPayment_type(1);
		userorder.setPostage(0);
		userorder.setStatus(Order.UNPAY.getStatus());
		
		int row=userorderDao.InsertUserorder(userorder);
		if(row>0) {//����ɹ�
			return userorder;
		}
		return null;
		
	}
	
	/**
	 * ���ɶ������
	 * */
	private long createOrder_no() {
		
		return System.currentTimeMillis()+(int)(Math.random()*100);
	}
	/**
	 * ���㶩���۸�
	 * */
	private BigDecimal gettotalprice(List<Userorder_item> userorder_items) {
		BigDecimal totalprice=new BigDecimal("0");
		for(Userorder_item userorder_item:userorder_items ) {
			totalprice=totalprice.add(userorder_item.getTotal_price());
		}
		return totalprice;
	}
	/**
	 * ��������ϸ���뵽���ݿ���
	 * @return 
	 * @throws Exception 
	 * */
	private int addUserorderItem(Userorder userorder,List<Userorder_item> userorder_items){
		//Ϊÿһ��������ϸ��Ӷ�����
		for(Userorder_item userorder_item:userorder_items) {
			userorder_item.setOrder_no(userorder.getOrder_no());
			//�ж���Ʒ���
			long stock=productDao.findstock(userorder_item.getProduct_id());
			/*if(stock<userorder_item.getQuantity()) {
				throw new Exception("��治��");
			}*/
		}
		//��������ϸ���뵽���ݿ�
		return userorderitemDao.insertUserorderItem(userorder_items);
	}
	@Override
	public PageModel<UserorderView> findPageUserorder(Integer user_id,HttpServletRequest request) {
		// TODO Auto-generated method stub
		String pageNo=request.getParameter("pageNo");
		String pageSize=request.getParameter("pageSize");
		Integer _pageNo=0;
		Integer _pageSize=0;
		
		try {
			_pageNo=Integer.parseInt(pageNo);
			_pageSize=Integer.parseInt(pageSize);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		PageModel<Userorder> pageModel= userorderDao.findPageUserorder(user_id, _pageNo, _pageSize);
		PageModel<UserorderView> pageModel2=convertUerorderToUserorderView(pageModel);
		return pageModel2;
	}
	
	/**
	 * ��UserOrder-->UserorderView
	 * */
	private PageModel<UserorderView> convertUerorderToUserorderView(PageModel<Userorder> pageModel) {
		 PageModel<UserorderView> _pageModel=new PageModel<UserorderView>();
		 if(pageModel!=null) {
			 List<UserorderView> list=new ArrayList<UserorderView>();
			List<Userorder> userorders=pageModel.getData();
			
			for (Userorder userorder : userorders) {
				UserorderView userorderView=new UserorderView();
				userorderView.convertUerorderToUserorderView(userorder);
				list.add(userorderView);
			}
			_pageModel.setData(list);
			_pageModel.setTotalPage(pageModel.getTotalPage());
		}
		return _pageModel;
		
	}
	
	
	@Override
	public int updateStatus(Long order_no, Integer status) {
		// TODO Auto-generated method stub
		return userorderDao.updateStatus(order_no, status);
	}
	@Override
	public List<Product> SelectProductByUserorderItem(Long order_no) {
		// TODO Auto-generated method stub
		return userorderDao.SelectProductByUserorderItem(order_no);
	}
	@Override
	public PageModel<UserorderView> findUserorderByOrderNo(Long order_no, Integer pageNo, Integer pageSize) {
		// TODO Auto-generated method stub
	PageModel<Userorder> pageModel=userorderDao.findUserorderByOrderNo(order_no, pageNo, pageSize);	
	PageModel<UserorderView> pageModel2=convertUerorderToUserorderView(pageModel);
	System.out.println("Service impl++++="+pageModel2);
	return pageModel2;
	}
	
} 





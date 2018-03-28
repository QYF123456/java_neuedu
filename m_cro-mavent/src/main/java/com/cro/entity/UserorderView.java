package com.cro.entity;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.cro.Chli.Order;
import com.cro.Chli.Payment;

/**
 * 展示在页面上的实体类
 * */
public class UserorderView  {
	private Integer	id;
	private Long  order_no ;
	private Integer	 user_id;
	private User user;
	private Address address;
	private Integer	 shipping_id;
	private BigDecimal	payment;
	private String	 payment_type;
	private Integer	 postage ;
	private String 	status;
	private String	 payment_time ;
	private String	 send_time;
	
	private String  _end_time;
	private String _create_time;
	private String  _update_time;
	private String  _close_time;
	private List<Userorder_item> userorder_items=null;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Long getOrder_no() {
		return order_no;
	}
	public void setOrder_no(Long order_no) {
		this.order_no = order_no;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Integer getShipping_id() {
		return shipping_id;
	}
	public void setShipping_id(Integer shipping_id) {
		this.shipping_id = shipping_id;
	}
	public BigDecimal getPayment() {
		return payment;
	}
	public void setPayment(BigDecimal payment) {
		this.payment = payment;
	}
	public String getPayment_type() {
		return payment_type;
	}
	public void setPayment_type(String payment_type) {
		this.payment_type = payment_type;
	}
	public Integer getPostage() {
		return postage;
	}
	public void setPostage(Integer postage) {
		this.postage = postage;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPayment_time() {
		return payment_time;
	}
	public void setPayment_time(String payment_time) {
		this.payment_time = payment_time;
	}
	public String getSend_time() {
		return send_time;
	}
	public void setSend_time(String send_time) {
		this.send_time = send_time;
	}
	public String get_end_time() {
		return _end_time;
	}
	public void set_end_time(String _end_time) {
		this._end_time = _end_time;
	}
	public String get_create_time() {
		return _create_time;
	}
	public void set_create_time(String _create_time) {
		this._create_time = _create_time;
	}
	public String get_update_time() {
		return _update_time;
	}
	public void set_update_time(String _update_time) {
		this._update_time = _update_time;
	}
	public String get_close_time() {
		return _close_time;
	}
	public void set_close_time(String _close_time) {
		this._close_time = _close_time;
	}
	public List<Userorder_item> getUserorder_items() {
		return userorder_items;
	}
	public void setUserorder_items(List<Userorder_item> userorder_items) {
		this.userorder_items = userorder_items;
	}
	
	@Override
	public String toString() {
		return "UserorderView [id=" + id + ", order_no=" + order_no + ", user_id=" + user_id + ", user=" + user
				+ ", address=" + address + ", shipping_id=" + shipping_id + ", payment=" + payment + ", payment_type="
				+ payment_type + ", postage=" + postage + ", status=" + status + ", payment_time=" + payment_time
				+ ", send_time=" + send_time + ", _end_time=" + _end_time + ", _create_time=" + _create_time
				+ ", _update_time=" + _update_time + ", _close_time=" + _close_time + ", userorder_items="
				+ userorder_items + "]";
	}
	//将Userorder的实体类转为UserorderView实体类
	public void convertUerorderToUserorderView(Userorder userorder) {
		this.id=userorder.getId();
		this.order_no=userorder.getOrder_no();
		this.user_id=userorder.getUser_id();
		this.user=userorder.getUser();
		this.address=userorder.getAddress();
		this.shipping_id=userorder.getShipping_id();
		this.payment=userorder.getPayment();
		
		Integer payment_type=userorder.getPayment_type();
		if(payment_type==Payment.ONLINE.getType()) {
			this.payment_type="在线支付";
		}else if (payment_type==Payment.OFFLINE.getType()) {
			this.payment_type="货到付款";
		}
		this.postage=userorder.getPostage();
		
		Integer status=userorder.getStatus();
		if(status==Order.CANCEL.getStatus()) {
			this.status="已取消";
		}else if (status==Order.UNPAY.getStatus()) {
			this.status="未付款";
		}else if (status==Order.PAY.getStatus()) {
			this.status="已付款";
		}else if (status==Order.SEND.getStatus()) {
			this.status="已发货";
		}else if (status==Order.SUCCESS.getStatus()) {
			this.status="交易成功";
		}else if (status==Order.CLOSE.getStatus()) {
			this.status="交易关闭";
		}
		
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.payment_time=format.format(userorder.getPayment_time().getTime());
		this.send_time=format.format(userorder.getSend_time().getTime());
		this._end_time=format.format(userorder.getEnd_time().getTime());
		this._close_time=format.format(userorder.getClose_time().getTime());
		Date create_time=userorder.getCreate_time();
		this._create_time=format.format(create_time.getTime());
		this._update_time=format.format(userorder.getUpdate_time().getTime());
		this.userorder_items=userorder.getUserorder_items();
	}
	
}

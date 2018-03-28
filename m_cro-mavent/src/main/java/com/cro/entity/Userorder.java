package com.cro.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
/**
 * ¶©µ¥±í
 * */
public class Userorder {
private Integer	id;
private Long  order_no ;
private Integer	 user_id;
private User user;
private Address address;
private Integer	 shipping_id;
private BigDecimal	payment;
private Integer	 payment_type;
private Integer	 postage ;
private Integer 	status;
private Date	 payment_time ;
private Date	 send_time;
private Date	 end_time;
private Date    close_time;
private Date	 create_time;
private Date	 update_time;

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
public Integer getPayment_type() {
	return payment_type;
}
public void setPayment_type(Integer payment_type) {
	this.payment_type = payment_type;
}
public Integer getPostage() {
	return postage;
}
public void setPostage(Integer postage) {
	this.postage = postage;
}
public Integer getStatus() {
	return status;
}
public void setStatus(Integer status) {
	this.status = status;
}
public Date getPayment_time() {
	return payment_time;
}
public void setPayment_time(Date payment_time) {
	this.payment_time = payment_time;
}
public Date getSend_time() {
	return send_time;
}
public void setSend_time(Date send_time) {
	this.send_time = send_time;
}
public Date getEnd_time() {
	return end_time;
}
public void setEnd_time(Date end_time) {
	this.end_time = end_time;
}
public Date getClose_time() {
	return close_time;
}
public void setClose_time(Date close_time) {
	this.close_time = close_time;
}
public Date getCreate_time() {
	return create_time;
}
public void setCreate_time(Date create_time) {
	this.create_time = create_time;
}
public Date getUpdate_time() {
	return update_time;
}
public void setUpdate_time(Date update_time) {
	this.update_time = update_time;
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

public List<Userorder_item> getUserorder_items() {
	return userorder_items;
}
public void setUserorder_items(List<Userorder_item> userorder_items) {
	this.userorder_items = userorder_items;
}

public Userorder(Integer id, Long order_no, Integer user_id, User user, Address address, Integer shipping_id,
		BigDecimal payment, Integer payment_type, Integer postage, Integer status, Date payment_time, Date send_time,
		Date end_time, Date close_time, Date create_time, Date update_time, List<Userorder_item> userorder_items) {
	super();
	this.id = id;
	this.order_no = order_no;
	this.user_id = user_id;
	this.user = user;
	this.address = address;
	this.shipping_id = shipping_id;
	this.payment = payment;
	this.payment_type = payment_type;
	this.postage = postage;
	this.status = status;
	this.payment_time = payment_time;
	this.send_time = send_time;
	this.end_time = end_time;
	this.close_time = close_time;
	this.create_time = create_time;
	this.update_time = update_time;
	this.userorder_items = userorder_items;
}
public Userorder() {
	super();
}
@Override
public String toString() {
	return "Userorder [id=" + id + ", order_no=" + order_no + ", user_id=" + user_id + ", user=" + user + ", address="
			+ address + ", shipping_id=" + shipping_id + ", payment=" + payment + ", payment_type=" + payment_type
			+ ", postage=" + postage + ", status=" + status + ", payment_time=" + payment_time + ", send_time="
			+ send_time + ", end_time=" + end_time + ", close_time=" + close_time + ", create_time=" + create_time
			+ ", update_time=" + update_time + ", userorder_items=" + userorder_items + "]";
}


}

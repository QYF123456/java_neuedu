package com.cro.entity;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * ¶©µ¥Ã÷Ï¸±í
 * */
public class UserorderItemView {
private Integer	 item_id;
private Long  order_no;
private Integer  user_id;
private User user;
private Integer  product_id;
private String	 product_name;
private String	 product_image;
private BigDecimal	current_unit_price;
private	Integer  quantity;
private BigDecimal	 total_price;
private	String   create_time;
private	String	update_time;


public Integer getItem_id() {
	return item_id;
}
public void setItem_id(Integer item_id) {
	this.item_id = item_id;
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
public Integer getProduct_id() {
	return product_id;
}
public void setProduct_id(Integer product_id) {
	this.product_id = product_id;
}
public String getProduct_name() {
	return product_name;
}
public void setProduct_name(String product_name) {
	this.product_name = product_name;
}
public String getProduct_image() {
	return product_image;
}
public void setProduct_image(String product_image) {
	this.product_image = product_image;
}
public BigDecimal getCurrent_unit_price() {
	return current_unit_price;
}
public void setCurrent_unit_price(BigDecimal current_unit_price) {
	this.current_unit_price = current_unit_price;
}
public Integer getQuantity() {
	return quantity;
}
public void setQuantity(Integer quantity) {
	this.quantity = quantity;
}
public BigDecimal getTotal_price() {
	return total_price;
}
public void setTotal_price(BigDecimal total_price) {
	this.total_price = total_price;
}
public String getCreate_time() {
	return create_time;
}
public void setCreate_time(String create_time) {
	this.create_time = create_time;
}
public String getUpdate_time() {
	return update_time;
}
public void setUpdate_time(String update_time) {
	this.update_time = update_time;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public UserorderItemView(Integer item_id, Long order_no, Integer user_id, User user, Integer product_id,
		String product_name, String product_image, BigDecimal current_unit_price, Integer quantity,
		BigDecimal total_price, String create_time, String update_time) {
	super();
	this.item_id = item_id;
	this.order_no = order_no;
	this.user_id = user_id;
	this.user = user;
	this.product_id = product_id;
	this.product_name = product_name;
	this.product_image = product_image;
	this.current_unit_price = current_unit_price;
	this.quantity = quantity;
	this.total_price = total_price;
	this.create_time = create_time;
	this.update_time = update_time;
}
public UserorderItemView() {
	super();
}
@Override
public String toString() {
	return "UserorderItemView [item_id=" + item_id + ", order_no=" + order_no + ", user_id=" + user_id + ", user="
			+ user + ", product_id=" + product_id + ", product_name=" + product_name + ", product_image="
			+ product_image + ", current_unit_price=" + current_unit_price + ", quantity=" + quantity + ", total_price="
			+ total_price + ", create_time=" + create_time + ", update_time=" + update_time + "]";
}

public void convertUerorderItemToUserorderItemView(Userorder_item userorder_item) {
	this.item_id=userorder_item.getItem_id();
	this.order_no=userorder_item.getOrder_no();
	this.user_id=userorder_item.getUser_id();
	this.product_id=userorder_item.getProduct_id();
	this.product_name=userorder_item.getProduct_name();
	this.product_image=userorder_item.getProduct_image();
	this.current_unit_price=userorder_item.getCurrent_unit_price();
	this.quantity=userorder_item.getQuantity();
	this.total_price=userorder_item.getTotal_price();
	SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	this.create_time=format.format(userorder_item.getCreate_time().getTime());
	this.update_time=format.format(userorder_item.getUpdate_time().getTime());
}

}

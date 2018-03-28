package com.cro.entity.view;


import java.text.SimpleDateFormat;

import com.cro.entity.Cart;
import com.cro.entity.Product;
import com.cro.entity.User;

public class Cartvo {
	private int id;
	private int user_id;
	private User user;
	private int product_id;
	private Product product;
	private int quantity;
	private int checked;
	private String create_time;
	private String  update_time;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getChecked() {
		return checked;
	}
	public void setChecked(int checked) {
		this.checked = checked;
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
	public Cartvo(int id, int user_id, User user, int product_id, Product product, int quantity, int checked,
			String create_time, String update_time) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.user = user;
		this.product_id = product_id;
		this.product = product;
		this.quantity = quantity;
		this.checked = checked;
		this.create_time = create_time;
		this.update_time = update_time;
	}
	public Cartvo() {
		super();
	}
	@Override
	public String toString() {
		return "Cartvo [id=" + id + ", user_id=" + user_id + ", user=" + user + ", product_id=" + product_id
				+ ", product=" + product + ", quantity=" + quantity + ", checked=" + checked + ", create_time="
				+ create_time + ", update_time=" + update_time + "]";
	}
	public void converCartToCartVo(Cart cart) {
		this.id=cart.getId();
		this.user_id=cart.getUser_id();
		this.user=cart.getUser();
		this.product_id=cart.getProduct_id();
		this.product=cart.getProduct();
		this.quantity=cart.getQuantity();
		this.checked=cart.getChecked();
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.create_time=format.format(cart.getCreate_time().getTime());
		this.update_time=format.format(cart.getUpdate_time().getTime());
	}
}

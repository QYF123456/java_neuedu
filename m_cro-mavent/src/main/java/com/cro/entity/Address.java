package com.cro.entity;

import java.util.Date;

public class Address {
	private int id;
	private int user_id;
	private String receiver_name;
	private String receiver_phone;
	private String receiver_mobile;
	private String receiver_provinc;
	private String receiver_city;
	private String receiver_district;
	private String receiver_address;
	private String receiver_zip;
	private Date create_time;
	private Date update_time;
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
	public String getReceiver_name() {
		return receiver_name;
	}
	public void setReceiver_name(String receiver_name) {
		this.receiver_name = receiver_name;
	}
	public String getReceiver_phone() {
		return receiver_phone;
	}
	public void setReceiver_phone(String receiver_phone) {
		this.receiver_phone = receiver_phone;
	}
	public String getReceiver_mobile() {
		return receiver_mobile;
	}
	public void setReceiver_mobile(String receiver_mobile) {
		this.receiver_mobile = receiver_mobile;
	}
	public String getReceiver_provinc() {
		return receiver_provinc;
	}
	public void setReceiver_provinc(String receiver_provinc) {
		this.receiver_provinc = receiver_provinc;
	}
	public String getReceiver_city() {
		return receiver_city;
	}
	public void setReceiver_city(String receiver_city) {
		this.receiver_city = receiver_city;
	}
	public String getReceiver_district() {
		return receiver_district;
	}
	public void setReceiver_district(String receiver_district) {
		this.receiver_district = receiver_district;
	}
	public String getReceiver_address() {
		return receiver_address;
	}
	public void setReceiver_address(String receiver_address) {
		this.receiver_address = receiver_address;
	}
	public String getReceiver_zip() {
		return receiver_zip;
	}
	public void setReceiver_zip(String receiver_zip) {
		this.receiver_zip = receiver_zip;
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
	
	public Address(int id, int user_id, String receiver_name, String receiver_phone, String receiver_mobile,
			String receiver_provinc, String receiver_city, String receiver_district, String receiver_address,
			String receiver_zip, Date create_time, Date update_time) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.receiver_name = receiver_name;
		this.receiver_phone = receiver_phone;
		this.receiver_mobile = receiver_mobile;
		this.receiver_provinc = receiver_provinc;
		this.receiver_city = receiver_city;
		this.receiver_district = receiver_district;
		this.receiver_address = receiver_address;
		this.receiver_zip = receiver_zip;
		this.create_time = create_time;
		this.update_time = update_time;
	}
	public Address() {
		super();
	}
	
	public Address(int id, int user_id, String receiver_name, String receiver_phone, String receiver_mobile,
			String receiver_provinc, String receiver_city, String receiver_district, String receiver_address,
			String receiver_zip) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.receiver_name = receiver_name;
		this.receiver_phone = receiver_phone;
		this.receiver_mobile = receiver_mobile;
		this.receiver_provinc = receiver_provinc;
		this.receiver_city = receiver_city;
		this.receiver_district = receiver_district;
		this.receiver_address = receiver_address;
		this.receiver_zip = receiver_zip;
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", user_id=" + user_id + ", receiver_name=" + receiver_name + ", receiver_phone="
				+ receiver_phone + ", receiver_mobile=" + receiver_mobile + ", receiver_provinc=" + receiver_provinc
				+ ", receiver_city=" + receiver_city + ", receiver_district=" + receiver_district
				+ ", receiver_address=" + receiver_address + ", receiver_zip=" + receiver_zip + ", create_time="
				+ create_time + ", update_time=" + update_time + "]";
	}
	
}

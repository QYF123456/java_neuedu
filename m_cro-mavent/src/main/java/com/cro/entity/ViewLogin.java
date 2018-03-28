package com.cro.entity;

import java.io.Serializable;

public class ViewLogin implements Serializable {
	
	public static final int LOGIN_SUCC=1;
	public static final int LOGIN_FAIL=0;
	
	/**
	 * 1  ³É¹¦
	 * 0 Ê§°Ü
	 * */
	private int errno;
	private String message;
	private User user;
	public int getErrno() {
		return errno;
	}
	public void setErrno(int errno) {
		this.errno = errno;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}

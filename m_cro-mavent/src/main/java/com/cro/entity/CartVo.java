package com.cro.entity;

import com.cro.entity.view.Cartvo;

public class CartVo {
	public static final int CART_SUCCESS=1;
	public static final int CART_LOGIN=0;
	
	private int errno;
	private String message;
	private PageModel<Cartvo> pageModel;
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
	public PageModel<Cartvo> getPageModel() {
		return pageModel;
	}
	public void setPageModel(PageModel<Cartvo> pageModel) {
		this.pageModel = pageModel;
	}
	@Override
	public String toString() {
		return "CartVo [errno=" + errno + ", message=" + message + ", pageModel=" + pageModel + "]";
	}
	

}

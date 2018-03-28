package com.cro.Chli;
/**
 * 订单状态  0-已取消 10-未付款 20-已付款 40-已发货 50-交易成功 60-交易关闭
 * */
public enum Order {
	CANCEL(0,"已取消"),
	UNPAY(10,"未付款"),
	PAY(20,"已付款"),
	SEND(40,"已发货"),
	SUCCESS(50,"交易成功"),
	CLOSE(60,"交易关闭");
	
	private int status;
	private  String message;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	private Order(int status, String message) {
		this.status = status;
		this.message = message;
	}
	 
}

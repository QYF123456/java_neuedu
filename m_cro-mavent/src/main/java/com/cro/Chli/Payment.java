package com.cro.Chli;

public enum Payment {
	
	ONLINE(1,"����֧��"),
	OFFLINE(2,"��������");
	private int type;
	private  String message;
	private Payment(int type, String message) {
		this.type = type;
		this.message = message;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}

package com.cro.Chli;

public enum Categorystatus {
	//ONLINE(1,"在线支付"),
	CHANGXIAO(1,"畅销"),
	XIAJIA(0,"下架");
	private int type;
	private  String message;
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
	private Categorystatus(int type, String message) {
		this.type = type;
		this.message = message;
	}
	

}

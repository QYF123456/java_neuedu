package com.cro.Chli;

public enum Categorystatus {
	//ONLINE(1,"����֧��"),
	CHANGXIAO(1,"����"),
	XIAJIA(0,"�¼�");
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

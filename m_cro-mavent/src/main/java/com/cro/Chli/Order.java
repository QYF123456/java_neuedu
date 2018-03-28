package com.cro.Chli;
/**
 * ����״̬  0-��ȡ�� 10-δ���� 20-�Ѹ��� 40-�ѷ��� 50-���׳ɹ� 60-���׹ر�
 * */
public enum Order {
	CANCEL(0,"��ȡ��"),
	UNPAY(10,"δ����"),
	PAY(20,"�Ѹ���"),
	SEND(40,"�ѷ���"),
	SUCCESS(50,"���׳ɹ�"),
	CLOSE(60,"���׹ر�");
	
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

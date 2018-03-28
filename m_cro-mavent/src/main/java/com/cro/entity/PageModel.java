package com.cro.entity;

import java.io.Serializable;
import java.util.List;

public class PageModel<T> implements Serializable {
	//每一页的数据集合
	private List<T> data;
	//总共有多少页
	private int totalPage;
	
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public PageModel(List<T> data, int totalPage) {
		super();
		this.data = data;
		this.totalPage = totalPage;
	}
	public PageModel() {
		super();
	}
	@Override
	public String toString() {
		return "PageModel [data=" + data + ", totalPage=" + totalPage + "]";
	}

	
}

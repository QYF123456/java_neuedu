package com.cro.entity.view;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.cro.Chli.Categorystatus;
import com.cro.entity.Category;

public class CategoryView {
	private int id;
	private int parent_id;
	private String name;
	private String status;
	private int sort_order;
	private String create_time;
	private String update_time;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getParent_id() {
		return parent_id;
	}
	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getSort_order() {
		return sort_order;
	}
	public void setSort_order(int sort_order) {
		this.sort_order = sort_order;
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
	
	@Override
	public String toString() {
		return "CategoryView [id=" + id + ", parent_id=" + parent_id + ", name=" + name + ", status=" + status
				+ ", sort_order=" + sort_order + ", create_time=" + create_time + ", update_time=" + update_time + "]";
	}
	//将Category的实体类转换为CategoryView
	public void CategoryToCateGoryView(Category category) {
		this.id=category.getId();
		this.parent_id=category.getParent_id();
		this.name=category.getName();
		Integer status=category.getStatus();
		if(status==Categorystatus.CHANGXIAO.getType()) {
			this.status="畅销";
		}else if (status==Categorystatus.XIAJIA.getType()) {
			this.status="下架";
		}
		this.sort_order=category.getSort_order();
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.create_time=format.format(category.getCreate_time().getTime());
		this.update_time=format.format(category.getUpdate_time().getTime());
	}
	
	
}

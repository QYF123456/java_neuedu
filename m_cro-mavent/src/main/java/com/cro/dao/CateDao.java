package com.cro.dao;

import java.util.List;

import com.cro.entity.Category;
import com.cro.entity.PageModel;

public interface CateDao {
	//分页
	public PageModel<Category> FindAllCateByPage(int pageNo,int pageSize);
	//查询全部信息
	public List<Category> FindAllCate();
	//根据id删除信息
	public int deleteCateById(Integer id);
	//添加类别信息
	public int insertCategory(Category cat);
	//根据id查找类别信息
	public Category findCategorybyid(Integer id);
	//根据id修改信息
	public int UpdateCategory(Category cat,Integer id);
	
}

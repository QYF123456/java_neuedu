package com.cro.service;

import java.util.List;

import com.cro.entity.Category;
import com.cro.entity.PageModel;
import com.cro.entity.view.CategoryView;

public interface CateServicel {
	public PageModel<CategoryView> findAllCateService(Integer pageNo,Integer pageSize);
	public List<Category> FindAllCate();
    public int deleteCateById(Integer id);
    public int insertEmp(Category cat);
    public Category findCategorybyid(Integer id);
    public int UpdateCategory(Category cat,Integer id); 
}

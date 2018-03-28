package com.cro.servicel.impl;

import java.util.ArrayList;
import java.util.List;

import com.cro.dao.CateDao;
import com.cro.dao.batisimpl.CateDaoBatisImpl;
import com.cro.dao.impl.CateDaoImpl;
import com.cro.entity.Category;
import com.cro.entity.PageModel;
import com.cro.entity.view.CategoryView;
import com.cro.service.CateServicel;

public class CateServiceimpl implements CateServicel {
	
	//CateDao catqa=CateDaoImpl.getInstance();
	CateDao catqa=CateDaoBatisImpl.getInstance();
	
	@Override
	public List<Category> FindAllCate() {
		// TODO Auto-generated method stub
		
		return catqa.FindAllCate();
	}

	@Override
	public PageModel<CategoryView> findAllCateService(Integer pageNo, Integer pageSize) {
		// TODO Auto-generated method stub
		
		PageModel<Category> pageModel= catqa.FindAllCateByPage(pageNo, pageSize);
		 return CategoryToCateGoryView(pageModel);
	}

	@Override
	public int deleteCateById(Integer id) {
		// TODO Auto-generated method stub
		
		return catqa.deleteCateById(id);
	}

	@Override
	public int insertEmp(Category cat) {
		// TODO Auto-generated method stub
		
		return catqa.insertCategory(cat);
	}

	@Override
	public Category findCategorybyid(Integer id) {
		// TODO Auto-generated method stub
		
		return catqa.findCategorybyid(id);
	}

	@Override
	public int UpdateCategory(Category cat,Integer id) {
		// TODO Auto-generated method stub
		
		return catqa.UpdateCategory(cat, id);
	}

	/**
	 * 将Category实体类转换为CategoryView
	 * */
	public PageModel<CategoryView> CategoryToCateGoryView(PageModel<Category> pageModel){
		PageModel<CategoryView> pageModelcateView=new PageModel<CategoryView>();
		if(pageModel!=null) {
			List<CategoryView> list=new ArrayList<CategoryView>();
			List<Category> cateview=pageModel.getData();
			for(Category cat:cateview) {
				CategoryView categoryView=new CategoryView();
				categoryView.CategoryToCateGoryView(cat);
				list.add(categoryView);
			}
			pageModelcateView.setData(list);
			pageModelcateView.setTotalPage(pageModel.getTotalPage());
		}
		
		return pageModelcateView;
	}
	

}

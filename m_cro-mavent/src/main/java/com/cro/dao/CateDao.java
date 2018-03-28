package com.cro.dao;

import java.util.List;

import com.cro.entity.Category;
import com.cro.entity.PageModel;

public interface CateDao {
	//��ҳ
	public PageModel<Category> FindAllCateByPage(int pageNo,int pageSize);
	//��ѯȫ����Ϣ
	public List<Category> FindAllCate();
	//����idɾ����Ϣ
	public int deleteCateById(Integer id);
	//��������Ϣ
	public int insertCategory(Category cat);
	//����id���������Ϣ
	public Category findCategorybyid(Integer id);
	//����id�޸���Ϣ
	public int UpdateCategory(Category cat,Integer id);
	
}

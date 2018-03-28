package com.cro.dao.batisimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.cro.common.MyBatis;
import com.cro.dao.CateDao;
import com.cro.entity.Category;
import com.cro.entity.PageModel;

public class CateDaoBatisImpl implements CateDao {
	private  static CateDao cateDao=null;
	public static CateDao getInstance() {
		synchronized(CateDaoBatisImpl.class) {
			if(cateDao==null) {
				cateDao=new CateDaoBatisImpl();
			}
		}
		return cateDao;
	}
		
	@Override
	public PageModel<Category> FindAllCateByPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		SqlSessionFactory factory= MyBatis.getSqlSessionFactory();
		SqlSession session= factory.openSession();
		//1.查询总的记录数
		int totalcount=session.selectOne("com.cro.entity.PageModel.findTotalCount");
		//2.查询某页面的数据
		Map<Object, Object> map=new HashMap<Object,Object>();
		map.put("offset",(pageNo-1)*pageSize);
		map.put("pageSize", pageSize);
		List<Category> cat=session.selectList("com.cro.entity.PageModel.FindAllCateByPage", map);
		PageModel<Category> pageModel=new PageModel<Category>();
		pageModel.setData(cat);
		pageModel.setTotalPage((totalcount%pageSize)==0?totalcount/pageSize:(totalcount/pageSize+1));
		return pageModel;
	}

	@Override
	public List<Category> FindAllCate() {
		// TODO Auto-generated method stub
		SqlSessionFactory factory= MyBatis.getSqlSessionFactory();
		SqlSession session= factory.openSession();
		List<Category> categories=session.selectList("com.cro.entity.PageModel.FindAllCate");
		return categories;
	}

	@Override
	public int deleteCateById(Integer id) {
		// TODO Auto-generated method stub
		SqlSessionFactory factory= MyBatis.getSqlSessionFactory();
		SqlSession session= factory.openSession();
		int i=session.update("com.cro.entity.PageModel.deleteCateById", id);
		session.commit();
		return i;
	}

	@Override
	public int insertCategory(Category cat) {
		// TODO Auto-generated method stub
		SqlSessionFactory factory= MyBatis.getSqlSessionFactory();
		SqlSession session= factory.openSession();
		int i=session.insert("com.cro.entity.PageModel.insertCategory", cat);
		session.commit();
		return i;
	}

	@Override
	public Category findCategorybyid(Integer id) {
		// TODO Auto-generated method stub
		SqlSessionFactory factory= MyBatis.getSqlSessionFactory();
		SqlSession session= factory.openSession();
		Category category=session.selectOne("com.cro.entity.PageModel.findCategorybyid", id);
		return category;
	}

	@Override
	public int UpdateCategory(Category cat,Integer id) {
		// TODO Auto-generated method stub
		SqlSessionFactory factory= MyBatis.getSqlSessionFactory();
		SqlSession session= factory.openSession();
		Map<Object, Object> map=new HashMap<Object,Object>();
		map.put("cat", cat);
		map.put("id", id);
		int i=session.update("com.cro.entity.PageModel.UpdateCategory", map);
		session.commit();
		return i;
	}

	

}

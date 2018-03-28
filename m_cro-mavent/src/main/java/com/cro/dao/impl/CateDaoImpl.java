package com.cro.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cro.common.DBUtils;
import com.cro.dao.CateDao;
import com.cro.entity.Category;
import com.cro.entity.PageModel;

public   class CateDaoImpl implements CateDao{
private  static CateDao cateDao=null;
	
	public CateDaoImpl() {}
	
	public static  CateDao getInstance() {
		synchronized(CateDaoImpl.class) {
			if(cateDao==null) {
				cateDao=new CateDaoImpl();
			}
		}
		return cateDao;
	}
	@Override
	public PageModel<Category> FindAllCateByPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<Category> list=new ArrayList<Category>();
		PageModel<Category> pm=new PageModel<Category>();
		try {
			conn=DBUtils.getConnection();
			//根据id查询总的记录数
			String sql="select count(id) from category";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			if(rs.next()) {
				int totalCount=rs.getInt(1);//总的记录
				 //计算共多少页
				 int totalPage= (totalCount%pageSize)==0?totalCount/pageSize:(totalCount/pageSize+1);
				 pm.setTotalPage(totalPage);
			}
			ps=conn.prepareStatement("select * from category limit ?,?");
			ps.setInt(1, (pageNo-1)*pageSize);
			ps.setInt(2, pageSize);
			rs=ps.executeQuery();
			while(rs.next()) {
				Category cate=new Category(rs.getInt("id"), rs.getInt("parent_id"), rs.getString("name"), rs.getInt("status"), rs.getInt("sort_order"), rs.getDate("create_time"), rs.getDate("update_time"));
				list.add(cate);
			}
			pm.setData(list); 
			System.out.println(pm+"++++++++++");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				DBUtils.close(conn, ps, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return pm;
	}
	@Override
	/**
	 * 查询全部信息
	 * */
	public List<Category> FindAllCate() {
		List<Category> list=new ArrayList<Category>();
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			conn=DBUtils.getConnection();
			pst=conn.prepareStatement("select * from category");
		     
			rs=pst.executeQuery();
			
			while(rs.next()) {
	
				Category cat=new Category(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getDate(6), rs.getDate(7));
				list.add(cat);
			}
		    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				DBUtils.close(conn, pst, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public int deleteCateById(Integer id) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pst=null;
		try {
			conn=DBUtils.getConnection();
			String sql="delete from category where id=?";
			pst=conn.prepareStatement(sql);
			pst.setInt(1, id);
			
			int i= pst.executeUpdate();
			System.out.println("i 到层="+i);
			 return i;
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				DBUtils.close(conn, pst);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return 0;
	}

	@Override
	public int insertCategory(Category cat) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pst=null;
		try {
			conn=DBUtils.getConnection();
			String sql="insert into category (id,parent_id,name,status,create_time,update_time)value(?,?,?,?,now(),now()) ";
			pst=conn.prepareStatement(sql);
			pst.setInt(1,cat.getId());
			pst.setInt(2,cat.getParent_id());
			pst.setString(3,cat.getName());
			pst.setInt(4,cat.getStatus());
			int count=pst.executeUpdate();
			if(count>0) {
				return 1;
			}else {
				return 0;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				DBUtils.close(conn, pst);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}

	@Override
	public Category findCategorybyid(Integer id) {
		// TODO Auto-generated method stub
		Category cat=null;
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			conn=DBUtils.getConnection();
			String sql="select * from category where id=?";
			pst=conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs=pst.executeQuery();
			if(rs.next()) {
				int _id=rs.getInt("id");
				int _parent_id=rs.getInt("parent_id");
				String _name=rs.getString("name");
				int _status=rs.getInt("status");
				int _sort_order=rs.getInt("sort_order");
				Date _create_time=rs.getDate("create_time");
				Date _udate_time=rs.getDate("update_time");
				cat=new Category(_id, _parent_id, _name, _status, _sort_order, _create_time, _udate_time);
				
				}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				DBUtils.close(conn, pst, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return cat;
	}

	@Override
	public int UpdateCategory(Category cat,Integer id) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pst=null;
		try {
			conn=DBUtils.getConnection();
			String sql="update category set parent_id=?,name=?,status=? where id=?";
			pst=conn.prepareStatement(sql);
			pst.setInt(1,cat.getParent_id());
			pst.setString(2, cat.getName());
			pst.setInt(3, cat.getStatus());
			pst.setInt(4, cat.getId());
			return pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				DBUtils.close(conn, pst);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return 0;
	}

	
}

package com.cro.dao.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.cro.common.DBUtils;
import com.cro.common.MyBatis;
import com.cro.dao.ProductDao;
import com.cro.entity.PageModel;
import com.cro.entity.Product;

public class ProductImpl implements ProductDao {
private  static ProductDao productDao=null;
	
	public ProductImpl() {}
	
	public static  ProductDao getInstance() {
		synchronized(ProductImpl.class) {
			if(productDao==null) {
				productDao=new ProductImpl();
			}
		}
		return productDao;
	}
	
	@Override
	public PageModel<Product> FindAllProductByPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<Product> list=new ArrayList<Product>();
		PageModel<Product> pm=new PageModel<Product>();
		try {
			conn=DBUtils.getConnection();
			//根据id查询总的记录数
			String sql="select count(id) from product";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			if(rs.next()) {
				int totalCount=rs.getInt(1);//总的记录
				System.out.println(totalCount+"+++++++++");
				 //计算共多少页
				 int totalPage= (totalCount%pageSize)==0?totalCount/pageSize:(totalCount/pageSize+1);
				 pm.setTotalPage(totalPage);
			}
			ps=conn.prepareStatement("select * from product limit ?,?");
			ps.setInt(1, (pageNo-1)*pageSize);
			ps.setInt(2, pageSize);
			rs=ps.executeQuery();
			while(rs.next()) {
				Product pdt=new Product(rs.getInt("id"),rs.getInt("category_id"),rs.getString("name"),rs.getString("subtitle"),rs.getString("main_image"),rs.getString("sub_images"),rs.getString("detail"),rs.getBigDecimal("price"),rs.getInt("stock"),rs.getInt("status"),rs.getDate("create_time"),rs.getDate("update_time"));
				list.add(pdt);
			}
			pm.setData(list); 
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

/**
 * 查询全部商品信息
 * */
	@Override
	public List<Product> FindAllProduct() {
		// TODO Auto-generated method stub
		List<Product> list=new ArrayList<Product>();
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			conn=DBUtils.getConnection();
			pst=conn.prepareStatement("select * from product ");
		     
			rs=pst.executeQuery();
			
			while(rs.next()) {
				Product pdt=new Product(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getBigDecimal(8),rs.getInt(9),rs.getInt(10),rs.getDate(11),rs.getDate(12));
				list.add(pdt);
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
/**
 * 删除商品信息
 * */
@Override
public int deleteProductById(Integer id) {
	// TODO Auto-generated method stub
	Connection conn=null;
	PreparedStatement pst=null;
	try {
		conn=DBUtils.getConnection();
		String sql="delete from product where id=?";
		pst=conn.prepareStatement(sql);
		pst.setInt(1, id);
		 int i=pst.executeUpdate();
		 System.out.println(i+"========");
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
/**
 * 添加商品信息
 * */
@Override
public int insertProduct(Product pdt) {
	// TODO Auto-generated method stub
	Connection conn=null;
	PreparedStatement pst=null;
	try {
		conn=DBUtils.getConnection();
		String sql="insert into product (category_id,name,subtitle,main_image,sub_images,detail,price,stock,status,create_time,update_time) values(?,?,?,?,?,?,?,?,?,now(),now()) ";

		pst=conn.prepareStatement(sql);
		pst.setInt(1,pdt.getCategory_id());
		pst.setString(2,pdt.getName());
		pst.setString(3,pdt.getSubtitle());
		pst.setString(4, pdt.getMain_image());
		pst.setString(5, pdt.getSub_images());
		pst.setString(6, pdt.getDetail());
		pst.setBigDecimal(7, pdt.getPrice());
		pst.setInt(8, pdt.getStock());
		pst.setInt(9, pdt.getStatus());
		
		int count=pst.executeUpdate();
		System.out.println(count);
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
public Product findProductById(Integer id) {
	// TODO Auto-generated method stub
	Product pdt=null;
	Connection conn=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	try {
		conn=DBUtils.getConnection();
		pst=conn.prepareStatement("select * from product where id=? ");
	     pst.setInt(1, id);
		rs=pst.executeQuery();
		
		if(rs.next()) {
			int _id=rs.getInt("id");
			int _category_id=rs.getInt("category_id");
			String _name=rs.getString("name");
			String _subtitle=rs.getString("subtitle");
			String _main_image=rs.getString("main_image");
			String _sub_images=rs.getString("sub_images");
			String _detail=rs.getString("detail");
			BigDecimal _price=rs.getBigDecimal("price");
			int _stock=rs.getInt("stock");
			int _status=rs.getInt("status");
			Date _create_time=rs.getDate("create_time");
			Date _update_time=rs.getDate("update_time");
			pdt=new Product(_id, _category_id, _name, _subtitle, _main_image, _sub_images, _detail, _price, _stock, _status, _create_time, _update_time);
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
	return pdt;
}
@Override
public int updateProduct(Product pdt) {
	// TODO Auto-generated method stub
	Connection conn=null;
	PreparedStatement pst=null;
	System.out.println(pdt);
	try {
		conn=DBUtils.getConnection();
		String sql="update product set category_id=?, name=?,subtitle=?,main_image=?,sub_images=?,detail=?,price=?,stock=?,status=? where id=?";
		pst=conn.prepareStatement(sql);
		pst.setInt(1, pdt.getCategory_id());
		pst.setString(2,pdt.getName());
		pst.setString(3,pdt.getSubtitle());
		pst.setString(4, pdt.getMain_image());
		pst.setString(5, pdt.getSub_images());
		pst.setString(6, pdt.getDetail());
		pst.setBigDecimal(7, pdt.getPrice());
		pst.setInt(8, pdt.getStock());
		pst.setInt(9, pdt.getStatus());
		pst.setInt(10, pdt.getId());
		System.out.println(pst);
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

@Override
public int findstock(Integer id) {
	// TODO Auto-generated method stub
	SqlSessionFactory factory=MyBatis.getSqlSessionFactory();
	SqlSession session=factory.openSession(true);
	int i=session.selectOne("com.cro.entity.Product.findstock", id);
	session.close();
	return i;
}

@Override
public int updatestock(Integer id, Integer quantity) {
	// TODO Auto-generated method stub
	SqlSessionFactory factory=MyBatis.getSqlSessionFactory();
	SqlSession session=factory.openSession(true);
	Map<String, Integer> map=new HashMap<String,Integer>();
	map.put("id", id);
	map.put("quantity", quantity);
	int i=session.update("com.cro.entity.Product.updatestock", map);
	session.close();
	return i;
}




}

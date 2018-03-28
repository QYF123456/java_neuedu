package com.cro.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cro.common.DBUtils;
import com.cro.dao.LoginDao;
import com.cro.entity.User;



public class LoginDaoImpl  implements LoginDao{
	@Override
	//通过从servlet层获取的请求信息中的用户名，在数据库中寻找该用户，若存在，返回1，否则返回0
	public int checkUserName(String username) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		try {
			conn=DBUtils.getConnection();
			String sql="select username from user where username=?";
			st=conn.prepareStatement(sql);
			st.setString(1, username);
			rs=st.executeQuery();
			if(rs.next()) {
				return 1;
			}else {
				return 0;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				DBUtils.close(conn, st, rs);
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return 0;
	}
	//通过从servlet层获取的请求信息中的用户名，在数据库中寻找该用户的用户名和密码，若存在，返回1，否则返回0
	@Override
	
	public User findUserandpwd(String username, String password) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		try {
			conn=DBUtils.getConnection();
			String sql="select id,username,password from user where username=? and password=?";
			st=conn.prepareStatement(sql);
			st.setString(1, username);
			st.setString(2, password);
			rs=st.executeQuery();
			if(rs.next()) {
				User user=new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				return user;
			}else {
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				DBUtils.close(conn, st, rs);
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
		return null;
	}
	@Override
	public int updateUsertookenById(Integer id, String tooken) {
		// TODO Auto-generated method stub
		
		Connection conn=null;
		PreparedStatement st=null;
		try {
			conn=DBUtils.getConnection();
			String sql="update user set tooken=? where id=?";
			
			st=conn.prepareStatement(sql);
			st.setString(1, tooken);
			st.setInt(2, id);
			return st.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				DBUtils.close(conn, st);
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
		return 0;
		
		}
	@Override
	public User finUserBytooken(String tooken) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		try {
			conn=DBUtils.getConnection();
			String sql="select username,password from user where tooken=?";
			st=conn.prepareStatement(sql);
			st.setString(1, tooken);
			rs=st.executeQuery();
			if(rs.next()) {
				User user=new User();
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				return user;
			}else {
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				DBUtils.close(conn, st, rs);
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
		return null;
	}

}

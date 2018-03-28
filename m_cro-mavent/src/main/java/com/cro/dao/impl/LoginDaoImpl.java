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
	//ͨ����servlet���ȡ��������Ϣ�е��û����������ݿ���Ѱ�Ҹ��û��������ڣ�����1�����򷵻�0
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
	//ͨ����servlet���ȡ��������Ϣ�е��û����������ݿ���Ѱ�Ҹ��û����û��������룬�����ڣ�����1�����򷵻�0
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

package com.cro.common;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 工具类，操作数据库
 * 
 * */
public class DBUtils {

	 /**
	  * 定义Properties属性类
	  * */ 
	private  static  Properties ps=new Properties();
	
	
	/**
	 * 在静态的代码块中加载属性文件jdbc.properties
	 * */
     static {
		//从当前路径(classpath)下加载jdbc.properties文件
		InputStream is=Thread.currentThread().getContextClassLoader().getResourceAsStream("jdbc.properties");
	    try {
			ps.load(is);
			//step1:加载驱动
			Class.forName(ps.getProperty("driver"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
     /**
      * 获取连接
      * */
    public static Connection  getConnection() throws SQLException {
    	Connection conn=null;
    	
    	conn=DriverManager.getConnection(ps.getProperty("url"), ps.getProperty("user"), ps.getProperty("password"));
    	
    	return conn;
    }
     
    
    /**
     * 关闭连接
     * @throws SQLException 
     * */
    public  static void  close(Connection conn) throws SQLException {
    	conn.close();
    }
    public  static void  close(Connection conn,PreparedStatement st) throws SQLException {
    	conn.close();
    	st.close();
    }
    public  static void  close(Connection conn,Statement st) throws SQLException {
    	conn.close();
    	st.close();
    }
    
    public  static void  close(Connection conn,PreparedStatement st,ResultSet rs) throws SQLException {
    	conn.close();
    	st.close();
    	rs.close();
    }
    
     
	
}

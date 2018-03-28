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
 * �����࣬�������ݿ�
 * 
 * */
public class DBUtils {

	 /**
	  * ����Properties������
	  * */ 
	private  static  Properties ps=new Properties();
	
	
	/**
	 * �ھ�̬�Ĵ�����м��������ļ�jdbc.properties
	 * */
     static {
		//�ӵ�ǰ·��(classpath)�¼���jdbc.properties�ļ�
		InputStream is=Thread.currentThread().getContextClassLoader().getResourceAsStream("jdbc.properties");
	    try {
			ps.load(is);
			//step1:��������
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
      * ��ȡ����
      * */
    public static Connection  getConnection() throws SQLException {
    	Connection conn=null;
    	
    	conn=DriverManager.getConnection(ps.getProperty("url"), ps.getProperty("user"), ps.getProperty("password"));
    	
    	return conn;
    }
     
    
    /**
     * �ر�����
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

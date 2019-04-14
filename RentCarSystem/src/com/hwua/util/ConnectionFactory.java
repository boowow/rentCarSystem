package com.hwua.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class ConnectionFactory {
	private static String DRIVER;
	private static String URL;
	private static String UNAME;
	private static String UPASS;
	
	static {
		//读取配置信息，存储到四个静态属性中
		Properties prop = new Properties();
		try {
			prop.load(ConnectionFactory.class.
				getResourceAsStream(
						"jdbcinfo.properties"));
			DRIVER = prop.getProperty("driver");
			URL = prop.getProperty("url");
			UNAME = prop.getProperty("uname");
			UPASS = prop.getProperty("upass");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(
					URL,
					UNAME, 
					UPASS);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;	
	}
	
	/**
	 * 释放所有的资源
	 */
	public static void close(ResultSet rs,
			Statement stmt,Connection conn) {
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(stmt!=null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void close(Statement stmt,Connection conn) {
		close(null,stmt,conn);
	}
}

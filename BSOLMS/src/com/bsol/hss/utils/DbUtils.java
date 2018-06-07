package com.bsol.hss.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class DbUtils {
	private static String username="root";
	private static String password="Root";
	private static String dburl="jdbc:mysql://localhost:3306/bsol";
	private static String dirverClass="com.mysql.jdbc.Driver";
	
	/**
	 * 功能：获取数据库的连接
	 * @return
	 */
	public static Connection getConnection() {
		Connection con=null;
		
		try {
			Class.forName(dirverClass);//1.加载驱动
			con= DriverManager.getConnection(dburl, username, password);//2.获取连接
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("驱动没找到");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("获取连接失败");
		}
		
		return con;
	}
	/**
	 * 功能：关闭数据库的连接
	 * @param con
	 * @param st
	 */
	public static void close(Connection con, Statement st) {
		if(st!=null) {
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/**
	 * 功能：关闭数据库的连接
	 * @param con
	 * @param st
	 * @param rs
	 */
	public static void close(Connection con,Statement st,ResultSet rs) {
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(st!=null) {
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

package com.lovo.util;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * ���ݿ���Դ������
 * @author Ҷ����
 *
 */
public class DbResourceManager {
	private static final String JDBC_DRV = "com.mysql.jdbc.Driver";
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/hw";
	private static final String JDBC_UID = "root";
	private static final String JDBC_PWD = "MySql";
	
	private static Driver driver = null;
	private static Properties info = new Properties();
	
	private DbResourceManager() {
		throw new AssertionError();
	}

	static {	
		try {
			loadDriver();	// ͨ����̬�����������ݿ�����
			info.setProperty("user", JDBC_UID);
			info.setProperty("password", JDBC_PWD);
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static void setDriver(Driver _driver) {
		driver = _driver;
	}
	
	// ������������
	private static void loadDriver() throws Exception {
		driver = (Driver) Class.forName(JDBC_DRV).newInstance();
		DriverManager.registerDriver(driver);
	}
	
	/**
	 * ������
	 * @return ���Ӷ���
	 * @throws Exception �޷������������޷���������ʱ���׳��쳣
	 */
	public static Connection getConnection() throws Exception {
		if(driver == null) {
			loadDriver();
		}
		return driver.connect(JDBC_URL, info);
	}
	
	/**
	 * �ر��α�
	 */
	public static void close(ResultSet rs) {
		try {
			if(rs != null && !rs.isClosed()) {
				rs.close();
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * �ر����
	 */
	public static void close(Statement stmt) throws SQLException {
		try {
			if(stmt != null && !stmt.isClosed()) {
				stmt.close();
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * �ر�����
	 */
	public static void close(Connection con) {
		try {
			if(con != null && !con.isClosed()) {
				con.close();
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ע������
	 * @throws SQLException
	 */
	public static void unloadDriver() throws SQLException {
		if(driver != null) {
			DriverManager.deregisterDriver(driver);
			driver = null;
		}
	}
	
}
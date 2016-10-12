package com.mchr.wechat.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;

public class DBManager {

	private static DBManager instance;
	private HashMap<Integer, Connection> connections;
	private HashMap<String, PreparedStatement> statements;

	private DBManager() {

	}

	public static DBManager getDBManager() throws ClassNotFoundException, SQLException {
		if (instance == null) {
			instance = new DBManager();
			Class.forName("com.mysql.jdbc.Driver");
			instance.connections = new HashMap<Integer, Connection>();
		}

		return instance;
	}
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://120.76.139.37:3306/mcwechat?characterEncoding=utf-8", "mcuser","mc2016");
		//Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mcwechat?characterEncoding=utf-8", "mcuser","mc2016");
		return connection;
	}
	
	

//	public synchronized PreparedStatement  getStatement(String sql) throws SQLException {
//		
//		int threadId = Thread.currentThread().hashCode();
//		if(!connections.containsKey(threadId))
//		{
//			Connection connection = DriverManager.getConnection("jdbc:mysql://iweiqiu.com:3306/mcwechat", "root","snow2014");
//		}
//		
//		
//		instance.statements = new HashMap<String, PreparedStatement>();
//		
//		if (statements.containsKey(sql)) {
//			return statements.get(sql);
//		}
//
//		PreparedStatement statement = connection.prepareStatement(sql);
//		statements.put(sql, statement);
//		return statement;
//
//	}

}

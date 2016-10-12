package com.mchr.wechat.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mchr.wechat.common.DBManager;
import com.mchr.wechat.entity.Job;

public class JobDao {
	
	public static Job getJobDetail(int id)
	{
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			String sql = "select * from mc_wx_job  where ID = ?";
			connection = DBManager.getConnection();
			statement = connection.prepareStatement(sql);
			//statement = DBManager.getDBManager().getStatement(sql);
			statement.setInt(1, id);
			
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Job item = new Job();
				item.id = resultSet.getInt("ID");
				item.title = resultSet.getString("Title");
				item.description = resultSet.getString("Description");
				item.Requirement = resultSet.getString("Requirement");
				item.Courses = resultSet.getString("Courses");
				return item;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet!=null) {
					resultSet.close();
				}
				
				if(statement != null)
				{
					statement.close();
				}
				
				if(connection != null)
				{
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}
}

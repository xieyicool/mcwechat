package com.mchr.wechat.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mchr.wechat.common.DBManager;
import com.mchr.wechat.entity.News;

public class NewsDao {
	
	public static News getNewsDetail(int id)
	{
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			String sql = "select * from mc_wx_news  where ID = ?";
			connection = DBManager.getConnection();
			statement = connection.prepareStatement(sql);
			//statement = DBManager.getDBManager().getStatement(sql);
			statement.setInt(1, id);
			
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				
				News item = new News();
				
				item.id = resultSet.getInt("ID");
				item.title = resultSet.getString("Title");
				item.createTime = resultSet.getTimestamp("CreateTime");
				item.author = resultSet.getString("Author");
				item.content = resultSet.getString("Content");
				
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
	public static List<News> getNewsList(int page, int pageSize)
	{
		List<News> list = new ArrayList<News>();
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			String sql = "select * from mc_wx_news  order by CreateTime desc limit ?,?";
			connection = DBManager.getConnection();
			statement = connection.prepareStatement(sql);
			//statement = DBManager.getDBManager().getStatement(sql);
			statement.setInt(1, page);
			statement.setInt(2, pageSize);
			
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				
				News item = new News();
				
				item.id = resultSet.getInt("ID");
				item.title = resultSet.getString("Title");
				item.createTime = resultSet.getTimestamp("CreateTime");
				item.author = resultSet.getString("Author");
				item.content = resultSet.getString("Content");
				
				list.add(item);
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
		return list;
	}
}

package com.mchr.wechat.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mchr.wechat.common.DBManager;
import com.mchr.wechat.entity.Policy;

public class PolicyDao {
	
	public static List<Policy> getPolicyList(int page, int pageSize)
	{
		List<Policy> list = new ArrayList<Policy>();
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			String sql = "select * from mc_wx_policy  order by  CreateTime desc limit ?,?";
			connection = DBManager.getConnection();
			statement = connection.prepareStatement(sql);
			//statement = DBManager.getDBManager().getStatement(sql);
			statement.setInt(1, page);
			statement.setInt(2, pageSize);
			
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				
				Policy item = new Policy();
				
				item.id = resultSet.getInt("ID");
				item.title = resultSet.getString("Title");
				item.createTime = resultSet.getTimestamp("CreateTime");
				item.remark = resultSet.getString("Remark");
				
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

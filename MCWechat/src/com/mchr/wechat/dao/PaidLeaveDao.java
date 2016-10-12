package com.mchr.wechat.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mchr.wechat.common.DBManager;
import com.mchr.wechat.entity.PaidLeave;

public class PaidLeaveDao {
	
	public static List<PaidLeave> getPaidLeaveList(int empId) {
		List<PaidLeave> list = new ArrayList<PaidLeave>();

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			String sql = "select * from mc_wx_annualleave  where EMPID = ?";
			connection = DBManager.getConnection();
			statement = connection.prepareStatement(sql);
			//statement = DBManager.getDBManager().getStatement(sql);
			statement.setInt(1, empId);

			resultSet = statement.executeQuery();
			while (resultSet.next()) {

				PaidLeave item = new PaidLeave();
				item.empId = resultSet.getInt("EMPID");
				item.item = resultSet.getString("Item");
				item.startTime = resultSet.getTimestamp("StartTime");
				item.endTime = resultSet.getTimestamp("EndTime");
				item.days = resultSet.getDouble("Days");
				item.usedDays = resultSet.getDouble("UsedDays");
				item.leftDays = resultSet.getDouble("LeftDays");
				
				list.add(item);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
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

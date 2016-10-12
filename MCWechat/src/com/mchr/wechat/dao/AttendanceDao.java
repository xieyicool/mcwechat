package com.mchr.wechat.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mchr.wechat.common.DBManager;
import com.mchr.wechat.entity.Attendance;

public class AttendanceDao {
	
	public static List<Attendance> getAttendanceList(int empId, Date startDate, Date endDate)
	{
		List<Attendance> list = new ArrayList<Attendance>();
		
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			String sql = "select * from mc_wx_attendance  where EMPID = ? and CountDate >= ? and CountDate < ? order by CountDate";
			connection = DBManager.getConnection();
			statement = connection.prepareStatement(sql);
			//statement = DBManager.getDBManager().getStatement(sql);
			statement.setInt(1, empId);
			statement.setDate(2, startDate);
			statement.setDate(3, endDate);
			
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				
				Attendance item = new Attendance();
				item.empId = resultSet.getInt("EMPID");
				item.countDate = resultSet.getDate("CountDate");
				item.status = resultSet.getString("Status");
				item.checkinStatus = resultSet.getString("CheckinStatus");
				item.attendantHours = resultSet.getDouble("AttendantHours");
				item.absentHours = resultSet.getDouble("AbsentHours");
				item.leaveHours = resultSet.getDouble("LeaveHours");
				item.overtimeHours = resultSet.getDouble("OvertimeHours");
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

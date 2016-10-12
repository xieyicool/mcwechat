package com.mchr.wechat.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mchr.wechat.common.DBManager;
import com.mchr.wechat.entity.Salary;

public class SalaryDao {
	
	
	public static List<Salary> getSalaryList(int empId, Date startDate, Date endDate)
	{
		List<Salary> list = new ArrayList<Salary>();
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			String sql = "select * from mc_wx_salary  where EMPID = ? and BalanceTime >= ? and BalanceTime < ?";
			connection = DBManager.getConnection();
			statement = connection.prepareStatement(sql);
			//statement = DBManager.getDBManager().getStatement(sql);
			statement.setInt(1, empId);
			statement.setDate(2, startDate);
			statement.setDate(3, endDate);
			
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				
				Salary item = new Salary();
				item.empId = resultSet.getInt("EMPID");
				item.empNo = resultSet.getString("EMPNO");
				item.balanceTime = resultSet.getDate("BalanceTime");
				item.item = resultSet.getString("Item");
				item.amount = resultSet.getDouble("Amount");
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

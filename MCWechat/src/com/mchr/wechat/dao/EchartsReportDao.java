package com.mchr.wechat.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mchr.wechat.common.DBManager;
import com.mchr.wechat.entity.EchartsReport;
 
public class EchartsReportDao {
	
	public static EchartsReport getAmountOfDepart()
	{
		ArrayList<String> xvalues = new ArrayList<String>();
		ArrayList<Double> yvalues = new ArrayList<Double>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			String sql = "SELECT dep,COUNT(1) AS amount FROM mc_wx_employee WHERE dep IS NOT NULL GROUP BY dep";
			connection = DBManager.getConnection();
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				xvalues.add(resultSet.getString("dep"));
				yvalues.add(resultSet.getDouble("amount"));
			}
			EchartsReport data = new EchartsReport(xvalues,yvalues,"");
			return data;
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

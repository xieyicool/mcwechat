package com.mchr.wechat.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mchr.wechat.common.DBManager;
import com.mchr.wechat.entity.Employee;

public class EmployeeDao {

	public static boolean exists(int empId, String password) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			String sql = "select * from mc_wx_employee where EMPID = ? and Password = ?";
			connection = DBManager.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, empId);
			statement.setString(2, password);

			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

				if (resultSet != null) {
					resultSet.close();
				}

				if (statement != null) {
					statement.close();
				}

				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public static Map<String, Employee> getAllEmplyee() {
		Map<String, Employee> users = new HashMap<String, Employee>();

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			String sql = "select * from mc_wx_employee ";
			connection = DBManager.getConnection();
			statement = connection.prepareStatement(sql);
			// statement = DBManager.getDBManager().getStatement(sql);

			resultSet = statement.executeQuery();
			while (resultSet.next()) {

				Employee item = new Employee();
				item.empId = resultSet.getInt("EMPID");
				item.empNo = resultSet.getString("EMPNO");
				item.name = resultSet.getString("Name");
				item.depId = resultSet.getInt("DEPID");
				item.dep = resultSet.getString("DEP");
				item.job = resultSet.getString("JOB");
				item.officePhone = resultSet.getString("OfficePhone");
				item.mobile = resultSet.getString("Mobile");
				item.email = resultSet.getString("Email");
				item.WXAccount = resultSet.getString("WXAccount");
				item.gender = resultSet.getString("Gender");

				users.put(item.WXAccount, item);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

				if (resultSet != null) {
					resultSet.close();
				}

				if (statement != null) {
					statement.close();
				}

				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return users;
	}

	public static List<Employee> getContactList(int depId, String keyword) {
		List<Employee> list = new ArrayList<Employee>();

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {

			connection = DBManager.getConnection();

			if (keyword != null && keyword.length() > 0) {
				String sql = "select * from mc_wx_employee  where DEPID = ? and (EMPNO = ? or Name = ?)";
				statement = connection.prepareStatement(sql);
				statement.setInt(1, depId);
				statement.setString(2, keyword);
				statement.setString(3, keyword);
			}
			else{
				String sql = "select * from mc_wx_employee  where DEPID = ?";
				statement = connection.prepareStatement(sql);
				statement.setInt(1, depId);
			}
			resultSet = statement.executeQuery();
			while (resultSet.next()) {

				Employee item = new Employee();
				item.empId = resultSet.getInt("EMPID");
				item.empNo = resultSet.getString("EMPNO");
				item.name = resultSet.getString("Name");
				item.depId = resultSet.getInt("DEPID");
				item.dep = resultSet.getString("DEP");
				item.job = resultSet.getString("JOB");
				item.officePhone = resultSet.getString("OfficePhone");
				item.mobile = resultSet.getString("Mobile");
				item.email = resultSet.getString("Email");

				list.add(item);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

				if (resultSet != null) {
					resultSet.close();
				}

				if (statement != null) {
					statement.close();
				}

				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public static Employee getEmployee(String wxAccount) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			String sql = "select * from mc_wx_employee where WXAccount=?";
			connection = DBManager.getConnection();
			statement = connection.prepareStatement(sql);
			// statement = DBManager.getDBManager().getStatement(sql);
			statement.setString(1, wxAccount);

			resultSet = statement.executeQuery();
			while (resultSet.next()) {

				Employee item = new Employee();
				item.empId = resultSet.getInt("EMPID");
				item.empNo = resultSet.getString("EMPNO");
				item.name = resultSet.getString("Name");
				item.englishName = resultSet.getString("EnglishName");
				// Blob photo = resultSet.getBlob("Photo");
				item.depId = resultSet.getInt("DEPID");
				item.dep = resultSet.getString("DEP");
				item.job = resultSet.getString("JOB");
				item.reporter = resultSet.getString("Reporter");

				item.onboardDate = resultSet.getDate("OnboardDate");
				item.workStatus = resultSet.getString("WorkStatus");
				item.contractEndDate = resultSet.getDate("ContractEndDate");
				item.probationEndDate = resultSet.getDate("ProbationEndDate");
				item.mobile = resultSet.getString("Mobile");
				item.email = resultSet.getString("Email");
				item.WXAccount = resultSet.getString("WXAccount");

				return item;

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}

				if (statement != null) {
					statement.close();
				}

				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public static Employee getEmployee(int empId) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			String sql = "select * from mc_wx_employee where EMPID=?";
			connection = DBManager.getConnection();
			statement = connection.prepareStatement(sql);
			// statement = DBManager.getDBManager().getStatement(sql);
			statement.setInt(1, empId);

			resultSet = statement.executeQuery();
			while (resultSet.next()) {

				Employee item = new Employee();
				item.empId = resultSet.getInt("EMPID");
				item.empNo = resultSet.getString("EMPNO");
				item.name = resultSet.getString("Name");
				item.englishName = resultSet.getString("EnglishName");
				// Blob photo = resultSet.getBlob("Photo");
				item.depId  = resultSet.getInt("DEPID");
				item.dep = resultSet.getString("DEP");
				item.job = resultSet.getString("JOB");
				item.reporter = resultSet.getString("Reporter");

				item.onboardDate = resultSet.getDate("OnboardDate");
				item.workStatus = resultSet.getString("WorkStatus");
				item.contractEndDate = resultSet.getDate("ContractEndDate");
				item.probationEndDate = resultSet.getDate("ProbationEndDate");
				item.mobile = resultSet.getString("Mobile");
				item.email = resultSet.getString("Email");
				item.WXAccount = resultSet.getString("WXAccount");

				return item;

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}

				if (statement != null) {
					statement.close();
				}

				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}

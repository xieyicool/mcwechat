package com.mchr.wechat.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.mchr.wechat.common.DBManager;
import com.mchr.wechat.entity.Department;
import com.mchr.wechat.entity.Employee;
import com.mchr.wechat.entity.WXMenu;
import com.mchr.wechat.entity.WXSubMenu;

public class SyncWXDao {

	public static Map<Integer, WXMenu> getWXMenuList() {

		Map<Integer, WXMenu> map = new TreeMap<Integer, WXMenu>();

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			String sql = "select * from mc_wx_wxmenu  order by XID asc, `Order` asc";
			
			connection = DBManager.getConnection();
			statement = connection.prepareStatement(sql);

			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				int xid = resultSet.getInt("XID");
				if (xid == 0) {
					WXMenu item = new WXMenu();
					item.id = resultSet.getInt("ID");
					item.xid = resultSet.getInt("XID");
					item.type = resultSet.getInt("Type");
					item.title = resultSet.getString("Title");
					item.url = resultSet.getString("URL");
					item.order = resultSet.getInt("Order");
					item.remark = resultSet.getString("Remark");
					map.put(item.id, item);

				} else {
					WXMenu menu = map.get(xid);
					
					WXSubMenu item = new WXSubMenu();
					item.id = resultSet.getInt("ID");
					item.xid = resultSet.getInt("XID");
					item.type = resultSet.getInt("Type");
					item.title = resultSet.getString("Title");
					item.url = resultSet.getString("URL");
					item.order = resultSet.getInt("Order");
					item.remark = resultSet.getString("Remark");
					menu.subMenuList.add(item);
				}

				


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
		return map;
	}

	public static Map<Integer, Department> getOrgnizationList() {
		Map<Integer, Department> deps = new HashMap<Integer,Department>();

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			String sql = "select * from mc_wx_orgnization  order by XID asc, `Order` asc";
			connection = DBManager.getConnection();
			statement = connection.prepareStatement(sql);

			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Department item = new Department();
				item.id = resultSet.getInt("ID");
				item.xid = resultSet.getInt("XID");
				item.name = resultSet.getString("Name");
				item.order = resultSet.getInt("Order");
				
				deps.put(item.id, item);
				
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
		return deps;
	}

	public static List<Employee> getAccountList() {
		List<Employee> list = new ArrayList<Employee>();
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			String sql = "select * from mc_wx_employee";
			connection = DBManager.getConnection();
			statement = connection.prepareStatement(sql);

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

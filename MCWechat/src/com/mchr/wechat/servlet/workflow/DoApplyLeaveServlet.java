package com.mchr.wechat.servlet.workflow;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mchr.wechat.common.DBManager;
import com.mchr.wechat.dao.EmployeeDao;
import com.mchr.wechat.entity.Employee;

/**
 * Servlet implementation class DoApplyLeaveServlet
 */
@WebServlet("/DoApplyLeaveServlet")
public class DoApplyLeaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoApplyLeaveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		HttpSession session = request.getSession();
		int empId = (Integer)session.getAttribute("empId");
		//int empId = (int)session.getAttribute("empId");
		Employee employee = EmployeeDao.getEmployee(empId);
		
		request.setCharacterEncoding("utf-8");
		String hours = request.getParameter("hours");
		String category = request.getParameter("category");
		String startTime = request.getParameter("startTime");
		String endTime = request.getParameter("endTime");
		
		 Date startDate = Date.valueOf(startTime);
		 Date endDate = Date.valueOf(endTime);
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			String sql = "insert into mc_wx_workflow_overtime(EMPID,EMPNO,Name,DEP,JOB,Category,StartTime,EndTime,Hours) values(?,?,?,?,?,?,?,?,?)  ";
			connection = DBManager.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, empId);
			statement.setString(2, employee.empNo);
			statement.setString(3, employee.name);
			statement.setString(4, employee.dep);
			statement.setString(5, employee.job);
			statement.setString(6, category);
			statement.setDate(7, startDate);
			statement.setDate(8, endDate);
			statement.setDouble(9, Double.parseDouble(hours));
			statement.execute();
			
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
		
		String appUrl = "http://"+ request.getServerName()+ ":"+ request.getServerPort() + request.getContextPath();

		response.sendRedirect(appUrl + "/workflow/applyindex.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

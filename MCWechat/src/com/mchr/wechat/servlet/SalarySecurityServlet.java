package com.mchr.wechat.servlet;

import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mchr.wechat.dao.EmployeeDao;
import com.mchr.wechat.dao.SalaryDao;
import com.mchr.wechat.entity.Salary;

/**
 * Servlet implementation class SalaryServlet
 */
@WebServlet("/SalarySecurityServlet")
public class SalarySecurityServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SalarySecurityServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();
		int empId = (Integer)session.getAttribute("empId");
		//int empId = (int) session.getAttribute("empId");
		
		String password = request.getParameter("password");

		if(EmployeeDao.exists(empId, password))
		{
			request.getRequestDispatcher("/employee/salary").forward(request, response);	
		}
		else{
			String appUrl = "http://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath();
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write("<script>alert('密码错误'); location.href='"+appUrl+"/employee/salary_security.jsp'</script>");
			response.getWriter().close();
		}


		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

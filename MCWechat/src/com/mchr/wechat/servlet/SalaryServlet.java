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

import com.mchr.wechat.dao.SalaryDao;
import com.mchr.wechat.entity.Salary;

/**
 * Servlet implementation class SalaryServlet
 */
@WebServlet("/SalaryServlet")
public class SalaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SalaryServlet() {
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

		String time = (String) request.getParameter("time");

		Date startDate = null;
		Date endDate = null;

		if (time == null) {
			Calendar c = Calendar.getInstance();// ���Զ�ÿ��ʱ���򵥶��޸�
			int year = c.get(Calendar.YEAR);
			int month = c.get(Calendar.MONTH);
			c.set(year, month, 1);
			startDate = new Date(c.getTimeInMillis());
			c.add(Calendar.MONTH, 1);
			endDate = new Date(c.getTimeInMillis());
		} else {
			startDate = Date.valueOf(time+"-01");
			Calendar c = Calendar.getInstance();
			c.setTime(startDate);
			c.add(Calendar.MONTH, 1);
			endDate = new Date(c.getTimeInMillis());
			
		}

		List<Salary> salaryList = SalaryDao.getSalaryList(empId, startDate, endDate);

		request.setAttribute("salaryList", salaryList);

		request.getRequestDispatcher("/employee/salary.jsp").forward(request, response);
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

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

import com.mchr.wechat.dao.AttendanceDao;
import com.mchr.wechat.entity.Attendance;

/**
 * Servlet implementation class AttendanceServlet
 */
@WebServlet("/AttendanceServlet")
public class AttendanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AttendanceServlet() {
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
		//int empId = (int)session.getAttribute("empId");
		
		
		String time = (String) request.getParameter("time");

		Date startDate = null;
		Date endDate = null;

		if (time == null) {
			Calendar c = Calendar.getInstance();// 
			int year = c.get(Calendar.YEAR);
			int month = c.get(Calendar.MONTH);
			int day  = c.get(Calendar.DATE);
			c.set(year, month, day);
			startDate = new Date(c.getTimeInMillis());
			c.add(Calendar.DATE, 1);
			endDate = new Date(c.getTimeInMillis());
		} else {
			startDate = Date.valueOf(time);
			Calendar c = Calendar.getInstance();
			c.setTime(startDate);
			c.add(Calendar.DATE, 1);
			endDate = new Date(c.getTimeInMillis());
			
		}
		
		
		List<Attendance> attendanceList = AttendanceDao.getAttendanceList(empId, startDate, endDate);

		request.setAttribute("attendanceList", attendanceList);
		
		if(time != null)
			request.setAttribute("time", time);
		else
		{
			Calendar c = Calendar.getInstance();
			Date date = new Date(c.getTimeInMillis());
			request.setAttribute("time", date.toString());
		}
		
		

		request.getRequestDispatcher("/employee/attendance.jsp").forward(request, response);
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

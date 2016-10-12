package com.mchr.wechat.servlet.workflow;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mchr.wechat.dao.EmployeeDao;
import com.mchr.wechat.entity.Employee;

/**
 * Servlet implementation class ApplyOverTimeServlet
 */
@WebServlet("/ApplyOverTimeServlet")
public class ApplyOverTimeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplyOverTimeServlet() {
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
		
		request.setAttribute("employee", employee);
		request.getRequestDispatcher("/workflow/applyovertime.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

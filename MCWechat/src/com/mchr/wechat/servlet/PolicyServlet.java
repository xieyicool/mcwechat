package com.mchr.wechat.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mchr.wechat.common.MCUtil;
import com.mchr.wechat.dao.PolicyDao;
import com.mchr.wechat.entity.Policy;

/**
 * Servlet implementation class PolicyServlet
 */
@WebServlet("/PolicyServlet")
public class PolicyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PolicyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int page = MCUtil.getIntParameter(request, "page",  0);
		int pageSize = MCUtil.getIntParameter(request, "pageSize", 20);
		List<Policy> policyList = PolicyDao.getPolicyList(page, pageSize);
		request.setAttribute("policyList", policyList);
		request.getRequestDispatcher("/company/policy.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

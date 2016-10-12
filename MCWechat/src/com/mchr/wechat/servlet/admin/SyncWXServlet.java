package com.mchr.wechat.servlet.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mchr.wechat.common.WXSyncUtil;

/**
 * Servlet implementation class SyncServlet
 */
@WebServlet("/SyncServlet")
public class SyncWXServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SyncWXServlet() {
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
		String op = request.getParameter("op");
		try {

			if (op != null && op.equals("menu")) {
				WXSyncUtil.deleteMenu(19);
				WXSyncUtil.createMenu(19);
				
			} else if (op != null && op.equals("dep")) {
				WXSyncUtil.syncDepartment();
				
			} else if (op != null && op.equals("emp")) {
				WXSyncUtil.syncAccount();
			}
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write("<script>alert('同步成功'); window.history.back();</script>");
			response.getWriter().close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write("<script>alert('同步失败，请联系管理员。'); window.history.back();</script>");
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

package com.mchr.wechat.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.mchr.wechat.common.WXSyncUtil;
import com.mchr.wechat.dao.SyncWXDao;
import com.mchr.wechat.entity.WXMenu;
import com.mchr.wechat.entity.WXSubMenu;

/**
 * Servlet implementation class SyncAccountServlet
 */
@WebServlet("/SyncAccountServlet")
public class SyncAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SyncAccountServlet() {
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

		// String func = request.getParameter("func");
		// String op = request.getParameter("op");
		// if(func == null || op == null)
		// return;

		try {
			//
			// if (func.equals("menu")) {
			// if (op.equals("create")) {
			// createMenu();
			//
			// } else if (op.equals("delete")) {
			// deleteMenu();
			// }
			// } else if (func.equals("dep")) {
			// if(op.equals("create"))
			//createDepartment();
			
			WXSyncUtil.deleteMenu(19);
			WXSyncUtil.createMenu(19);
			
			//WXSyncUtil.syncDepartment();
			//WXSyncUtil.getAccountList(1);
			
//			WXSyncUtil.syncAccount();
			
			
			// else if(op.equals("update"))
			// updateDepartment();
			// else if(op.equals("query"))
			// getDepartmentList();
			// else if(op.equals("delete"))
			// deleteDepartment();
			//
			// } else if (func.equals("account")) {
			// if(op.equals("create"))
			// createAccount();
			// else if(op.equals("delete"))
			// deleteAccount();
			// else if(op.equals("query"))
			// getAccountList();
			// }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

	private void createMenu(int agentId) throws Exception {

		WXSyncUtil.createMenu(agentId);

	}

	private void deleteMenu() throws Exception {
		WXSyncUtil.deleteMenu(5);
	}

	private void createDepartment() {

	}

	private void updateDepartment() {

	}

	private void getDepartmentList() {

	}

	private void deleteDepartment() {

	}

	private void getAccountList() {

	}

	private void deleteAccount() {

	}

	private void createAccount() {

	}

}

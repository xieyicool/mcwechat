package com.mchr.wechat.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mchr.wechat.common.EncriptTools;
import com.mchr.wechat.common.WXSyncUtil;
import com.mchr.wechat.entity.WXTicket;

/**
 * Servlet implementation class CheckinServlet
 */
@WebServlet("/CheckinServlet")
public class CheckinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckinServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			WXTicket item = WXSyncUtil.getTicket();
			String url = request.getRequestURL().toString();
			String content = String.format("jsapi_ticket=%s&noncestr=%s&timestamp=%s&url=%s", item.ticket, item.noncestr, item.timestamp+"", url);
			item.sign = EncriptTools.sha(content);
			request.setAttribute("timestamp", item.timestamp);
			request.setAttribute("nonceStr", item.noncestr);
			request.setAttribute("signature", item.sign);
			request.getRequestDispatcher("/employee/checkin.jsp").forward(request, response);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

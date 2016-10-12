package com.mchr.wechat.servlet;

import java.io.IOException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mchr.wechat.common.MCNet;
import com.mchr.wechat.dao.EmployeeDao;
import com.mchr.wechat.entity.Employee;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployeeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		int empId = (Integer)session.getAttribute("empId");
		Employee employee = EmployeeDao.getEmployee(empId);
		
		request.setAttribute("employee", employee);
		//request.getRequestDispatcher("/employee/userinfo.jsp").forward(request, response);
		request.getRequestDispatcher("/employee/myself.jsp").forward(request, response);
	}

	// SSL Certifications
	/**
	 * ����֤��HostName
	 */
	private static HostnameVerifier ignoreHostnameVerifier = new HostnameVerifier() {
		public boolean verify(String s, SSLSession sslsession) {
			return true;
		}
	};
	/**
	 * Ignore Certification
	 */
	private static TrustManager ignoreCertificationTrustManger = new X509TrustManager() {
		// private X509Certificate[] certificates;

		@Override
		public void checkClientTrusted(X509Certificate certificates[], String authType) throws CertificateException {
			// if(this.certificates == null){
			// this .certificates = certificates;
			// System.out.println("init at checkClientTrusted");
			// }
		}

		@Override
		public void checkServerTrusted(X509Certificate[] ax509certificate, String s) throws CertificateException {
			// if(this.certificates == null){
			// this.certificates = ax509certificate;
			// System.out.println("init at checkServerTrusted");
			// }
		}

		@Override
		public X509Certificate[] getAcceptedIssuers() {
			// TODO Auto-generated method stub
			return null;
		}
	};

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

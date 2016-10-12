package com.mchr.wechat.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mchr.wechat.common.WXSyncUtil;
import com.mchr.wechat.dao.EmployeeDao;
import com.mchr.wechat.entity.Employee;

/**
 * Servlet Filter implementation class AccessFilter
 */
@WebFilter("/AccessFilter")
public class AccessFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public AccessFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
	
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		Cookie[] cookies = req.getCookies();
		for (int i = 0; cookies != null && i < cookies.length; ++i) {
			Cookie cookie = cookies[i];
			if (cookie.getName() != null && cookie.getName().equals("userid")) {
				String value = cookie.getValue();

				Employee user = EmployeeDao.getEmployee(value);

				HttpSession session = req.getSession();
				session.setAttribute("empId", user.empId);
				session.setAttribute("depId", user.depId);
				session.setAttribute("userid", value);
				chain.doFilter(request, response);
				return;
			}
		}
		String code = req.getParameter("code");
		if (code != null) {
			
			try {
				String userid = WXSyncUtil.getUserIDFromWX(code);
				
				Employee user = EmployeeDao.getEmployee(userid);
				HttpSession session = req.getSession();
				session.setAttribute("empId", user.empId);
				session.setAttribute("depId", user.depId);
				session.setAttribute("userid", userid);
				
				Cookie cookie = new Cookie("userid", userid);
				resp.addCookie(cookie);
				chain.doFilter(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else {
			String requestUrl = req.getRequestURL().toString();
			if (req.getQueryString() != null)
				requestUrl += "?" + req.getQueryString();
			String redirectUrl = WXSyncUtil.getRedirectUrl(requestUrl);
			resp.sendRedirect(redirectUrl);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

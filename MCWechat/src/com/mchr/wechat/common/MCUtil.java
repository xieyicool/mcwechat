package com.mchr.wechat.common;

import javax.servlet.http.HttpServletRequest;

public class MCUtil {
	
	public static int getIntParameter(HttpServletRequest request, String name, int defaultValue)
	{
		String value = request.getParameter(name);
		if(value != null)
		{
			return Integer.parseInt(value);
		}
		
		return defaultValue;
	}

}

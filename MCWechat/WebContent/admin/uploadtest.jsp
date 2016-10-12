<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	request.setCharacterEncoding("UTF-8");
	String appUrl = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<%=appUrl%>/admin/uploadtest"  method="POST"  enctype="multipart/form-data">
		<select name="Category">
			<option value="1">员工照片</option>
			<option value="2">HR政策文件</option>
		</select>
		<br/>
		<input name="ID" type="text" />
		<br/>
		<input name="File" type="file" />
		<br/><br/>
		<input type="submit" value="上传"/>
	</form>
</body>
</html>
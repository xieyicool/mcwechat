<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	request.setCharacterEncoding("UTF-8");
String appUrl = "http://"+ request.getServerName()+ ":"+ request.getServerPort() + request.getContextPath();
%>
<jsp:include page="/shared/header.jsp">
	<jsp:param name="title" value="工资查询" />
</jsp:include>

<div class="page-salary padding form-simple">
	<form id="SalaryForm" action="<%=appUrl%>/employee/salarysecurity" method="post">
		<p class="row-10"></p>
		<p class="f5">请输入工资查询密码：</p>
		<p class="row-1"></p>
		<div><input id="Password"  name="password" type="password" class="password"/></div>
		<p class="row-5"></p>
		<span class="button ok" onclick="submit()">确认</span>
	</form>
</div>
<script>
	function submit(){
		var psw = document.getElementById('Password').value;
		if(!psw){
			alert('查询密码不能为空');
			return;
		}
		document.getElementById('SalaryForm').submit();
	}
</script>
<%@ include file="/shared/footer.jsp"%>
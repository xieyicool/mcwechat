<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
String appUrl = "http://"+ request.getServerName()+ ":"+ request.getServerPort() + request.getContextPath();
%>
<jsp:include page="/shared/header.jsp">
	<jsp:param name="title" value="职位JD" />
</jsp:include>

<div class="page-jobdetail padding">
	<p class="row-2"></p>
	<p class="f4">${title}</p>
	<p class="row-2"></p>
	<p class="text-bold">职位描术：</p>
	<div>${requirement }</div>
	<p class="row-2"></p>
	<p class="text-bold">任职要求：</p>
	<div>${desc }</div>
	<p class="row-2"></p>
	<p class="text-bold">必备课程：</p>
	<div>${course}</div>
</div>

<%@ include file="/shared/footer.jsp"%>
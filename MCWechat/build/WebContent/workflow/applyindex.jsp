<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
String appUrl = "http://"+ request.getServerName()+ ":"+ request.getServerPort() + request.getContextPath();

%>
<jsp:include page="/shared/header.jsp">
	<jsp:param name="title" value="新申请" />
</jsp:include>

<div class="page-applyindex padding">
	<p>请选择申请项目：</p>
	<ul class="list-dottor f5">
		<li><a href="<%=appUrl%>/workflow/applyleave">请假申请</a></li>
		<li><a href="<%=appUrl%>/workflow/applyovertime">加班申请</a></li>
	</ul>
</div>

<%@ include file="/shared/footer.jsp"%>
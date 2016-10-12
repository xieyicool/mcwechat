<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
String appUrl = "http://"+ request.getServerName()+ ":"+ request.getServerPort() + request.getContextPath();
%>
<jsp:include page="/shared/header.jsp">
	<jsp:param name="title" value="审批列表" />
</jsp:include>

<div class="page-newslist padding">
	<ul class="list-dottor">
		<li><a href="<%=appUrl%>/workflow/flowleave.jsp?review=1">请审批张三2016年5月5日的请假申请</span></li>
		<li><a href="<%=appUrl%>/workflow/flowovertime.jsp?review=1">请审批张三2016年5月1日的加班申请</span></li>
		<li><a href="<%=appUrl%>/workflow/flowovertime.jsp?review=1">请审批张三2016年4月20日的加班申请</span></li>
	</ul>
</div>

<%@ include file="/shared/footer.jsp"%>
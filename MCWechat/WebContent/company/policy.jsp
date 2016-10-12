<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	request.setCharacterEncoding("UTF-8");
String appUrl = "http://"+ request.getServerName()+ ":"+ request.getServerPort() + request.getContextPath();
%>
<jsp:include page="/shared/header.jsp">
	<jsp:param name="title" value="HR政策" />
</jsp:include>

<div class="page-policy padding">
	<p>请阅读HR相关政策：</p>
	<ul class="list-dottor f5">
		<c:forEach items="${policyList}" var="item">
			<li><a href="<%=appUrl%>/file/${item.remark}">${item.title }</a> <span class="text-gray-light f7">${item.createTime.toString()}</span></li>
		</c:forEach>
	</ul>
</div>

<%@ include file="/shared/footer.jsp"%>
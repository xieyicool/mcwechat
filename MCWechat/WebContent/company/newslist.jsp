<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%
	request.setCharacterEncoding("UTF-8");
	String appUrl = "http://"+ request.getServerName()+ ":"+ request.getServerPort() + request.getContextPath();
%>
<jsp:include page="/shared/header.jsp">
	<jsp:param name="title" value="公司新闻" />
</jsp:include>

<div class="page-newslist padding">
	<ul class="list-dottor">
		<c:forEach items="${newsList}" var="item">
			<li><a href="<%=appUrl%>/company/newsdetail?id=${item.id}">${item.title }</a><br />
				<span class="text-gray-light f7">发布时间：<fmt:formatDate value="${item.createTime }" pattern="yyyy-MM-dd"/></span></li>
		</c:forEach>

	</ul>
</div>

<%@ include file="/shared/footer.jsp"%>
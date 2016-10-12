<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
	request.setCharacterEncoding("UTF-8");
String appUrl = "http://"+ request.getServerName()+ ":"+ request.getServerPort() + request.getContextPath();
%>
<jsp:include page="/shared/header.jsp">
	<jsp:param name="title" value="新闻详情" />
</jsp:include>

<div class="page-newsdetail padding">
	<p class="row-2"></p>
	<p class="f4 text-center">${news.title}</p>
	<div class="text-gray-lighter text-center ">
		<span class="text-gray-light">发布时间：<fmt:formatDate value="${news.createTime }" pattern="yyyy-MM-dd"/></span> <span>/</span> <span class="text-gray-light">发布人：${news.author }</span>
	</div>
	<p class="row-5"></p>
	<div>
		${news.content}
	</div>
</div>

<%@ include file="/shared/footer.jsp"%>
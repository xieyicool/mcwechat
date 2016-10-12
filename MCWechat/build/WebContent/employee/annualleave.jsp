<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	request.setCharacterEncoding("UTF-8");
	String appUrl = "http://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath();
%>
<jsp:include page="/shared/header.jsp">
	<jsp:param name="title" value="有薪假查询" />
</jsp:include>

<div class="page-paidleave form-simple">
	<p class="row-5"></p>
	<div class="margin-horizontal scroll-horizontal">
		<c:forEach items="${paidLeaveList}" var="item">
			<table class="width-full border-light simple">
				<colgroup>
					<col width="120" />
				</colgroup>
				<tr>
					<td class="text-bold">年度：</td>
					<td><fmt:formatDate value="${item.endTime }"
							pattern="yyyy" /></td>

				</tr>
				<tr>
					<td class="text-bold">有薪假项目：</td>
					<td>${item.item }</td>
				</tr>
				<tr>
					<td class="text-bold">享用开始日期：</td>
					<td><fmt:formatDate value="${item.startTime }"
							pattern="yyyy-MM-dd" /></td>
				</tr>
				<tr>
					<td class="text-bold">享用结束日期：</td>
					<td><fmt:formatDate value="${item.endTime }"
							pattern="yyyy-MM-dd" /></td>
				</tr>
				<tr>
					<td class="text-bold">总额：</td>
					<td>${item.days }</td>
				</tr>
				<tr>
					<td class="text-bold">使用额：</td>
					<td>${item.usedDays }</td>
				</tr>
				<tr>
					<td class="text-bold">剩余额：</td>
					<td>${item.leftDays }</td>
				</tr>
				<tr>
					<td class="text-bold">单位：</td>
					<td>天</td>
				</tr>
			</table>
			<p class="row-5"></p>
		</c:forEach>
	</div>

</div>

<%@ include file="/shared/footer.jsp"%>
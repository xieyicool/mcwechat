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
	<div class="vertical-middle float-fluid">
		<span class="l"><span>月份：</span><input id="Month" type="month" value="2016-05" /></span> <span class="button smaller ok r" onclick="checkMonth()">查询</span>
	</div>
	<p class="row-2"></p>
	<table class="width-full border-light simple">
		<colgroup>
			<col width="130" />
		</colgroup>
		<thead>
			<tr>
				<td>薪资科目</td>
				<td>金额</td>
				<td>单位</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${salaryList}" var="item">
				<tr>
					<td>${item.item }</td>
					<td>${item.amount }元</td>
				</tr>
			</c:forEach>
			<tr>
				<td>基本工资</td>
				<td>10,000.00</td>
				<td>元</td>
			</tr>
			<tr>
				<td>奖金</td>
				<td>2,000.00</td>
				<td>元</td>
			</tr>
		</tbody>
	</table>
</div>
<script>
	function checkMonth(){
		var value = document.getElementById('Month').value;
		location.href='<%=appUrl%>/employee/salary?time='+value;
	}
</script>
<%@ include file="/shared/footer.jsp"%>
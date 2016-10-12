<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	request.setCharacterEncoding("UTF-8");
String appUrl = "http://"+ request.getServerName()+ ":"+ request.getServerPort() + request.getContextPath();
%>

<jsp:include page="/shared/header.jsp">
	<jsp:param name="title" value="通讯录" />
</jsp:include>

<div class="page-contact form-simple">
	<div class="vertical-middle float-fluid padding searchbar">
		<span class="l"><span>搜索：</span><input id="Keyword" type="text" placeholder="请输入搜索关键字" /></span> <span class="button smaller ok r" onclick="doSearch()">查询</span>
	</div>
	<p class="row-2"></p>
	<div class="margin-horizontal scroll-horizontal">
		<c:forEach items="${contactList}" var="item">
		<table class="width-full border-light simple">
			<colgroup>
				<col width="100" />
			</colgroup>
			<tr>
				<td class="text-bold">工号：</td>
				<td>${item.empNo }</td>
			</tr>
			<tr>
				<td class="text-bold">姓名：</td>
				<td>${item.name }</td>
			</tr>
			<tr>
				<td class="text-bold">部门：</td>
				<td>${item.dep }</td>
			</tr>
			<tr>
				<td class="text-bold">职位：</td>
				<td>${item.job }</td>
			</tr>
			<tr>
				<td class="text-bold">办公电话：</td>
				<td><a href="tel:${item.officePhone }">${item.officePhone }</a></td>
			</tr>
			<tr>
				<td class="text-bold">手机：</td>
				<td><a href="tel:${item.mobile }">${item.mobile }</a></td>
			</tr>
			<tr>
				<td class="text-bold">电子邮箱：</td>
				<td><a href="mailto:${item.email }">${item.email }</a></td>
			</tr>
		</table>
		<p class="row-5"></p>
		</c:forEach>
	</div>

</div>
<script>
	function doSearch(){
		var value = document.getElementById('Keyword').value;
		location.href='<%=appUrl%>/company/contact?keyword='+encodeURI(value);
	}
</script>
<%@ include file="/shared/footer.jsp"%>
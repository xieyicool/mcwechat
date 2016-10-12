<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	request.setCharacterEncoding("UTF-8");
	String appUrl = "http://"+ request.getServerName()+ ":"+ request.getServerPort() + request.getContextPath();
%>
<jsp:include page="/shared/header.jsp">
	<jsp:param name="title" value="个人信息" />
</jsp:include>

<div class="page-userinfo padding">
	<p class="row-2"></p>
	<table class="width-full simple border-light">
		<colgroup>
		</colgroup>
		<tr>
			<td class="text-bold">照片：</td>
			<td><img src="<%=appUrl%>/image/temp_head.png" class="head block" /></td>
		</tr>
		<tr>
			<td class="text-bold">工号：</td>
			<td>${employee.empNo }</td>
		</tr>
		<tr>
			<td class="text-bold">姓名：</td>
			<td>${employee.name}</td>
		</tr>
		<tr>
			<td class="text-bold">部门：</td>
			<td>${employee.dep }</td>
		</tr>
		<tr>
			<td class="text-bold">职位：</td>
			<td>${employee.job }</td>
		</tr>
		<tr>
			<td class="text-bold">汇报上级：</td>
			<td>李四</td>
		</tr>
		<tr>
			<td class="text-bold">入职日期：</td>
			<td>${employee.onboardDate.toString() }</td>
		</tr>
		<tr>
			<td class="text-bold">在职状态：</td>
			<td>${employee.workStatus }</td>
		</tr>
		<tr>
			<td class="text-bold">合同到期日：</td>
			<td>${employee.contractEndDate.toString() }</td>
		</tr>
		<tr>
			<td class="text-bold">试用结束日：</td>
			<td>${employee.probationEndDate.toString() }</td>
		</tr>
		<tr>
			<td class="text-bold">电话：</td>
			<td><a href="tel:${employee.mobile}">${employee.mobile}</a></td>
		</tr>
		<tr>
			<td class="text-bold">邮箱：</td>
			<td><a href="mailto:${employee.email }">${employee.email}</a></td>
		</tr>
	</table>
</div>

<%@ include file="/shared/footer.jsp"%>
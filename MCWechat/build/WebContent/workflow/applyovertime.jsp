<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
String appUrl = "http://"+ request.getServerName()+ ":"+ request.getServerPort() + request.getContextPath();
%>
<jsp:include page="/shared/header.jsp">
	<jsp:param name="title" value="加班申请" />
</jsp:include>

<div class="page-applydetail padding">

	<form id="MyForm" action="<%=appUrl%>/workflow/doapplyovertime"
		method="post">
		<table class="flow-detail width-full border-light simple">
			<tr>
				<td class="text-bold">工号：</td>
				<td>${employee.empNo }</td>
			</tr>
			<tr>
				<td class="text-bold">姓名：</td>
				<td>${employee.name }</td>
			</tr>
			<tr>
				<td class="text-bold">部门：</td>
				<td>${employee.dep }</td>
			</tr>
			<tr>
				<td class="text-bold">岗位：</td>
				<td>${employee.job}</td>
			</tr>
			<tr>
				<td class="text-bold">加班类型：</td>
				<td><select name="category">
						<option>加班</option>
						<option>调休加班</option>
				</select></td>
			</tr>
			<tr>
				<td class="text-bold">加班开始时间：</td>
				<td><input type="date" name="startTime" /></td>
			</tr>
			<tr>
				<td class="text-bold">加班结束时间：</td>
				<td><input type="date" name="endTime" /></td>
			</tr>
			<tr>
				<td class="text-bold">加班时长：</td>
				<td><input type="text" name="hours" /></td>
			</tr>
		</table>
		<p class="row-5"></p>
		<span class="button ok" onclick="apply()">申请</span>
	</form>
</div>
<script>
function apply(){
	var form = document.getElementById('MyForm').submit();
}
</script>
<%@ include file="/shared/footer.jsp"%>
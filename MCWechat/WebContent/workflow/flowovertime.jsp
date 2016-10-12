<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
String appUrl = "http://"+ request.getServerName()+ ":"+ request.getServerPort() + request.getContextPath();
	String review = request.getParameter("review");
%>
<jsp:include page="/shared/header.jsp">
	<jsp:param name="title" value="加班申请" />
</jsp:include>

<div class="page-applydetail padding">
	<table class="flow-detail width-full border-light simple">
		<tr>
			<td class="text-bold">工号：</td>
			<td>123</td>
		</tr>
		<tr>
			<td class="text-bold">姓名：</td>
			<td>张三</td>
		</tr>
		<tr>
			<td class="text-bold">部门：</td>
			<td>开发部</td>
		</tr>
		<tr>
			<td class="text-bold">岗位：</td>
			<td>iOS开发</td>
		</tr>
		<tr>
			<td class="text-bold">加班类型：</td>
			<td>调休加班</td>
		</tr>
		<tr>
			<td class="text-bold">加班开始时间：</td>
			<td>2015-5-1 9:00</td>
		</tr>
		<tr>
			<td class="text-bold">加班结束时间：</td>
			<td>2015-5-1 17:00</td>
		</tr>
		<tr>
			<td class="text-bold">加班时长：</td>
			<td>8小时</td>
		</tr>
	</table>
	<p class="row-2"></p>
	<table class="width-full border-light simple">
		<thead>
			<tr>
				<td>审批人</td>
				<td>审批结果</td>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>张三</td>
				<td>同意</td>
			</tr>
			<tr>
				<td>李四</td>
				<td>同意</td>
			</tr>
		</tbody>
	</table>
	<%if("1".equals(review)){
		%>
	<p class="row-5"></p>
	<span class="button ok">同意</span>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<span class="button cancel">拒绝</span>
		<%
	} %>
</div>

<%@ include file="/shared/footer.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	request.setCharacterEncoding("UTF-8");
	String appUrl = request.getContextPath();
%>

<jsp:include page="/shared/header.jsp">
	<jsp:param name="title" value="通讯录" />
</jsp:include>

<div class="padding-large text-center">
	<p class="row-10"></p>
	<p class="f5">同步微信组织结构：</p>
	<p class="row-5"></p>
	<span class="button ok" onclick="sync()">确认</span>
</div>
<script>
	function sync(){
		location.href='<%=appUrl%>/admin/sync?op=dep';
	}
</script>

<%@ include file="/shared/footer.jsp"%>
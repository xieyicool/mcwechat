<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%
	request.setCharacterEncoding("UTF-8");
	String appUrl = "http://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath();
	String time = (String)request.getAttribute("time");
%>
<jsp:include page="/shared/header.jsp">
	<jsp:param name="title" value="出勤查询" />
</jsp:include>
<script type="text/javascript"
	src="<%=appUrl%>/include/jquery/jquery-1.10.2.min.js"></script>
<script type="text/javascript"
	src="<%=appUrl%>/include/kalendar/kalendar.js"></script>
<link type="text/css" rel="stylesheet"
	href="<%=appUrl%>/include/kalendar/kalendar.css">

<div class="page-attendance form-simple padding">
	<p class="row-2"></p>
	<div id="calender"></div>
	<p class="row-5"></p>
	<div class="scroll-horizontal">
		<c:forEach items="${attendanceList}" var="item">

			<table class="width-full border-light simple">
				<colgroup>
					<col width="100" />
				</colgroup>
				<tr>
					<td class="text-bold">日期:</td>
					<td><fmt:formatDate value="${item.countDate }"
							pattern="yyyy-MM-dd" /></td>
				</tr>
				<tr>
					<td class="text-bold">考勤状态:</td>
					<td>${item.status }</td>
				</tr>
				<tr>
					<td class="text-bold">刷卡状态:</td>
					<td>${item.checkinStatus}</td>
				</tr>
				<tr>
					<td class="text-bold">出勤小时:</td>
					<td>${item.attendantHours }</td>
				</tr>
				<tr>
					<td class="text-bold">缺勤小时:</td>
					<td>${item.absentHours}</td>
				</tr>
				<tr>
					<td class="text-bold">请假小时:</td>
					<td>${item.leaveHours}</td>
				</tr>
				<tr>
					<td class="text-bold">加班小时:</td>
					<td>${item.overtimeHours }</td>
				</tr>


			</table>
			<p class="row-5"></p>
		</c:forEach>

	</div>

</div>
<script>
	kalendar('#calender', '<%=time%>', {dayClick: function(date){
		location.href='<%=appUrl%>/employee/attendance?time='+date.format('yyyy-MM-dd');
	}});
	Date.prototype.format = function (format) {
	    var o = {
	        "M+": this.getMonth() + 1, //month
	        "d+": this.getDate(), //day
	        "h+": this.getHours(), //hour
	        "m+": this.getMinutes(), //minute
	        "s+": this.getSeconds(), //second
	        "q+": Math.floor((this.getMonth() + 3) / 3), //quarter
	        "S": this.getMilliseconds() //millisecond
	    }
	    if (/(y+)/.test(format)) format = format.replace(RegExp.$1,
	        (this.getFullYear() + "").substr(4 - RegExp.$1.length));
	    for (var k in o) if (new RegExp("(" + k + ")").test(format))
	        format = format.replace(RegExp.$1,
	        RegExp.$1.length == 1 ? o[k] :
	        ("00" + o[k]).substr(("" + o[k]).length));
	    return format;
	};
	function checkMonth(){
		var value = document.getElementById('Month').value;
		location.href='<%=appUrl%>/employee/attendance?time=' + value;
	}
</script>
<%@ include file="/shared/footer.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");
	String appUrl = "http://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath();
	
	
%>
<jsp:include page="/shared/header.jsp">
	<jsp:param name="title" value="移动考勤" />
</jsp:include>
<script type="text/javascript" src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>

<div class="page-attendance form-simple padding text-center">
	<p class="row-10"></p>
	
	<span type="button" onclick="checkin()" class="button large ok">签到</span>
	<p class="row-2"></p>
	<p class="text-light">请到达工作地点后，再点击签到</p>

</div>
<script>
	wx.config({
	    appId: 'wx5b89c447b32fe3eb',
	    timestamp: <%=request.getAttribute("timestamp")%>,
	    nonceStr: '<%=request.getAttribute("nonceStr")%>',
	    signature: '<%=request.getAttribute("signature")%>',
	    jsApiList: [
	        // 所有要调用的 API 都要加到这个列表中
	        'checkJsApi',
	        'openLocation',
	        'getLocation'
	      ]
	});
	function checkin(){
		wx.checkJsApi({
		    jsApiList: [
		        'getLocation'
		    ],
		    success: function (res) {
		        if (res.checkResult.getLocation == false) {
		            alert('你的微信版本太低，不支持微信JS接口，请升级到最新的微信版本！');
		            return;
		        }
		        
				wx.getLocation({
				    success: function (res) {
				        var latitude = res.latitude; // 纬度，浮点数，范围为90 ~ -90
				        var longitude = res.longitude; // 经度，浮点数，范围为180 ~ -180。
				        location.href = '<%=appUrl%>/employee/docheckin?lon=' + longitude + '&lat=' + latitude;
				    },
				    cancel: function (res) {
				        alert('用户拒绝授权获取地理位置');
				    }
				});
		    }
		});
	}
</script>
<%@ include file="/shared/footer.jsp"%>
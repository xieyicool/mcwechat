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

<div class="bd">
<!--    <div class="weui_panel weui_panel_access" >

         <div class="weui_panel_bd" >
                <div class="weui_media_hd" align="center" >
           <img class="weui_media_appmsg_thumb" src="../image/weui/eg_planets.jpg" width="120" height="120">
                </div>
        </div>
         -->
    <div class="weui_cells weui_cells_form" style="margin-top:0em;">
    	<div class="weui_cell" style="padding-top:5px;padding-bottom:5px;">
            <div class="weui_cell_hd"><label class="weui_label">头像</label></div>
            <div class="weui_cell_bd weui_cell_primary" align="right">
                <img class="weui_media_appmsg_thumb" src="../image/weui/eg_planets.jpg" width="60" height="60">
            </div>
        </div> 
        <div class="weui_cell" style="padding-top:5px;padding-bottom:5px;">
            <div class="weui_cell_hd"><label class="weui_label">工号</label></div>
            <div class="weui_cell_bd weui_cell_primary" align="right">
                <label class="weui_input"  placeholder="员工工号"/>${employee.empNo }</label>
            </div>
        </div> 
        <div class="weui_cell" style="padding-top:5px;padding-bottom:5px">  
            <div class="weui_cell_hd"><label class="weui_label">姓名</label></div>
            <div class="weui_cell_bd weui_cell_primary" align="right">
                <label class="weui_input"  placeholder="姓名"/>${employee.name}</label>
            </div>
        </div> 
        <div class="weui_cell" style="padding-top:5px;padding-bottom:5px">      
            <div class="weui_cell_hd"><label class="weui_label">部门</label></div>
            <div class="weui_cell_bd weui_cell_primary" align="right">
                <label class="weui_input"  placeholder="部门"/>${employee.dep }</label>
            </div>
        </div> 
        <div class="weui_cell" style="padding-top:5px;padding-bottom:5px">      
            <div class="weui_cell_hd"><label class="weui_label">职位</label></div>
            <div class="weui_cell_bd weui_cell_primary" align="right">
                <label class="weui_input"  placeholder="职位"/>${employee.job }</label>
            </div>
        </div> 
        <div class="weui_cell" style="padding-top:5px;padding-bottom:5px">  
            <div class="weui_cell_hd"><label class="weui_label">汇报上级</label></div>
            <div class="weui_cell_bd weui_cell_primary" align="right">
                <label class="weui_input"  placeholder="汇报上级"/>${employee.reporter}</label>
            </div>
        </div> 
        <div class="weui_cell" style="padding-top:5px;padding-bottom:5px">      
            <div class="weui_cell_hd"><label class="weui_label">入职日期</label></div>
            <div class="weui_cell_bd weui_cell_primary" align="right">
                <label class="weui_input"  placeholder="入职日期"/>${employee.onboardDate.toString() }</label>
            </div>
         </div> 
        <div class="weui_cell" style="padding-top:5px;padding-bottom:5px">     
            <div class="weui_cell_hd"><label class="weui_label">在职状态</label></div>
            <div class="weui_cell_bd weui_cell_primary" align="right">
                <label class="weui_input"  placeholder="在职状态"/>${employee.workStatus }</label>
            </div>
         </div> 
        <div class="weui_cell" style="padding-top:5px;padding-bottom:5px">     
            <div class="weui_cell_hd"><label class="weui_label">电话</label></div>
            <div class="weui_cell_bd weui_cell_primary" align="right">
                <label class="weui_input"  placeholder="电话"/>${employee.mobile}</label>
            </div>
         </div> 
        <div class="weui_cell" style="padding-top:5px;padding-bottom:5px"> 
            <div class="weui_cell_hd"><label class="weui_label">邮箱</label></div>
            <div class="weui_cell_bd weui_cell_primary" align="right">
                <label class="weui_input"  placeholder="邮箱"/>${employee.email}</label>
            </div>
         </div>
        </div>
    </div>
 </div> 

<%@ include file="../shared/footer.jsp"%>
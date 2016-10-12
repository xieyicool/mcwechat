<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	//String appUrl = request.getContextPath();
	String appUrl = "http://"+ request.getServerName()+ ":"+ request.getServerPort() + request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no" />
    <meta name="format-detection" content="telephone=no" />
    <title><%=request.getParameter("title") %></title>
    <link href="<%=appUrl %>/css/weui.min.css" rel="stylesheet" />
    <link href="<%=appUrl %>/css/main.css" rel="stylesheet" />
</head>
<body>
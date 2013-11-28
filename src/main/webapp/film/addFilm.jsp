<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'MainConsole.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="StyleSheet" href="css/zTreeStyle/zTreeStyle.css" type="text/css" />
	 <style>
	body {
	background-color: white;
	margin:0; padding:0;
	text-align: center;
	}
	div, p, table, th, td {
		list-style:none;
		margin:0; padding:0;
		color:#333; font-size:12px;
		font-family:dotum, Verdana, Arial, Helvetica, AppleGothic, sans-serif;
	}
	#testIframe {margin-left: 10px;}
  </style>
  </head> 
<div class="pageContent">
<form method="post" action="/film_c/addFilm" class="required-validate pageForm" onsubmit="return validateCallback(this, dialogReloadNavTab);">
	<div class="pageFormContent" layoutH="58">
	<p>
		<label>节目名称：</label>
		<input type="text" name="title" class="validate[required,maxSize[32]] required" size="32" maxlength="32"/>
	</p>
	
	<p>
		<label>演员：</label>
		<textarea name="actor" cols="28" rows="3" maxlength="255"></textarea>
	</p>
	
	<p>
		<label>导演：</label>
		<textarea name="director" cols="28" rows="3" maxlength="255"></textarea>
	</p>
	<p>
		<label>语言：</label>
		<textarea name="language" cols="28" rows="3" maxlength="255"></textarea>
	</p>
	<p>
		<label>发行年份：</label>
		<textarea name="release_year" cols="28" rows="3" maxlength="255"></textarea>
	</p>
	<p>
		<label>国家：</label>
		<textarea name="country" cols="28" rows="3" maxlength="255"></textarea>
	</p>
	<p>
		<label>片长：</label>
		<textarea name="length" cols="28" rows="3" maxlength="255"></textarea>
	</p>
	<p>
		<label>影片类型：</label>
		<textarea name="genre" cols="28" rows="3" maxlength="255"></textarea>
	</p>
	<p>
		<label>描述：</label>
		<textarea name="description" cols="28" rows="3" maxlength="255"></textarea>
	</p>
	</div>
	
	<div class="formBar">
		<ul>
			<li><div class="button"><div class="buttonContent"><button type="submit">确定</button></div></div></li>
			<li><div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div></li>
		</ul>
	</div>
</form>
</div>
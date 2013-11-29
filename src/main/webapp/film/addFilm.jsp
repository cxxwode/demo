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
	div, p, table, th, td {
		align:center;
		list-style:none;
		margin:0; padding:0;
		color:#333; font-size:12px;
		font-family:dotum, Verdana, Arial, Helvetica, AppleGothic, sans-serif;
	}
	
	.pageContent {align: center; width:100%}
  </style>
  </head> 
<div class="pageContent">
<form method="post" action="/film_c/addFilm" class="required-validate pageForm" onsubmit="return validateCallback(this, dialogReloadNavTab);">
	<table class="pageFormContent" layoutH="58">
	<tr>
		<td><label>节目名称：</label></td>
		<td><input type="text" name="title" class="validate[required,maxSize[32]] required" size="10" maxlength="10"/></td>
		<td><label>演员：</label></td>
		<td><input name="actor" cols="28" rows="3" maxlength="255"></input></td>
	</tr>
	<tr>	
		<td><label>导演：</label></td>
		<td><input name="director" cols="28" rows="3" maxlength="255"></input></td>
		<td><label>语言：</label></td>
		<td><input name="language" cols="28" rows="3" maxlength="255"></input></td>
	</tr>
	<tr>
		<td><label>发行年份：</label></td>
		<td><input name="release_year" cols="28" rows="3" maxlength="255"></input></td>
		<td><label>国家：</label></td>
		<td><input name="country" cols="28" rows="3" maxlength="255"></input></td>
	</tr>
	<tr>
		<td><label>片长：</label></td>
		<td><input name="length" cols="28" rows="3" maxlength="255"></input></td>
		<td><label>影片类型：</label></td>
		<td><input name="genre" cols="28" rows="3" maxlength="255"></input></td>
	</tr>
	<tr>
		<td><label>poster：</label></td>
		<td><input name="poster" type="file"></input></td>
	</tr>
	<tr>
		<td><label>subtitle：</label></td>
		<td><input name="srt" type="file"></input></td>
	</tr>
	<tr>
		<td><label>content：</label></td>
		<td><input name="content" type="file"></input></td>
	</tr>
	<tr>
		<td><label>描述：</label></td>
		<td><textarea name="description" cols="28" rows="3" maxlength="255"></textarea></td>
	</tr>
	</table>
	
	<div class="formBar">
		<div class="button">
			<button type="submit">确定</button>
			<button type="button" class="close">关闭</button>
		</div>
	</div>
</form>
</div>

</html>
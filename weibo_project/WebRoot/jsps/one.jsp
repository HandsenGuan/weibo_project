<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'one.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <form action="/weibo_project/test?method=add" method="post">
  	<table width="319" border="1" cellpadding="1">

  <tr>
    <td>id:</td>
    <td><input name="user_id" type="text" value="u0000000007"/></td>
  </tr>
  <tr>
    <td>nickname:</td>
    <td><input name="user_nickname" type="text" value="昵称7"/></td>
  </tr>
  <tr>
    <td>image</td>
    <td><input name="user_image" type="file" value="null"/></td>
  </tr>
  <tr>
    <td>email</td>
    <td><input name="user_email" type="text" /></td>
  </tr>
  <tr>
    <td>password</td>
    <td><input name="user_password" type="text" /></td>
  </tr>
  <tr>
    <td>sex</td>
    <td><input name="user_sex" type="text" /></td>
  </tr>
  <tr>
    <td>name</td>
    <td><input name="user_name" type="text" /></td>
  </tr>
  <tr>
    <td>skin</td>
    <td><input name="user_skin" type="text" /></td>
  </tr>
  <tr>
    <td>qq</td>
    <td><input name="user_qq" type="text" /></td>
  </tr>
  <tr>
    <td>school</td>
    <td><input name="user_school" type="text" /></td>
  </tr>
  <tr>
    <td>work</td>
    <td><input name="user_work" type="text" /></td>
  </tr>
  <tr>
    <td>tel</td>
    <td><input name="user_tel" type="text" /></td>
  </tr>
  <tr>
    <td>info</td>
    <td><input name="user_info" type="text" /></td>
  </tr>
  <tr>
    <td>datetime</td>
    <td><input name="user_datetime" type="text" /></td>
  </tr>
  <tr>
    <td>blog</td>
    <td><input name="user_blog" type="text" /></td>
  </tr>
  <tr>
    <td>status</td>
    <td><input name="status" type="text" /></td>
  </tr>
  <tr>
    <td></td>
    <td><input name="input17" type="submit" value="submit" /></td>
  </tr>
</table>
  
  
  
  </form>
    
  </body>
</html>

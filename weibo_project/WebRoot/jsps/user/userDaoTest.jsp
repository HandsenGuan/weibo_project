<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
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
   		<%=basePath%><br>
   		<%=path %><br>
   		<c:choose>
   			<c:when test="${choose==1 }">
			
			注册<br>
				
			<form:form commandName="user" action="test?method=add" method="post">     
       		user_id:<form:input path="user_id" /><br />
       		user_nickname:<form:input path="user_nickname" /><br />
      		user_password:<form:password path="user_password" /><br />
      		user_email:<form:input path="user_email" /><br />
      		
			<input type="submit" value="Submit" />
			</form:form>

			
   				
   			</c:when>
   			
   			<c:when test="${choose==2 }">
   				登录<br>
   			
   			</c:when>
   			
   			
   			<c:when test="${choose==3 }">
   				
   			修改<br>
   			<form:form  commandName="user" action="test?method=update" method="post">     
       		user_id:<form:input path="user_id" /><br />
       		user_nickname:<form:input path="user_nickname" /><br />
      		user_password:<form:input path="user_password" /><br />
      		user_email:<form:input path="user_email" /><br />
      		<%-- user_image:<form:input path="user_image" /><br />
      		user_sex:<form:input path="user_sex" /><br />
      		user_name:<form:input path="user_name" /><br />
      		user_skin:<form:input path="user_skin" /><br />
      		user_qq:<form:input path="user_qq" /><br />
      		user_school:<form:input path="user_school" /><br />
      		user_work:<form:input path="user_work" /><br />
      		user_tel:<form:input path="user_tel" /><br />
      		user_info:<form:input path="user_info" /><br />
      		user_datetime:<form:input path="user_datetime" /><br />
      		user_blog:<form:input path="user_blog" /><br />
      		user_status:<form:input path="user_status" /><br /> --%>
			
			<input type="submit" value="Submit" />
			
			</form:form>
			
   			</c:when>
   			
   			
   			<c:when test="${choose==4 }">
   				查看所有<br>
   				<c:forEach var="user" items="${users }" varStatus="status">
   					<table border="1px" bordercolor="#000000">
   						<tr><td>index:</td><td>${status.index }</td></tr>
   						<tr><td>序号:</td><td>${status.count }</td></tr>
   						<tr><td>id:</td><td>${user.user_id }</td></tr>
   						<tr><td>nickname:</td><td>${user.user_nickname }</td></tr>
   						<tr><td>image:</td><td>${user.user_image }</td></tr>
   						<tr><td>email:</td><td>${user.user_email }</td></tr>
   						<tr><td>password:</td><td>${user.user_password }</td></tr>
   						<tr><td>sex:</td><td>${user.user_sex }</td></tr>
   						<tr><td>name:</td><td>${user.user_name }</td></tr>
   						<tr><td>skin:</td><td>${user.user_skin }</td></tr>
   						<tr><td>qq:</td><td>${user.user_qq }</td></tr>
   						<tr><td>school:</td><td>${user.user_school }</td></tr>
   						<tr><td>work:</td><td>${user.user_work }</td></tr>
   						<tr><td>tel:</td><td>${user.user_tel }</td></tr>
   						<tr><td>info:</td><td>${user.user_info }</td></tr>
   						<tr><td>datetime:</td><td>${user.user_datetime }</td></tr>
   						<tr><td>blog:</td><td>${user.user_blog }</td></tr>
   						<tr><td>status:</td><td>${user.user_status }</td></tr>
   						
   						<c:url var="view_url" value="/test">
   							<c:param name="method">view</c:param>
   							<c:param name="user_id">${user.user_id}</c:param>
   						</c:url>
   						
   						<tr><td><a href="${view_url}">修改信息</a></td><td>	<a href="#">删除</a></td></tr>
   					</table>
   					
   				</c:forEach>
   			
   			</c:when>
   			
   			<c:when test="${choose==5 }">
   				欢迎${username}!
   				
   			</c:when>
   			
   			<c:when test="${choose==6 }">
   				欢迎${user.user_nickname}!<br>
   				<form:form  modelAttribute="user">     
   				user_id:<form:input path="user_id"  readonly="true"/><br />
       			user_nickname:<form:input path="user_nickname" readonly="true"/><br />
      			user_password:<form:password path="user_password" readonly="true"/><br />
      			user_email:<form:input path="user_email" readonly="true"/><br />
      			user_image:<form:input path="user_image" readonly="true"/><br />
      			user_sex:<form:input path="user_sex" readonly="true"/><br />
      			user_name:<form:input path="user_name" readonly="true"/><br />
      			user_skin:<form:input path="user_skin" readonly="true"/><br />
      			user_qq:<form:input path="user_qq" readonly="true"/><br />
      			user_school:<form:input path="user_school" readonly="true"/><br />
      			user_work:<form:input path="user_work" readonly="true"/><br />
      			user_tel:<form:input path="user_tel" readonly="true"/><br />
      			user_info:<form:input path="user_info" readonly="true"/><br />
      			user_datetime:<form:input path="user_datetime" readonly="true"/><br />
      			user_blog:<form:input path="user_blog" readonly="true"/><br />
      			user_status:<form:input path="user_status" readonly="true"/><br />
   				</form:form>
   			</c:when>
   			
   			
   			
   		</c:choose>
   		
   		<c:url var="select_url" value="/test">
   			<c:param name="method">select</c:param>
   		</c:url>
   			<a href="${select_url}">查看所有用户</a>
   		
   		
  </body>
</html>

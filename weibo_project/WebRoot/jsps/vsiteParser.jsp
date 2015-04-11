<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'vsiteParser.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script src="vsiteparser/vsparser.js"></script>
	<script>
		window.onload = function(){
			document.getElementById("insert").onclick = function(){
				url = vsparser(document.getElementById("url").value);
				document.getElementById("vid").innerHTML="<embed src=" + url + " style=\"width: 500px;height:500px;\"/>";

				document.getElementById("url").innerHTML="<p>"+url+"<p>";
				//document.write(url);
			};
		};
	</script>
  </head>
  
  <body>
    <div>
		<input type="text" id="url" style="width: 200px; margin-bottom: 20px;" placeholder="Input video URL here"/>
		<button id="insert">Insert</button>
	</div>
	
	<div id="vid" style="width: 500px;height:500px;">

	</div>

	<div id="url"></div>
  </body>
</html>

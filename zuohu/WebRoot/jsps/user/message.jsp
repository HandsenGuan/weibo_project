<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<title>作乎</title>
<meta charset="utf-8" />
<link rel="stylesheet" type="text/css"
	href="bootstrap/css/bootstrap.min.css">

<link rel="stylesheet" type="text/css"
	href="bootstrap/Flat-UI-master/dist/css/flat-ui.min.css">
<script type="text/javascript" src="bootstrap/js/flat-ui.js"></script>


<script type="text/javascript" src="bootstrap/js/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>

</head>

<body>
	<c:if test="${empty user}">
		<c:redirect url="/user?method=login" />
	</c:if>

	<nav class="navbar navbar-inverse  navbar-static-top" role="navigation">
		<div class="container">
			<!-- 导航栏 -->
			<div class="row">
				<div>

					<!-- Brand and toggle get grouped for better mobile display -->
					<div class="navbar-header">
						<button type="button" class="navbar-toggle" data-toggle="collapse"
							data-target="#navbar-collapse-5">
							<span class="sr-only">折叠汉堡</span> <span class="icon-bar"></span>
							<span class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span> <span class="icon-bar"></span>
						</button>
						<a class="navbar-brand"
							href="<%=request.getContextPath()%>/nav?method=index">Zuo.Hu</a>
					</div>

					<!-- Collect the nav links, forms, and other content for toggling -->
					<div class="collapse navbar-collapse" id="navbar-collapse-5">
						<ul class="nav navbar-nav">
							<li class="active"><a
								href="<%=request.getContextPath()%>/nav?method=index">首页</a></li>
							<li><a href="<%=request.getContextPath()%>/nav?method=sixin">
									消息<span class="navbar-unread"></span>

							</a></li>
							<li><a href="<%=request.getContextPath()%>/nav?method=found">浏览</a></li>

							<li><a
								href="<%=request.getContextPath()%>/nav?method=person">个人</a></li>
							<li><a
								href="<%=request.getContextPath()%>/nav?method=setting">设置</a></li>
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown"> 更多 <b class="caret"></b>
							</a>
								<ul class="dropdown-menu">
									<li><a href="#">开发者介绍</a></li>
									<li class="divider"></li>
									<li><a
										href="<%=request.getContextPath()%>/user?method=exit">退出登录</a></li>
								</ul></li>
						</ul>
						<form class="navbar-form navbar-left"  role="search">
							<div class="form-group">
								<div class="input-group">
									<input class="form-control" id="navbarInput-01" type="search"
										placeholder="搜索"> <span class="input-group-btn">
										<button type="submit" class="btn">
											<span class="fui-search"></span>
										</button>
									</span>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		<!-- /.navbar-collapse -->
	</nav>
	<br>
	
	 <c:choose>
  	<c:when test="${code eq 'success' }">
  		<c:set var="img" value="image/duihao.jpg"/>
  		<c:set var="title" value="激活成功！"/>
  	</c:when>
  	<c:when test="${code eq 'error' }">
  		<c:set var="img" value="image/cuohao.png"/>
  		<c:set var="title" value="激活失败！"/>
  	</c:when>
  	
 	 </c:choose>
	<div class="container">
		<div class="divBody">
			<div class="divTitle">
				<span class="spanTitle">${title }</span>
			</div>
			<div class="divContent">
				<div style="margin: 20px;">
					<img style="float: left; margin-right: 30px;"
						src="${img}" width="150" /> <span
						style="font-size: 30px; color: #c30; font-weight: 900;">${msg }</span>
					<br /> <br /> <br /> <br /> 
					<span style="margin-left: 50px;"><a target="_top"
						href="<%=request.getContextPath()%>/nav?method=index">主页</a></span>
				</div>
			</div>
		</div>



	</div>



</body>
</html>

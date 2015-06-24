<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<meta charset="utf-8" />

<head>
<title>群主页</title>
<link rel="stylesheet" type="text/css"
	href="bootstrap/css/bootstrap.min.css">

<link rel="stylesheet" type="text/css"
	href="bootstrap/Flat-UI-master/dist/css/flat-ui.css">
<link rel="shortcut icon" type="text/css" href="bootstrap/img/icon2.ico">

<script type="text/javascript" src="bootstrap/js/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>

<style>
body {
	background-color: #ECF0F1;
}

.brief img {
	height: 140px;
	margin-left:30px;
}

.brief {
	float: left;
}

.clear {
	clear: both;
}

.col-lg-8 {
	background-color: #fff;
	border-radius: 10px;
}

.img-rounded {
	margin-left: 35%;
}

.panel {
	width: 80%;
	margin-left: 10%;
}
</style>
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
							<li ><a
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
						<form class="navbar-form navbar-left" action="#" role="search">
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
						<!-- 只有用户激活后才能使用该功能 -->
					<c:if test="${user.status==true}">
						<ul class="nav navbar-nav navbar-right">
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown"> 工具集 <b class="caret"></b>
							</a>
								<ul class="dropdown-menu">
									<li><a href="#">饼状图</a></li>
									<li><a href="#">折线图</a></li>
									<li><a href="#">条形图</a></li>
									<li class="divider"></li>
									<li><a href="#">Separated link</a></li>
								</ul></li>
						</ul>
					</c:if>
					</div>

				</div>
			</div>
		</div>
		<!-- /.navbar-collapse -->
	</nav>

	<br>
	<!--导航条结束-->


	<!--群主要面板，包括群介绍和群成员介绍-->
	<div class="row">
		<div class="col-lg-8">

			<div class="panel">
				<div class="panel-heading">
					<img class="img-rounded" src="bootstrap/img/9.jpg" height="140"
						width="140" />
				</div>

				<div class="panel-body">

					<div class="row">
						<div class="col-md-offset-4">
						<h5>${group.g_name }</h5>
						</div>
						<p class="text-left">${group.g_desc}</p>
						<hr style="border:1px dashed; height:1px" color="#DDDDDD">
					</div>
					<!--群介绍结束分割线，下面是群成员，一个row就是一个成员-->
					<c:forEach var="groupuser" items="${users}">
						<div class="row">
							<p>
							<h6>
							<a href="<%=request.getContextPath()%>/nav?method=person&u_id=${groupuser.user.u_id}">
								<img src="${groupuser.user.user_img}" height="50" width="50">
							</a>
								&nbsp;&nbsp;&nbsp;${groupuser.user.nickname}&nbsp;&nbsp;&nbsp;
								<button class="btn btn-primary group_follow_btn">
									<input type="hidden" value="${groupuser.user.u_id}"/>
									<span class="glyphicon glyphicon-plus"></span> 关注
								</button>
								
							</h6>
							</p>
							<br>
							<div>
								<c:if test="${!empty groupuser.user.messages}">
									<c:forEach items="${groupuser.user.messages}" var="message"
										begin="0" end="4">
										<div class="brief">
											<c:if test="${message.type==1}">
												<c:if test="${!empty message.src }">
													<img src="${message.src}" />
												</c:if>
											</c:if>
										</div>
									</c:forEach>
								</c:if>
								<c:if test="${empty groupuser.user.messages}">
									<h6>该用户比较懒，未发布任何状态！</h6>
								</c:if>

							</div>
							<div class="clear"></div>
							<hr style="border:1px dashed; height:1px" color="#DDDDDD">
						</div>
					</c:forEach>
					<!--一个成员结束-->
				</div>


			</div>

		</div>



		<div class="col-lg-4">
			<!--右栏推荐-->
			<div class="panel">
				<div class="panel-body">
					<li style="list-style:none;"><a href=""
						class="list-group-item"
						style="background:url(bootstrap/img/you1.jpg);background-position:center center; height:120px;text-align:center;padding:30px 20px; "><h6
								style="color:#fff; ">我爱生活</h6></a></li>

					<li style="list-style:none;"><a href=""
						class="list-group-item"
						style="background:url(bootstrap/img/you2.jpg);background-position:center center; height:120px;text-align:center;padding:30px 20px; "><h6
								style="color:#fff; ">我爱生活</h6></a></li>
					<li style="list-style:none;"><a href=""
						class="list-group-item"
						style="background:url(bootstrap/img/you3.jpg);background-position:center center; height:120px;text-align:center;padding:30px 20px; "><h6
								style="color:#fff;">我爱生活</h6></a></li>
				</div>
				<div class="panel-footer">更多作群推荐>></div>

			</div>
			<div class="panel">
				<div class="panel-body">
					<li style="list-style:none;"><a href=""
						class="list-group-item"
						style="background:url(bootstrap/img/1.jpg);background-position:center center; height:120px;text-align:center;padding:30px 20px; "><h6
								style="color:#fff; ">我爱生活</h6></a></li>

					<li style="list-style:none;"><a href=""
						class="list-group-item"
						style="background:url(bootstrap/img/2.jpg);background-position:center center; height:120px;text-align:center;padding:30px 20px; "><h6
								style="color:#fff; ">我爱生活</h6></a></li>
					<li style="list-style:none;"><a href=""
						class="list-group-item"
						style="background:url(bootstrap/img/3.jpg);background-position:center center; height:120px;text-align:center;padding:30px 20px; "><h6
								style="color:#fff;">我爱生活</h6></a></li>
				</div>
				<div class="panel-footer">更多作群推荐>></div>

			</div>


		</div>
	</div>
	
	<script type="text/javascript" src="myjs/user/person.js"></script>
</body>
</html>
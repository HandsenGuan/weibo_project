<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>

<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="stylesheet" type="text/css"
	href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="bootstrap/Flat-UI-master/dist/css/flat-ui.css">

<script type="text/javascript" src="bootstrap/js/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>



<title>关注</title>
<link rel="shortcut icon" type="text/css" href="bootstrap/img/icon2.ico">
<style>
body {
	background-color: #ECF0F1;
	min-height: 2000px;
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
							<li><a
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
					</div>

				</div>
			</div>
		</div>
		<!-- /.navbar-collapse -->
	</nav>

	<br>
	<!--navbar结束-->


	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<!--main-->
				<div class="row">
					<!--私聊部分-->
					<div class="col-md-9">
						<div class="panel">
							<div class="panel-heading">
								<h4>我的关注</h4>
							</div>
							<div class="panel-body">
								<table class="table">

									<tr>
										<td style="background-color:#ECF0F1;">
										<a href="" style="float:left; padding:15px ;"> 
										<img src="bootstrap/img/1.jpg" height="50" width="50">
										</a>
										<span>
												<li style="list-style:none;padding:10px 5px 0px 5px;">
													<strong><small>女王大人</small></strong>
												</li>

												<li style="list-style:none; font-size:12px;">
												<small>04/28 2015更新</small>
												</li>
										</span>
										</td>
										
										<td style="background-color:#ecf7f7;"><a href=""
											style="float:left; padding:15px ;"> <img src="bootstrap/img/2.jpg"
												height="50" width="50">
										</a> <span>
												<li style="list-style:none;padding:10px 5px 0px 5px;">
													<strong><small>女王大人</small></strong>
											</li>

												<li style="list-style:none; font-size:12px;"><small>04/28
														2015更新</small></li>

										</span></td>
									</tr>
									<tr>
										<td style="background-color:#ecf7f7;"><a href=""
											style="float:left; padding:15px ;"> <img src="bootstrap/img/3.jpg"
												height="50" width="50">
										</a> <span>
												<li style="list-style:none;padding:10px 5px 0px 5px;">
													<strong><small>女王大人</small></strong>
											</li>

												<li style="list-style:none; font-size:12px;"><small>04/28
														2015更新</small></li>

										</span></td>
										<td style="background-color:#ECF0F1;"><a href=""
											style="float:left; padding:15px ;"> <img src="bootstrap/img/4.jpg"
												height="50" width="50">
										</a> <span>
												<li style="list-style:none;padding:10px 5px 0px 5px;">
													<strong><small>女王大人</small></strong>
											</li>

												<li style="list-style:none; font-size:12px;"><small>04/28
														2015更新</small></li>

										</span></td>
									</tr>
									<tr>
										<td style="background-color:#ECF0F1;"><a href=""
											style="float:left; padding:15px ;"> <img src="bootstrap/img/5.jpg"
												height="50" width="50">
										</a> <span>
												<li style="list-style:none;padding:10px 5px 0px 5px;">
													<strong><small>女王大人</small></strong>
											</li>

												<li style="list-style:none; font-size:12px;"><small>04/28
														2015更新</small></li>

										</span></td>
										<td style="background-color:#ecf7f7;"><a href=""
											style="float:left; padding:15px ;"> <img src="bootstrap/img/6.jpg"
												height="50" width="50">
										</a> <span>
												<li style="list-style:none;padding:10px 5px 0px 5px;">
													<strong><small>女王大人</small></strong>
											</li>

												<li style="list-style:none; font-size:12px;"><small>04/28
														2015更新</small></li>

										</span></td>
									</tr>
								</table>
							</div>
							<div class="panel-footer"></div>
						</div>

					</div>

					<!-- 右侧菜单框 -->
					<div class="col-md-3">
						<div class="menu">

							<p>

								<a class="list-group-item"
									style="background-color:#16A085; color:#fff"><span
									class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;&nbsp;${user.nickname}
								</a>
								<a class="list-group-item"
									style="background-color:#2C3E50; color:#fff" href="<%=request.getContextPath()%>/nav?method=person">
									<span class="glyphicon glyphicon-pencil"></span>&nbsp;&nbsp;&nbsp;状态
									<span class="badge">${user.message_num}</span>
								</a> 
								<a class="list-group-item" style="background-color:#2C3E50; color:#fff" href="<%=request.getContextPath()%>/user?method=follow">
								<span class="glyphicon glyphicon-star"></span>&nbsp;&nbsp;&nbsp;关注
								<span class="badge">${user.follow_num}</span>
								</a> 
								<a class="list-group-item" style="background-color:#2C3E50; color:#fff">
								<span
									class="glyphicon glyphicon-heart"></span>&nbsp;&nbsp;&nbsp;收藏<span
									class="badge">${user.fav_num}</span></a>
							<div class="panel-group" id="accordion">
								<div class="panel panel-default">

									<div class="panel-heading"
										style="background-color:#f4fbf8;color:#2C3E50;height:50px;padding:18px;">
										<h4 class="panel-title" style="text-align:left;">
											<a data-toggle="collapse" data-parent="#accordion"
												href="#collapseOne"><span
												class="glyphicon glyphicon-folder-open">&nbsp;<strong>我的工作ZUO群</strong></span></a>
										</h4>
									</div>

									<div id="collapseOne" class="panel-collapse collapse in">
										<div class="panel-body">
											<c:forEach var="groupuser" items="${user.groups}">
												<div class="row">
													<div class="col-md-offset-2">
														<a
															href="<%=request.getContextPath()%>/nav?method=group&g_id=${groupuser.group.g_id}">${groupuser.group.g_name }</a>
													</div>
												</div>
											</c:forEach>
										</div>
									</div>
								</div>

								<div class="panel panel-default">
									<div class="panel-heading"
										style="background-color:#f4fbf8;color:#2C3E50;height:50px;padding:18px;">
										<h4 class="panel-title" style="  text-align:left;">
											<a data-toggle="collapse" data-parent="#accordion"
												href="#collapseTwo"><span
												class="glyphicon glyphicon-glass">&nbsp;<strong>我的生活ZUO群</strong></span></a>
										</h4>
									</div>
									<div id="collapseTwo" class="panel-collapse collapse">
										<div class="panel-body">
											<div class="row">
												<div class="col-md-offset-2">生活群一</div>
											</div>
											<div class="row">
												<div class="col-md-offset-2">生活群二</div>
											</div>
											<div class="row">
												<div class="col-md-offset-2">生活群三</div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<!-- 右三 -->
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

						</div>
						<!--右侧导航栏结束-->
					</div>
					<!--main结束-->
					<!--footer-->
					<div class="row"></div>
					<!--footer-->
				</div>
			</div>
		</div>




	</div>
</body>
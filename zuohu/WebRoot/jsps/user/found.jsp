<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<meta charset="utf-8" />

	<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css">

	<link rel="stylesheet" type="text/css" href="bootstrap/Flat-UI-master/dist/css/flat-ui.css">
	
	<link rel="shortcut icon" type="text/css" href="bootstrap/img/icon2.ico">

	<script type="text/javascript" src="bootstrap/js/jquery-1.11.2.min.js"></script>
	<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>

	<script type="text/javascript" src="bootstrap/unslider-master/src/unslider.js"></script>
	<link rel="stylesheet" type="text/css" href="bootstrap/css/foundcss/demo.css">
	<noscript>
	<link rel="stylesheet" type="text/css" href="bootstrap/css/foundcss/noJS.css">
	</noscript>
	<link rel="stylesheet" type="text/css" href="bootstrap/css/foundcss/style.css">
	<script type="text/javascript" src="bootstrap/js/foundjs/jquery.hoverdir.js"></script>
	<script type="text/javascript" src="bootstrap/js/foundjs/modernizr.custom.97074.js"></script>
	
	
	<script type="text/javascript" src="myjs/user/login.js"></script>
	<script type="text/javascript" src="myjs/user/jquery.cookie.js"></script>
	<link rel="stylesheet" type="text/css" href="bootstrap/css/load.css">

<head>
	<title>浏览</title>
	<style>
      body {
        min-height: 2000px;
        background-color:#ECF0F1;
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
							<li  class="active"><a href="<%=request.getContextPath()%>/nav?method=found">浏览</a></li>

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
	
	
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<div id="myCarousel" class="carousel slide">
					<!-- 轮播（Carousel）指标 -->
					<ol class="carousel-indicators">
						<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
						<li data-target="#myCarousel" data-slide-to="1"></li>
						<li data-target="#myCarousel" data-slide-to="2"></li>
					</ol>
					<!-- 轮播（Carousel）项目 -->
					<div class="carousel-inner">

						<div class="item active">
							<img src="bootstrap/img/subway.jpg" height="406" width="1400" alt="First slide"></div>
						<div class="item">
							<img src="bootstrap/img/sunset.jpg" height="406" width="1400" alt="Second slide"></div>
						<div class="item">
							<img src="bootstrap/img/wood.jpg" height="406" width="1400" alt="Third slide"></div>
					</div>
					<!-- 轮播（Carousel）导航 -->
					<a class="carousel-control left" href="#myCarousel" data-slide="prev">&lsaquo;</a>
					<a class="carousel-control right" href="#myCarousel" data-slide="next">&rsaquo;</a>
				</div>
			</div>
		</div>
		<br>
		<!--四个介绍button，不同的群-->
		<div class="row">
			<div class="row demo-row">
				<div class="col-lg-3">
					<a href="#fakelink" class="btn btn-block btn-lg btn-primary">工业设计</a>
				</div>
				<div class="col-lg-3">
					<a href="#fakelink" class="btn btn-block btn-lg btn-warning">水下摄影</a>
				</div>
				<div class="col-lg-3">
					<a href="#fakelink" class="btn btn-block btn-lg btn-info">夏季街拍</a>
				</div>
				<div class="col-lg-3">
					<a href="#fakelink" class="btn btn-block btn-lg btn-danger">文化苦旅</a>
				</div>
			</div>
			<br>
				<!-- 群推荐-->
			<div class="row">
				<div class="  col-lg-12">
					<div class="panel panel-success">
						<div class="panel-heading"><div class="panel-title col-lg-offset-6"><h6><strong>作 群</strong></h6></div> </div>
						<div class="panel-body">
							<section class="col-lg-offset-1">

								<ul id="da-thumbs" class="da-thumbs">

									<li>

										<a href="http://dribbble.com/shots/505046-Menu">

											<img src="bootstrap/img/images/9.jpg" />

											<div>
												<span>Menu by Simon Jensen</span>
											</div>

										</a>

									</li>

									<li>

										<a href="http://dribbble.com/shots/504336-TN-Aquarium">

											<img src="bootstrap/img/images/8.jpg" />

											<div>
												<span>TN Aquarium by Charlie Gann</span>
											</div>

										</a>

									</li>

									<li>

										<a href="http://dribbble.com/shots/504197-Mr-Crabs">

											<img src="bootstrap/img/images/7.jpg" />

											<div>
												<span>Mr. Crabs by John Generalov</span>
											</div>

										</a>

									</li>

									<li>

										<a href="http://dribbble.com/shots/503731-Gallery-of-Mo-2-Mo-logo">

											<img src="bootstrap/img/images/6.jpg" />

											<div>
												<span>Gallery of Mo 2.Mo logo by Adam Campion</span>
											</div>

										</a>

									</li>

									<li>

										<a href="http://dribbble.com/shots/503058-Ice-Cream-nom-nom">

											<img src="bootstrap/img/images/5.jpg" />

											<div>
												<span>Ice Cream - nom nom by Eight Hour Day</span>
											</div>

										</a>

									</li>

									<li>

										<a href="http://dribbble.com/shots/502927-My-Muse">

											<img src="bootstrap/img/images/4.jpg" />

											<div>
												<span>My Muse by Zachary Horst</span>
											</div>

										</a>

									</li>

									<li>

										<a href="http://dribbble.com/shots/502538-Natalie-Justin-Cleaning">

											<img src="bootstrap/img/images/3.jpg" />

											<div>
												<span>Natalie & Justin Cleaning by Justin Younger</span>
											</div>

										</a>

									</li>

									<li>

										<a href="http://dribbble.com/shots/502523-App-Preview">

											<img src="bootstrap/img/images/2.jpg" />

											<div>
												<span>App Preview by Ryan Deshler</span>
											</div>

										</a>

									</li>

							 

								</ul>

							</section>
						</div>
						<div class="panel-footer"><h class="col-lg-offset-5">更多发现>></h></div>
					</div>
				</div>
			</div>
			<!--群推荐结束-->
			<br>
			<br>
			<!--达人推荐-->
			<div class="row">
				<div class="  col-lg-12">
					<div class="panel panel-warning">
						<div class="panel-heading"><div class="panel-title col-lg-offset-6"><h6><strong>达人推荐</strong></h6></div> </div>
						<div class="panel-body">
							<div class=" col-lg-offset-1 col-lg-5">
								<div class="thumbnail">
									<p>
										<img src="bootstrap/img/10.jpg" height="140" width="141">							
										<img src="bootstrap/img/11.jpg" height="140" width="141">							
										<img src="bootstrap/img/12.jpg" height="140" width="141"></p>

									<div class="caption">

										<p>
											<h6>
												<img src="bootstrap/img/13.jpg" height="50" width="50"/>							
												&nbsp;&nbsp;&nbsp;赵某某&nbsp;&nbsp;&nbsp;
												<button class="btn btn-primary" href="#">
													<span class="glyphicon glyphicon-plus"></span>
													关注
												</button>
											</h6>
										</p>
									</div>
								</div>
							</div>
							<div class="  col-lg-5">
								<div class="thumbnail">
									<p>
										<img src="bootstrap/img/1.jpg" height="140" width="141">							
										<img src="bootstrap/img/2.jpg" height="140" width="141">							
										<img src="bootstrap/img/3.jpg" height="140" width="141"></p>

									<div class="caption">

										<p>
											<h6>
												<img src="bootstrap/img/you1.jpg" height="50" width="50">							
												&nbsp;&nbsp;&nbsp;刘某某&nbsp;&nbsp;&nbsp;
												<button class="btn btn-primary" href="#">
													<span class="glyphicon glyphicon-plus"></span>
													关注
												</button>
											</h6>
										</p>
									</div>
								</div>
							</div>
							<div class="  col-lg-offset-1 col-lg-5">
								<div class="thumbnail">
									<p>
										<img src="bootstrap/img/4.jpg" height="140" width="141">							
										<img src="bootstrap/img/5.jpg" height="140" width="141">							
										<img src="bootstrap/img/6.jpg" height="140" width="141"></p>

									<div class="caption">

										<p>
											<h6>
												<img src="bootstrap/img/you2.jpg" height="50" width="50">							
												&nbsp;&nbsp;&nbsp;关某某&nbsp;&nbsp;&nbsp;
												<button class="btn btn-primary" href="#">
													<span class="glyphicon glyphicon-plus"></span>
													关注
												</button>
											</h6>
										</p>
									</div>
								</div>
							</div>
							<div class="  col-lg-5">
								<div class="thumbnail">
									<p>
										<img src="bootstrap/img/7.jpg" height="140" width="141">							
										<img src="bootstrap/img/8.jpg" height="140" width="141">							
										<img src="bootstrap/img/9.jpg" height="140" width="141"></p>

									<div class="caption">

										<p>
											<h6>
												<img src="bootstrap/img/you3.jpg" height="50" width="50">							
												&nbsp;&nbsp;&nbsp;张某某&nbsp;&nbsp;&nbsp;
												<button class="btn btn-primary" href="#">
													<span class="glyphicon glyphicon-plus"></span>
													关注
												</button>
											</h6>
										</p>
									</div>
								</div>
							</div>
							</div>
						<div class="panel-footer"><h class="col-lg-offset-5">更多达人>></h></div>
					</div>
				</div>
			</div>
		</div>
		<!--达人推荐结束-->
		<script type="text/javascript">

			$(function() {

				$(' #da-thumbs > li ').each( function() { $(this).hoverdir(); } );

			});

		</script>
	</div>
</body>

	</html>

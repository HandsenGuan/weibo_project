<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8" />

<link rel="stylesheet" type="text/css"
	href="bootstrap/css/bootstrap.min.css">

<link rel="stylesheet" type="text/css" href="bootstrap/Flat-UI-master/dist/css/flat-ui.min.css">
<script type="text/javascript" src="bootstrap/js/flat-ui.js"></script>

<link rel="shortcut icon" type="text/css" href="bootstrap/img/icon2.ico">

<script type="text/javascript" src="bootstrap/js/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>

<script type="text/javascript" src="myjs/user/setting.js"></script>

<script type="text/javascript" src="myjs/ImgCrop/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="myjs/ImgCrop/js/cropbox-min.js"></script>
<script type="text/javascript" src="myjs/ImgCrop/js/cropbox.js"></script>
<script type="text/javascript" src="myjs/ImgCrop/js/cropbox_config.js"></script>
<link rel="stylesheet" href="myjs/ImgCrop/css/style.css" type="text/css" />

<title>设置</title>
<style>
body {
	background-color: #ECF0F1;
	min-height: 800px;
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
							<li  class="active">
								<a href="<%=request.getContextPath()%>/nav?method=setting">设置</a>
							</li>
								<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown"> 更多 <b class="caret"></b>
							</a>
								<ul class="dropdown-menu">
									<li><a href="#">开发者介绍</a></li>
									<li class="divider"></li>
									<li><a href="<%=request.getContextPath()%>/user?method=exit">退出登录</a></li>
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
	<br>
	
	<div class="container">

		<input type="hidden" name="u_id" value="${user.u_id }" id="u_id">

		<!--设置的表格。。。但是没有设置的功能-->
		<div class="row">
			<div class=" col-md-offset-2 col-md-8" style="display:block;"
				id="setting">
				<ul id="myTab" class="nav nav-tabs">
					<li class="active"><a
						href="/demo/bootstrap3-plugin-tab.htm#information"
						data-toggle="tab">资料设置</a></li>
					<li><a href="/demo/bootstrap3-plugin-tab.htm#number"
						data-toggle="tab">账号设置</a></li>

				</ul>
				<div id="myTabContent" class="tab-content">

					<div class="tab-pane fade in active" id="information">
						<div class="panel"
							style="border-left:1px solid #e1e1e1; border-right:1px solid #e1e1e1; border-bottom:1px solid #e1e1e1;">

							<ul class="list-group">

								<li class="list-group-item">
									<div class="row">
										<div class="col-md-2">
											<h>邮箱设置</h>
										</div>
										<div class="col-md-10">
											<ul>
												<li style="list-style:none;"><h>
													<small>为你的主页绑定一个邮箱帐号，绑定后可直接登录Zuo.Hu</small></h></li>
												<li style="list-style:none;"><a id="blinEmail"><small>去绑定邮箱</small><span
														class="glyphicon glyphicon-chevron-right"></span></a></li>
											</ul>

										</div>
									</div>
								</li>

								<li class="list-group-item">
									<div class="row">
										<div class="col-md-2">
											<h>头像设置</h>
										</div>
										<div class="col-md-10">
											<ul>
												<li style="list-style:none;"><h>
													<small>自定义你的用户头像</small></h></li>
												<li style="list-style:none;"><a id="setImg"><small>去设置头像</small><span
														class="glyphicon glyphicon-chevron-right"></span></a></li>
											</ul>

										</div>
									</div>

								</li>

								<li class="list-group-item">
									<div class="row">
										<div class="col-md-2">
											<h>个人信息</h>
										</div>
										<div class="col-md-10">
											<ul>
												<li style="list-style:none;"><h>
													<small>设置你的可见资料，可以让大家更好地了解你</small></h></li>
												<li style="list-style:none;"><a id="setInfo"><small>去设置个人信息</small><span
														class="glyphicon glyphicon-chevron-right"></span></a></li>
											</ul>

										</div>
									</div>

								</li>

							</ul>

						</div>
					</div>

					<div class="tab-pane fade" id="number">
						<div class="panel"
							style="border-left:1px solid #e1e1e1; border-right:1px solid #e1e1e1; border-bottom:1px solid #e1e1e1;">

							<ul class="list-group">
								<li class="list-group-item">
									<div class="row">
										<div class="col-md-2">
											<h>密码修改</h>
										</div>
										<div class="col-md-10">

											<div class="row">
												<div class="form-group">
													<div class="col-md-2">
														<h>原密码</h>
													</div>

													<div class="col-md-5">
														<input type="password" class="form-control"
															placeholder="原密码" id="oldpassword">
													</div>
												</div>

												<label class="col-lg-5 control-label" id="oldpasswordError"></label>

											</div>

											<div class="row">
												<div class="form-group">
													<div class="col-md-2">
														<h>新密码</h>
													</div>

													<div class="col-md-5">
														<input type="password" class="form-control"
															placeholder="新密码" id="newpassword">
													</div>
												</div>

												<label class="col-lg-5 control-label" id="newpasswordError"></label>

											</div>

											<div class="row">

												<div class=" col-md-offset-2 col-md-6">
													<button class="btn btn-primary" id="updatePassword">确认修改</button>
												</div>

											</div>


										</div>
									</div>
								</li>



							</ul>

						</div>
					</div>

				</div>
			</div>

			<!--邮箱设置-->
			<div class="col-md-offset-2 col-md-8" style="display:none;"
				id="email">
				<div class="panel">
					<div class="panel-heading">
						<div class="row">
							<div class="col-md-4">
								<h4>邮箱设置</h4>
							</div>
							<div class="col-md-offset-6 col-md-2" style="margin-top:10px;">
								<a><small class="back">返回资料设置</small></a>
							</div>
						</div>

					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-md-offset-2 col-md-6">
								<label class="col-lg-5 control-label" id="email_inputError"></label>
							</div>
						</div>
						<div class="row">
							<div class="col-md-offset-2 col-md-6">
								<input type="text" class="form-control" id="email_input"
									placeholder="常用邮箱号">
								<button class="btn btn-primary "
									style="margin-top:10px; margin-bottom:40px;" id="setEmail">完成</button>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!--邮箱设置结束-->

			<!--头像设置-->
			<div class="col-md-offset-2 col-md-8" style="display:none;" id="img">
				<div class="panel">
					<div class="panel-heading">
						<div class="row">
							<div class="col-md-4">
								<h5>头像设置</h5>
							</div>
							<div class="col-md-offset-6 col-md-2" style="margin-top:10px;">
								<a><small class="back">返回资料设置</small></a>
							</div>
						</div>
					</div>
					<div class="panel-body" >
						<div class="row">
						<!-- 设置框 -->
						<!--左侧框  -->
						<div class="col-md-7">
						<!--图片选择框  -->
						<div class="row">
						<div class="imageBox">
							<div class="thumbBox"></div>
							<div class="spinner" style="display: none"></div>
						</div>
						</div><!--图片选择框  -->
						<!-- 按钮框 -->
						<div class="row" style="margin-top:10px;">
						<!-- <div class="action"> -->
						<div class="form-group">
						<div class=" col-md-2">
								<input type="button" id="btnZoomIn" class="Btnsty_peyton" value="+">
						</div>
						<div class="col-md-2">
							<input type="button" id="btnZoomOut" class="Btnsty_peyton" value="-">
						</div>
						<div class="col-md-5">
							<div class="form-group">
							<div class="new-contentarea tc">
								<a href="javascript:void(0)" class="upload-img">
								 <label for="upload-file">请先选择图片</label>
								</a> 
								<input type="file" class="" name="upload-file" id="upload-file" />
							</div>
							</div>
						</div>
						<div class="col-md-3">
							<input type="button" id="btnCrop" class="Btnsty_peyton" value="OK">
						</div>
						</div>
						<!-- </div> -->
						</div><!-- 按钮框 -->
						
						</div><!--左侧框  -->
						
						<!--右侧框  -->
						<div class="col-md-offset-1 col-md-4">
							<div class="cropped"></div>
						</div><!--右侧框  -->
						
						</div><!-- ！！！！设置框 -->
					</div>
				</div>
			</div>
			<!--头像设置结束-->

			<!--个人信息设置-->
			<div class="col-md-offset-2 col-md-8" style="display:none;" id="info">
				<div class="panel">

					<ul class="list-group">
						<li class="list-group-item">

							<div class="row">
								<div class="col-md-4">
									<h4>个人信息设置</h4>
								</div>
								<div class="col-md-offset-6 col-md-2" style="margin-top:10px;">
									<a> <small class="back">返回资料设置</small>
									</a>
								</div>
							</div>

						</li>
						<li class="list-group-item">
							<div class="row">

								<div class="col-md-2">
									<h>真实姓名</h>
								</div>
								<div class="col-md-6">

									<div class="form-group">
										<input type="text" class="form-control" placeholder="真实姓名">
									</div>
								</div>
							</div>

						</li>
						<li class="list-group-item">
							<div class="row">

								<div class="col-md-2">
									<h>性别</h>
								</div>
								<div class="col-md-3">

									<label class="radio" for="radio4c"> <input type="radio"
										name="optionsRadios" data-toggle="radio" value="" required>男
									</label>

								</div>
								<div class="col-md-3">

									<label class="radio" for="radio4c"> <input type="radio"
										name="optionsRadios" data-toggle="radio" value="" required>女
									</label>
								</div>
							</div>

						</li>
						<li class="list-group-item">
							<div class="row">

								<div class="col-md-2">
									<h>简短介绍</h>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<textarea class="form-control" rows="3" style="resize:none;"></textarea>
									</div>

								</div>
							</div>

						</li>
					</ul>
				</div>


			</div>
			<!--个人信息设置结束-->
		</div>
	
	</div>
</body>
</html>
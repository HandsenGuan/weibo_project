<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css"
	href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="bootstrap/Flat-UI-master/dist/css/flat-ui.css">
<script type="text/javascript" src="bootstrap/js/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<link rel="shortcut icon" type="text/css" href="bootstrap/img/icon2.ico">

<script type="text/javascript" src="myjs/user/regist-login.js"></script>
<script type="text/javascript" src="myjs/user/jquery.cookie.js"></script>

<style type="text/css">
.container {
	margin-top: 5%;
	text-align: center;
}

body {
	background-color: #ECF0F1;
}
</style>
</head>
<body>
	<div class="container ">
		<div class="row">

			<img src="bootstrap/img/flogo.png" height="103" width="310">
			<h6>Play hard,work harder!</h6>

		</div>
		<div class="row">
			<div class="col-md-offset-3 col-md-6">
				<ul id="myTab" class="nav nav-tabs">
					<li >
						<a href="/demo/bootstrap3-plugin-tab.htm#signin" data-toggle="tab" style="width:275px;"><strong>注册</strong></a>
					</li>
					<li class="active">
						<a href="/demo/bootstrap3-plugin-tab.htm#load" data-toggle="tab" style="width:276px;"><strong>登录</strong></a>
					</li>

				</ul>
				
				<div id="myTabContent" class="tab-content">
					<!-- 注册 -->
					<div class="tab-pane fade " id="signin">
						<div class="panel" style="border-left:1px solid #e1e1e1; border-right:1px solid #e1e1e1; border-bottom:1px solid #e1e1e1;">
							<div class="panel-body">
								<form action="<%=request.getContextPath()%>/user?method=submit" class="form-horizontal" role="form" method="post">
									<div class="form-group">
										<label for="firstname" class="col-lg-2 control-label">
										<span class="glyphicon glyphicon-user"></span> 
										</label>
										<div class="col-lg-6">
											<input type="text" class="form-control" id="name" name="username" placeholder="用户名">
										</div>

										<label class="col-lg-4 control-label" id="nameError"></label>
									</div>
									
										
									<div class="form-group">
										<label for="firstname" class="col-lg-2 control-label"> <span
											class="glyphicon glyphicon-envelope"></span>
										</label>
											<div class="col-lg-6">
												<input type="text" class="form-control" id="email" name="email" placeholder="邮箱">
											</div>

											<label class="col-lg-4 control-label" id="emailError"></label>
									</div>
									 
									<div class="form-group">
										<label for="lastname" class="col-lg-2 control-label"> 
										<span class="glyphicon glyphicon-lock"></span>
										</label>
										<div class="col-lg-6">
											<input type="password" class="form-control" id="password" name="password" placeholder="密码">
										</div>
										<label class="col-lg-4 control-label" id="passwordError"></label>
									</div>
									
									<div class="form-group">
									<label for="lastname" class="col-lg-2 control-label"> 
									<span class="glyphicon glyphicon-ok-sign"></span>
									</label>
									<div class="col-lg-6">
										<input type="password" class="form-control" id="confirm_password" name="confirm_password" placeholder="确认密码">
									</div>
									<label class="col-lg-4 control-label" id="confirm_passwordError"></label>
									</div>
									
									<div class="form-group">
										<div class=" col-lg-offset-2 col-lg-6">
											<button type="submit" class="btn btn-inverse btn-block">注册</button>
										</div>
									</div>

								</form>

							</div>
						</div>
					</div>
					
					<!-- 登录 -->
					<div class="tab-pane fade in active" id="load">
						 <div class="panel" style="border-left:1px solid #e1e1e1; border-right:1px solid #e1e1e1; border-bottom:1px solid #e1e1e1;">
							<div class="panel-body" >
								<form action="<%=request.getContextPath()%>/user?method=loginSubmit" class="form-horizontal" role="form" method="post">
									<div class="form-group">
										<label for="firstname" class="col-md-offset-1 col-md-2 control-label">
										<strong>用户名</strong>
										</label>
										<div class="col-md-8">
											<input type="text" class="form-control" id="login_name" name="login_username" placeholder="用户名/邮箱">
										</div>
									</div>
									 
									<div class="form-group">
										<label for="lastname" class="col-md-offset-1 col-md-2 control-label"> 
										<strong>密码</strong>
										</label>
										<div class="col-md-8">
										<input type="password" class="form-control" id="login_password" name="login_password" placeholder="密码">
										</div>
									</div>

									<div class="form-group">
										<div class="col-md-10">
										<input type="checkbox" id="checkbox">
										<strong>记住密码</strong>
										</div>
									</div>									 

									<div class="form-group">
										<div class=" col-lg-offset-3 col-lg-6">
											<button type="submit" class="btn btn-inverse btn-block" id="loginSubmit">登录</button>
										</div>
									</div>

								</form>

							</div>
						</div>
					</div>

				</div>
			</div>
		</div>

	</div>
</body>
</html>

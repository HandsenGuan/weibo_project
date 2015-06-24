<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>注册</title>

<link rel="stylesheet" type="text/css"
	href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="bootstrap/Flat-UI-master/dist/css/flat-ui.css">
<script type="text/javascript" src="bootstrap/js/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<link rel="shortcut icon" type="text/css" href="bootstrap/img/icon2.ico">

<script type="text/javascript" src="myjs/user/regist.js"></script>

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

			<div class=" col-lg-offset-2 col-lg-10">

				<!-- 提交的controller地址 -->
				<c:url var="i" value="/user?method=index"></c:url>
				
				<!-- action="<%=request.getContextPath()%>/user?method=index" -->
				
				<form action="<%=request.getContextPath()%>/user?method=submit"
					method="post" class="form-horizontal" role="form" id="registForm">
					<div class="form-group">
						<label for="firstname" class="col-lg-2 control-label"><span
							class="glyphicon glyphicon-user"></span> </label>
						<div class="col-lg-6">
							<input type="text" class="form-control" id="name" name="username"
								placeholder="用户名">
						</div>

						<label class="col-lg-3 control-label" id="nameError"></label>

					</div>


					<div class="form-group">
						<label for="firstname" class="col-lg-2 control-label"> <span
							class="glyphicon glyphicon-envelope"></span>
						</label>
						<div class="col-lg-6">
							<input type="text" class="form-control" id="email" name="email"
								placeholder="邮箱">
						</div>

						<label class="col-lg-3 control-label" id="emailError"></label>
					</div>

					<div class="form-group">
						<label for="lastname" class="col-lg-2 control-label"> <span
							class="glyphicon glyphicon-lock"></span>
						</label>
						<div class="col-lg-6">
							<input type="password" class="form-control" id="password"
								name="password" placeholder="密码">
						</div>
						<label class="col-lg-3 control-label" id="passwordError"></label>
					</div>

					<div class="form-group">
						<label for="lastname" class="col-lg-2 control-label"> <span
							class="glyphicon glyphicon-ok-sign"></span>
						</label>
						<div class="col-lg-6">
							<input type="password" class="form-control" id="confirm_password"
								name="confirm_password" placeholder="确认密码">
						</div>
						<label class="col-lg-3 control-label" id="confirm_passwordError"></label>
					</div>

					<div class="form-group">
						<div class=" col-lg-offset-2 col-lg-6">
							<button id="submit" type="submit"
								class="btn btn-inverse btn-block">注册</button>
						</div>
					</div>


				</form>

			</div>
		</div>
</body>
</html>
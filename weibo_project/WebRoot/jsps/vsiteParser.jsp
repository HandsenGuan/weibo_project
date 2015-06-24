<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<title>视频分享</title>
<link rel="shortcut icon" type="text/css" href="../bootstrap/img/icon2.ico">

<link rel="stylesheet" type="text/css"
	href="../bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="../bootstrap/Flat-UI-master/dist/css/flat-ui.css">

<script type="text/javascript" src="../bootstrap/js/jquery.min.js"></script>
<script type="text/javascript" src="../bootstrap/js/bootstrap.min.js"></script>

<style>
body {
	background-color: #ECF0F1;
	min-height: 2000px;
	margin-top: 30px
}

.container {
	margin-top: 30px;
}
</style>

</head>

<body>
	<c:if test="${empty sessionScope.user}">
	<c:redirect url="/nav?method=index"></c:redirect>
	</c:if>
	<div class="container">
		<div class="row">
			<div class=" col-md-offset-2 col-md-8">
				<div class="panel">
					<div class="panel-body">
						<div class="row" style="text-align:center;">
								<img src="../${user.user_img }" height="100" width="100" style="margin-top:15px;">
						</div>
						<div class="row" style="text-align:center;">
							<h4>${user.nickname}</h4>
						</div>

					</div>
				</div>
				<div class="panel">
					<div class="row" style="text-align:center;margin-top:20px;">
						<!-- 标题 -->
						<div id="title">
							<input style="width: 400px;" type="text" id='title_input' placeholder="标题(可不填)"/>
						</div>
					</div>
					<div class="row" style="text-align:center;margin-top:20px;">
						<input type="text" id="url"
							style="width: 400px; margin-bottom: 20px;"
							placeholder="支持优酷网、土豆网、56网、凤凰网、酷6网等视频分享" />
					</div>
					<div class="row" style="text-align:center;margin-bottom: 20px;">
						<button type="button" id="publish" style="margin-right:100px;">分享</button>
						
						<button type="button" id="view">预览</button>
					</div>
				</div>

				<div class="panel">
					<div class="row">
						<div id="video_title" style="text-align:center;margin-top:20px;"></div>
					</div>
					<div class="row">
						<div id="vid" style="text-align:center;margin-top:20px;"></div>
					</div>
				</div>
			</div>
		</div>
	</div>
<script src="../vsiteparser/vsparser.js"></script>
<script src="../myjs/message/my_vsiteparser.js"></script>
</body>
</html>

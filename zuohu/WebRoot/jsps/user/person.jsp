<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
	<meta charset="UTF-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>个人</title>
	<link rel="shortcut icon" type="text/css" href="bootstrap/img/icon2.ico">
	
	<link rel="stylesheet" type="text/css" href="bootstrap/css/component.css" />
	<link rel="stylesheet" type="text/css" href="bootstrap/css/demo.css" />
	<link rel="stylesheet" type="text/css" href="bootstrap/css/component.css" />
	<link rel="stylesheet" type="text/css" href="bootstrap/css/init.css">
	<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="bootstrap/css/flat-ui.css">
	
	 
	<script type="text/javascript" src="bootstrap/js/flat-ui.js"></script>
	<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript"src="bootstrap/js/jquery-1.11.2.min.js"></script>

	<style>
		body {
			background: #ECF0F1;
		}
		.codrops-demos a.current-demo {
			color: #999;
		}
		.codrops-header h1 {
			margin-top: 50px;
			font-family: 'Microsoft Yahei';
			color: #fff;
		}
		.example-animation {
		color: #FFF;
		font-size: 60px;
	}
	
	.small_message img{
		width:300px;
	}
	
		</style>
	<script src="bootstrap/script/modernizr.custom.js"></script>

</head>
<body>
	
	<c:if test="${empty user}">
		<c:redirect url="/user?method=login" />
	</c:if>
	
	<div class="container">
		 <!--个人页顶-->
		<header class="codrops-header">
			<div class="row">
				<div class="col-lg-offset-8 col-lg-4">
					<p>
						<c:if test="${self==1}">
						<input type="hidden" class="personpage_uid" value="${user.u_id }">
						<a href="<%=request.getContextPath()%>/nav?method=setting">
							<button type="button" class="btn btn-primary btn-xs">
							<span class="glyphicon glyphicon-cog"></span>
								设置
							</button>
						</a>
						</c:if>
						
						<c:if test="${self==0}">
							<c:if test="${isFollow!=1}">
							<input type="hidden" class="personpage_uid" value="${other.u_id}">
							<button type="button" class="btn btn-primary btn-xs" id="follow_btn">
							<span class="glyphicon glyphicon-plus"></span>
								关注
							</button>
							</c:if>
						</c:if>
						
						
						<a href="<%=request.getContextPath()%>/nav?method=index" style="text-decoration:none;">
							<button type="button" class="btn btn-inverse btn-xs">返回首页</button>
						</a>
					</p>
				</div>
				
			</div>
			<!--两个小button行结束-->
			<!--头像和个性签名-->
			<div class="row">

				<div class="col-lg-12">
					<c:if test="${self==1}">
					<img alt="140x140" class="img-thumbnail" src="${user.user_img }" height="140" width="140" />
					<h4>${user.nickname }</h4>
					<h6>${user.user_desc }</h6>
					</c:if>
					
					<c:if test="${self==0}">
					<img alt="140x140" class="img-thumbnail" src="${other.user_img }" height="140" width="140" />
					<h4>${other.nickname }</h4>
					<h6>${other.user_desc }</h6>
					</c:if>
					<hr style="border:3px dashed; height:1px" color="#DDDDDD">
				</div>
					
			</div>
		</header>
		 <!--个人页面头部结束分割线以上-->
		 <!--个人页面头部结束分割线以下，瀑布流的地方，每张图片都是一个li-->

		<section class="grid-wrap">
			<ul class="grid swipe-down" id="grid">
				
				<c:forEach var="message" items="${messages}">
					<c:choose>
						<c:when test="${message.type==1}">
						<c:if test="${!empty message.src}">
							<li>
								<a>
								<div class="small_message" style="min-width:300px;">
									<img  src="${message.src}"/>
								</div>
								<c:if test="${!empty message.title }">
									<h3>${message.title}</h3>
								</c:if>
								</a>
								</li>
							</c:if>
						</c:when>
						
						<c:when test="${message.type==2}">
								<c:forEach var="image" items="${message.images }">
									<c:if test="${status.count==1}">
										<a href="#/15758125/SQUET-April-2014-issue">
										<img src="${image.url}" alt="img03">
										<h3>${image.desc}</h3>
										</a>
									</c:if>
								</c:forEach>
						</c:when>
												
					</c:choose>
				</c:forEach>
				
			</ul>
		</section>
	</div>
	<!-- /container -->
	 
	<script src="bootstrap/js/masonry.pkgd.min.js"></script>
	<script src="bootstrap/js/imagesloaded.pkgd.min.js"></script>
	<script src="bootstrap/js/classie.js"></script>
	<script src="bootstrap/js/colorfinder-1.1.js"></script>
	<script src="bootstrap/js/gridScrollFx.js"></script>
	<script>
			new GridScrollFx( document.getElementById( 'grid' ), {
				viewportFactor : 0.4
			} );
		</script>

</body>
</html>
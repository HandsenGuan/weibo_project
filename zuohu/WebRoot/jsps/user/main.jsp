<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<title>首页</title>
<link rel="shortcut icon" type="text/css" href="bootstrap/img/icon2.ico">

<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="stylesheet" type="text/css"
	href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="bootstrap/Flat-UI-master/dist/css/flat-ui.css">
<script type="text/javascript" src="bootstrap/js/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>

<link rel="stylesheet" type="text/css" href="bootstrap/css/default.css" />
<link rel="stylesheet" type="text/css"
	href="bootstrap/css/upcss/componentbutton.css" />
<script type="text/javascript" src="bootstrap/js/modernizr.custom.js"></script>


<link rel="stylesheet" type="text/css"
	href="bootstrap/image-show/css/styles.css">

<script type="text/javascript"
	src="bootstrap/image-show/touchTouch/touchTouch.jquery.js"></script>
	
<link rel="stylesheet" type="text/css"
	href="bootstrap/image-show/touchTouch/touchTouch.css">
	
<style>
body {
	background-color: #ECF0F1;
	min-height: 2000px;
}
/* for 480px or less */
@media screen and (max-width: 1280px) {
	#upload {
		display: none;
	}
}
a{
text-decoration: none;
}

.big_pic img {
	width: 480px;
}
</style>

</head>

<body>

	<c:if test="${empty user}">
		<c:redirect url="/user?method=login" />
	</c:if>

	<nav class="navbar navbar-inverse navbar-static-top" role="navigation">
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
							<li class="active">
								<a href="<%=request.getContextPath()%>/nav?method=index">首页</a>
							</li>
							<li>
								<a href="<%=request.getContextPath()%>/nav?method=sixin"> 消息<span class="navbar-unread"></span>
								</a>
							</li>
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

	<div class="container">
		<!-- 内容框 -->
		<div class="row" id="maincon">

			<!-- 左侧框 -->
			<div class="col-md-9">

				<!-- 消息发布框 -->
				<div class="row col-md-offset-1" id="upload" style="height:110px;">
					<p>

						<!-- 头像 -->
					<li style="list-style:none; float:left;"><a
						href="<%=request.getContextPath()%>/nav?method=person"> <img
							src="${user.user_img}" height="110" width="110">
					</a></li>

					<!-- 消息发布选项框 -->
					<ul class="grid cs-style-3">

						<!-- 文字上传 -->
						<figure>
							<li style="list-style:none; "><img
								src="bootstrap/img/word.png" height="110" width="140"
								style="border-right:1px solid #ECF0F1">

								<figcaption>
									<a class="btn btn-primary"
										href="<%=request.getContextPath()%>/jsps/demo.jsp"> 分享文字 </a>
								</figcaption></li>
						</figure>

						<!-- 图片上传 -->
						<figure>
							<li style="list-style:none;"><img
								src="bootstrap/img/photo.png" height="110" width="140"
								style="border-right:1px solid #ECF0F1">

								<figcaption>
									<a class="btn btn-primary"
										href="<%=request.getContextPath()%>/jsps/uploadFile.jsp">分享图片</a>
								</figcaption></li>
						</figure>

						<!-- 音乐上传 -->
						<figure>
							<li style="list-style:none; float:left;"><img
								src="bootstrap/img/audio.png" height="110" width="140"
								style="border-right:1px solid #ECF0F1">
								<figcaption>
									<a class="btn btn-primary"
									href="<%=request.getContextPath()%>/jsps/music.jsp">分享音乐</a>
								</figcaption></li>
						</figure>

						<!-- 视频上传 -->
						<figure>
							<li style="list-style:none; float:left;"><img
								src="bootstrap/img/vedio.png" height="110" width="140"
								style="border-right:1px solid #ECF0F1">

								<figcaption>
									<a class="btn btn-primary"
										href="<%=request.getContextPath()%>/jsps/vsiteParser.jsp">分享视频</a>
								</figcaption></li>
						</figure>
					</ul>

					</p>

				</div>

				<br> <br> <br>
				<!--一条信息  -->
				<c:forEach var="message" items="${messages}">
					<div class="row">
						<!-- 左侧头像 -->
						<div class=" col-md-offset-1 col-md-2">
							<a href="<%=request.getContextPath()%>/nav?method=person&u_id=${message.user.u_id}">
							<img src="${message.user.user_img}" height="80" width="80">
							</a>
						</div>

						<!-- 状态信息 -->
						<div class="col-md-8">

						<!-- 缩小模式 -->
						<div class="well" style="display:block;">
								<!-- 用户昵称 -->
								<div class="row">
									<ul style="list-style:none;">
										<li>
											<div class="user_name">
												<a href="<%=request.getContextPath()%>/nav?method=person&u_id=${message.user.u_id}">${message.user.nickname}</a>
											</div>
										</li>
										<li><span><h6>${message.title}</h6></span></li>
									</ul>
								</div><!-- 用户昵称 -->


								<!-- 消息体 -->
								<div class="row" id="together">

									<c:choose>
										<c:when test="${message.type==1 }">
											<c:if test="${!empty message.src}">
												<div class="col-md-4">
													<div class="small_pic">
														<img width="140" src="${message.src}" class="pull-left"/>
													</div>
												</div>

												<div class="col-md-8">
													<div class="big_pic"
														style="margin-left:18px; margin-top:0px;">
														${message.html}</div>
												</div>
											</c:if>
											<c:if test="${empty message.src}">
												<div class="col-md-12">
													<div class="big_pic"
														style="margin-left:18px; margin-top:0px;">
														${message.html}</div>
												</div>
											</c:if>

										</c:when>

										<c:when test="${message.type==3}">
											<div style="text-align:center;">
												<embed
													src="http://music.163.com/style/swf/widget.swf?sid=${message.content}&type=2&auto=0&width=320&height=66"
													width="340" height="86" allowNetworking="all" />
											</div>
										</c:when>
										
										<c:when test="${message.type==4}">
											<div style="text-align:center;">
												<embed src="${message.content }" style="width: 430px;height:350px;"/>
											</div>
										</c:when>


									</c:choose>

								</div>

								<!--底部信息框 -->
								<div class="row" style="margin-top:10px;">
									<div class="col-md-7">
										<span class="glyphicon glyphicon-tag"
											style="margin-left:10px;"></span>
										<c:forEach var="label" items="${message.labels}">
											<span class="option" style="width:10px;margin-left:10px;">
												<a href="#"> <span >${label.name }</span>
											</a>
											</span>
										</c:forEach>
									</div>

									<!-- 状态信息 -->
									<div class="col-md-5">
										<span class="option" style="width:10px;"> 
										<a data-toggle="collapse" data-target="#${message.m_id }"> 
										<span >评论（${fn:length(message.replys)}）</span>
										</a>
										</span> 
										
										<span class="option" style="width:10px;"> 
										<a href="#">
												<span >收藏（${fn:length(message.faveds)}）</span>
										</a>
										</span> 
										
										<span class="option" style="width:10px;"> 
										<a href="#	">
												<span class="glyphicon glyphicon-heart"></span>
										</a>
										</span>
									</div>

								</div>
								<!-- ！底部信息框 -->

								<!--评论展开-->
								<div id="${message.m_id }" class="collapse">
									<div class="panel">
											<div class="input-group" style="margin:10px;">
												<div class="col-md-10">
													<input type="text" class="form-control" id="input_${message.m_id}">
												</div>
												<div class="col-md-2 reply_btn_div">
													<a class="input-group-btn btn btn-primary reply_btn">
													评论
													<input type="hidden" value="${message.m_id}" class="message_id"> 
													</a>
												</div>
												
												<div class="col-md-2 huifu_btn_div" style="display:none">
													<a class="input-group-btn btn btn-primary huifu_btn">
													回复
													<input type="hidden" value="${message.m_id}" class="message_id">
													<input type="hidden" class="reply_id"> 
													</a>
												</div>
												
											</div>

											<ul class="list-group">
											
												<c:forEach items="${message.replys}" var="reply" begin="0" end="9">
												<c:if test="${empty reply.parent}">
												<li class="list-group-item" style="color:#000;">
													<img src="${reply.user.user_img}" height="20" width="20"> 
													<span style="margin-left:10px;">
													${reply.user.nickname}:
													</span>
													<span style="margin-left:10px;">
													${reply.content}
													</span>
													
													<a data-toggle="collapse" class="huifu">
													<input type="hidden" value="${message.m_id}" class="message_id"> 
													<input type="hidden" value="${reply.r_id}" class="reply_id">
													<input type="hidden" value="${reply.user.nickname}" class="replyer_name">
													<span style="float:right">回复</span>
													</a>
												</li>
												</c:if>
												
												<c:if test="${!empty reply.parent}">
												<li class="list-group-item" style="color:#000;">
													<img src="${reply.user.user_img}" height="20" width="20"> 
													<span style="margin-left:10px;">
													${reply.user.nickname}<small>回复</small>${reply.parent.user.nickname}:
													</span>
													<span style="margin-left:10px;">
													${reply.content}
													</span>
													
													<a data-toggle="collapse" class="huifu">
													<input type="hidden" value="${message.m_id}" class="message_id"> 
													<input type="hidden" value="${reply.r_id}" class="reply_id">
													<input type="hidden" value="${reply.user.nickname}" class="replyer_name">
													<span style="float:right">回复</span>
													</a>
												</li>
												</c:if>
												</c:forEach>
											</ul>

									</div>

								</div>
								<!--评论结束-->

							</div>
						<!--缩小模式   -->
						
						<!--如果不是富文本或图片状态，不生成放大模式  -->
						<c:if test="${message.type<3}">
						<!-- 放大模式 -->
						<div class="well" style="display:none;">

							<script>
								$(function() {
									//图片事件,img-gather处为仿qq空间图片效果展示
									$('.see_big_pic a').touchTouch();
									/*$('#thumbs a').touchTouch();*/
								});
							</script>

							<!-- 用户昵称 -->
								<div class="row">
									<ul style="list-style:none;">
										<li>
											<div class="user_name">
												<a href="<%=request.getContextPath()%>/nav?method=person&u_id=${message.user.u_id}">${message.user.nickname}</a>
											</div>
										</li>
										<li><span><h6>${message.title}</h6></span></li>
									</ul>
								</div><!-- 用户昵称 -->

							<!-- 图片 -->
								<div class="row">
									<c:choose>
										<c:when test="${message.type==1}">
											<div class="big_pic">${message.content}</div>
										</c:when>

										<c:when test="${message.type==2}">

											<c:forEach var="image" items="${message.images}">
												<div class="big_pic">
													<a style="background-image:url(${image.url})"
														title="${image.desc}"></a>
												</div>
												<div class="see_big_pic" style="text-align:left;">
													<a href="${image.url}"
														style="height:30px;margin-left:30px;">查看大图</a>
												</div>
											</c:forEach>
											<div class="clearfix">
												<!-- 文本内容 -->
												<p style="margin-left:10px; margin-top:10px; float:left;">${message.content}</p>
											</div>

										</c:when>

										<c:when test="${message.type==3}">
											<div>
												<embed
													src="http://music.163.com/style/swf/widget.swf?sid=1614642&type=2&auto=0&width=320&height=66"
													width="340" height="86" allowNetworking="all"></embed>
											</div>
											<div>${message.content}</div>
										</c:when>

										<c:when test="${message.type==4}">
											<div>${message.content}</div>
										</c:when>

									</c:choose>

								</div><!-- ！图片 -->

							<!-- 底部信息框 -->
							<div class="row">
								<div class="tag">
									<ul>
										<li style="list-style:none;">
											<span class="glyphicon glyphicon-tag" style="margin-left:30px;">
											</span> 
											<c:forEach var="label" items="${message.labels}">
												<span class="option" style="width:10px;margin-left:10px;">
													<a href="#"> 
														<span>${label.name }</span>
													</a>
												</span>
											</c:forEach> <!-- 状态信息 --> 
											<span class="option" style="width:10px;margin-left:200px;"> 
												<a data-toggle="collapse" data-target="#${message.m_id}_big"> 
												<span >评论（${fn:length(message.replys)}）</span>
												</a>
											</span> 
											<span class="option" style="width:10px;margin-left:10px;">
												<a href="#"> 
												<span >收藏（${fn:length(message.faveds)}） </span>
												</a>
											</span> 
											<span class="option" style="width:10px;margin-left:10px;">
												<a href="#"> 
												<span class="glyphicon glyphicon-heart"></span>
												</a>
											</span>
										3</li>
									</ul>
								</div>
							</div>
							<!-- ！底部信息框 -->
							<!--评论展开-->
								<div id="${message.m_id }_big" class="collapse">
									<div class="panel">
										<div>
											<div class="input-group" style="margin:10px;">
												<div class="col-md-10">
													<input type="text" class="form-control" id="input_${message.m_id}">
												</div>
												<div class="col-md-2">
													<a class="input-group-btn btn btn-primary reply_btn">
													发布
													<input type="hidden" value="${message.m_id}" class="message_id"> 
													</a>
												</div>
											</div>

											<ul class="list-group">
											
												<c:forEach items="${message.replys}" var="reply" begin="0" end="9">
												<li class="list-group-item" style="color:#000;">
													
													<img src="${reply.user.user_img}" height="20" width="20"> 
													<span style="margin-left:10px;">
													: ${reply.content}
													</span>
													
													<a data-toggle="collapse" class="huifu_btn">
													<input type="hidden" value="${message.m_id}" class="message_id"> 
													<input type="hidden" value="${reply.r_id}" class="reply_id">
													<span class="btn-link" style="float:right">回复</span>
													</a>
												</li>
												</c:forEach>
											</ul>
										</div>

									</div>

								</div>
								<!--评论结束-->

						</div>
						<!-- ！放大模式 -->
						</c:if>
						</div>
						<!-- ！状态信息 -->
					</div>
				</c:forEach>
				<!--一条信息  -->

			</div>
			<!-- ！左侧框 -->

			<!-- 右侧菜单框 -->
			<div class="col-md-3">
				<div class="menu">

					<p>

						<a class="list-group-item" style="background-color:#16A085; color:#fff">
							<span class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;&nbsp;${user.nickname}
						</a>
						<a class="list-group-item" style="background-color:#2C3E50; color:#fff" href="<%=request.getContextPath()%>/nav?method=person">
							<span class="glyphicon glyphicon-pencil"></span>&nbsp;&nbsp;&nbsp;状态
							<span class="badge">${user.message_num}</span>
						</a> 
						<a class="list-group-item" style="background-color:#2C3E50; color:#fff" href="<%=request.getContextPath()%>/user?method=follow">
							<span class="glyphicon glyphicon-star"></span>&nbsp;&nbsp;&nbsp;关注
							<span class="badge">${user.follow_num}</span>
						</a> 
						<a class="list-group-item" style="background-color:#2C3E50; color:#fff">
							<span class="glyphicon glyphicon-heart"></span>&nbsp;&nbsp;&nbsp;收藏
							<span class="badge">${user.fav_num}</span>
						</a>
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
									</ul>
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
				<!--右栏-->
			</div>

		</div>
		<!-- ！内容框 -->

	</div>

	<script type="text/javascript" src="myjs/message/reply_message.js"></script>
	
	<script type="text/javascript">
		$('.small_pic').click(function() {
		 
		 if ($(this).closest('.well').css('display') == 'block') {
		 $(this).closest('.well').css('display', 'none');
		 $(this).closest('.well').next().css('display','block');
		 }
		 
		 });
		 $('.big_pic').click(function() {
		 if ($(this).closest('.well').css('display') == 'block') {
		 $(this).closest('.well').css('display', 'none');
		 $(this).closest('.well').prev().css('display', 'block');
		 }
		 });
	</script>

</body>
</html>

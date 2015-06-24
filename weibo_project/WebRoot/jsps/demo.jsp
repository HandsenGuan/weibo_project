<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>文字发布</title>
<link rel="shortcut icon" type="text/css" href="../bootstrap/img/icon2.ico">

<link
	href="http://netdna.bootstrapcdn.com/font-awesome/3.0.2/css/font-awesome.css"
	rel="stylesheet">
<link href="../wysiwyg/external/google-code-prettify/prettify.css"
	rel="stylesheet">
<link href="../wysiwyg/bootstrap-combined.no-icons.min.css"
	rel="stylesheet">
<link href="../wysiwyg/bootstrap-responsive.min.css" rel="stylesheet">
<link href="../wysiwyg/index.css" rel="stylesheet">

<script src="../wysiwyg/jquery-2.1.3.min.js"></script>
<script src="../wysiwyg/external/jquery.hotkeys.js"></script>
<script src="../wysiwyg/bootstrap.min.js"></script>
<script src="../wysiwyg/external/google-code-prettify/prettify.js"></script>
<script src="../wysiwyg/bootstrap-wysiwyg.js"></script>
<style type="text/css">
.container {
	width: 600px;
	height: 380px;
}

.hero-unit {
	padding-left: 13px;
}

#title {
	margin-top: 20px;
}

#title input {
	width: 600px;
	height: 30px;
}

#tag {
	margin-top: 20px;
}

#tag input {
	width: 600px;
	height: 30px;
}

.infocard {
	width: 600px;
	margin-top: 50px;
	margin-bottom: 50px;
}

.infocard_img {
	float: left;
	width: 200px;
}

.infocard_html {
	float: left;
	width: 350px;
}

#content {
	width: 600px;
	height: auto;
}
</style>
</head>



<body>

<c:if test="${empty sessionScope.user}">
	<c:redirect url="/nav?method=index"></c:redirect>
</c:if>
	
	<div class="container">

		<!-- 标题 -->
		<div id="title">
			<input type="text" id='title_input' placeholder="标题(可不填)"/>
		</div>

		<!--toolbar  -->
		<div class="hero-unit">
			<div class="btn-toolbar" data-role="editor-toolbar"
				data-target="#editor">

				<!-- 字体大小按钮组 -->
				<div class="btn-group">
					<a class="btn dropdown-toggle" data-toggle="dropdown"
						title="Font Size"><i class="icon-text-height"></i>&nbsp;<b
						class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a data-edit="fontSize 5"><font size="5">Huge</font></a></li>
						<li><a data-edit="fontSize 3"><font size="3">Normal</font></a></li>
						<li><a data-edit="fontSize 1"><font size="1">Small</font></a></li>
					</ul>
				</div>

				<!--字体样式按钮组  -->
				<div class="btn-group">
					<a class="btn" data-edit="bold" title="Bold (Ctrl/Cmd+B)"><i class="icon-bold"></i></a> 
					<a class="btn" data-edit="italic" title="Italic (Ctrl/Cmd+I)"><i class="icon-italic"></i></a> 
					<a class="btn" data-edit="strikethrough" title="Strikethrough"><i class="icon-strikethrough"></i></a>
					<a class="btn" data-edit="underline" title="Underline (Ctrl/Cmd+U)"><i class="icon-underline"></i></a>
				</div>

				<!-- 列表按钮组 -->
				<div class="btn-group">
					<a class="btn" data-edit="insertunorderedlist" title="Bullet list"><i class="icon-list-ul"></i></a> 
					<a class="btn" data-edit="insertorderedlist" title="Number list"><i class="icon-list-ol"></i></a> 
					<a class="btn" data-edit="outdent" title="Reduce indent (Shift+Tab)"><i class="icon-indent-left"></i></a>
					<a class="btn" data-edit="indent" title="Indent (Tab)"><i class="icon-indent-right"></i></a>
				</div>



				<!--对齐按钮组 -->
				<div class="btn-group">
        		<a class="btn" data-edit="justifyleft" title="Align Left (Ctrl/Cmd+L)"><i class="icon-align-left"></i></a>
        		<a class="btn" data-edit="justifycenter" title="Center (Ctrl/Cmd+E)"><i class="icon-align-center"></i></a>
        		<a class="btn" data-edit="justifyright" title="Align Right (Ctrl/Cmd+R)"><i class="icon-align-right"></i></a>
       			<a class="btn" data-edit="justifyfull" title="Justify (Ctrl/Cmd+J)"><i class="icon-align-justify"></i></a>
      			</div>

				<!--添加链接按钮组  -->
				<div class="btn-group">
					<a class="btn dropdown-toggle" data-toggle="dropdown"
						title="Hyperlink"><i class="icon-link"></i></a>
					<div class="dropdown-menu input-append">
						<input class="span2" placeholder="URL" type="text"
							data-edit="createLink" />
						<button class="btn" type="button">Add</button>
					</div>
					<a class="btn" data-edit="unlink" title="Remove Hyperlink"><i
						class="icon-cut"></i></a>
				</div>

				<!-- 图片按钮组 -->
				<div class="btn-group">
					<a class="btn" title="Insert picture (or just drag & drop)"
						id="pictureBtn"><i class="icon-picture"></i></a> <input
						type="file" data-role="magic-overlay" data-target="#pictureBtn"
						data-edit="insertImage" />
				</div>

				<!--撤销按钮组  -->
				<div class="btn-group">
					<a class="btn" data-edit="undo" title="Undo (Ctrl/Cmd+Z)"><i
						class="icon-undo"></i></a> <a class="btn" data-edit="redo"
						title="Redo (Ctrl/Cmd+Y)"><i class="icon-repeat"></i></a>
				</div>

				<!--  <input type="text" data-edit="inserttext" id="voiceBtn" x-webkit-speech=""> -->
			</div>

		</div>

		<!--富文本编辑框  -->
		<div id="editor"></div>

		<!--标签  -->
		<div id="tag">
			<input type="text" placeholder="标签(可不填)" />
		</div>

		<input id="submit" type="button" value="submit" />


	</div>


	<div class="infocard">
		<div class="infocard_img"></div>

		<div class="infocard_html"></div>

	</div>


	<div>
		<div id="title"></div>
		<div id="content"></div>
		<div id="error"></div>
	</div>

	<script type="text/javascript" src="../myjs/message/publishword.js"></script>

</body>



</html>

<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>Ckedtor</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css" href="ckeditor/contents.css">
<script src="ckeditor/ckeditor.js"></script>
<style type="text/css">
	body
{
	/* Font */
	font-family: sans-serif, Arial, Verdana, "Trebuchet MS";
	font-size: 13px;

	/* Text color */
	color: #333;

	/* Remove the background color to make it transparent */
	background-color: #fff;

	margin: 20px;
}
</style>

</head>

<body>

	<form action="<%=request.getContextPath()%>/ckeditorControl?method=save"
		method="post">
		<textarea name="editor1" id="editor1" rows="10" cols="80">
                This is my textarea to be replaced with CKEditor.
         </textarea>

		<script>
			// Replace the <textarea id="editor1"> with a CKEditor
			// instance, using default configuration.
			CKEDITOR.replace(
							'editor1',
							{
								uiColor :'#CCEAEE',
								width : '70%',
								height : 200,
								toolbarGroups : [ {
									"name" : "basicstyles",
									"groups" : [ "basicstyles" ]
								}, {
									"name" : "paragraph",
									"groups" : [ "list", "blocks" ]
								},{
									"name" : "insert",
									"groups" : [ "insert" ]
								}],
								toolbarLocation : 'bottom',
								// Remove the redundant buttons from toolbar groups defined above.
								removeButtons : 'CreateDiv,Image,Flash,Table,HorizontalRule,SpecialChar,PageBreak,Iframe,Underline,Strike,Subscript,Superscript,Anchor,Styles',
								removePlugins: 'elementspath,resize'
							});
		</script>

		<input type="submit" value="submit">
	</form>

	<div>
			<div class="cke_contents_ltr">${content }</div>
			  
		<hr>

		<textarea  cols="80" id="editor" name="editor"rows="10">
			  ${content }
		</textarea>
		<script>
			//var editor;

			// The instanceReady event is fired when an instance of CKEditor has finished
			// its initialization.
			/* CKEDITOR.on('instanceReady',
						function(ev) {
							editor = ev.editor;
							editor.setReadOnly(true);
							
			}); */
			//CKEDITOR.config.removePlugins ='basicstyles,links,paragraph,document,insert,styles';
			
			CKEDITOR.replace(
					'editor',
					{
						uiColor : '#CCEAEE',
						width : '70%',
						height : 200,
						toolbarGroups : [ {
							"name" : "basicstyles",
							"groups" : [ "basicstyles" ]
						}, {
							"name" : "paragraph",
							"groups" : [ "list", "blocks" ]
						},{
							"name" : "insert",
							"groups" : [ "insert" ]
						}],
						toolbarLocation : 'bottom',
						// Remove the redundant buttons from toolbar groups defined above.
						removeButtons : 'NumberedList,BulletedList,CreateDiv,Image,Flash,Table,HorizontalRule,SpecialChar,PageBreak,Iframe,Underline,Strike,Subscript,Superscript,Styles',
						removePlugins: 'elementspath,resize'
					});

		</script>
	</div>
</body>
</html>

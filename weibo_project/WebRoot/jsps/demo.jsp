<%@page import="org.springframework.web.context.request.RequestScope"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>微型、开源的Bootstrap所见即所得（WYSIWYG）富文本编辑器 -- 由MindMup贡献</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta name="keywords" content="编辑器,在线编辑器,富文本编辑器,所见即所得编辑器,opensource rich wysiwyg text editor jquery bootstrap execCommand html5" />
    <meta name="description" content="这个微型的JQuery Bootstrap WYSIWYG 插件能将任何DIV变为HTML5富文本编辑器" />
	
	<link href="http://netdna.bootstrapcdn.com/font-awesome/3.0.2/css/font-awesome.css" rel="stylesheet">
    <link href="../wysiwyg/external/google-code-prettify/prettify.css" rel="stylesheet">
    <link href="../wysiwyg/bootstrap-combined.no-icons.min.css" rel="stylesheet">
    <link href="../wysiwyg/bootstrap-responsive.min.css" rel="stylesheet">
    <link href="../wysiwyg/font-awesome.css" rel="stylesheet">
    <link href="../wysiwyg/index.css" rel="stylesheet">

	<script src="../wysiwyg/jquery-2.1.3.min.js"></script>
	<script src="../wysiwyg/external/jquery.hotkeys.js"></script>
    <script src="../wysiwyg/bootstrap.min.js"></script>
    <script src="../wysiwyg/external/google-code-prettify/prettify.js"></script>
    <script src="../wysiwyg/bootstrap-wysiwyg.js"></script>
	
	<script type="text/javascript">
	$(function(){
		
		
		
	});
	
	</script>
	
	
  </head>


  <body>

<div class="container">
  <div class="hero-unit">
    <div class="btn-toolbar" data-role="editor-toolbar" data-target="#editor">
      <div class="btn-group">
        <a class="btn dropdown-toggle" data-toggle="dropdown" title="Font"><i class="icon-font"></i><b class="caret"></b></a>
          <ul class="dropdown-menu">
          </ul>
        </div>
      <div class="btn-group">
        <a class="btn dropdown-toggle" data-toggle="dropdown" title="Font Size"><i class="icon-text-height"></i>&nbsp;<b class="caret"></b></a>
          <ul class="dropdown-menu">
          <li><a data-edit="fontSize 5"><font size="5">Huge</font></a></li>
          <li><a data-edit="fontSize 3"><font size="3">Normal</font></a></li>
          <li><a data-edit="fontSize 1"><font size="1">Small</font></a></li>
          </ul>
      </div>
      <div class="btn-group">
        <a class="btn" data-edit="bold" title="Bold (Ctrl/Cmd+B)"><i class="icon-bold"></i></a>
        <a class="btn" data-edit="italic" title="Italic (Ctrl/Cmd+I)"><i class="icon-italic"></i></a>
        <a class="btn" data-edit="strikethrough" title="Strikethrough"><i class="icon-strikethrough"></i></a>
        <a class="btn" data-edit="underline" title="Underline (Ctrl/Cmd+U)"><i class="icon-underline"></i></a>
      </div>
      <div class="btn-group">
        <a class="btn" data-edit="insertunorderedlist" title="Bullet list"><i class="icon-list-ul"></i></a>
        <a class="btn" data-edit="insertorderedlist" title="Number list"><i class="icon-list-ol"></i></a>
        <a class="btn" data-edit="outdent" title="Reduce indent (Shift+Tab)"><i class="icon-indent-left"></i></a>
        <a class="btn" data-edit="indent" title="Indent (Tab)"><i class="icon-indent-right"></i></a>
      </div>
      <div class="btn-group">
        <a class="btn" data-edit="justifyleft" title="Align Left (Ctrl/Cmd+L)"><i class="icon-align-left"></i></a>
        <a class="btn" data-edit="justifycenter" title="Center (Ctrl/Cmd+E)"><i class="icon-align-center"></i></a>
        <a class="btn" data-edit="justifyright" title="Align Right (Ctrl/Cmd+R)"><i class="icon-align-right"></i></a>
        <a class="btn" data-edit="justifyfull" title="Justify (Ctrl/Cmd+J)"><i class="icon-align-justify"></i></a>
      </div>
      <div class="btn-group">
		  <a class="btn dropdown-toggle" data-toggle="dropdown" title="Hyperlink"><i class="icon-link"></i></a>
		    <div class="dropdown-menu input-append">
			    <input class="span2" placeholder="URL" type="text" data-edit="createLink"/>
			    <button class="btn" type="button">Add</button>
        </div>
        <a class="btn" data-edit="unlink" title="Remove Hyperlink"><i class="icon-cut"></i></a>

      </div>
      
      <div class="btn-group">
        <a class="btn" title="Insert picture (or just drag & drop)" id="pictureBtn"><i class="icon-picture"></i></a>
        <input type="file" data-role="magic-overlay" data-target="#pictureBtn" data-edit="insertImage" />
      </div>
      <div class="btn-group">
        <a class="btn" data-edit="undo" title="Undo (Ctrl/Cmd+Z)"><i class="icon-undo"></i></a>
        <a class="btn" data-edit="redo" title="Redo (Ctrl/Cmd+Y)"><i class="icon-repeat"></i></a>
      </div>
      <input type="text" data-edit="inserttext" id="voiceBtn" x-webkit-speech="">
    </div>
	
	</div>
	
	<form  method="post" id="editorForm">
    <div id="editor">
      Go ahead&hellip;
    </div>
	<input id="submit" type="button" value="submit"/>
	</form>


  </div>
  
  
  
  <c:url var="publish" value="/message?method=save"></c:url>
 
	<div id="title">${RequestScope.title }</div>
<div id="content">${RequestScope.content }</div>

<div id="error" > </div>

 <script>
		
		/* $('#submit').click(function(){
			
			var content = $('#editor').html();
			alert(content);
			$('#content').html(content);
		});
		 */
		
		 $('#submit').click(function(){
				
				var content = $('#editor').html();
				alert(content);
				/* $('#content').html(content); */
				
				var timestamp = Date.parse(new Date());//时间戳,用于从服务器得到最新的数据
				$.ajax({
					url:"${publish}", //要请求的servlet
					data:{title:"save",content:content},//给服务器的参数
					type:"post",
					dataType:"json",//json
					async:false,//是否异步请求，如果是异步，那么不会等待服务器返回，函数继续向下执行。
					cache:false,
					success:function(data){  
						 alert("success!");
						 /* data=eval("("+data+")");//获取从后台返回的数据,通常是Json格式 */
					     alert(data.title);
						 $('#content').html(data.content);
						 
					},
					error:function(data){
			                  alert(data);
			            alert("system error");
			          }
				});
				
			});
		
	</script>

<script>
     function initToolbarBootstrapBindings() {
      var fonts = ['Serif', 'Sans', 'Arial', 'Arial Black', 'Courier', 
            'Courier New', 'Comic Sans MS', 'Helvetica', 'Impact', 'Lucida Grande', 'Lucida Sans', 'Tahoma', 'Times',
            'Times New Roman', 'Verdana'],
            fontTarget = $('[title=Font]').siblings('.dropdown-menu');
      $.each(fonts, function (idx, fontName) {
          fontTarget.append($('<li><a data-edit="fontName ' + fontName +'" style="font-family:\''+ fontName +'\'">'+fontName + '</a></li>'));
      });
      $('a[title]').tooltip({container:'body'});
    	$('.dropdown-menu input').click(function() {return false;})
		    .change(function () {$(this).parent('.dropdown-menu').siblings('.dropdown-toggle').dropdown('toggle');})
        .keydown('esc', function () {this.value='';$(this).change();});

      $('[data-role=magic-overlay]').each(function () { 
        var overlay = $(this), target = $(overlay.data('target')); 
        overlay.css('opacity', 0).css('position', 'absolute').offset(target.offset()).width(target.outerWidth()).height(target.outerHeight());
      });
      if ("onwebkitspeechchange"  in document.createElement("input")) {
        var editorOffset = $('#editor').offset();
        $('#voiceBtn').css('position','absolute').offset({top: editorOffset.top, left: editorOffset.left+$('#editor').innerWidth()-35});
      } else {
        $('#voiceBtn').hide();
      }
	};
	function showErrorAlert (reason, detail) {
		var msg='';
		if (reason==='unsupported-file-type') { msg = "Unsupported format " +detail; }
		else {
			console.log("error uploading file", reason, detail);
		}
		$('<div class="alert"> <button type="button" class="close" data-dismiss="alert">&times;</button>'+ 
		 '<strong>File upload error</strong> '+msg+' </div>').prependTo('#alerts');
	};
    initToolbarBootstrapBindings(); 
	$('#editor').wysiwyg({ fileUploadError: showErrorAlert} );
</script>


</body>



</html>

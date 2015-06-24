	$('#submit').click(function() {
		var title = $('#title_input').val();
		var content = $('#editor').html();
		var urls = [];
		content.replace(/<img.*?src="(.*?)"[^>]*>/ig, function(a,b) {
		    urls.push(b);
		});
		
		if (!content||typeof(content)=="undefined"||content==" ") {
			alert("内容不能为空！");
		} else if (urls.length > 3) {
			alert("超过指定图片数量！");
		} else {
			
			$.ajax({
				url : "/zuohu/messages?method=save1", // 要请求的servlet
				data : {
					title : title,
					content : content
				},// 给服务器的参数
				type : "post",
				dataType : "json",// json
				async : false,// 是否异步请求，如果是异步，那么不会等待服务器返回，函数继续向下执行。
				cache : false,
				success : function(data) {
					if(data.state==1){
						alert("success!");
						location.href ="/zuohu/nav?method=index";
					}else{
						alert("发布失败，请重新发布！");
					}
				},
				error : function(data) {
					alert("system error");
				}
			});

		}

	});

	function initToolbarBootstrapBindings() {
		var fonts = [ 'Serif', 'Sans', 'Arial', 'Arial Black', 'Courier',
				'Courier New', 'Comic Sans MS', 'Helvetica', 'Impact',
				'Lucida Grande', 'Lucida Sans', 'Tahoma', 'Times',
				'Times New Roman', 'Verdana' ], fontTarget = $('[title=Font]')
				.siblings('.dropdown-menu');
		$.each(fonts, function(idx, fontName) {
			fontTarget.append($('<li><a data-edit="fontName ' + fontName
					+ '" style="font-family:\'' + fontName + '\'">' + fontName
					+ '</a></li>'));
		});
		$('a[title]').tooltip({
			container : 'body'
		});
		$('.dropdown-menu input').click(function() {
			return false;
		}).change(
				function() {
					$(this).parent('.dropdown-menu').siblings(
							'.dropdown-toggle').dropdown('toggle');
				}).keydown('esc', function() {
			this.value = '';
			$(this).change();
		});

		$('[data-role=magic-overlay]').each(
				function() {
					var overlay = $(this), target = $(overlay.data('target'));
					overlay.css('opacity', 0).css('position', 'absolute')
							.offset(target.offset()).width(target.outerWidth())
							.height(target.outerHeight());
				});
		if ("onwebkitspeechchange" in document.createElement("input")) {
			var editorOffset = $('#editor').offset();
			$('#voiceBtn').css('position', 'absolute').offset({
				top : editorOffset.top,
				left : editorOffset.left + $('#editor').innerWidth() - 35
			});
		} else {
			$('#voiceBtn').hide();
		}
	};
	function showErrorAlert(reason, detail) {
		var msg = '';
		if (reason === 'unsupported-file-type') {
			msg = "Unsupported format " + detail;
		} else {
			console.log("error uploading file", reason, detail);
		}
		$(
				'<div class="alert"> <button type="button" class="close" data-dismiss="alert">&times;</button>'
						+ '<strong>File upload error</strong> '
						+ msg
						+ ' </div>').prependTo('#alerts');
	}
	;
	initToolbarBootstrapBindings();
	$('#editor').wysiwyg({
		fileUploadError : showErrorAlert
	});

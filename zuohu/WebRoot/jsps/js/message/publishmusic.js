$(function(){
	$("#publish").click(function() {
		/*获取视频链接*/
		music_url = $("#url").val();
		if (music_url != "") {
			/*获取音乐标题*/
			if(music_title!=""){
				music_title = $("#title_input").val();
			}

			$.ajax({
				url : "/zuohu/messages", // 要请求的servlet
				data : {
					method : "save3",
					music_url : music_url,
					music_title : music_title
				},// 给服务器的参数
				type : "POST",
				dataType : "json",
				async : false,// 是否异步请求，如果是异步，那么不会等待服务器返回，函数继续向下执行。
				cache : false,
				success : function(result) {
					if (result.ok) {
						alert("发布成功！");
						location.href = "/zuohu/user?method=index";
					} else {
						alert("发布失败，请重试！");
					}
				}
			});

		}

	});

	$("#view").click( function() {
		music_url = $("#url").val();
		music_title = $("#title_input").val();
		if (music_url != "") {
			if(music_title!=""){
				$("#music_title").html("<h3>" + music_title + "</h3>");
			}
			
			$.ajax({
				url : "/zuohu/messages", // 要请求的servlet
				data : {
					method : "yulanMusic",
					music_url : music_url,
				},// 给服务器的参数
				type : "POST",
				dataType : "json",
				async : false,// 是否异步请求，如果是异步，那么不会等待服务器返回，函数继续向下执行。
				cache : false,
				success : function(result) {
					if (result.ok) {
						var music = "<embed src=\"http://music.163.com/style/swf/widget.swf?sid="+result.music163_id+"&type=2&auto=0&width=320&height=66\" width=\"340\" height=\"86\" allowNetworking=\"all\" />";
						$("#music_content") .html(music);
					} else {
						alert("预览失败，请检查输入地址！");
					}
				}
			});
			
		} else {
			alert("请输入分享音乐地址！");
		}

	});
	
	
});
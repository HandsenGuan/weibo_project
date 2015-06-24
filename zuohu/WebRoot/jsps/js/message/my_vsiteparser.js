/*window.onload = function() {
	document.getElementById("view").onclick = function() {
		url = vsparser(document.getElementById("url").value);
		title = document.getElementById("title_input").value;
		if(url!=undefined){
			document.getElementById("video_title").innerHTML = "<h3>"+title+"</h3>";
			document.getElementById("vid").innerHTML = "<embed src=" + url
			+ " style=\"width: 500px;height:400px;\"/>";

			document.getElementById("url").innerHTML = "<p>" + url + "<p>";
		}else{
			alert("请输入分享视频地址！");
		}
	};
	
	document.getElementById("publish").onclick = function() {
		
		alert("publish");
	};
	
};*/

$(function() {
	$("#publish").click(function() {

		/*获取视频链接*/
		video_url = vsparser($("#url").val());

		if (url != undefined) {
			/*获取视频标题*/
			video_title = $("#title_input").val();

			$.ajax({
				url : "/zuohu/messages", // 要请求的servlet
				data : {
					method : "save4",
					video_url : video_url,
					video_title : video_title
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
						url = vsparser($("#url").val());
						title = $("#title_input").val();
						if (url != undefined) {
							$("#video_title").html("<h3>" + title + "</h3>");
							$("#vid") .html(
											"<embed src="
													+ url
													+ " style=\"width: 500px;height:400px;\"/>");
						} else {
							alert("请输入分享视频地址！");
						}

					});

});

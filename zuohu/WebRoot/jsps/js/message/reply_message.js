$(function() {
	$('.reply_btn').click(function() {

		var message_id = $(this).find('.message_id').val();

		var reply_content = $("#input_" + message_id).val();
		if (reply_content == "") {
			alert("请输入内容后发布！");
		} else {
			$("#input_" + message_id).val("");
			$.ajax({
				url : "/zuohu/user", // 要请求的servlet
				data : {
					method : "ajaxReplyMessage",
					m_id : message_id,
					reply_content : reply_content
				},// 给服务器的参数
				type : "POST",
				dataType : "json",
				async : false,// 是否异步请求，如果是异步，那么不会等待服务器返回，函数继续向下执行。
				cache : false,
				success : function(result) {
					if (result.ok) {
						alert("评论成功！");
						location.href = "/zuohu";

					} else {
						alert("评论失败，请重试！");
					}
				}
			});
		}

	});

	$('.huifu').click(function() {
		var message_id = $(this).find('.message_id').val();
		var replyer_name = $(this).find('.replyer_name').val();

		var reply_id = $(this).find('.reply_id').val();

		var input = $("#input_" + message_id);
//		input.val("回复" + replyer_name + ":");
		input.attr("placeholder","回复" + replyer_name + ":");
		
		var input_group = input.parents(".input-group");
		input_group.find(".reply_btn_div").css("display", "none");
		input_group.find(".huifu_btn_div").css("display", "block");

		input_group.find(".reply_id").attr("value", reply_id);

	});

	$('.huifu_btn').click(function() {
				var message_id = $(this).find('.message_id').val();
				var reply_id = $(this).find('.reply_id').val();
				var input = $("#input_" + message_id);

				var huifu_content = input.val();
				if (huifu_content == "") {
					alert("请输入内容后回复！");
				} else {
					input.val("");
					$.ajax({
						url : "/zuohu/user", // 要请求的servlet
						data : {
							method : "ajaxReply2Reply",
							message_id : message_id,
							reply_id : reply_id,
							huifu_content : huifu_content
						},// 给服务器的参数
						type : "POST",
						dataType : "json",
						async : false,// 是否异步请求，如果是异步，那么不会等待服务器返回，函数继续向下执行。
						cache : false,
						success : function(result) {
							if (result.ok) {
								alert("评论成功！");
								location.href = "/zuohu";

							} else {
								alert("评论失败，请重试！");
							}
						}
					});
				}
				input.attr("placeholder","");
				input.parents(".input-group").find(".reply_btn_div").css(
						"display", "block");
				input.parents(".input-group").find(".huifu_btn_div").css(
						"display", "none");

			});

});
$(function(){
	// 1.输入框得到焦点隐藏错误信息
	$("input").focus(function() {
		var inputId = $(this).attr("id");

		$("#" + inputId + "Error").text("");

		showRight($("#" + inputId));
	});
	
	// 2.输入框失去焦点进行校验
	$("input").blur(function() {
				var inputId = $(this).attr("id");

				var funName = "validate"
						+ inputId.substring(0, 1).toUpperCase()
						+ inputId.substring(1) + "()";// 得到对应的方法

				eval(funName);// 执行函数调用
	});
	
	/*修改密码*/
	$('#updatePassword').click(function(){
			var oldpassword = $('#oldpassword').val();
			var newpassword = $('#newpassword').val();
			
			var u_id = $('#u_id').val();
			
			$.ajax({
				url : "/zuohu/user", // 要请求的servlet
				data : {
					method : "updatePassword",
					u_id : u_id,
					oldpassword : oldpassword,
					newpassword : newpassword
				},// 给服务器的参数
				type : "POST",
				dataType : "json",
				async : false,// 是否异步请求，如果是异步，那么不会等待服务器返回，函数继续向下执行。
				cache : false,
				success : function(result) {
					if (result.error) {
						alert("更新失败,请重试！");
					}else{
						alert("修改成功，请从新登录！");
						location.href="/zuohu/nav?method=setting";
					}
				}
			});
	});
	
	$('#setEmail').click(function(){
		var email = $('#email_input').val();
		var u_id = $('#u_id').val();
		
		$.ajax({
			url : "/zuohu/user", // 要请求的servlet
			data : {
				method : "updateEmail",
				u_id : u_id,
				email : email
			},// 给服务器的参数
			type : "POST",
			dataType : "json",
			async : false,// 是否异步请求，如果是异步，那么不会等待服务器返回，函数继续向下执行。
			cache : false,
			success : function(result) {
				if (result.ok) {
					alert("修改成功！！");
				}
			}
		});
		
	});
	
	$('#blinEmail').click(function(){
		$('#setting').css('display','none');
		$('#img').css('display','none');
		$('#info').css('display','none');
		$('#email').css('display','block');
	});
	
	$('#setImg').click(function(){
		$('#setting').css('display','none');
		$('#img').css('display','block');
		$('#info').css('display','none');
		$('#email').css('display','none');
		
	});
	
	$('#setInfo').click(function(){
		$('#setting').css('display','none');
		$('#img').css('display','none');
		$('#info').css('display','block');
		$('#email').css('display','none');
		
	});
	
	$('.back').click(function(){
		$('#setting').css('display','block');
		$('#img').css('display','none');
		$('#info').css('display','none');
		$('#email').css('display','none');
	});
	
});


//校验原密码
function validateOldpassword() {

	var id = "oldpassword";
	
	var value = $("#" + id).val();// 获取输入框内容
	
	if (!value) {
		/**
		 * 获取对应的label 添加错误信息 显示label
		 */
		$("#" + id + "Error").text("密码不能为空！");
		showError($("#" + id));
		return false;
	}

	if (value.length < 3 || value.length > 20) {
		$("#" + id + "Error").text("密码长度必须在3-20之间！");
		showError($("#" + id));
		return false;
	}
	
	var u_id = $('#u_id').val();
	$.ajax({
		url : "/zuohu/user", // 要请求的servlet
		data : {
			method : "validatePassword",
			oldpassword : value,
			u_id : u_id
		},// 给服务器的参数
		type : "POST",
		dataType : "json",
		async : false,// 是否异步请求，如果是异步，那么不会等待服务器返回，函数继续向下执行。
		cache : false,
		success : function(result) {
			if (result.exit) {
				$("#" + id + "Error").text("密码错误！");
				showError($("#" + id));
				return false;
			}
		}
	});

	return true;
}

//校验新密码
function validateNewpassword() {

	var id = "newpassword";
	var value = $("#" + id).val();// 获取输入框内容
	if (!value) {
		/**
		 * 获取对应的label 添加错误信息 显示label
		 */
		$("#" + id + "Error").text("密码不能为空！");
		showError($("#" + id));
		return false;
	}

	if (value.length < 3 || value.length > 20) {
		$("#" + id + "Error").text("密码长度必须在3-20之间！");
		showError($("#" + id));
		return false;
	}

	return true;
}

//校验邮箱
function validateEmail_input() {
	var id = "email_input";
	var value = $("#" + id).val();// 获取输入框内容
	if (!value) {
		/**
		 * 获取对应的label 添加错误信息 显示label
		 */
		$("#" + id + "Error").text("Email不能为空！");
		showError($("#" + id));
		return false;
	}

	if (!/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/
			.test(value)) {
		$("#" + id + "Error").text("错误的Email格式");
		showError($("#" + id));
		return false;
	}

	$.ajax({
		url : "/zuohu/user", // 要请求的servlet
		data : {
			method : "validateEmail",
			email : value
		},// 给服务器的参数
		type : "POST",
		dataType : "json",
		async : false,// 是否异步请求，如果是异步，那么不会等待服务器返回，函数继续向下执行。
		cache : false,
		success : function(result) {
			if (result.exit) {
				$("#" + id + "Error").text("该邮箱已注册！");
				showError($("#" + id));
				return false;
			}
		}
	});
	return true;
}

//输入框错误提示
function showError(ele) {
	var input_div = ele.parent().parent();
	input_div.attr("class", "form-group has-error");
};

// 显示正常
function showRight(ele) {
	var input_div = ele.parent().parent();
	input_div.attr("class", "form-group");
};


function validateBtnZoomIn(){
	
};
function validateBtnZoomOut(){
	
};
function validateUpload(){
	
};
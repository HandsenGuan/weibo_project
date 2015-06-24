$(function() {

	// 1.输入框得到焦点隐藏错误信息
	$("input").focus(function() {
		var inputId = $(this).attr("id");

		$("#" + inputId + "Error").text("");

		showRight($("#" + inputId));
	});

	// 2.输入框失去焦点进行校验
	$("input").blur(
			function() {
				var inputId = $(this).attr("id");

				var funName = "validate"
						+ inputId.substring(0, 1).toUpperCase()
						+ inputId.substring(1) + "()";// 得到对应的方法

				eval(funName);// 执行函数调用
			});
	// 3。对表单提交时进行校验
	$("#registForm").click(function(){
		var bool = false;
		if (validateName() && validatePassword()
				&& validateConfirm_password() && validateEmail()){
			bool = true;
		}
		if(bool){
			var username = $('#name').val();
			var email = $('#email').val();
			var password = $('#password').val();
			
			$.ajax({
				url : "/zuohu/user", // 要请求的servlet
				data : {
					method : "ajaxSubmit",
					username : username,
					email:email,
					password:password
				},// 给服务器的参数
				type : "POST",
				dataType : "json",
				async : false,// 是否异步请求，如果是异步，那么不会等待服务器返回，函数继续向下执行。
				cache : false,
				success : function(result) {
					if (result.ok) {
						alert("注册成功！");
						location.href="/zuohu/user?method=index";
					}else{
						alert("注册失败，请重试！");
					}
				}
			});
		}
		
	});

	
});

// 校验用户名(validate+input标签id)
function validateName() {
	/**
	 * 1、非空校验 2、长度校验 3、是否注册校验
	 */
	var id = "name";
	var value = $("#" + id).val();// 获取输入框内容

	if (!value) {
		/**
		 * 获取对应的label 添加错误信息 显示label
		 */
		$("#" + id + "Error").text("用户名不能为空！");
		showError($("#" + id));
		return false;
	}

	if (value.length < 3 || value.length > 20) {
		$("#" + id + "Error").text("长度必须在3-20之间！");
		showError($("#" + id));
		return false;
	}

	$.ajax({
		url : "/zuohu/user", // 要请求的servlet
		data : {
			method : "validateName",
			loginname : value
		},// 给服务器的参数
		type : "POST",
		dataType : "json",
		async : false,// 是否异步请求，如果是异步，那么不会等待服务器返回，函数继续向下执行。
		cache : false,
		success : function(result) {
			if (result.exit) {
				$("#" + id + "Error").text("用户名已注册！");
				showError($("#" + id));
				return false;
			}
		}
	});
	return true;
};

// 校验邮箱
function validateEmail() {
	var id = "email";
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

// 校验密码
function validatePassword() {

	var id = "password";
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
		$("#" + id + "Error").text("长度必须在3-20之间！");
		showError($("#" + id));
		return false;
	}

	return true;

}

// 校验确认密码
function validateConfirm_password() {
	var id = "confirm_password";
	var value = $("#" + id).val();// 获取输入框内容
	if (!value) {
		/**
		 * 获取对应的label 添加错误信息 显示label
		 */
		$("#" + id + "Error").text("确认密码不能为空！");
		showError($("#" + id));
		return false;
	}

	if (value != $("#password").val()) {
		$("#" + id + "Error").text("两次输入不一致！");
		showError($("#" + id));
		return false;
	}

	return true;
}

// 输入框错误提示
function showError(ele) {
	var input_div = ele.parent().parent();
	input_div.attr("class", "form-group has-error");
};

// 显示正常
function showRight(ele) {
	var input_div = ele.parent().parent();
	input_div.attr("class", "form-group");
};
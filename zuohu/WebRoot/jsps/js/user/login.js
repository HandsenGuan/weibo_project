$(function(){
	
	/*cookie显示用户名密码*/
	if($.cookie('username')!=null){
		$("#name").val($.cookie('username'));
	}
	if($.cookie('password')!=null){
		$("#password").val($.cookie('password'));
	}
	
	
	$("input").focus(function(){
		$(this).parent().parent().attr("class", "form-group");
	});
	
	$("#loginSubmit").click(function(){
		
		var checkbox = $("#checkbox").attr("checked");//true/false
		
		var username = $("#name").val();
		
		var password = $("#password").val();
		
		
		if(checkbox=="checked"){
			$.cookie('username',username,{expires:7});
			$.cookie('password',password,{expires:7});
		}
		
		var name = $("#name").val();// 获取输入框内容
		var password = $("#password").val();// 获取输入框内容

		if (!name||!password) {
			/**
			 * 获取对应的label 添加错误信息 显示label
			 */
			$("input").each(function(){
				if($(this).val()==""){
					$(this).parent().parent().attr("class", "form-group has-error");
					$(this).attr("placeholder","不能为空");
				}
			});
			return false;
		}
		
	});
	
	$('#exitButton').click(function() {
		$('#registButton').show();
		$('#loginButtin').show();
		alert("退出成功！");
	});
	

	$('.theme-login').click(function() {
		$('.theme-popover-mask').fadeIn(100);
		$('.theme-popover').slideDown(200);
	});
	$('.theme-poptit .close').click(function() {
		$('.theme-popover-mask').fadeOut(100);
		$('.theme-popover').slideUp(200);
	});

	
});
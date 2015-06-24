$(function(){
	
	/*个人页面*/
	$("#follow_btn").click(function(){
		
		var u_id = $(".personpage_uid").val();
		alert(u_id);

		$.ajax({
			url : "/zuohu/user", // 要请求的servlet
			data : {
				method : "ajaxFollowone",
				u_id : u_id
			},// 给服务器的参数
			type : "POST",
			dataType : "json",
			async : false,// 是否异步请求，如果是异步，那么不会等待服务器返回，函数继续向下执行。
			cache : false,
			success : function(result) {
				if (result.ok) {
					alert("关注成功！");
				}else{
					alert("关注失败，请重试！");
				}
			}
		});
	});
	
	/*群页面*/
$(".group_follow_btn").click(function(){
		var u_id = $(this).children("input").val();
		if(u_id==undefined){
			return false;
		}
		
		$.ajax({
			url : "/zuohu/user", // 要请求的servlet
			data : {
				method : "ajaxFollowone",
				u_id : u_id
			},// 给服务器的参数
			type : "POST",
			dataType : "json",
			async : false,// 是否异步请求，如果是异步，那么不会等待服务器返回，函数继续向下执行。
			cache : false,
			success : function(result) {
				if (result.ok) {
					alert("关注成功！");
				}else{
					alert("关注失败，请重试！");
				}
			}
		});
	});
	
});
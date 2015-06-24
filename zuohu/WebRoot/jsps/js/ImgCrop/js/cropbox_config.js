$(window).load(
				function() {
					// $('#btnCrop').click();$("#idName").css("cssText","background-color:red!important");

					// $(".imageBox").css("cssText","background-position:88px
					// 88px!important");$(".imageBox").css("cssText","background-size:222px
					// 222px!important");
					var options = {
						thumbBox : '.thumbBox',
						spinner : '.spinner',
						imgSrc : 'myjs/ImgCrop/images/avatar.png'
					};
					var cropper = $('.imageBox').cropbox(options);
					var img = "";
					
					$('#upload-file').on('change', function() {
						var reader = new FileReader();
						reader.onload = function(e) {
							options.imgSrc = e.target.result;
							cropper = $('.imageBox').cropbox(options);
							getImg();
						};
						reader.readAsDataURL(this.files[0]);
						this.files = [];
						getImg();
					});
					
					
					$('#btnCrop').on('click', function() {
						/*alert("图片上传喽");
						alert(getImg());
						$('#image').html(getImg());*/
						var u_id = $('#u_id').val();
						var img = getImg();
						
						$.ajax({
							url : "/zuohu/user", // 要请求的servlet
							data : {
								method : "updateUserImg",
								u_id : u_id,
								img : img
							},// 给服务器的参数
							type : "POST",
							dataType : "json",
							async : false,// 是否异步请求，如果是异步，那么不会等待服务器返回，函数继续向下执行。
							cache : false,
							success : function(result) {
								if (result.ok) {
									alert("修改成功！");
								}else{
									alert("修改失败，请重试！");
								}
							}
						});
						
						/*
						 * $('img').attr( "src", getImg());
						 */
					});
					function getImg() {
						img = cropper.getDataURL();
						$('.cropped').html('');
						$('.cropped')
								.append(
										'<img src="'
												+ img
												+ '" align="absmiddle" style="width:100px;margin-top:34px; box-shadow:0px 0px 12px #7E7E7E;"><p>100px*100px</p>');
						$('.cropped')
								.append(
										'<img src="'
												+ img
												+ '" align="absmiddle" style="width:50px;margin-top:24px; box-shadow:0px 0px 12px #7E7E7E;"><p>50px*50px</p>');
						$('.cropped')
								.append(
										'<img src="'
												+ img
												+ '" align="absmiddle" style="width:30px;margin-top:24px; box-shadow:0px 0px 12px #7E7E7E;" ><p>30px*30px</p>');
						return img;
					};

					$(".imageBox").on("mouseup", function() {
						getImg();
					});

					$('#btnZoomIn').on('click', function() {
						cropper.zoomIn();
						getImg();
					});
					$('#btnZoomOut').on('click', function() {
						cropper.zoomOut();
						getImg();
					});
				});
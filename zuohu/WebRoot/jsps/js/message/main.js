/*返回富文本中第一张图片*/
function getImage(content){
	var urls = [];
	content.replace(/<img.*?src="(.*?)"[^>]*>/ig, function(a,b) {
	    urls.push(b);
	});
	return urls[0];
}

/*返回除去图片的html*/
function getHtml(content){
	content = content.replace(/<img.*?src="(.*?)"[^>]*>/ig,"");
	return content;
}
package com.guan.weibo.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.logging.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

import com.guan.weibo.message.service.MessageService;
import com.guan.weibo.utils.ImageUtils;
import com.guan.weibo.utils.RichTextProcessor;

/**
 * 测试message的CRUD
 * @author guan
 *
 */

@Controller
@RequestMapping("/message")
public class ControllerTest2{
	
	@Resource(name="messageService")
	private MessageService messageService;
	
	
	@RequestMapping(params="method=save")
	@ResponseBody
	public Object save(HttpServletRequest req){
		
		String content = req.getParameter("content");
		String title  = req.getParameter("title");
	
		String json ; 
		if(content.length()<100){
			json = "{\"title\":\""+title+"\",\"content\":\""+content+"\"}";//拼成Json格式字符串
		}else{
			json ="{\"title\":\""+title+"\",\"content\":\""+content.substring(0, 100)+"..."+"\"}";//拼成Json格式字符串
		}
		
		//System.out.println("\n json: \n"+json);
		
		List<String> listImages = RichTextProcessor.getImgSrc(content);
		for(String image : listImages){
			//System.out.println("图片src:"+image.substring(0, 100)+"(...)");
		}
		
		String newhtml = RichTextProcessor.getHtml(content);
		System.out.println("newhtml:\n"+newhtml);
		
		Map<String, Object> map=new HashMap<String, Object>();
		 
		String encoder = HtmlUtils.htmlEscape(content);
		String decoder = HtmlUtils.htmlUnescape(encoder);
		 
//		 System.out.println("```````````````````````````````````````````");
//		 System.out.println("编码后："+encoder);
//		 System.out.println("解码后："+decoder);
//		 System.out.println("```````````````````````````````````````````");
		 
		 
		 map.put("title", title);
		 map.put("content", content);
		 map.put("listImages", listImages);
		 map.put("newhtml", newhtml);
		 
		return map;
	}
	

}

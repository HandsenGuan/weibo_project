package com.guan.weibo.test;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

import com.guan.weibo.message.service.MessageService;

/**
 * 测试message的CRUD
 * @author guan
 *
 */

@Controller
@RequestMapping("/message")
public class ControllerTest2{
	
	@Resource(name="messgaeService")
	private MessageService messageService;
	
	
	@RequestMapping(params="method=save")
	@ResponseBody
	public Object save(HttpServletRequest req){
		
		System.out.println("!!!!!!!!!!");
		
		String content = req.getParameter("content");
		String title  = req.getParameter("title");
		System.out.println("title:\n"+title+"\n");
		System.out.println("content:\n"+content+"\n");
		
		String json="{\"title\":\""+title+"\",\"content\":\""+content+"\"}";//拼成Json格式字符串
		System.out.println("\n json: \n"+json);
		
		 Map<String, Object> map=new HashMap<String, Object>();
		 
		 String encoder = HtmlUtils.htmlEscape(content);
		 String decoder = HtmlUtils.htmlUnescape(encoder);
		 
		 System.out.println("```````````````````````````````````````````");
		 System.out.println("编码后："+encoder);
		 System.out.println("解码后："+decoder);
		 System.out.println("```````````````````````````````````````````");
		 map.put("title", title);
		 map.put("content", content);
		return map;
	}
	

}

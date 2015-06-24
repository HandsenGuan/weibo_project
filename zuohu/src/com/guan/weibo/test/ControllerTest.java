package com.guan.weibo.test;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 测试富文本编辑器
 * @author guan
 *
 */

@Controller
@RequestMapping("/ckeditorControl")
public class ControllerTest{

	@RequestMapping(params="method=save")
	public ModelAndView handleRequest(HttpServletRequest req) {
		System.out.println("Ckeditor save");
		
		System.out.println("congtroller执行。。。"+this);
		String content = req.getParameter("editor1");
		
		System.out.println("文本内容:");
		System.out.println("content:"+content);
		
		//声明ModelAndView
		ModelAndView mv = new ModelAndView("one");
		//封装数据的ModelAndView,name是key,jack是value会放到request范围中
		mv = new ModelAndView("Ckeditor", "content", content);
		
		return mv;
	}
	
	@RequestMapping(params="method=index")
	public String ckeditor(){
		System.out.println("Ckeditor index");
		return "Ckeditor";
	}

}

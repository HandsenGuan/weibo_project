package com.guan.weibo.test;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.guan.weibo.message.domain.PriMessage;
import com.guan.weibo.message.service.PrimessageService;
import com.guan.weibo.user.domain.User;
import com.guan.weibo.user.service.UserService;

@Controller
@RequestMapping("/test7")
public class PrimessageControllerTest {

	@Resource(name="primessageService")
	PrimessageService primessageService;
	
	@Resource(name="userService")
	UserService userService;
	
	@RequestMapping(params = "method=add")
	public ModelAndView add() {

		User user1 = userService.queryByUid("8abf8b1d4cb80801014cb8083cda0000");//张
		
		User user2 = userService.queryByUid("8abf8b1d4cb833eb014cb8341c770000");//关
		
		User user3 = userService.queryByUid("8abf8b1d4cb833eb014cb8341d040001");//刘
		
		User user4 = userService.queryByUid("8abf8b1d4cb833eb014cb8341d320002");//曹
		
		PriMessage priMessage1 =  new PriMessage();
		PriMessage priMessage2 =  new PriMessage();
		PriMessage priMessage3 =  new PriMessage();
		PriMessage priMessage4 =  new PriMessage();
		PriMessage priMessage5 =  new PriMessage();
		PriMessage priMessage6 =  new PriMessage();
		PriMessage priMessage7 =  new PriMessage();
//		PriMessage priMessage8 =  new PriMessage();
//		PriMessage priMessage9 =  new PriMessage();
//		PriMessage priMessage10 =  new PriMessage();
		
		//张-关
		priMessage1.setFrom(user1);
		priMessage1.setTo(user2);
		priMessage1.setContent("这是张-》关的第一条私信！");
		priMessage1.setTime(new Timestamp(System.currentTimeMillis()));
		priMessage1.setState(1);
		
		priMessage2.setFrom(user2);
		priMessage2.setTo(user1);
		priMessage2.setContent("这是关-》张的回复第一条私信！");
		priMessage2.setTime(new Timestamp(System.currentTimeMillis()));
		priMessage2.setState(1);
		
		priMessage3.setFrom(user1);
		priMessage3.setTo(user2);
		priMessage3.setContent("这是张-》关的第二条私信！");
		priMessage3.setTime(new Timestamp(System.currentTimeMillis()));
		priMessage3.setState(1);
		
		priMessage4.setFrom(user1);
		priMessage4.setTo(user2);
		priMessage4.setContent("这是张-》关的第三条私信！");
		priMessage4.setTime(new Timestamp(System.currentTimeMillis()));
		priMessage4.setState(1);
		
		priMessage5.setFrom(user2);
		priMessage5.setTo(user1);
		priMessage5.setContent("这是关-》张的回复私信！");
		priMessage5.setTime(new Timestamp(System.currentTimeMillis()));
		priMessage5.setState(0);
		
		//刘-关
		priMessage6.setFrom(user3);
		priMessage6.setTo(user2);
		priMessage6.setContent("这是刘-》关的第一条私信！");
		priMessage6.setTime(new Timestamp(System.currentTimeMillis()));
		priMessage6.setState(0);
		
		//曹-关
		priMessage7.setFrom(user4);
		priMessage7.setTo(user2);
		priMessage7.setContent("这是曹-》关的第一条私信！");
		priMessage7.setTime(new Timestamp(System.currentTimeMillis()));
		priMessage7.setState(0);
		
		primessageService.add(priMessage1);
		primessageService.add(priMessage2);
		primessageService.add(priMessage3);
		primessageService.add(priMessage4);
		primessageService.add(priMessage5);
		primessageService.add(priMessage6);
		primessageService.add(priMessage7);
		
		return null;
	}

	@RequestMapping(params = "method=delete")
	public ModelAndView delete() {

		primessageService.deleteByPMid("8abf8b1d4cc1924e014cc1927f920003");
		
		System.out.println("删除指定id的消息！");

		return null;
	}
	
	@RequestMapping(params = "method=update")
	public  ModelAndView update() {
		
		primessageService.updatePrimessageStateByPMid("8abf8b1d4cc1924e014cc192805a0006");
		
		System.out.println("更新一条私信状态!");
		
		return null;
	}
	
	@RequestMapping(params = "method=update1")
	public  ModelAndView update1() {
		
		primessageService.updatePrimessageStateByToAndState("8abf8b1d4cb833eb014cb8341c770000");
		
		System.out.println("更新关某某所有的未读私信状态!");
		
		return null;
	}

	@RequestMapping(params = "method=query")
	public ModelAndView query() {

		List<PriMessage> messages = primessageService.queryPrimessagesByTo("8abf8b1d4cb833eb014cb8341c770000");

		System.out.println("查询关某某收到的所有私信："+messages.size()+"\n" + messages);
		
		List<PriMessage> messages1 = primessageService.queryPrimessagesByFromAndTo("8abf8b1d4cb80801014cb8083cda0000", "8abf8b1d4cb833eb014cb8341c770000");

		System.out.println("查询关-张之间发布的所有私信："+messages1.size()+"\n" + messages1);
		
		List<PriMessage> messages2 = primessageService.queryPrimessagesByToAndState("8abf8b1d4cb833eb014cb8341c770000", 0);
		
		System.out.println("查询发给关的所有未读私信："+messages2.size()+"\n" + messages2);
		
		return null;
	}

}

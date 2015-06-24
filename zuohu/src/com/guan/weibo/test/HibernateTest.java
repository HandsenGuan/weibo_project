package com.guan.weibo.test;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.guan.weibo.user.domain.User;
import com.guan.weibo.user.service.UserService;

@Controller
@RequestMapping("/test")
public class HibernateTest {

	@Resource(name = "userService")
	private UserService userService;

	@RequestMapping(value = "/index")
	public ModelAndView index() {

		ModelAndView mv = new ModelAndView();
		return mv;
	}

	@RequestMapping(params = "method=add")
	public ModelAndView add() {

		ModelAndView mv = new ModelAndView();

		// 添加用户
		User user = new User();
		user.setNickname("关某某");
		user.setPassword("132412312");
		user.setStatus(true);
		user.setMessage_num(4);
		user.setFollow_num(1);
		user.setDatetime(new Timestamp(System.currentTimeMillis()));

		userService.regist(user);
		
		User user1 = new User();
		user1.setNickname("刘某某");
		user1.setPassword("213412312");
		user1.setStatus(false);
		user1.setMessage_num(2);
		user1.setFollow_num(5);
		user1.setDatetime(new Timestamp(System.currentTimeMillis()));

		userService.regist(user1);
		
		User user2 = new User();
		user2.setNickname("曹某某");
		user2.setPassword("123456");
		user2.setStatus(true);
		user2.setMessage_num(6);
		user2.setFollow_num(2);
		user2.setDatetime(new Timestamp(System.currentTimeMillis()));

		userService.regist(user2);
		
		return mv;
	}

	@RequestMapping(params = "method=update1")
	public ModelAndView updatePassword() {

		ModelAndView mv = new ModelAndView();

		// 修改用户密码
		userService.updatePassword("8abf8b1d4cb80801014cb8083cda0000",
				"654321", "123456");

		return mv;
	}

	@RequestMapping(params = "method=update2")
	public ModelAndView update() {

		ModelAndView mv = new ModelAndView();

		// 修改用户信息
		User user = new User();
		user.setU_id("8abf8b1d4cb80801014cb8083cda0000");
		user.setNickname("张某某");
		user.setPassword("123456");
		user.setStatus(true);
		user.setMessage_num(2);
		user.setFollow_num(2);
		user.setDatetime(new Timestamp(System.currentTimeMillis()));

		userService.updateUserInfo(user);
		
		return mv;
	}

	@RequestMapping(params = "method=selectAll")
	public ModelAndView select() {

		ModelAndView mv = new ModelAndView();

		List<User> users = userService.queryAll();
		System.out.println("查询所有：" + users);

		return mv;
	}

	@RequestMapping(params = "method=select1")
	public ModelAndView viewOne() {

		ModelAndView mv = new ModelAndView();

		User user = userService.queryByUid("8abf8b1d4cb80801014cb8083cda0000");

		System.out.println("根据id查找用户：" + user.toString());

		boolean bool = userService.ajaxValidateEmail("123@qq.com");

		System.out.println("根据邮箱查找用户：" + bool);

		boolean bool1 = userService.ajaxValidateLoginname("张某某");

		System.out.println("根据登录名查找用户：" + bool1);

		return mv;
	}

}

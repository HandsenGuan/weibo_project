package com.guan.weibo.test;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.guan.weibo.user.domain.User;
import com.guan.weibo.user.service.UserService;

@Controller
@RequestMapping("/test")
public class HibernateTest {

	@Resource(name="userService")
	private UserService userService;
	
	
	@RequestMapping(value="/index")
	public ModelAndView index(){
		System.out.println("index");
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/user/userDaoTest");
		mv.addObject("choose", 1);
		mv.addObject("user", new User());
		
		return mv;
	}
	
	@RequestMapping(params="method=select")
	public ModelAndView select(){
		
		List<User> users = userService.queryAll();
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("users", users);
		mv.addObject("choose", 4);
		
		mv.setViewName("/user/userDaoTest");
		
		return mv;
	}
	
	@RequestMapping(params="method=add" ,method= {RequestMethod.POST})
	public ModelAndView add(HttpServletRequest req,User user){
		System.out.println("add");
		System.out.println(user.toString());
		System.out.println("id:"+user.getUser_id());
		System.out.println("nickname"+user.getUser_nickname());
		System.out.println("email"+user.getUser_email());
		
		userService.regist(user);
		req.getSession().setAttribute("username", user.getUser_nickname());
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/user/userDaoTest");
		mv.addObject("choose", 5);
		return mv;
	}
	
	@RequestMapping(params="method=update" ,method= {RequestMethod.POST})
	public ModelAndView update(HttpServletRequest req,User user){
		
		System.out.println("update");
		
		if(user!= null)
		System.out.println(user.getUser_id());
		
		userService.updateUserInfo(user);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/user/userDaoTest");
		
		if(user!= null)
		{
			user = userService.findByUid(user.getUser_id());
			System.out.println("update完成！");
			mv.addObject("user", user);
		}
		mv.addObject("choose", 6);
		return mv;
	} 
	
	@RequestMapping(params="method=view")
	public ModelAndView viewOne(String user_id){
		
		System.out.println("view");
		System.out.println(user_id);
		
		User user = userService.findByUid(user_id);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/user/userDaoTest");
		mv.addObject("user", user);
		mv.addObject("choose", 3);
		return mv;
	} 
	
}

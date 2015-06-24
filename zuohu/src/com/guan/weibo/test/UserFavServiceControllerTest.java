package com.guan.weibo.test;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.guan.weibo.message.domain.Message;
import com.guan.weibo.message.service.MessageService;
import com.guan.weibo.user.domain.User;
import com.guan.weibo.user.domain.UserFav;
import com.guan.weibo.user.service.UserFavService;
import com.guan.weibo.user.service.UserService;

@Controller
@RequestMapping("/test5")
public class UserFavServiceControllerTest {
	
	@Resource(name="userFavService")
	UserFavService userFavService;
	
	@Resource(name="userService")
	UserService userService;
	
	@Resource(name="messageService")
	MessageService messageService;

	@RequestMapping(params = "method=add")
	public ModelAndView add() {
		
		//用户
		User user1 = userService.queryByUid("8abf8b1d4cb833eb014cb8341d040001");//刘
		
		User user2 = userService.queryByUid("8abf8b1d4cb833eb014cb8341d320002");//曹
		
		//消息
		Message message1 = messageService.queryMessageByMid("297e79064cbcc855014cbcc876e00000"); //图片状态
		
		Message message2 = messageService.queryMessageByMid("297e79064cbcca7b014cbccaa1830000"); //图片状态
		
		Message message3 = messageService.queryMessageByMid("402881e94cb89703014cb8973d2d0001"); //富文本
		
		Message message4 = messageService.queryMessageByMid("402881e94cb89703014cb8973dbf0002"); //富文本
		
//		UserFav userFav1 = new UserFav();
//		UserFav userFav2 = new UserFav();
//		UserFav userFav3 = new UserFav();
//
//		userFav1.setUser(user1);
//		userFav1.setMessage(message1);
//		
//		userFav2.setUser(user1);
//		userFav2.setMessage(message2);
//		
//		userFav3.setUser(user2);
//		userFav3.setMessage(message3);
//		
//		userFavService.add(userFav1);
//		userFavService.add(userFav2);
//		userFavService.add(userFav3);
		
		
		UserFav userFav4 = new UserFav();
		userFav4.setUser(user2);
		userFav4.setMessage(message4);
		
		userFavService.add(userFav4);
		
		System.out.println("添加用户关注记录!");
		
		return null;
		
	}
	
	@RequestMapping(params = "method=delete")
	public ModelAndView delete() {
		
		userFavService.delete("ff8080814cbfef22014cbfef45590000");
		
		System.out.println("删除用户关注记录！");
		
		return null;
	}
	
	@RequestMapping(params = "method=query")
	public ModelAndView query() {
		
		List<UserFav>  userFavs = userFavService.queryByUid("8abf8b1d4cb833eb014cb8341d040001");
		
		System.out.println("指定用户的所有的关注记录："+userFavs);
		
		boolean isFav = userFavService.queryByUidAndMid("8abf8b1d4cb833eb014cb8341d320002", "402881e94cb89703014cb8973dbf0002");
		
		System.out.println("是否关注(message4)："+isFav);
		
		boolean isFav2 = userFavService.queryByUidAndMid("8abf8b1d4cb833eb014cb8341d320002", "402881e94cb89703014cb8973d2d0001");
		
		System.out.println("是否关注(message3)："+isFav2);
		
		return null;
		
	}
	
}

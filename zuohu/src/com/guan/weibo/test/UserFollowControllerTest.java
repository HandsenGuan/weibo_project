package com.guan.weibo.test;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.guan.weibo.user.domain.User;
import com.guan.weibo.user.domain.UserFollow;
import com.guan.weibo.user.service.UserFollowService;
import com.guan.weibo.user.service.UserService;


@Controller
@RequestMapping("/test6")
public class UserFollowControllerTest {
	
	@Resource(name="userService")
	UserService userService;
	
	@Resource(name="userFollowService")
	UserFollowService userFollowService;
	
	@RequestMapping(params = "method=add")
	public ModelAndView add() {
		
		User user1 = userService.queryByUid("8abf8b1d4cb80801014cb8083cda0000");//张
		User user2 = userService.queryByUid("8abf8b1d4cb833eb014cb8341c770000");//关
		User user3 = userService.queryByUid("8abf8b1d4cb833eb014cb8341d040001");//刘
		User user4 = userService.queryByUid("8abf8b1d4cb833eb014cb8341d320002");//曹
		
		UserFollow userFollow1 = new UserFollow();
		UserFollow userFollow2 = new UserFollow();
		UserFollow userFollow3 = new UserFollow();
		UserFollow userFollow4 = new UserFollow();
		UserFollow userFollow5 = new UserFollow();
		UserFollow userFollow6 = new UserFollow();
		UserFollow userFollow7 = new UserFollow();
		UserFollow userFollow8 = new UserFollow();
		UserFollow userFollow9 = new UserFollow();
		
		//张---关注
		userFollow1.setUser(user1);
		userFollow1.setFuser(user2);
		
		userFollow2.setUser(user1);
		userFollow2.setFuser(user3);
		
		userFollow3.setUser(user1);
		userFollow3.setFuser(user4);
		
		//关 ---关注
		userFollow4.setUser(user2);
		userFollow4.setFuser(user1);
		
		userFollow5.setUser(user2);
		userFollow5.setFuser(user3);
		
		//刘---关注
		userFollow6.setUser(user3);
		userFollow6.setFuser(user1);
		
		userFollow7.setUser(user3);
		userFollow7.setFuser(user4);
		
		userFollow8.setUser(user3);
		userFollow8.setFuser(user2);
		
		//曹---关注
		userFollow9.setUser(user4);
		userFollow9.setFuser(user2);
		
		
		userFollowService.add(userFollow1);
		userFollowService.add(userFollow2);
		userFollowService.add(userFollow3);
		userFollowService.add(userFollow4);
		userFollowService.add(userFollow5);
		userFollowService.add(userFollow6);
		userFollowService.add(userFollow7);
		userFollowService.add(userFollow8);
		userFollowService.add(userFollow9);
		
		System.out.println("添加用户关注记录!");
		
		return null;
	}
	
	@RequestMapping(params = "method=delete")
	public ModelAndView delete() {
		
		userFollowService.delete("ff8080814cc02a5d014cc02add970000");
		
		System.out.println("删除用户关注记录！");
		
		return null;
	}
	
	@RequestMapping(params = "method=query")
	public ModelAndView query() {
		
		List<UserFollow>  zhangFollows = userFollowService.queryByUid("8abf8b1d4cb80801014cb8083cda0000");
		List<UserFollow>  guanFollows = userFollowService.queryByUid("8abf8b1d4cb833eb014cb8341c770000");
		List<UserFollow>  liuFollows = userFollowService.queryByUid("8abf8b1d4cb833eb014cb8341d040001");
		List<UserFollow>  caoFollows = userFollowService.queryByUid("8abf8b1d4cb833eb014cb8341d320002");
		
		System.out.println("指定用户的所有的关注记录："+"\n zhang:"+zhangFollows.size()+"\n guan:"+guanFollows.size()+"\n liu:"+liuFollows.size()+"\n cao:"+caoFollows.size());
		
		boolean isFollow= userFollowService.queryByUidAndFuid("8abf8b1d4cb80801014cb8083cda0000", "8abf8b1d4cb833eb014cb8341c770000");
		
		System.out.println("是否关注(user1---关注--user2)："+isFollow);
		
		boolean isFollow2 = userFollowService.queryByUidAndFuid("8abf8b1d4cb833eb014cb8341d320002", "8abf8b1d4cb80801014cb8083cda0000");
		
		System.out.println("是否关注(user4---no关注--user1)："+isFollow2);
		
		return null;
		
	}

}

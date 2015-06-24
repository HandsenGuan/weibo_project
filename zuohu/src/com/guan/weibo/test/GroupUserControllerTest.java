package com.guan.weibo.test;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.guan.weibo.user.domain.Group;
import com.guan.weibo.user.domain.GroupUser;
import com.guan.weibo.user.domain.User;
import com.guan.weibo.user.service.GroupService;
import com.guan.weibo.user.service.GroupUserService;
import com.guan.weibo.user.service.UserService;

@Controller
@RequestMapping("/test4")
public class GroupUserControllerTest {

	@Resource(name = "groupUserService")
	GroupUserService groupUserService;
	
	@Resource(name="userService")
	UserService userService;
	
	@Resource(name="groupService")
	GroupService groupService;

	@RequestMapping(params = "method=add")
	public ModelAndView add() {

		GroupUser group_user1 = new GroupUser();
		GroupUser group_user2 = new GroupUser();
		GroupUser group_user3 = new GroupUser();
		GroupUser group_user4 = new GroupUser();
		GroupUser group_user5 = new GroupUser();
		GroupUser group_user6 = new GroupUser();
		
		//用户
		User user1 = userService.queryByUid("8abf8b1d4cb80801014cb8083cda0000");//张
		User user2 = userService.queryByUid("8abf8b1d4cb833eb014cb8341c770000");//关
		User user3 = userService.queryByUid("8abf8b1d4cb833eb014cb8341d040001");//刘
		User user4 = userService.queryByUid("8abf8b1d4cb833eb014cb8341d320002");//曹
		
		//群
		Group group1 = groupService.queryGroupById("b1fbd5de4cbb39b2014cbb39e1b00000");
		Group group2 = groupService.queryGroupById("b1fbd5de4cbb39b2014cbb39e27c0001");
		
		//添加群-用户关系
		//----------------1群-------------
		group_user1.setGroup(group1);
		group_user1.setUser(user1);
		
		group_user2.setGroup(group1);
		group_user2.setUser(user2);
		
		group_user3.setGroup(group1);
		group_user3.setUser(user3);
		
		//----------------2群-------------
		group_user4.setGroup(group2);
		group_user4.setUser(user1);
		
		group_user5.setGroup(group2);
		group_user5.setUser(user3);
		
		group_user6.setGroup(group2);
		group_user6.setUser(user4);
		
		
		groupUserService.add(group_user1);
		groupUserService.add(group_user2);
		groupUserService.add(group_user3);
		groupUserService.add(group_user4);
		groupUserService.add(group_user5);
		groupUserService.add(group_user6);

		System.out.println("添加用户、群对应关系！");

		return null;
	}

	@RequestMapping(params = "method=delete")
	public ModelAndView delete() {

		groupUserService.delete("8abf8b1d4cb833eb014cb8341d320002", "b1fbd5de4cbb39b2014cbb39e27c0001");

		System.out.println("删除指定用户、群的关系！");

		return null;
	}

	@RequestMapping(params = "method=update")
	public ModelAndView update() {

		groupUserService.updateLevelByUidAndGid("b1fbd5de4cbb39b2014cbb39e1b00000","8abf8b1d4cb80801014cb8083cda0000", 1);
		
		System.out.println("修改指定用户的等级！");
		
		return null;
	}

	@RequestMapping(params = "method=query")
	public ModelAndView query() {

		List<GroupUser> groups = groupUserService.queryGroupsByUid("8abf8b1d4cb833eb014cb8341d040001");

		System.out.println("查询指定用户所在的群：" + groups);
		
		List<GroupUser> users = groupUserService.queryUsersByGid("b1fbd5de4cbb39b2014cbb39e1b00000");
		
		System.out.println("查询指定群下的所有的用户："+users);
		
		return null;
	}

}

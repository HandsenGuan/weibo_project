package com.guan.weibo.test;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.guan.weibo.user.domain.Group;
import com.guan.weibo.user.service.GroupService;

@Controller
@RequestMapping("/test2")
public class GroupControllerTest {
	
	@Resource(name="groupService")
	GroupService groupService;

	@RequestMapping(params = "method=add")
	public ModelAndView add() {

		Group group = new Group();
		
		group.setG_name("第一个测试群");
		
		Group group1 = new Group();
		
		group1.setG_name("第二个测试群");
		
		Group group2 = new Group();
		
		group2.setG_name("第三个测试群");
		
		groupService.add(group);
		groupService.add(group1);
		groupService.add(group2);
		
		System.out.println("添加群！");
		
		return null;
	}

	@RequestMapping(params = "method=delete")
	public ModelAndView delete() {
		
		groupService.delete("b1fbd5de4cbb39b2014cbb39e2f10002");
		
		System.out.println("删除指定id的群!");
		
		return null;
	}

	@RequestMapping(params = "method=update")
	public ModelAndView updateGroup() {
		
		
		Group group = new Group();
		group.setG_id("b1fbd5de4cbb39b2014cbb39e1b00000");
		group.setG_name("第一个测试群");
		group.setG_desc("这是第一个群的描述信息~~~~~~~~~~~");
		
		groupService.updateGroup(group);
		
		System.out.println("更新群！");
		
		return null;
	}
	
	@RequestMapping(params = "method=update1")
	public ModelAndView updateGroupName() {
		
		
		groupService.updateGroupName("b1fbd5de4cbb39b2014cbb39e27c0001", "第二个测试群（修改后）");
		
		System.out.println("更新群名称！");
		
		return null;
	}

	@RequestMapping(params = "method=query")
	public ModelAndView query() {
		
		
		Group group = groupService.queryGroupById("b1fbd5de4cbb39b2014cbb39e1b00000");
		
		System.out.println("查询指定id的群："+group.toString());
		
		return null;
	}

}

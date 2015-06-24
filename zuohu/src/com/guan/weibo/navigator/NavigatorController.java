package com.guan.weibo.navigator;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.guan.weibo.message.domain.Message;
import com.guan.weibo.message.domain.PriMessage;
import com.guan.weibo.message.service.MessageService;
import com.guan.weibo.message.service.PrimessageService;
import com.guan.weibo.user.domain.Group;
import com.guan.weibo.user.domain.GroupUser;
import com.guan.weibo.user.domain.User;
import com.guan.weibo.user.service.GroupUserService;
import com.guan.weibo.user.service.UserFollowService;
import com.guan.weibo.user.service.UserService;
import com.guan.weibo.utils.CommonUtils;
import com.guan.weibo.utils.Pager;

@Controller
@RequestMapping("/nav")
public class NavigatorController {

	@Resource(name = "messageService")
	private MessageService messageService;

	@Resource(name = "groupUserService")
	private GroupUserService groupUserService;

	@Resource(name = "userService")
	private UserService userService;
	
	@Resource(name="userFollowService")
	private UserFollowService userFollowService;

	@Resource(name = "primessageService")
	private PrimessageService primessageService;

	@RequestMapping(params = "method=index")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("redirect:/user?method=index");
		return modelAndView;
	}

	@RequestMapping(params = "method=found")
	public ModelAndView found() {
		ModelAndView modelAndView = new ModelAndView("user/found");

		return modelAndView;
	}

	@RequestMapping(params = "method=person")
	public ModelAndView person(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("user/person");

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user != null) {
			String u_id = request.getParameter("u_id");
			List<Message> messages = null;
			//不是当前登录用户
			if (u_id!=null&&!u_id.equals(user.getU_id())) {
				
				System.out.println("不是当前用户！\n点击用户："+u_id+"\n当前用户："+user.getU_id());
				
				messages = messageService.queryByPageAndUid(u_id, 0, Pager.PAGE_SIZE);
				User other_user = userService.queryByUid(u_id);
				request.setAttribute("other", other_user);
				request.setAttribute("self", 0);
				if(userFollowService.queryByUidAndFuid(user.getU_id(), u_id)){
					request.setAttribute("isFollow", 1);
				}
			} else {
				System.out.println("是当前用户！\n点击用户："+u_id+"\n当前用户："+user.getU_id());
				messages = messageService.queryByPageAndUid(user.getU_id(), 0, Pager.PAGE_SIZE);
				request.setAttribute("self", 1);
			}
			messages = CommonUtils.decoderMessage(messages);
			request.setAttribute("messages", messages);
		}

		return modelAndView;
	}

	@RequestMapping(params = "method=group")
	public ModelAndView group(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("user/group");

		String g_id = request.getParameter("g_id");

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		System.out.println("user:" + user.getNickname());
		Set<GroupUser> groupusers = user.getGroups();
		Iterator<GroupUser> it = groupusers.iterator();
		while (it.hasNext()) {
			Group group = it.next().getGroup();
			if (group.getG_id().equals(g_id)) {
				System.out.println("group:" + group.toString());
				request.setAttribute("group", group);

				List<GroupUser> users = groupUserService.queryUsersByGid(group.getG_id());
				request.setAttribute("users", users);
			}

		}
		return modelAndView;
	}

	@RequestMapping(params = "method=setting")
	public ModelAndView setting() {
		ModelAndView modelAndView = new ModelAndView("user/setting");

		return modelAndView;
	}

	@RequestMapping(params = "method=sixin")
	public ModelAndView sixin(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("user/sixin");

		User user = (User) request.getSession().getAttribute("user");
		List<PriMessage> primessages = primessageService.queryPrimessagesByTo(user.getU_id());
		request.setAttribute("primessages", primessages);

		return modelAndView;
	}

}

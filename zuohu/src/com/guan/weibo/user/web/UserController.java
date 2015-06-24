package com.guan.weibo.user.web;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.guan.weibo.message.domain.Message;
import com.guan.weibo.message.domain.Reply;
import com.guan.weibo.message.service.MessageService;
import com.guan.weibo.message.service.ReplyService;
import com.guan.weibo.user.domain.User;
import com.guan.weibo.user.domain.UserFollow;
import com.guan.weibo.user.service.UserFollowService;
import com.guan.weibo.user.service.UserService;
import com.guan.weibo.utils.CommonUtils;
import com.guan.weibo.utils.ImageUtils;
import com.guan.weibo.utils.MD5Utils;
import com.guan.weibo.utils.Pager;

@Controller
@RequestMapping("/user")
public class UserController {

	@Resource(name = "userService")
	private UserService userService;

	@Resource(name = "userFollowService")
	private UserFollowService userFollowService;

	@Resource(name = "messageService")
	private MessageService messageService;

	@Resource(name = "replyService")
	private ReplyService replyService;

	@RequestMapping(params = "method=regist")
	public ModelAndView regist() {
		return new ModelAndView("/user/load");
	}

	@RequestMapping(params = "method=login")
	public ModelAndView login() {
		return new ModelAndView("/user/load1");
	}

	@RequestMapping(params = "method=showMsg")
	public ModelAndView showMsg() {
		return new ModelAndView("/user/message");
	}

	@RequestMapping(params = "method=follow")
	public ModelAndView follow() {
		return new ModelAndView("/user/guanzhu");
	}

	@RequestMapping(params = "method=index")
	public String index(HttpServletRequest request) {

		HttpSession session = request.getSession();

		User user = (User) session.getAttribute("user");
		
		if (user != null) {
			List<Message> messages = messageService.queryByPageAndUid(user.getU_id(), 0, Pager.PAGE_SIZE);
			messages = CommonUtils.decoderMessage(messages);
			session.setAttribute("messages", messages);

		} else {
			session.removeAttribute("messages");
		}
		return "/user/main";
	}

	// 退出登录
	@RequestMapping(params = "method=exit")
	public String exit(HttpServletRequest request) {
		request.getSession().removeAttribute("user");
		request.getSession().removeAttribute("messages");
		return "redirect:/user?method=index";
	}

	// 注册成功
	@RequestMapping(params = "method=registSuccess")
	public String registSuccess() {
		return "redirect:/user?method=index";
	}

	// 注册提交
	@RequestMapping(params = "method=submit")
	public String registSubmit(HttpServletRequest request) {

		String username = request.getParameter("username");

		String email = request.getParameter("email");

		String password = request.getParameter("password");

		if (password != null && !"".equals(password)) {
			password = MD5Utils.getMD5(password);
		}

		User user = new User(username, password);
		user.setEmail(email);
		user.setUser_img("myjs/ImgCrop/images/avatar.png");

		if (username != null && !"".equals(username) && email != null && !"".equals(email) && password != null && !"".equals(password)) {
			userService.regist(user);
			user = userService.login(username, password);
			request.getSession().setAttribute("user", user);
			return "redirect:/user?method=index";
		}

		return "user/load1";
	}

	// 用户激活
	@RequestMapping(params = "method=activation")
	public String activation(HttpServletRequest request) {
		/**
		 * 1、获取参数激活码 2、用激活码调用service方法完成激活
		 * 》service方法有可能抛出异常,把异常信息保存到request中，转发到msg.jsp。
		 * 3、保存成功信息到request，转发到msg.jsp
		 */
		String code = (String) request.getParameter("activationCode");
		try {
			userService.activation(code);
			request.getSession().setAttribute("code", "success");// 通知messageg.jsp显示正确页面
			request.getSession().setAttribute("msg", "恭喜激活成功！");
			User user = (User)request.getSession().getAttribute("user");
			user.setStatus(true);
		} catch (Exception e) {
			// 抛出异常
			request.getSession().setAttribute("msg", e.getMessage());
			request.getSession().setAttribute("code", "error");// 通知messageg.jsp显示错误页面
		}

		return "redirect:/user?method=showMsg";
	}

	// 登录验证
	@RequestMapping(params = "method=loginSubmit")
	public String loginSubmit(HttpServletRequest request) {

		String loginname = request.getParameter("login_username");

		String password = request.getParameter("login_password");

		System.out.println("username:" + loginname);
		System.out.println("编码前password:" + password);

		if (loginname != null && !"".equals(loginname) && password != null && !"".equals(password)) {

			password = MD5Utils.getMD5(password);
			System.out.println("编码后password:" + password);

			User user = userService.login(loginname, password);

			if (user != null) {
				System.out.println("登录成功！");
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				List<Message> messages = messageService.queryByPageAndUid(user.getU_id(), 0, Pager.PAGE_SIZE);
				// 解码html
				messages = CommonUtils.decoderMessage(messages);
				request.setAttribute("messages", messages);
				return "redirect:/user?method=index";
			} else {
				System.out.println("登录失败！");
			}

		} else {
			System.out.println("用户名或密码为空！");
		}

		return "user/load1";
	}

	// ajax验证用户名
	@RequestMapping(params = "method=validateName")
	@ResponseBody
	public Object ajaxValidateUsername(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();

		String username = request.getParameter("loginname");

		if (userService.ajaxValidateLoginname(username)) {
			map.put("exit", 1);
		}
		return map;
	}

	// ajax验证邮箱
	@RequestMapping(params = "method=validateEmail")
	@ResponseBody
	public Object ajaxValidateEmail(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();

		String email = request.getParameter("email");

		if (userService.ajaxValidateEmail(email)) {
			map.put("exit", 1);
		}

		return map;
	}

	// ajax验证用户名
	@RequestMapping(params = "method=validateLogin")
	@ResponseBody
	public Object ajaxValidateUsernameAndPassword(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		System.out.println("username:" + username);
		System.out.println("password:" + password);

		User user = null;
		if (username != null && password != null) {
			user = userService.login(username, password);
		}

		if (user != null) {
			request.getSession().setAttribute("user", user);
			map.put("exit", 1);
		}
		return map;
	}

	// ajax验证密码
	@RequestMapping(params = "method=validatePassword")
	@ResponseBody
	public Object validatePassword(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();

		String u_id = request.getParameter("u_id");
		String oldpassword = request.getParameter("oldpassword");
		oldpassword = MD5Utils.getMD5(oldpassword);

		if (!userService.ajaxValidatePassword(u_id, oldpassword)) {
			map.put("exit", 1);
		}

		return map;
	}

	// ajax修改密码
	@RequestMapping(params = "method=updatePassword")
	@ResponseBody
	public Object updatePassword(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();

		String u_id = request.getParameter("u_id");
		String oldpassword = request.getParameter("oldpassword");
		String newpassword = request.getParameter("newpassword");
		oldpassword = MD5Utils.getMD5(oldpassword);
		newpassword = MD5Utils.getMD5(newpassword);

		try {
			userService.updatePassword(u_id, newpassword, oldpassword);
			request.getSession().removeAttribute("user");
		} catch (Exception e) {
			map.put("error", 1);
		}

		return map;
	}

	// ajax修改邮箱
	@RequestMapping(params = "method=updateEmail")
	@ResponseBody
	public Object updateEmail(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();

		String u_id = request.getParameter("u_id");
		String email = request.getParameter("email");

		System.out.println("u_id:" + u_id);
		System.out.println("email:" + email);

		userService.updateEmail(u_id, email);

		map.put("ok", 1);
		return map;
	}

	// ajax修改头像
	@RequestMapping(params = "method=updateUserImg")
	@ResponseBody
	public Object updateUserImg(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();

		String u_id = request.getParameter("u_id");
		String img = request.getParameter("img");

		System.out.println("u_id:" + u_id);
		System.out.println("img:" + img.substring(0, 100));

		if (u_id != null && !"".endsWith(u_id) && img != null && !"".endsWith(img)) {

			// 匹配Base64编码后的图片文件
			Matcher matcher = Pattern.compile("data:image\\/(\\w+)").matcher(img);
			String image_suffix = "jpg";
			if (matcher.find()) {
				// 获取后缀名
				image_suffix = matcher.group(1);
			}

			String[] str = img.split(",");
			// 构建新的文件名
			String newFileName = u_id + "." + image_suffix;

			// 保存路径
			String savePath = request.getServletContext().getRealPath("/") + "/upload/images/touxiang/";
			System.out.println("savepath:"+savePath);
			
			// 将Base64数据转化为图片存储
			if (!ImageUtils.decodeBase64ToImage(str[1], savePath, newFileName)) {
				map.put("ok", 0);
			}

			// Spring配置的映射路径
			String mappingPath = "message_imgs/touxiang/";
			userService.updateUserImg(u_id, mappingPath + newFileName);

			User user = (User) request.getSession().getAttribute("user");
			user.setUser_img(mappingPath + newFileName);

			map.put("ok", 1);
		} else {
			map.put("ok", 0);
		}
		return map;
	}

	// 关注
	@RequestMapping(params = "method=ajaxFollowone")
	@ResponseBody
	public Object ajaxFollowone(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		String u_id = request.getParameter("u_id");
		if (u_id != null) {
			// 添加用户关注映射
			User follow_user = userService.queryByUid(u_id);
			UserFollow userFollow = new UserFollow();
			User user = (User) request.getSession().getAttribute("user");
			userFollow.setUser(user);
			userFollow.setFuser(follow_user);
			userFollowService.add(userFollow);
			// 更改用户关注数
			userService.updateUserFollowNum(user.getU_id(), true);
			userService.updateUserFollowedNum(follow_user.getU_id(), true);
			user.setFollow_num(user.getFollow_num() + 1);

			map.put("ok", 1);
		}

		return map;
	}

	// 评论
	@RequestMapping(params = "method=ajaxReplyMessage")
	@ResponseBody
	public Object ajaxReplyMessage(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		// 状态id
		String m_id = request.getParameter("m_id");
		Message message = messageService.queryMessageByMid(m_id);
		// 评论内容
		String content = request.getParameter("reply_content");

		User user = (User) request.getSession().getAttribute("user");

		if (message != null && content != null && !"".equals(content) && user != null) {
			Reply reply = new Reply();
			reply.setContent(content);
			reply.setMessage(message);
			reply.setUser(user);
			reply.setTime(new Timestamp(System.currentTimeMillis()));

			replyService.add(reply);

			map.put("ok", 1);
		} else {
			map.put("ok", 0);
		}

		return map;
	}
	
	//回复评论
	@RequestMapping(params = "method=ajaxReply2Reply")
	@ResponseBody
	public Object ajaxReply2Reply(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		// 状态id
		String m_id = request.getParameter("message_id");
		Message message = messageService.queryMessageByMid(m_id);
		
		//评论
		String reply_id = request.getParameter("reply_id");
		Reply reply = replyService.queryByRid(reply_id);
		// 评论内容
		String content = request.getParameter("huifu_content");
		//当前用户
		User user = (User) request.getSession().getAttribute("user");
		
		if (message != null && content != null && !"".equals(content) && user != null&&reply!=null) {
			Reply huifu = new Reply();
			huifu.setContent(content);
			huifu.setMessage(message);
			huifu.setUser(user);
			huifu.setParent(reply);
			huifu.setTime(new Timestamp(System.currentTimeMillis()));
			
			replyService.add(huifu);
			
			map.put("ok", 1);
		} else {
			map.put("ok", 0);
		}
		
		return map;
	}

	// 获取主页消息
	@RequestMapping(params = "method=ajaxForMessages")
	@ResponseBody
	private List<Message> ajaxGetMessages(HttpServletRequest request) {

		HttpSession session = request.getSession();

		// 获取当前登录用户
		User user = (User) session.getAttribute("user");
		// 若用户已登录
		if (user != null) {
			// 获取数据总数
			long totalCount;
			Object total_obj = session.getAttribute("totalCount");
			if (total_obj == null) {
				totalCount = messageService.queryTotalCountByUid(user.getU_id());
			} else {
				totalCount = (long) total_obj;
			}

			// 获取当前
			int pageNum;
			Object page_obj = session.getAttribute("pageNum");
			if (page_obj == null) {
				pageNum = 0;
			} else {
				pageNum = (int) page_obj;
			}

			List<Message> messages = null;
			if ((pageNum - 1) * Pager.PAGE_SIZE <= totalCount) {
				messages = messageService.queryByPageAndUid(user.getU_id(), pageNum, Pager.PAGE_SIZE);
			}
		}

		return null;
	}

}

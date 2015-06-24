package com.guan.weibo.test;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.guan.weibo.message.domain.Message;
import com.guan.weibo.message.service.MessageService;
import com.guan.weibo.user.domain.User;
import com.guan.weibo.user.service.UserService;

@Controller
@RequestMapping("/test1")
public class MessageControllerTest {
	
	@Resource(name="messageService")
	MessageService messageService;

	@Resource(name="userService")
	UserService userService;

	@RequestMapping(params = "method=add")
	public ModelAndView publish() {

		User user = userService.queryByUid("8abf8b1d4cb80801014cb8083cda0000");

		if(user!=null){
			System.out.println("用户："+user.getNickname());
		}else{
			System.out.println("查找用户失败！");
			return null;
		}
		
		Message message = new Message();

		message.setUser(user);
		message.setTitle("第一条测试状态的标题");
		message.setContent("第一条富文本测试状态！！！！！！！！！！！！");
		message.setTime(new Timestamp(System.currentTimeMillis()));
		message.setType(1);
		message.setReply_num(0);
		message.setScan_num(0);

		Message message1 = new Message();

		message1.setUser(user);
		message1.setTitle("第二条测试状态的标题");
		message1.setContent("第二条富文本测试状态················");
		message1.setTime(new Timestamp(System.currentTimeMillis()));
		message1.setType(1);
		message1.setReply_num(0);
		message1.setScan_num(0);
		
		Message message2 = new Message();

		message2.setUser(user);
		message2.setTitle("第三条测试状态的标题");
		message2.setContent("第三条富文本测试状态！！！！！！！！！！！！");
		message2.setTime(new Timestamp(System.currentTimeMillis()));
		message2.setType(1);
		message2.setReply_num(0);
		message2.setScan_num(0);

		messageService.publishMessage(message);
		messageService.publishMessage(message1);
		messageService.publishMessage(message2);

		return null;
	}

	@RequestMapping(params = "method=delete")
	public ModelAndView delete() {
		
		messageService.deleteMessageById("402881e94cb89703014cb8973c740000");
		
		System.out.println("删除指定id的消息：");
		
		return null;
	}

	@RequestMapping(params = "method=update")
	public ModelAndView update() {
		
		Message message =messageService.queryMessageByMid("b1fbd5de4cbc1a8d014cbc1ce4990000");
		message.setTitle("（曹某某）第二条测试状态的标题");
		message.setContent("第二条图片测试状态！！！！！！！！！！！！！(修改了内容)");
		messageService.update(message);
		
		System.out.println("更新指定id的消息");
		
		return null;
	}

	@RequestMapping(params = "method=query")
	public ModelAndView query() {

//		List<Message> messages = messageService.queryMessagesByUid("8abf8b1d4cb80801014cb8083cda0000");
//		
//		System.out.println("查询指定用户发布的所有消息："+messages.size());
//		
//		Message message = messageService.queryMessageByMid("402881e94cb89703014cb8973dbf0002");
//		
//		System.out.println("查询指定id的消息："+message);
//		
//		Map<String,Object> infos =  messageService.queryMessageInfo("402881e94cb89703014cb8973dbf0002");
//		
//		System.out.println("查询指定消息的相关信息："+infos.toString());
//		
//		long count = messageService.queryCountByUid("8abf8b1d4cb80801014cb8083cda0000");
//		
//		System.out.println("查询指定用户发布消息的总数："+count);
//		
//		int type = messageService.queryTypeByMid("402881e94cb89703014cb8973dbf0002");
//		
//		System.out.println("查询指定消息的类型："+type);
		
//		long count = messageService.queryTotalCountByUid("8abf8b1d4cb833eb014cb8341d320002");
//		System.out.println("消息总数："+count);
//		
//		List<Message> messages = messageService.queryByPageAndUid("8abf8b1d4cb833eb014cb8341d320002", 1, 5);
//		
//		System.out.println("单页数据：\n");
//		for(Message m : messages){
//			System.out.println(m.toString());
//			System.out.println(m.getContent());
//		}
//		
		
		return null;
	}

	@Test
	public void Test(){
		String content = "回复张三：:：你真2，哈：哈哈：哈:哈 :）";
		String contents[] = content.split("[:：]",2);
		StringBuffer huifu = new StringBuffer();
		System.out.println(contents[1]);
		
//		for(int i=1;i<contents.length;i++){
//			huifu.append(contents[i]);
//		}
//		System.out.println(huifu.toString());
	}
	
}

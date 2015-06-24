package com.guan.weibo.test;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.guan.weibo.message.domain.Image;
import com.guan.weibo.message.domain.Message;
import com.guan.weibo.message.service.ImageService;
import com.guan.weibo.message.service.MessageService;
import com.guan.weibo.user.domain.User;
import com.guan.weibo.user.service.UserService;
import com.guan.weibo.utils.CommonUtils;

@Controller
@RequestMapping("/test3")
public class ImageControllerTest {
	
	@Resource(name="messageService")
	MessageService messageService;

	@Resource(name="userService")
	UserService userService;
	
	@Resource(name="imageService")
	ImageService imageService;

	@RequestMapping(params = "method=add")
	public ModelAndView publish() {

		User user = userService.queryByUid("8abf8b1d4cb833eb014cb8341d320002");

		if(user!=null){
			System.out.println("用户："+user.getNickname());
		}else{
			System.out.println("查找用户失败！");
			return null;
		}
		
		Message message = new Message();
		String m_id = CommonUtils.uuid();
		message.setM_id(m_id);
		message.setUser(user);
		message.setTitle("（曹某某）第二条测试状态的标题");
		message.setContent("第二条图片测试状态！！！！！！！！！！！！");
		
		Timestamp time = new Timestamp(System.currentTimeMillis());
		message.setTime(time);
		message.setType(2);
		message.setReply_num(0);
		message.setScan_num(0);

		messageService.publishMessage(message);
		
//		Message message2 = messageService.queryMessageByTime(time);
		Message message2 = messageService.queryMessageByMid(m_id);
//		
//		System.out.println("message:"+message2.toString());
		
		Image image = new Image();
		image.setMessage(message);
		image.setUrl("/test3/images/a.jpg");
		image.setDesc("图片一");
		
		imageService.add(image);
		
		Image image1 = new Image();
		image1.setMessage(message);
		image1.setUrl("/test4/images/b.jpg");
		image1.setDesc("图片二");
		
		imageService.add(image1);
		
		Image image2 = new Image();
		image2.setMessage(message);
		image2.setUrl("/test5/images/c.jpg");
		image2.setDesc("图片三");
		
		imageService.add(image2);
		
		System.out.println("发布照片！");

		return null;
	}

	@RequestMapping(params = "method=delete")
	public ModelAndView delete() {
		
		imageService.deleteByImgid("297e79064cbcca7b014cbccaa2e70003");
		
		System.out.println("删除指定id的图片!");
		
		imageService.deleteByMid("297e79064cbcca7b014cbccaa1830000");
		
		System.out.println("删除指定消息id的所有图片!");
		
		return null;
	}

	@RequestMapping(params = "method=update")
	public ModelAndView update() {
		
		Image image = imageService.queryImageByImgid("297e79064cbcc855014cbcc877510001");
		image.setDesc("图片一(修改信息)");
		
		imageService.update(image);
		
		System.out.println("更新指定id的图片信息！");
		
		return null;
	}

	@RequestMapping(params = "method=query")
	public ModelAndView query() {

		List<Image> images = imageService.queryImagesByMid("297e79064cbcc855014cbcc876e00000");
		
		System.out.println("查询指定用户发布的所有图片："+images.size());
		
		Image image = imageService.queryImageByImgid("297e79064cbcc855014cbcc877890002");
		
		System.out.println("查询指定id的消息："+image.toString());
		
		return null;
	}

}

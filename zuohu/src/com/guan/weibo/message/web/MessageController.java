package com.guan.weibo.message.web;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

import com.guan.weibo.message.domain.Message;
import com.guan.weibo.message.service.LabelService;
import com.guan.weibo.message.service.MessageLabelService;
import com.guan.weibo.message.service.MessageService;
import com.guan.weibo.user.domain.User;
import com.guan.weibo.user.service.UserService;
import com.guan.weibo.utils.ImageUtils;
import com.guan.weibo.utils.RichTextProcessor;

@Controller
@RequestMapping("/messages")
public class MessageController {

	@Resource(name = "messageService")
	private MessageService messageService;
	
	@Resource(name = "userService")
	private UserService userService;

	@Resource(name = "labelService")
	private LabelService labelService;

	@Resource(name = "messageLabelService")
	private MessageLabelService messageLabelService;

	// 配置路径
	protected String configPath = "/upload/images/";

	protected String dirTemp = "/upload/images/temp/";

	// Spring配置的映射路径
	protected String mappingPath = "message_imgs/";

	/**
	 * 发布文字
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "method=save1")
	@ResponseBody
	public Object save1(HttpServletRequest request) {
		// 回显
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			String title = request.getParameter("title");
			String content = request.getParameter("content");

			String label = request.getParameter("label");
			String[] labels;
			if (label != null) {
				labels = label.split(",");
			}

			// 将图片转化为路径格式
			content = this.convertContent(request, content);
			// 将html编码
			String encoder_content = HtmlUtils.htmlEscape(content);

			// 获取当前用户
			User user = (User) request.getSession().getAttribute("user");
			// 构建消息对象
			Message message = new Message(user, encoder_content, 1);
			message.setTitle(title);

			// 存储消息
			messageService.publishMessage(message);
			userService.updateUserMessageNum(user.getU_id(), true);
			user.setMessage_num(user.getMessage_num()+1);

			map.put("content", content);
			map.put("state", 1);
		} catch (Exception e) {
			System.out.println("发布失败！");
			map.put("state", 0);
		}
		return map;
	}

	/**
	 * 发布图片
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "method=save2")
	public Object save2(HttpServletRequest request, HttpServletResponse response) {
		// 回显
		Map<String, Object> map = new HashMap<String, Object>();

		String realPath = null;

		// 保存路径
		String savePath = request.getServletContext().getRealPath("/") + configPath;
		System.out.println("savepath:" + savePath);
		// 缓存路径
		String tempPath = request.getServletContext().getRealPath("/") + dirTemp;
		System.out.println("tempPath:" + tempPath);

		System.out.println("开始上传。。。。。");
		// 上传文件
		String result = uploadFiles(request, savePath, tempPath);
		System.out.println("上传完毕。。。。。");

		String text = request.getParameter("editor1");
		System.out.println("text:" + text);

		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.print("<script>alert('上传失败');</script>");
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return map;
	}

	/**
	 * 分享音乐
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "method=save3")
	@ResponseBody
	public Object save3(HttpServletRequest request) {
		// 回显
		Map<String, Object> map = new HashMap<String, Object>();

		String music_url = request.getParameter("music_url");
		if (!"".equals(music_url)) {
			// 获取当前用户
			User user = (User) request.getSession().getAttribute("user");
			if (user != null) {
				String music_id = null;
				if (music_url.contains("music.163.com")) {
					music_id = music_url.split("=")[1];
				}

				if (!"".equals(music_id) && music_id != null) {
					// 构建消息对象
					Message message = new Message(user, music_id, 3);
					String music_title = request.getParameter("music_title");
					message.setTitle(music_title);
					// 存储消息
					try {
						messageService.publishMessage(message);
						userService.updateUserMessageNum(user.getU_id(), true);
						user.setMessage_num(user.getMessage_num()+1);
						map.put("ok", 1);
					} catch (Exception e) {
						System.out.println("发布失败！");
						map.put("ok", 0);
					}
				}

			}
		}

		return map;
	}

	/**
	 * 分享音乐
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "method=yulanMusic")
	@ResponseBody
	public Object yulanMusic(HttpServletRequest request) {
		// 回显
		Map<String, Object> map = new HashMap<String, Object>();

		String music_url = request.getParameter("music_url");
		if (!"".equals(music_url)) {
			String music_id = null;
			if (music_url.contains("music.163.com")) {
				music_id = music_url.split("=")[1];

				if (!"".equals(music_id) && music_id != null) {
					map.put("music163_id", music_id);
					map.put("ok", 1);
				}else{
					map.put("ok", 0);
				}
			}
		}else{
			map.put("ok", 0);
		}
		return map;
	}

	/**
	 * 分享视频
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "method=save4")
	@ResponseBody
	public Object save4(HttpServletRequest request) {
		// 回显
		Map<String, Object> map = new HashMap<String, Object>();

		String video_url = request.getParameter("video_url");
		String video_title = request.getParameter("video_title");
		if (!"".equals(video_url)) {
			// 获取当前用户
			User user = (User) request.getSession().getAttribute("user");
			if (user != null) {
				// 构建消息对象
				Message message = new Message(user, video_url, 4);
				message.setTitle(video_title);

				// 存储消息
				try {
					messageService.publishMessage(message);
					userService.updateUserMessageNum(user.getU_id(), true);
					user.setMessage_num(user.getMessage_num()+1);
					map.put("ok", 1);
				} catch (Exception e) {
					System.out.println("发布失败！");
					map.put("ok", 0);
				}
			}
		}

		return map;
	}

	// 将Base64编码后的图片转化为路径格式
	// 转换富文本
	private String convertContent(HttpServletRequest request, String content) {
		// 提取富文本中的图片
		List<String> listImages = RichTextProcessor.getImgSrc(content);

		// 保存路径
		String savePath = request.getServletContext().getRealPath("/") + configPath;
		
		// 缓存路径
		String tempPath = request.getServletContext().getRealPath("/") + dirTemp;

		List<String> images = new ArrayList<>();
		for (String img : listImages) {
			Matcher matcher = Pattern.compile("data:image\\/(\\w+)").matcher(img);
			String image_suffix = "jpg";
			if (matcher.find()) {
				image_suffix = matcher.group(1);
			}

			String[] str = img.split(",");
			// 构建新的文件名
			SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
			String newFileName = df.format(new Date()) + "_" + new Random().nextInt(1000) + "." + image_suffix;

			// 将Base64数据转化为图片存储
			ImageUtils.decodeBase64ToImage(str[1], savePath, newFileName);
			// 存储Spring配置图片存储路径
			images.add(mappingPath + newFileName);
		}
		for (int j = 0; j < listImages.size(); j++) {
			// 替换Base64编码为图片路径
			content = content.replace(listImages.get(j), images.get(j));
		}
		return content;
	}

	/**
	 * 上传文件
	 * 
	 * @param request
	 * @param response
	 * @return
	 */

	protected String dirName = "file";

	public String uploadFiles(HttpServletRequest request, String savePath, String tempPath) {
		String result = null;

		// SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		// String ymd = sdf.format(new Date());
		// savePath += "/" + ymd + "/";
		// 新建文件目录
		File dirFile = new File(savePath);
		if (!dirFile.exists()) {
			dirFile.mkdirs();
		}

		// tempPath += "/" + ymd + "/";
		// 临时文件目录
		File dirTempFile = new File(tempPath);
		if (!dirTempFile.exists()) {
			dirTempFile.mkdirs();
		}

		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(20 * 1024 * 1024); //
		factory.setRepository(new File(tempPath)); // 设置缓存库目录
		// 创建一个新的文件上传处理程序
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setHeaderEncoding("UTF-8");
		try {
			// 解析获取的文件
			List items = upload.parseRequest(request);
			System.out.println("items = " + items);
			// 处理上传的文件
			Iterator itr = items.iterator();

			while (itr.hasNext()) {
				FileItem item = (FileItem) itr.next();
				// 获取上传文件的参数
				String fileName = item.getName();
				long fileSize = item.getSize();
				if (!item.isFormField()) {
					// 文件后缀名
					String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
					SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
					// 构建新的文件名
					String newFileName = df.format(new Date()) + "_" + new Random().nextInt(1000) + "." + fileExt;

					try {
						File uploadedFile = new File(savePath, newFileName);
						// 获取
						OutputStream os = new FileOutputStream(uploadedFile);
						InputStream is = item.getInputStream();
						byte buf[] = new byte[1024];// 缓存数组
						int length = 0;
						while ((length = is.read(buf)) > 0) {
							os.write(buf, 0, length);
						}
						// 鍏抽棴娴�
						os.flush();
						os.close();
						is.close();
						System.out.println("保存路径" + savePath + "/" + newFileName);

						result = savePath + "/" + newFileName;
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					String filedName = item.getFieldName();
					System.out.println("===============");
					System.out.println("文件名：" + filedName);
					System.out.println("数据类型：" + item.getString());
				}
			}

		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		return result;
	}

}

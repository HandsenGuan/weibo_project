package com.guan.weibo.utils;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;

import org.junit.Test;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class ImageUtils {

	// 获取img标签正则
	private static final String IMGURL_REG = "<img.*src=(.*?)[^>]*?>";

	// 获取src路径的正则
	private static final String IMGSRC_REG = "http:\"?(.*?)(\"|>|\\s+)";

	// 获取src路径的正则
	private static final String IMGSRC = "src=\"?(.*?)(\"|>|\\s+)";

	// 直接获取src
	private static List<String> getSrc(String html) {

		Matcher matcher = Pattern.compile(IMGSRC).matcher(html);
		List<String> listUrl = new ArrayList<String>();
		while (matcher.find()) {
			listUrl.add(matcher.group().substring(5, matcher.group().length() - 1));
		}
		return listUrl;

	}

	// 获取img标签的src
	private static List<String> getImageSrc(String html) {
		// List<String> listImgUrl = new ArrayList<String>();

		List<String> listImgLabel = getImagesLabel(html);

		List<String> listImgUrl = getImageUrl(listImgLabel);

		return listImgUrl;
	}

	// 提取img标签
	private static List<String> getImagesLabel(String html) {
		Matcher matcher = Pattern.compile(IMGURL_REG).matcher(html);
		List<String> listImgUrl = new ArrayList<String>();
		while (matcher.find()) {
			listImgUrl.add(matcher.group());
		}
		return listImgUrl;

	}

	// 提取img标签下的src地址
	private static List<String> getImageUrl(List<String> listImageUrl) {
		List<String> listImgSrc = new ArrayList<String>();
		for (String image : listImageUrl) {
			Matcher matcher = Pattern.compile(IMGSRC).matcher(image);
			while (matcher.find()) {
				listImgSrc.add(matcher.group().substring(5, matcher.group().length() - 1));
			}
		}
		return listImgSrc;
	}


	/**
	 * 将Base64位编码的图片进行解码，并保存到指定目录
	 * 
	 * @param base64
	 *            base64编码的图片信息
	 * @return
	 */
	public static boolean decodeBase64ToImage(String base64, String path, String imgName) {
		if (base64 == null) // 图像数据为空
			return false;
		//判断文件夹是否存在，不存在创建一个
		File file =new File(path); 
		if  (!file .exists()  && !file .isDirectory())      
		{       
		    if(file.mkdirs()) {
		    	return false;
		    } 
		}
		
		BASE64Decoder decoder = new BASE64Decoder();
	    try {
	      FileOutputStream write = new FileOutputStream(new File(path
	          + imgName));
	      byte[] decoderBytes = decoder.decodeBuffer(base64);
	      write.write(decoderBytes);
	      write.close();
	      return true;
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
		return false;
	}

	@Test
	public void testURL() {
		 String html
		 ="<div><img src=\"1234.jpg\" width=\"\" height=\"\" border=\"0\" alt=\"\"></div>";
		
		 System.out.println("---------img标签---------");
		
		 List<String> images = getImagesLabel(html);
		 for(String image : images){
		 System.out.println("image:\n"+image);
		 }
		
		 System.out.println("---------img下的src---------");
		
		 List<String> imagesSrc = getImageUrl(images);
		 for(String image : imagesSrc){
		 System.out.println("src:\n"+image);
		 }
		
		 System.out.println("---------直接---------");
		
		 List<String> images2 = getSrc(html);
		 for(String image : images2){
		 System.out.println("直接地址:\n"+image);
		 }
		
		 System.out.println("---------直接---------");
		
		 List<String> images3 = getImageSrc(html);
		 for(String image : images3){
		 System.out.println("img下src地址:\n"+image);
		 }

	}

}

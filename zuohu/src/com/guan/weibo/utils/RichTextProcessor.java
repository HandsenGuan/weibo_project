package com.guan.weibo.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class RichTextProcessor {

	// img标签正则  
    private static final String IMGURL_REG = "<img.*src=(.*?)[^>]*?>";  
    
    // src路径的正则  
    private static final String IMGSRC = "src=\"?(.*?)(\"|>|\\s+)";  
    
	//获取图片src
	public static List<String> getImgSrc(String html){
		Matcher matcher = Pattern.compile(IMGSRC).matcher(html);  
        List<String> listUrl = new ArrayList<String>();  
        while (matcher.find()) {  
        	listUrl.add(matcher.group().substring(5, matcher.group().length()-1));  
        }  
        return listUrl;
	}
	
	//获取除去图片的文本
	public static String getHtml(String html){
		
		String newHtml = html.replaceAll(IMGURL_REG, "");
				
		return newHtml;
	}
	
	@Test
	public void test(){
		String html ="<div>"+
	"<img src=\"1234.jpg\" width=\"\" height=\"\" border=\"0\" alt=\"\">"+
	"<input type=\"text\" value=\"标题\"/>"+
	"<img src=\"4323.jpg\" width=\"\" height=\"\" border=\"0\" alt=\"\">"+
	"</div>";
		
		List<String> listUrl = getImgSrc(html);
		System.out.println("image_src:\n");
		for(String imageUrl : listUrl){
			System.out.println(imageUrl+"\n");
		}

		System.out.println("---------------------------------");
		
		String newHtml = getHtml(html);
		System.out.println("html:\n"+newHtml);
		
	}
	
	@Test
	public void test2(){
		String music_id_pattern = "song[?]{1}id=(\\d+)";
		
		String url = "http://music.163.com/#/song?id=22842404";
		if(url.contains("music.163.com")){
//			Matcher matcher = Pattern.compile(music_id_pattern).matcher(url);  
//			 while (matcher.find()) {  
//		        
//				 String url_id = matcher.group();
//				 System.out.println("url_id:"+url_id);
//				 
//				 String id = url_id.split("=")[1];
//				 System.out.println("id:"+id);
//		        }  
			 String id = url.split("=")[1];
			 System.out.println("id:"+id);
			
		}
		
		
		
		
	}
	
	
}

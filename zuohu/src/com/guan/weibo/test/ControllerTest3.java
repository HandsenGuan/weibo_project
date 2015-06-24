package com.guan.weibo.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 测试文件上传
 * @author guan
 *
 */

@Controller
@RequestMapping("/uploadFile")
public class ControllerTest3{
	
	@RequestMapping(params="method=message", method=RequestMethod.POST)
	public void  handleRequest( HttpServletRequest request,HttpServletResponse response) {
		 //如果只是上传一个文件，则只需要MultipartFile类型接收文件即可，而且无需显式指定@RequestParam注解  
        //如果想上传多个文件，那么这里就要用MultipartFile[]类型来接收文件，并且还要指定@RequestParam注解  
        //并且上传多个文件时，前台表单中的所有<input type="file"/>的name都应该是myfiles，否则参数里的myfiles无法获取到所有上传的文件  
		 //如果用的是Tomcat服务器，则文件会上传到\\%TOMCAT_HOME%\\webapps\\YourWebProject\\WEB-INF\\upload\\文件夹中 
		
        String realPath = null;  
        
        //保存路径 
        String savePath = request.getServletContext().getRealPath("/") + configPath;  
        System.out.println("savepath:"+savePath);
        // 缓存路径   
        String tempPath = request.getServletContext().getRealPath("/") + dirTemp;  
        System.out.println("tempPath:"+tempPath);
        
        
        System.out.println("开始上传。。。。。");
        //上传文件
        String result = uploadFiles(request, savePath, tempPath);
        System.out.println("上传完毕。。。。。");
        
        PrintWriter out = null;
		try {
			out = response.getWriter();  
			out.print(result);
			out.flush();  
	        out.close(); 
		} catch (IOException e) {
			e.printStackTrace();
		} 
        
	}
	
	
	
	/**
	 * 上传文件
	 * @param request
	 * @param response
	 * @return
	 */
	//配置路径
    protected String configPath = "upload/images";  
  
    protected String dirTemp = "upload/images/temp";  
      
    protected String dirName = "file";  
    
	public String uploadFiles(HttpServletRequest request,String savePath,String tempPath){
		String result = null;
          
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");  
        String ymd = sdf.format(new Date());  
        savePath += "/" + ymd + "/";  
        //新建文件目录
        File dirFile = new File(savePath);  
        if (!dirFile.exists()) {  
            dirFile.mkdirs();  
        }  
          
        tempPath += "/" + ymd + "/";  
        //临时文件目录
        File dirTempFile = new File(tempPath);  
        if (!dirTempFile.exists()) {  
            dirTempFile.mkdirs();  
        }  
          
        DiskFileItemFactory  factory = new DiskFileItemFactory();  
        factory.setSizeThreshold(20 * 1024 * 1024); //
        factory.setRepository(new File(tempPath)); //设置缓存库目录
        // 创建一个新的文件上传处理程序
        ServletFileUpload upload = new ServletFileUpload(factory);  
        upload.setHeaderEncoding("UTF-8");  
        try {  
        	 // 解析获取的文件
            List items = upload.parseRequest(request);  
            System.out.println("items = " + items);  
            // 处理上传的文件	
            Iterator itr = items.iterator();  
              
            while (itr.hasNext())   
            {  
                FileItem item = (FileItem) itr.next();  
             // 获取上传文件的参数
                String fileName = item.getName();  
                long fileSize = item.getSize();  
                if (!item.isFormField()) {
                	//文件后缀名
                    String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();  
                    SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");  
                    //构建新的文件名
                    String newFileName = df.format(new Date()) + "_" + new Random().nextInt(1000) + "." + fileExt; 
                    
                    try{  
                        File uploadedFile = new File(savePath, newFileName);  
                        //获取
                        OutputStream os = new FileOutputStream(uploadedFile);  
                        InputStream is = item.getInputStream();  
                        byte buf[] = new byte[1024];//缓存数组
                        int length = 0;    
                        while( (length = is.read(buf)) > 0 ){    
                            os.write(buf, 0, length);    
                        }    
                        //鍏抽棴娴�   
                        os.flush();  
                        os.close();    
                        is.close();    
                        System.out.println("保存路径"+savePath+"/"+newFileName);  
                        
                        result = savePath+"/"+newFileName;
                    }catch(Exception e){  
                        e.printStackTrace();  
                    }  
                }else {  
                    String filedName = item.getFieldName();  
                    System.out.println("===============");   
                    System.out.println("文件名："+filedName);  
                    System.out.println("数据类型："+item.getString());  
                }             
            }   
              
        } catch (FileUploadException e) {  
            e.printStackTrace();  
        }  
		return result;
	}
	
	
	
}

package com.kc.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class UploadAndDownload {
       @RequestMapping("/upload")
       @ResponseBody
	  public  Map<String, String>  upload(MultipartFile file,HttpServletRequest request) {
    	   //文件存储的根路径
    	   String path=request.getServletContext().getRealPath("/upload");
    	    String realPath =path;
    	    //获取文件全名
    	    String filename = file.getOriginalFilename();
    	    //分割 . 后面的文件类型
    	    String[] names=filename.split("\\.");
    	    //获取随机码
    	    UUID tempNum=UUID.randomUUID();
    	    //拼接新的文件全名
    	    String uploadFileName=tempNum.toString() +System.currentTimeMillis()+"."+names[names.length-1];
    	    //创建文件
    	    File targetFile = new File (realPath,uploadFileName);//目标文件    	    
    	    //开始从源文件拷贝到目标文件    	     
    	    //传图片一步到位
    	    try {
    	    	//文件目录是否存在
    	    	 if(!targetFile.exists()) {
    	    		 //创建文件夹
        	    	 targetFile.getParentFile().mkdir();        	    	
        	      }
    	    	 file.transferTo(targetFile);
    	    	
    	    } catch (IllegalStateException e) {
    	        // TODO Auto-generated catch block
    	        e.printStackTrace();
    	    } catch (IOException e) {
    	        // TODO Auto-generated catch block
    	        e.printStackTrace();
    	    }
    	     
    	    Map<String, String> map = new HashMap<String, String>();
    	    map.put("url",request.getContextPath()+"/upload/"+uploadFileName);//这里应该是项目路径
    	    return map;//将图片地址返回

	  }
}

package com.kc.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kc.model.Url;
import com.kc.service.MenuService;
import com.kc.service.UrlService;
import com.kc.util.JSONResult;
import com.kc.util.Util;

@Controller
@RequestMapping("/url")
public class UrlControl {
	@Autowired
	private  UrlService urlServiceImpl;
	@Autowired
	  MenuService menuServiceImpl;
	@RequestMapping("/index")
    public String index(@RequestParam(defaultValue="0")Integer one,@RequestParam(defaultValue="1",name="number")Integer number,@RequestParam(defaultValue="8",name="pageSize")Integer pageSize,Url entity, Model model,HttpServletRequest request) {		
	   
		 HttpSession session =request.getSession();			
		 //有存在session的情况
		 if( true==Util.isNull(entity) && session.getAttribute("entity")!=null) {
			
			 if(one==1) {
				  session.removeAttribute("entity");
			    }	
			  else {
				  entity=(Url) session.getAttribute("entity");
			   }
		   }
		//有存在带查询条件其session中没有值
		 else  if(false== Util.isNull(entity) && session.getAttribute("entity")==null) {
			 session.setAttribute("entity", entity);
		   }
		//有存在带查询条件其session中有值
		 else  if(false== Util.isNull(entity)&& session.getAttribute("entity")!=null) {
			 session.setAttribute("entity", entity);
		    }		
		 model.addAttribute("sendMenu", menuServiceImpl.selectSecendMenu());
		model.addAttribute("pageInfo",urlServiceImpl.selAndPage(number, pageSize, entity));
    	return "urlManage";
     }
	@RequestMapping("/remove")
	@ResponseBody
	public   JSONResult remove(String id) {
	   return   urlServiceImpl.remove(Long.parseLong(id)); 
		
	}
	
	@GetMapping("/add")
    public String addOrUpdate(Long id,Model  model) {
		if(id!=null) {
			Url url=urlServiceImpl.selById(id);
			model.addAttribute("myurl", url);
		  }
		model.addAttribute("sendMenu", menuServiceImpl.selectSecendMenu());
		return "addUrl";
	}   
	
	    @PostMapping("/add")
	    @ResponseBody
	    public JSONResult  add(@RequestParam(defaultValue="0")Integer one,@RequestBody Url url, HttpServletRequest request){	    	
		       if(one==1) {
                  request.getSession().removeAttribute("entity");
		       }		 
		     //判断是否有ID ,
	    	//1.没有就是新增操作
	    	//2.如果存在，就是更新操作
	    	if(url.getId()!=null) {
	    		return urlServiceImpl.update(url);
	    	}
	    	else { 	
		    	return urlServiceImpl.add(url);
	    	}	 	      	
	     }
	    
	 
 }

package com.kc.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;

import com.kc.model.Job;
import com.kc.service.JobService;
import com.kc.util.JSONResult;
import com.kc.util.Util;

@RequestMapping("/job")
@Controller
public class JobControl {
	 @Autowired
      JobService jobService;
	 @RequestMapping("/index")
	 /**
	  * 实现多条件查询
	  * @param pageNum
	  * @param pageSize
	  * @param entity
	  * @param model
	  * @param request
	  * @return
	  */
	 public String index(@RequestParam(defaultValue="0")Integer one,@RequestParam(defaultValue="1")Integer pageNum,@RequestParam(defaultValue="2")  Integer pageSize,Job entity,Model model,HttpServletRequest request) {
		 HttpSession session =request.getSession();
		 if(one==1) {
			  session.removeAttribute("entity");
		    }		
		 //有存在session的情况
		 if( true==Util.isNull(entity) && session.getAttribute("entity")!=null) {
			 entity=(Job) session.getAttribute("entity");
		   }
		//有存在带查询条件其session中没有值
		 else  if(false== Util.isNull(entity) && session.getAttribute("entity")==null) {
			 session.setAttribute("entity", entity);
		   }
		//有存在带查询条件其session中有值
		 else  if(false== Util.isNull(entity)&& session.getAttribute("entity")!=null) {
			 session.setAttribute("entity", entity);
		    }
		
		 PageInfo<Job> pageInfo=jobService.selectAndPage(pageNum, pageSize, entity);		
		 //返回分页后的数据
		 model.addAttribute("pageInfo", pageInfo);
		 return "jobList";
	 }
 @GetMapping("/add")
   public String add(@RequestParam(defaultValue="0")Long id,Model model) {
		 //判断是否带有ID值，有就为修改信息，返回当前信息
		  if(id>0) {
			Job job=jobService.selectById(id);  
			model.addAttribute("job", job);
		    }
      	return "addJob";
      }
	 
	 @GetMapping("/remove")
	 @ResponseBody
	    public JSONResult remove(Long id,Model model) {
		 JSONResult JsonResult=jobService.delete(id);
	    	return JsonResult;
	       }
	 @PostMapping("/add")
	 @ResponseBody
	    public JSONResult add(Job job,Model model,HttpServletRequest request) {
		     JSONResult result=null;
		     //判断是否带有ID值，有就进行修改操作
			 if(job.getId()!=null) {
				result=jobService.update(job);
			    }
			 //没有就进行插入操作
			 else {
				job.setCreateDate(new Date());
				 result=jobService.add(job);
			    }
	    	return result;
	       }
}

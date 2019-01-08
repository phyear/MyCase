package com.kc.controller;


import java.util.Date;
import java.util.List;

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

import com.github.pagehelper.PageInfo;
import com.kc.model.Dept;
import com.kc.model.Users;
import com.kc.service.DeptService;
import com.kc.util.JSONResult;
import com.kc.util.Util;

@RequestMapping("/dept")
@Controller
public class DeptControl {
	 @Autowired
      DeptService deptService;
	 @RequestMapping("/index")
	 public String index(@RequestParam(defaultValue="0")Integer one,@RequestParam(defaultValue="1",name="number")Integer pageNum,@RequestParam(defaultValue="2")  Integer pageSize,Dept entity,Model model,HttpServletRequest request) {
		 HttpSession session =request.getSession();
			
		 if( true==Util.isNull(entity) && session.getAttribute("entity")!=null) {
			 if(one==1) {
				  session.removeAttribute("entity");
			    }	
			  else {
				 entity=(Dept) session.getAttribute("entity");
			   }
			   
		   }
		 else  if(false== Util.isNull(entity) && session.getAttribute("entity")==null) {
			 session.setAttribute("entity", entity);		 
		   }
		 else  if(false== Util.isNull(entity)&& session.getAttribute("entity")!=null) {
			 session.setAttribute("entity", entity);
		    }
		 PageInfo<Dept> pageInfo=deptService.selectAndPage(pageNum, pageSize, entity);		
		 //返回分页后的数据
		List<Dept> depts=deptService.selAll();
		 model.addAttribute("pageInfo", pageInfo);
		 model.addAttribute("allDept", depts);
		 return "deptManage";
	 }
	 @GetMapping("/add")
    public String add(@RequestParam(defaultValue="0")int id,Model model) {
		 //判断是否带有ID值，有就为修改信息，返回当前信息
		  if(id>0) {
			Dept dept=deptService.selectById(id);  
			model.addAttribute("dept", dept);
		    }
		  List<Dept> depts=deptService.selAll();
		  model.addAttribute("allDept", depts);
    	return "addDept";
       }
	 
	 @GetMapping("/remove")
	 @ResponseBody
	    public JSONResult remove(int id,Model model) {
		 JSONResult JsonResult=deptService.delete(id);
	    	return JsonResult;
	       }
	 @PostMapping("/add")
	
	    public  @ResponseBody JSONResult add(@RequestBody Dept dept,Model model,HttpServletRequest request) {
		     JSONResult result=null;
		     //判断是否带有ID值，有就进行修改操作
		     System.out.println(dept);
			 if(dept.getId()!=null) {
				result=deptService.update(dept);
			    }
			 //没有就进行插入操作
			 else {
				HttpSession session= request.getSession();
				Users users=(Users) session.getAttribute("users");
				dept.setCreater(users.getUsername());
				dept.setCreateDate(new Date());
				 result=deptService.add(dept);
			    }
	    	return result;
	       }
}

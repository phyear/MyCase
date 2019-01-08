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

import com.kc.model.Users;
import com.kc.service.RoleService;
import com.kc.service.UsersService;

import com.kc.util.JSONResult;
import com.kc.util.Util;



@RequestMapping("/users")
@Controller
public class UsersControl {
	 @Autowired
     UsersService usersService;
	 @Autowired
	 RoleService  roleUrlServiceImpl;
	 @RequestMapping("/index")
	 public String index(@RequestParam(defaultValue="0")int one,@RequestParam(defaultValue="1")Integer pageNum,@RequestParam(defaultValue="2")  Integer pageSize,Users entity,Model model,HttpServletRequest request) {
		 HttpSession session =request.getSession();
		 if(one==1) {
			  session.removeAttribute("entity");
		    }		
		 //有存在session的情况
		 if( true==Util.isNull(entity) && session.getAttribute("entity")!=null) {
			 entity=(Users) session.getAttribute("entity");
		   }
		//有存在带查询条件其session中没有值
		 else  if(false== Util.isNull(entity) && session.getAttribute("entity")==null) {
			 session.setAttribute("entity", entity);
		   }
		//有存在带查询条件其session中有值
		 else  if(false== Util.isNull(entity)&& session.getAttribute("entity")!=null) {
			 session.setAttribute("entity", entity);
		    }		 
		 
		 PageInfo<Users> pageInfo=usersService.selectAndPage(pageNum, pageSize, entity);
		 //返回分页后的数据
		 model.addAttribute("pageInfo", pageInfo);
		 return "usersManage";
	 }
	 @GetMapping("/add")
   public String add(@RequestParam(defaultValue="0")Long id,Model model) {
		 //判断是否带有ID值，有就为修改信息，返回当前信息
		  if(id>0) {
			Users users=usersService.selectById(id);  
			model.addAttribute("users", users);
		    }
		  model.addAttribute("roles", roleUrlServiceImpl.selAll());
     	return "addUser";
      }
	 
	 @GetMapping("/remove")
	 public JSONResult remove(Long id,Model model) {
		 JSONResult JsonResult=usersService.remove(id);
	    	return JsonResult;
	       }
	 
	 @GetMapping("/changeStatus")
	 public JSONResult changeStatus(Long id,Integer isActive,Model model) {
		 JSONResult result=usersService.ChangeState(isActive, id);
	    	return result;
	       }
	 @PostMapping("/add")
	 @ResponseBody
	    public JSONResult add(Users users,Model model,HttpServletRequest request) {
		     JSONResult result=null;
		     //判断是否带有ID值，有就进行修改操作
			 if(users.getUserId()!=null) {
				result=usersService.updateInfo(users);
			    }
			 //没有就进行插入操作
			 else {
				HttpSession session= request.getSession();
				Users users1=(Users) session.getAttribute("users");
				users.setCreater(users1.getUsername());
				users.setCreateDate(new Date());
				 result=usersService.add(users);
			    }
	    	return result;
	       }
	 @RequestMapping("/allotRole")
   public int allotRole(String roles,Long uid) {
		 int result= usersService.allotRole(roles, uid);
		 return result;
     }
}

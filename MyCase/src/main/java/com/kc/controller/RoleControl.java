package com.kc.controller;


import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.kc.model.Role;
import com.kc.model.Users;
import com.kc.service.RoleService;
import com.kc.util.JSONResult;
import com.kc.util.Util;


@RequestMapping("/role")
@Controller
public class RoleControl {
	@Autowired
	 RoleService roleServiceImpl;
	@RequestMapping("/index")
    public String index(@RequestParam(defaultValue="0")Integer one,@RequestParam(defaultValue="1",name="number")Integer number,@RequestParam(defaultValue="8",name="pageSize")Integer pageSize,Role entity, Model model,HttpServletRequest request) {		
	   
		 HttpSession session =request.getSession();			
		 //有存在session的情况
		 if( true==Util.isNull(entity) && session.getAttribute("entity")!=null) {
			
			 if(one==1) {
				  session.removeAttribute("entity");
			    }	
			  else {
				  entity=(Role) session.getAttribute("entity");
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
		 
		model.addAttribute("pageInfo",roleServiceImpl.selAndPage(number, pageSize, entity));
    	return "roleManage";
     }	
	@RequestMapping("/remove")
	@ResponseBody
	public   JSONResult remove(String id) {
	   return   roleServiceImpl.remove(Long.parseLong(id)); 
		
	}
	    @PostMapping("/add")
	    @ResponseBody
	    public JSONResult  add(@RequestParam(defaultValue="0")Integer one,@RequestBody Role role, HttpServletRequest request){	    	
	    	//判断是否有ID ,
	    	//1.没有就是新增操作
	    	//2.如果存在，就是更新操作
	    	if(role.getRoleId()!=null) {
	    		return roleServiceImpl.update(role);
	    	}
	    	else {
	    		HttpSession session=request.getSession();
		    	Users users=(Users) session.getAttribute("users");
		    	role.setCreateTime(new Date());	 
		    	role.setCreater(users.getUserId());	
		    	return roleServiceImpl.add(role);
	    	}	    	
	     }
	     @GetMapping("/add")
	    public String addOrUpdate(Long id,Model  model) {
			if(id!=null) {
				Role role=roleServiceImpl.selByRId(id);
				model.addAttribute("role", role);
			  }
			return "addRole";
		}   
	 @GetMapping("/allot")
	 public String allot(Long id,Model model) {
		   Map<String, Object>map= roleServiceImpl.getAllot(id);
		    model.addAttribute("map", map);
		    return "allot"; 
	    }
	 @RequestMapping(value = "/allot", method = RequestMethod.POST)
	 @ResponseBody
	 public JSONResult allote(HttpServletRequest request) {
		    String id=request.getParameter("rid");
		    String mids=request.getParameter("mids");
		    String uids=request.getParameter("uids");
		     Long rid=Long.parseLong(id);
		     JSONResult result=  roleServiceImpl.allotPrivileges(rid, mids, uids);
		     return result; 
	    }
}

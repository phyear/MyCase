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

import com.kc.model.Menu;
import com.kc.model.Users;
import com.kc.service.MenuService;
import com.kc.util.JSONResult;
import com.kc.util.Util;
@Controller
@RequestMapping("/menu")
public class MenuControl {
	@Autowired
	 MenuService menuService;
	@RequestMapping("/index")
   public String index(@RequestParam(defaultValue="0")Integer one,@RequestParam(defaultValue="1",name="number")Integer number,@RequestParam(defaultValue="10",name="pageSize")Integer pageSize,Menu entity, Model model,HttpServletRequest request) {		
		 HttpSession session =request.getSession();
		 if(one==1) {
			  session.removeAttribute("entity");
		    }		
		 //有存在session的情况
		 if( true==Util.isNull(entity) && session.getAttribute("entity")!=null) {
			 entity=(Menu) session.getAttribute("entity");
		   }
		//有存在带查询条件其session中没有值
		 else  if(false== Util.isNull(entity) && session.getAttribute("entity")==null) {
			 session.setAttribute("entity", entity);
		   }
		//有存在带查询条件其session中有值
		 else  if(false== Util.isNull(entity)&& session.getAttribute("entity")!=null) {
			 session.setAttribute("entity", entity);
		    }		
		 model.addAttribute("parentMenu",menuService.seleTree());
		model.addAttribute("pageInfo",menuService.selAndPage(number, pageSize, entity));
   	    return "menuManage";
    }	
	@PostMapping("/remove")
	@ResponseBody
	public   JSONResult  remove(HttpServletRequest request) {
		 String id=request.getParameter("id");		
	     return  menuService.remove(Long.parseLong(id)); 		
	}
	    @PostMapping("/add")
	    @ResponseBody
	  public JSONResult  add(@RequestBody Menu menu, HttpServletRequest request){
	    	System.out.println(menu);
	    	if(menu.getId()!=null) {
	    		return menuService.update(menu);
	    	}
	    	else {
	    		HttpSession session=request.getSession();
		    	Users users=(Users) session.getAttribute("users");
		    	if (menu.getParentid()>0) {
					menu.setUrl(menu.getUrl()+"?one=1");
				    }
		    	menu.setCreateTime(new Date());
		    	menu.setCreater(users.getUserId());
		    	return menuService.add(menu);
	    	}	    	
	     }
	    @GetMapping("/add")
	    public String addOrUpdate(Long id,Model  model) {
			if(id!=null) {
				Menu menu=menuService.seletByMid(id);
				model.addAttribute("menu", menu);
			  }
			List<Menu> list=menuService.seleTree();
			model.addAttribute("allMenu", list);
			return "addMenu";
		}   
	     @RequestMapping("/getTree")	
		 @ResponseBody
		  public   List<Menu> getTree(){
			  List<Menu> menus=menuService.seleTree();
			  System.out.println(menus);
			  return menus;
		  }
  }

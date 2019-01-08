package com.kc.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.kc.service.UsersService;
import com.kc.util.JSONResult;

@Controller
public class LoginControl {
	   @Autowired
	   UsersService us;
      @PostMapping("/login")
      @ResponseBody
	  public  JSONResult  login(String name,String pass,HttpServletRequest request) {
          Map<String, Object> map= us.Login(name, pass);
           HttpSession session=  request.getSession();
        	  if(map.get("users")!=null) {  
        		  session.setAttribute("users", map.get("users"));
        		  session.setAttribute("allPower", map.get("allPower"));
        	    }       
        	  return (JSONResult) map.get("msg");
	  }
      
      @GetMapping("/")
	  public String   hello() {
		  return "login";
	  }
      
      @GetMapping("/exit")
	  public String   exit(HttpServletRequest request) {
    	  HttpSession session=request.getSession();
    	  session.removeAttribute("users");
		  return "redirect:/";
	  }
      @GetMapping("/index")
	  public String   index() {
		  return "index";
	  }
      @GetMapping("/main")
      public String tomain() {
    	  return "main";
      }
}

package com.kc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.kc.model.Case;
import com.kc.service.CaseService;
import com.kc.util.JSONResult;
import com.kc.util.Util;

@RequestMapping("/case")
@Controller
public class CaseControl {
	@Autowired
	CaseService caseService;
	@PostMapping("/add")
	public JSONResult add(Case case1) {
		JSONResult result=null;
		 if(case1.getId()!=null) {
			 result =caseService.add(case1);
		 }
		 else {
			 result=caseService.update(case1);
		 }
		return result;
	 }
	
	public JSONResult remove(Long id) {
		JSONResult result=caseService.remove(id);
				return result;
	}
	
	public String index(@RequestParam(defaultValue="0")Integer one,@RequestParam(defaultValue="1")Integer pageNum,@RequestParam(defaultValue="2")  Integer pageSize,Case entity,Model model,HttpServletRequest request) {
		 
		HttpSession session =request.getSession();
		 if(one==1) {
			  session.removeAttribute("entity");
		    }		
		 if( true==Util.isNull(entity) && session.getAttribute("entity")!=null) {
			 entity=(Case) session.getAttribute("entity");
		   }
		 else  if(false== Util.isNull(entity) && session.getAttribute("entity")==null) {
			 session.setAttribute("entity", entity);		 
		   }
		 else  if(false== Util.isNull(entity)&& session.getAttribute("entity")!=null) {
			 session.setAttribute("entity", entity);
		    }
		PageInfo<Case> pageInfo=caseService.selAndPage(pageNum, pageSize, entity);		
		 model.addAttribute("pageInfo", pageInfo);
		return "caseList";
	 }
}

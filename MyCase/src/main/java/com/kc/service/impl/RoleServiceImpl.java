package com.kc.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kc.mapper.RoleMapper;
import com.kc.mapper.RoleUrlMapper;
import com.kc.model.Menu;
import com.kc.model.Role;
import com.kc.model.Url;
import com.kc.service.MenuService;
import com.kc.service.RoleMenuService;
import com.kc.service.RoleService;
import com.kc.service.RoleUrlService;
import com.kc.service.UrlService;
import com.kc.util.JSONResult;
import com.kc.util.Util;
@Service
public class RoleServiceImpl implements RoleService{
     
	@Resource
	RoleMapper rolemp;
	@Resource
	UrlService urlService;
	@Resource
	MenuService menuService; 
	@Resource
	RoleMenuService roleMenu;
	@Resource
	RoleUrlService roleUrl;
	@Resource
	RoleUrlMapper rmMapper;
	@Override
	public JSONResult add(Role role) {
	     int result=rolemp.insertSelective(role);
	     System.out.println(role.getRoleId());
	     String msg="";
	     int status=0;
	     if(result>0) {
	    	 msg=Util.ADD_SUCCESS;
	    	 status=Util.RESPONSE_SUCCESS;
	        }
	     else{
	    	 status=Util.RESPONSE_FAIL;
	    	 msg=Util.ADD_FAIL;
	     }
		return JSONResult.build(status, "角色"+msg, "");
	}

	@Override
	public JSONResult update(Role role) {
		 int result=rolemp.updateByPrimaryKeySelective(role);
	     String msg="";
	     int status=0;
	     if(result>0) {
	    	 msg=Util.UPDATE_SUCCESS;
	    	 status=Util.RESPONSE_SUCCESS;
	        }
	     else{
	    	 status=Util.RESPONSE_FAIL;
	    	 msg=Util.UPDATE_FAIL;
	     }
		return JSONResult.build(status, "角色"+msg, "");
	}
    @Transactional
	@Override
	public JSONResult remove(Long rid) {
		 int rm=rolemp.deleteByRid(rid);
		 int ru=rmMapper.deleteByRid(rid);
		 int result=rolemp.deleteByPrimaryKey(rid);
	     String msg="";
	     int status=0;
	     if(result>0) {
	    	 msg=Util.DELETE_SUCCESS;
	    	 status=Util.RESPONSE_SUCCESS;
	        }
	     else{
	    	 status=Util.RESPONSE_FAIL;
	    	 msg=Util.DELETE_FAIL;
	     }
		return JSONResult.build(status,"角色"+msg, "");
	}

	@Override
	public PageInfo<Role> selAndPage(int number,int pageSize,Role role) {
		     PageHelper.startPage(number, pageSize);
			List<Role> list=rolemp.selAll(role);
			PageInfo<Role> pageInfo=new PageInfo<Role>(list);
		return pageInfo;
	}
    @Transactional
	@Override
	public JSONResult allotPrivileges(Long rid, String menus, String urls) {						 
		 int a=roleMenu.allotMenu(rid, menus);
		 int b=roleUrl.allotUrl(rid, urls);
		 if(a>0 && b>0) {
			 return JSONResult.ok(Util.UPDATE_SUCCESS);
		 }
		 else {
			
				 return JSONResult.ok(Util.UPDATE_FAIL);
			
		 }
		
	}

	@Override
	public Role selByRId(Long id) {
		
		return rolemp.selectByPrimaryKey(id);
	}

	@Override
	public Map<String, Object> getAllot(Long id) {
		Map<String, Object> map=new HashMap<>();
		List<Url> myList=urlService.selByRid(id);
		List<Menu> list=menuService.seleTree();
		List<Url>  urlList=urlService.selAll();
		for (Url url : urlList) {
			for (Url url1 : myList) {
				 if(url.getId()==url1.getId()) {
					 url.setExits(true);
				   }
			 }
		}
		map.put("rid", id);				
		map.put("menuList", list);
		map.put("urlList", urlList);
		return map;
	}

	@Override
	public List<Role> selAll() {
		// TODO Auto-generated method stub
		return rolemp.selAll(null);
	}
}

package com.kc.service.impl;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kc.mapper.RoleMenuMapper;
import com.kc.model.RoleMenu;
import com.kc.service.RoleMenuService;
import com.kc.util.Util;

@Service
public class RoleMenuServiceImpl implements RoleMenuService {
	 @Resource
     RoleMenuMapper rmm;
	@Override
	public int allotMenu(Long rid, String menus) {
		 int result=0;
		//将现在菜单的id字符串，转换成数组
		 Long[] mids=Util.Conversion_String_ArrayLong(menus,"\\,");
		 //将mids数组转换成list集合
		 List<Long> current=Arrays.asList(mids);
		   try {
		 //获取角色未更新的菜单
		 List<RoleMenu>list= rmm.selByRid(rid);
		 
		  if(list !=null) {
			  //将菜单的mid装换成list集合exist
			  List<Long> exist=new ArrayList<>();
				 for (RoleMenu roleMenu : list) {
					  exist.add(roleMenu.getMenuid());
				    }
				 /**
				  * 比较current和exist的差集
				  * 1.current的差集就是要新增的
				  * 2.exist的差集就是要删去的
				  */
				 Collection<Long> needRemove=Util.remove(exist, current);
				 Collection<Long> needAdd=Util.remove(current, exist);
				 if(needAdd!=null && needRemove!=null) {
				 for (Long mid : needRemove) {
					  for (RoleMenu roleMenu : list) {
						     //删去角色的菜单
						     if(roleMenu.getMenuid()==mid) {
							    result=rmm.deleteByPrimaryKey(roleMenu.getId());
							   }
					         }				  
				   }
				 
				 for (Long  mid : needAdd) {
					 RoleMenu roleMenu=new RoleMenu();
					 roleMenu.setRoleid(rid);
					 roleMenu.setMenuid(mid);
	                 result=rmm.insertSelective(roleMenu);
				    }
				 result=1;
				 }
		    }
		  else {
			  for (Long  mid : mids) {
					 RoleMenu roleMenu=new RoleMenu();
					 roleMenu.setRoleid(rid);
					 roleMenu.setMenuid(mid);
					 result=rmm.insertSelective(roleMenu);
				    }
		  }
		   }
		   catch (Exception e) {
			  result=0;
		     }
		
			return result;
	   }
}

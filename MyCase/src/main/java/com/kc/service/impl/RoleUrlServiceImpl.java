package com.kc.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kc.mapper.RoleUrlMapper;

import com.kc.model.RoleUrl;
import com.kc.service.RoleUrlService;
import com.kc.util.Util;
@Service
public class RoleUrlServiceImpl  implements RoleUrlService{
	@Resource
     RoleUrlMapper rum;
	@Override
	public int allotUrl(Long rid, String urls) {
		 int result=0;
			//将现在链接权限的id字符串，转换成数组
			 Long[] uids=Util.Conversion_String_ArrayLong(urls,"\\,");
			 //将uids数组转换成list集合
			 List<Long> current=Arrays.asList(uids);
			   try {
			 //获取角色未更新的链接权限
			 List<RoleUrl>list= rum.selByRid(rid);
			 
			  if(list !=null) {
				  //将权限的uid装换成list集合exist
				  List<Long> exist=new ArrayList<>();
					 for (RoleUrl roleUrl : list) {
						  exist.add(roleUrl.getUrlid());
					    }
					 /**
					  * 比较current和exist的差集
					  * 1.current的差集就是要新增的
					  * 2.exist的差集就是要删去的
					  */
					 
					 Collection<Long> needRemove=Util.remove(exist, current);
					
					 Collection<Long> needAdd=Util.remove(current, exist);					 
					
					 if(needAdd!=null && needRemove!=null) {
						 for (Long uid : needRemove) {
							  for (RoleUrl roleUrl : list) {
								     //删去角色的权限
								     if(roleUrl.getUrlid()==uid) {
									    result=rum.deleteByPrimaryKey(roleUrl.getId());
									   }
							         }				  
						   }						 
						 for (Long  uid : needAdd) {
							 RoleUrl roleUrl=new RoleUrl();
							 roleUrl.setRoleid(rid);
							 roleUrl.setUrlid(uid);
							 result=rum.insertSelective(roleUrl);
						    }
					 }
					result=1;
			    }
			  else {
				  for (Long  uid : uids) {
					  RoleUrl roleUrl=new RoleUrl();
						 roleUrl.setRoleid(rid);
						 roleUrl.setUrlid(uid);
						 result=rum.insertSelective(roleUrl);
					    }
			  }
			   }
			   catch (Exception e) {
				  result=0;
			     }
			
				return result;
	}

}

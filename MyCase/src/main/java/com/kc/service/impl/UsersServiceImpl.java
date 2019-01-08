package com.kc.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kc.mapper.JobMapper;
import com.kc.mapper.MenuMapper;
import com.kc.mapper.UrlMapper;
import com.kc.mapper.UsersMapper;
import com.kc.mapper.UsersRoleMapper;
import com.kc.model.RoleMenu;
import com.kc.model.Users;
import com.kc.model.UsersRole;
import com.kc.service.UsersService;
import com.kc.util.JSONResult;
import com.kc.util.Util;
@Service
public class UsersServiceImpl implements UsersService {
	@Resource
     UsersMapper  um;
	@Resource
	 MenuMapper menuMapper;
	@Resource
	 UrlMapper urlMapper;
	@Resource
	UsersRoleMapper urMapper;
	@Resource
	 JobMapper JobMapper;
	
	@Override
	public Map<String, Object> Login(String name, String pass) {
		System.out.println(name);
		Map<String, Object> map=new HashMap<>();
		Users users=um.selectByName(name);
		System.out.println(users.toString());
		if(users!=null&& pass.equals(users.getPassword())) {
			if(users.getIsActive()>0) {
				map.put("msg", JSONResult.errorMsg("当前账户被禁用"));
			}
			else {
				users.setMenus(menuMapper.selByUid(users.getUserId()));
				users.setUrls(urlMapper.selByUid(users.getUserId()));
				map.put("users", users);
				map.put("allPower", urlMapper.selectAll());
				map.put("msg", JSONResult.ok("登录成功"));
			}
		  }
		else {
			map.put("msg", JSONResult.errorMsg("用户名或者密码错误"));
		}
		return map;
	}

	@Override
	public JSONResult updateInfo(Users users) {		
		int rs=0,status=0;
		String msg="";
		 try {
	    	 rs= um.updateByPrimaryKeySelective(users);
			  if(rs>0) {
				  status=Util.RESPONSE_SUCCESS;
				  msg=Util.UPDATE_SUCCESS;
			   }
			  else {
				  status=Util.RESPONSE_FAIL;
				  msg=Util.UPDATE_FAIL;
			     }
	    }
		catch (Exception e) {
			status=Util.RESPONSE_THOWS_EXCEPTION;
		     msg=e.getMessage();
		}
		 return JSONResult.build(status, "用户信息"+msg,"");
	}

	@Override
	public JSONResult updatePass(Long uid, String pass, String repass) {
		int rs=0,status=0;
		String msg="";
		  if(pass ==repass) {
			    try {
			    	 rs= um.updatePass(pass, uid);
					  if(rs>0) {
						  status=Util.RESPONSE_SUCCESS;
						  msg=Util.UPDATE_SUCCESS;
					   }
					  else {
						  status=Util.RESPONSE_FAIL;
						  msg=Util.UPDATE_FAIL;
					     }
			    }
				catch (Exception e) {
					status=Util.RESPONSE_THOWS_EXCEPTION;
				     msg=e.getMessage();
				}
		     }
		return JSONResult.build(status,"密码"+msg, "");
	}

	@Override
	public JSONResult add(Users users) {
		int rs=0,status=0;
		String msg="";
		 try {
	    	 rs= um.insertSelective(users);
			  if(rs>0) {
				  status=Util.RESPONSE_SUCCESS;
				  msg=Util.ADD_SUCCESS;
			   }
			  else {
				  status=Util.RESPONSE_FAIL;
				  msg=Util.ADD_FAIL;
			     }
	    }
		catch (Exception e) {
			status=Util.RESPONSE_THOWS_EXCEPTION;
		     msg=e.getMessage();
		}
		 return JSONResult.build(status, "用户"+msg,"");
	}
     @Transactional(rollbackFor = Exception.class)
	@Override
	public JSONResult remove(Long uid) {
		  String msg="";
	      int status=0,result=0;
	      int us=urMapper.deleteByUid(uid);
	      try {
	    	  result=um.deleteByPrimaryKey(uid);
	    	  if(result>0) {
			    	 msg=Util.DELETE_SUCCESS;
			    	 status=Util.RESPONSE_SUCCESS;
			        }
			     else{
			    	 status=Util.RESPONSE_FAIL;
			    	 msg=Util.DELETE_FAIL;
			     }
		     } catch (Exception e) {
		    	TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		        status=Util.RESPONSE_THOWS_EXCEPTION;
			    msg=e.getMessage();
		    }		    
			return JSONResult.build(status, "用户"+msg, "");
	}

	@Override
	public JSONResult ChangeState(int state, Long uid) {
		
       String msg="";
	    int status=0,result=0;
	    result=um.ChangeState(state, uid);
	    try {
	    	  if(result>0) {
			    	 msg=Util.UPDATE_SUCCESS;
			    	 status=Util.RESPONSE_SUCCESS;
			        }
			     else{
			    	 status=Util.RESPONSE_FAIL;
			    	 msg=Util.UPDATE_FAIL;
			     }
		     } catch (Exception e) {
		        status=Util.RESPONSE_THOWS_EXCEPTION;
			    msg=e.getMessage();
		    }		    
			return JSONResult.build(status, "用户状态"+msg, "");
	}

	@Override
	public PageInfo<Users> selectAndPage(Integer pageNum, Integer pageSize, Users users) {
		PageHelper.startPage(pageNum, pageSize);
		List<Users> list=um.selAll(users);
		PageInfo<Users> pageInfo=new PageInfo<>(list);
		return pageInfo;
	}

	@Override
	public Users selectById(Long id) {		
		return um.selectByPrimaryKey(id);
	}
   @Override
   @Transactional
	public int allotRole(String roles,Long uid){
		 int result=0;
		 //将现在角色的id字符串，转换成数组
	     Long[] rids=Util.Conversion_String_ArrayLong(roles,"\\,");
	     //将mids数组转换成list集合
		 List<Long> current=Arrays.asList(rids);
	
				 //获取用户现有的角色
				 List<UsersRole>list= urMapper.selByUid(uid);
				 
				  if(list !=null) {
					  //将角色的ID换成list集合exist
					  List<Long> exist=new ArrayList<>();
						 for (UsersRole userRole : list) {
							  exist.add(userRole.getRid());
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
							  for (UsersRole userRole : list) {
								     //删去角色的菜单
								     if(userRole.getRid()==mid) {
									    result=urMapper.deleteByPrimaryKey(userRole.getRid());
									   }
							         }				  
						   }
						 
						 for (Long  mid : needAdd) {
							 UsersRole usersRole=new UsersRole();
							  usersRole.setRid(mid);
							  usersRole.setUid(uid);
			                  result=urMapper.insertSelective(usersRole);
						    }
						 result=1;
						 }
				    }
				  else {
					  for (Long  mid : rids) {
							  UsersRole usersRole=new UsersRole();
							  usersRole.setRid(mid);
							  usersRole.setUid(uid);
		                     result=urMapper.insertSelective(usersRole);
						    }
				     }
				   				   
				
					return result;
	 }
}

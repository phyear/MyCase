package com.kc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kc.mapper.MenuMapper;

import com.kc.mapper.RoleMenuMapper;
import com.kc.mapper.UrlMapper;
import com.kc.model.Menu;

import com.kc.service.MenuService;
import com.kc.util.JSONResult;
import com.kc.util.Util;
@Service
public class MenuServiceImpl implements MenuService {
    @Resource
	 MenuMapper menuMapper;
    @Resource
  	 RoleMenuMapper roleMenuMapper;
    @Resource
 	 UrlMapper urlMapper;
	@Override
	public JSONResult add(Menu menu) {
		
		 int result=menuMapper.insertSelective(menu);
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
		return JSONResult.build(status, msg, "");
	}

	@Override
	public JSONResult update(Menu menu) {
		 int result=menuMapper.updateByPrimaryKeySelective(menu);
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
		return JSONResult.build(status, msg, "");
	}

	@Override
	@Transactional
	public JSONResult remove(Long mid) {
		System.out.println(mid);
		 String msg="";
	     int status=0;
		 roleMenuMapper.deleteByMid(mid);
		 urlMapper.deleteByMid(mid);
         int result=menuMapper.deleteByPrimaryKey(mid);		         
		 if(result>0) {
		    	 msg=Util.DELETE_SUCCESS;
		    	 status=Util.RESPONSE_SUCCESS;
		        }
		     else{
		    	 status=Util.RESPONSE_FAIL;
		    	 msg=Util.DELETE_FAIL;
		     }

		return JSONResult.build(status, msg, "");
	}

	@Override
	public PageInfo<Menu> selAndPage(int number, int pageSize, Menu menu) {
		 PageHelper.startPage(number, pageSize);
		 List<Menu> list=menuMapper.selAll(menu);
		 PageInfo<Menu> pageInfo=new PageInfo<Menu>(list);
		return pageInfo;
	  }

	@Override
	public Menu seletByMid(Long id) {
		// TODO Auto-generated method stub
		return menuMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Menu> seleTree() {
		// TODO Auto-generated method stub
		return menuMapper.selTree();
	}

	@Override
	public List<Menu> selectSecendMenu() {
		// TODO Auto-generated method stub
		return menuMapper.selSendMenu();
	}

}

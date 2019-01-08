package com.kc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kc.mapper.RoleUrlMapper;
import com.kc.mapper.UrlMapper;
import com.kc.model.Role;
import com.kc.model.Url;
import com.kc.service.RoleUrlService;
import com.kc.service.UrlService;
import com.kc.util.JSONResult;
import com.kc.util.Util;
@Service
public class UrlServiceImpl implements UrlService {
	@Resource
	 UrlMapper urlMapper;
	@Resource
	 RoleUrlMapper   roleUrlMapper;
	@Override
	public JSONResult add(Url url) {
	     int result=urlMapper.insertSelective(url);
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
	public JSONResult update(Url url) {
		 int result=urlMapper.updateByPrimaryKeySelective(url);
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
	public JSONResult remove(Long uid) {
		roleUrlMapper.deleteByUrlId(uid);
		 int result=urlMapper.deleteByPrimaryKey(uid);
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
		return JSONResult.build(status, msg, "");
	}

	@Override
	public PageInfo<Url> selAndPage(int number,int pageSize,Url url) {
		     PageHelper.startPage(number, pageSize);
			 List<Url> list=urlMapper.selAll(url);			
			 PageInfo<Url> pageInfo=new PageInfo<Url>(list);
		 return pageInfo;
	}

	@Override
	public List<Url> selAll() {
		
		return urlMapper.selectAll();
	}

	@Override
	public List<Url> selByRid(Long id) {
	
		return urlMapper.selByRid(id);
	}

	@Override
	public Url selById(Long id) {

		return urlMapper.selectByPrimaryKey(id);
	}


}

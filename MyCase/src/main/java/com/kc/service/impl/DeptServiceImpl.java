package com.kc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kc.mapper.DeptMapper;
import com.kc.model.Dept;
import com.kc.service.DeptService;
import com.kc.util.JSONResult;
import com.kc.util.Util;
@Service
public class DeptServiceImpl implements DeptService {
      @Resource
	  DeptMapper deptMapper;
	
	@Override
	public JSONResult add(Dept dept) {
		  String msg="";
	      int status=0,result=0;
	      try {
	    	  result=deptMapper.insertSelective(dept);
	    	  if(result>0) {
			    	 msg=Util.ADD_SUCCESS;
			    	 status=Util.RESPONSE_SUCCESS;
			        }
			     else{
			    	 status=Util.RESPONSE_FAIL;
			    	 msg=Util.ADD_FAIL;
			     }
		     } catch (Exception e) {
		        status=Util.RESPONSE_THOWS_EXCEPTION;
			    msg=e.getMessage();
		    }		    
			return JSONResult.build(status, msg, "");
	}

	@Override
	public JSONResult delete(int id) {
		  String msg="";
	      int status=0,result=0;
	      try {
	    	  result=deptMapper.deleteByPrimaryKey(id);
	    	  if(result>0) {
			    	 msg=Util.DELETE_SUCCESS;
			    	 status=Util.RESPONSE_SUCCESS;
			        }
			     else{
			    	 status=Util.RESPONSE_FAIL;
			    	 msg=Util.DELETE_FAIL;
			     }
		     } catch (Exception e) {
		        status=Util.RESPONSE_THOWS_EXCEPTION;
			    msg=e.getMessage();
		    }		    
			return JSONResult.build(status, msg, "");
	}

	@Override
	public JSONResult update(Dept dept) {
		  String msg="";
	      int status=0,result=0;
	      try {
	    	  result=deptMapper.updateByPrimaryKeySelective(dept);
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
			return JSONResult.build(status, msg, "");
	}

	@Override
	public PageInfo<Dept> selectAndPage(int pageNum, int pageSize, Dept dept) {
		PageHelper.startPage(pageNum,pageSize);
		 List<Dept> depts=deptMapper.selectAndPage(dept);
		 PageInfo<Dept> pageInfo=new PageInfo<Dept>(depts);
		return pageInfo;
	}

	@Override
	public Dept selectById(int id) {
		
		return deptMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Dept> selAll() {
		return deptMapper.selectAndPage(null);
	}

}

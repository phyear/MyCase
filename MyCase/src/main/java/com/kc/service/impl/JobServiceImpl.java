package com.kc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kc.mapper.JobMapper;
import com.kc.model.Job;
import com.kc.service.JobService;
import com.kc.util.JSONResult;
import com.kc.util.Util;
@Service
public class JobServiceImpl implements JobService {
      @Resource
	  JobMapper  jobMapper;
	
	@Override
	public JSONResult add(Job job) {
		  String msg="";
	      int status=0,result=0;
	      try {
	    	  result=jobMapper.insertSelective(job);
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
	public JSONResult delete(Long id) {
		  String msg="";
	      int status=0,result=0;
	      try {
	    	  result=jobMapper.deleteByPrimaryKey(id);
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
	public JSONResult update(Job job) {
		  String msg="";
	      int status=0,result=0;
	      try {
	    	  result=jobMapper.updateByPrimaryKeySelective(job);
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
	public PageInfo<Job> selectAndPage(int pageNum, int pageSize, Job  job) {
		PageHelper.startPage(pageNum,pageSize);
		 List<Job> depts=jobMapper.selectAndPage(job);
		 PageInfo<Job> pageInfo=new PageInfo<Job>(depts);
		return pageInfo;
	}

	@Override
	public Job selectById(Long id) {
	
		return jobMapper.selById(id);
	}

}

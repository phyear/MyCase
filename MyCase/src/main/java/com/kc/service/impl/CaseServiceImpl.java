package com.kc.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kc.mapper.CaseMapper;
import com.kc.mapper.CaseOperaLogMapper;
import com.kc.model.Case;
import com.kc.model.CaseOperaLog;
import com.kc.service.CaseService;
import com.kc.util.JSONResult;
import com.kc.util.Util;
@Service
public class CaseServiceImpl implements CaseService {
	@Resource
	CaseMapper caseMapper;
	@Resource
	CaseOperaLogMapper caseOperaLogMapper;
	@Transactional
	public JSONResult add(Case case1) {
		 case1.setCreateDate(new Date());
	     int result=caseMapper.insertSelective(case1);
	     String msg="";
	     int status=0;
	     if(result>0) {
	    	 CaseOperaLog caseOperaLog=new  CaseOperaLog();
	    	 caseOperaLog.setCaseId(case1.getId().intValue());
	    	 caseOperaLog.setLogDesc("案件未分配");
	    	 caseOperaLog.setCreateDate(new Date());
	    	 int log=caseOperaLogMapper.insertSelective(caseOperaLog);
	    	 if(log>0) {
	    		 msg=Util.ADD_SUCCESS;
		    	 status=Util.RESPONSE_SUCCESS;
	    	    }	    	 
	        }
	     else{
	    	 status=Util.RESPONSE_FAIL;
	    	 msg=Util.ADD_FAIL;
	     }
		return JSONResult.build(status, "案件"+msg, "");
	}
	@Transactional
	@Override
	public JSONResult update(Case case1) {
		 int result=caseMapper.updateByPrimaryKeySelective(case1);
	     String msg="";
	     int status=0;
	     if(result>0) {
	    	 CaseOperaLog caseOperaLog=new  CaseOperaLog();
	    	 caseOperaLog.setCaseId(case1.getId().intValue());
	    	 caseOperaLog.setLogDesc("案件信息修改");
	    	 caseOperaLog.setCreateDate(new Date());
	    	 caseOperaLogMapper.insertSelective(caseOperaLog);
	    	 msg=Util.UPDATE_SUCCESS;
	    	 status=Util.RESPONSE_SUCCESS;
	        }
	     else{
	    	 status=Util.RESPONSE_FAIL;
	    	 msg=Util.UPDATE_FAIL;
	     }
		return JSONResult.build(status, "案件"+msg, "");
	}
    
	@Override
	@Transactional
	public JSONResult remove(Long cid) {
		 int log=caseOperaLogMapper.deleteByCaseId(cid);
		 int result=caseMapper.deleteByPrimaryKey(cid);
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
		return JSONResult.build(status,"案件"+msg, "");
	}

	@Override
	public PageInfo<Case> selAndPage(int number,int pageSize,Case case1) {
		     PageHelper.startPage(number, pageSize);
			List<Case> list=caseMapper.selAll(case1);
			PageInfo<Case> pageInfo=new PageInfo<Case>(list);
		return pageInfo;
	  }

}

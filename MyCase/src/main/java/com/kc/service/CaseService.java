package com.kc.service;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.kc.model.Case;
import com.kc.util.JSONResult;

@Service
public interface CaseService { 
	
	public JSONResult add(Case case1);
   
    public JSONResult update(Case case1);
    
    public JSONResult remove(Long cid);
    
    public PageInfo<Case> selAndPage(int pageNum,int pageSize,Case aCase);
}

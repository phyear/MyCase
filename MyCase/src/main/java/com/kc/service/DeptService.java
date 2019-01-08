package com.kc.service;
import java.util.List;

import com.github.pagehelper.PageInfo;
import com.kc.model.Dept;
import com.kc.util.JSONResult;

public interface DeptService {
	
	   public JSONResult add(Dept dept);
	   
	   public JSONResult delete(int id);
	   
	   public JSONResult update(Dept dept);
	   
	   public PageInfo<Dept> selectAndPage(int pageNum,int pageSize,Dept dept);

	   public Dept selectById(int id);

	  public List<Dept> selAll();
}

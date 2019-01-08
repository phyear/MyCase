package com.kc.service;

import java.util.List;

import com.github.pagehelper.PageInfo;

import com.kc.model.Url;
import com.kc.util.JSONResult;

public interface UrlService {	
	
     public JSONResult add(Url url);
     
     public JSONResult update(Url url);
     
     public JSONResult remove(Long uid);
     
     public PageInfo<Url> selAndPage(int number,int pageSize,Url url);

	public List<Url> selAll();

	public List<Url> selByRid(Long id);

	public Url selById(Long id);
  }

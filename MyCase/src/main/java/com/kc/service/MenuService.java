package com.kc.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.kc.model.Menu;
import com.kc.util.JSONResult;

public interface MenuService {    
	 public JSONResult add(Menu menu);
     
     public JSONResult update(Menu menu);
     
     public JSONResult remove(Long mid);
     
     public PageInfo<Menu> selAndPage(int number,int pageSize,Menu menu);

	public Menu seletByMid(Long id);

	public List<Menu> seleTree();

	public List<Menu> selectSecendMenu();
}

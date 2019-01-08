package com.kc.service;


import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.kc.model.Role;
import com.kc.util.JSONResult;

public interface RoleService {	
   public JSONResult add(Role role);
   public JSONResult update(Role role);
   public JSONResult remove(Long rid);
   public PageInfo<Role> selAndPage(int number,int pageSize,Role role);
   public JSONResult  allotPrivileges(Long rid,String menus,String urls);
   public Role selByRId(Long id);
  public Map<String, Object> getAllot(Long id);
  public List<Role> selAll();
}

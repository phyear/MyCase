package com.kc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;


import com.kc.model.Menu;
@Mapper
public interface MenuMapper {
	/**
	 * 删除菜单
	 * @param id
	 * @return
	 */
   public  int deleteByPrimaryKey(Long id);
    
   /**
    * 增加菜单
    * @param record
    * @return
    */
   public  int insert(Menu record);
   
   /**
    * 动态添加菜单
    * @param record
    * @return
    */
   public  int insertSelective(Menu record);
   
   
   /**
    * 查询菜单（按主键查询）
    * @param id
    * @return
    */
   public Menu selectByPrimaryKey(Long id);
   
   /**
    * 动态修改菜单信息
    * @param record
    * @return
    */
   public int updateByPrimaryKeySelective(Menu record);
 
   /**
    * 修改菜单
    * @param record
    * @return
    */
   public int updateByPrimaryKey(Menu record);
  
   /**
    * 查询用户的菜单
    * @param uid
    * @return
    */
   public List<Menu> selByUid(Long uid);
   
   
   /**
    * 查询所有的二级菜单
    * @return
    */
   public List<Menu> selSendMenu();

   public List<Menu> selAll(Menu menu);
   
  public List<Menu> selTree();
   
}
package com.kc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;


import com.kc.model.Role;
@Mapper
public interface RoleMapper {
	/**
	 * 删除角色
	 * @param roleId
	 * @return
	 */
    int deleteByPrimaryKey(Long roleId);
    /**
     * 增加角色
     * @param record
     * @return
     */
    int insert(Role record);
    /**
     * 动态增加
     * @param record
     * @return
     */
    int insertSelective(Role record);
    /**
     * 查询角色
     * @param roleId
     * @return
     */
    Role selectByPrimaryKey(Long roleId);
    /**
     * 动态修改
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Role record);
	   /**
	    * 修改
	    * @param record
	    * @return
	    */
    int updateByPrimaryKey(Role record);
    
	List<Role> selAll(Role role);
	 @Delete("delete from role_menu where roleid=#{0}")
	 int deleteByRid(Long rid);
	 

}
package com.kc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.kc.model.RoleMenu;
@Mapper
public interface RoleMenuMapper {
	/**
	 * 删除角色菜单
	 * @param id
	 * @return
	 */
    int deleteByPrimaryKey(Long id);
    /**
     * 角色分配菜单（必须有ID值）
     * @param record
     * @return
     */
    int insert(RoleMenu record);
    /**
     * 角色分配菜单
     * @param record
     * @return
     */
    int insertSelective(RoleMenu record);
     
    RoleMenu selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RoleMenu record);

    int updateByPrimaryKey(RoleMenu record);
    @Select("select * from role_menu where roleid=#{0}")
	List<RoleMenu> selByRid(Long rid);
    
    @Delete("delete from role_menu where menuid=#{0}")
	int deleteByMid(Long mid);
}
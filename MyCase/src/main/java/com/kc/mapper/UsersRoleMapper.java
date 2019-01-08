package com.kc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;


import com.kc.model.UsersRole;
@Mapper
public interface UsersRoleMapper{
    int deleteByPrimaryKey(Long id);
    /**
     * 为用户添加角色
     * @param record
     * @return
     */
    int insert(UsersRole record);
    
    int insertSelective(UsersRole record);
     
    UsersRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UsersRole record);

    int updateByPrimaryKey(UsersRole record);
     /**
      * 删去用户的角色
      * @param uid
      * @return
      */
    @Delete("delete from users_role where uid=#{0}")
	 int deleteByUid(Long uid);

	List<UsersRole> selByUid(Long uid);
}
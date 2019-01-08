package com.kc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.kc.model.RoleUrl;
@Mapper
public interface RoleUrlMapper {
    int deleteByPrimaryKey(Long id);

    int insert(RoleUrl record);

    int insertSelective(RoleUrl record);

    RoleUrl selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RoleUrl record);

    int updateByPrimaryKey(RoleUrl record);
    
    @Select("select * from role_url where roleid=#{0}")
	List<RoleUrl> selByRid(Long rid);
    
    @Delete("delete from role_url where roleid=#{0}")
	int deleteByRid(Long rid);
    
    @Delete("delete from role_url where urlid=#{0}")
	int deleteByUrlId(Long uid); 
}
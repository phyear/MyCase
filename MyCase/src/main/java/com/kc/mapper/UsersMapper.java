package com.kc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import com.kc.model.Users;
@Mapper
public interface UsersMapper {
	/**
	 * 删除用户
	 * @param userId
	 * @return
	 */
    int deleteByPrimaryKey(Long userId);
    /**
     * 插入数据
     * @param record
     * @return
     */
    int insert(Users record);
    /**
     * 动态插入数据
     * @param record
     * @return
     */
    int insertSelective(Users record);
     /**
      * 根据用户id查询用户
      * @param userId
      * @return
      */
    Users selectByPrimaryKey(Long userId);
   /**
    * 动态修改用户
    * @param record
    * @return
    */
    int updateByPrimaryKeySelective(Users record);
    /**
     * 修改用户
     * @param record
     * @return
     */
    int updateByPrimaryKey(Users record);
    
     /**
      * 根据登录名和密码查询
      * @param tel
      * @param pass
      * @return
      */
     Users selectByName(@Param("tel")String tel);
     /**
      * 根据用户ID 查询用户
      * @param uid
      * @return
      */
     Users selecByUid(Long uid);
     
     @Update("update users set password =#{pass} where   user_id=#{uid}")
     int  updatePass(@Param("pass") String pass,@Param("uid")Long uid);
     
     /**
      * 改变用户的状态
      * @param state，uid
      * @return
      */
     @Update("update users set is_active =#{state} where  user_id=#{uid}")
     public int  ChangeState(@Param("state") int state,@Param("uid") Long uid);
	 /**
	  * 动态查询所有用户
	  * @param users
	  * @return
	  */
     List<Users> selAll(Users users);
	
}
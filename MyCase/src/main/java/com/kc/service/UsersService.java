package com.kc.service;

import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.kc.model.Users;
import com.kc.util.JSONResult;




public interface UsersService {
	
	/**
	 * 登录验证
	 * @param name
	 * @param pass
	 * @return
	 */
	public Map<String,Object> Login(String name,String pass);
	
	/**
	 * 修改用户基本信息
	 * @param users
	 * @return
	 */
	public JSONResult updateInfo(Users users);

	/**
	 * 修改密码
	 * @param uid
	 * @param pass
	 * @param repass
	 * @return
	 */
	public JSONResult updatePass(Long uid,String pass,String repass);
	
	/**
	 * 新增用户
	 * @param users
	 * @return
	 */
	public JSONResult  add(Users users);
	
	/**
	 * 删除用户
	 * @param uid
	 * @return
	 */
	
	public JSONResult  remove(Long uid);
	/**
	 * 改变用户的状态
	 * @param state,uid
	 * @return
	 */
	public JSONResult  ChangeState(int state,Long uid);
    /**
     * 显示及分页
     * @param pageNum
     * @param pageSize
     * @param users
     * @return
     */
	public PageInfo<Users> selectAndPage(Integer pageNum, Integer pageSize, Users users);
    /**
     * 根据用户ID查询用户
     * @param id
     * @return
     */
	public Users selectById(Long id);
	
	/**
	 * 为用户分配角色
	 * @param roles
	 * @param uid
	 * @return
	 */
	public int allotRole(String roles,Long uid);
}

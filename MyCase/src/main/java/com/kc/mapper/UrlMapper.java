package com.kc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.kc.model.Url;
@Mapper
public interface UrlMapper {
  public   int deleteByPrimaryKey(Long id);

  public  int insert(Url record);

  public  int insertSelective(Url record);

  public   Url selectByPrimaryKey(Long id);

  public  int updateByPrimaryKeySelective(Url record);

  public  int updateByPrimaryKey(Url record);
    
  public  List<Url> selByMid(Long mid);
    /**
     * 动态查询
     * @param url
     * @return
     */
  public	List<Url> selAll(Url url);
	/**
	 * 根据菜单ID删除权限
	 * @param mid
	 * @return
	 */
	@Delete("delete from url where mid=#{0}")
	public	int deleteByMid(Long mid);
    @Select("select * from url")
	public List<Url> selectAll();

	public List<Url> selByUid(Long userId);

	public List<Url> selByRid(Long id);
}
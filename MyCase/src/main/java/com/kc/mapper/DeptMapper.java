package com.kc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kc.model.Dept;
@Mapper
public interface DeptMapper {
	public   int deleteByPrimaryKey(Integer id);

	public  int insert(Dept record);

    int insertSelective(Dept record);

    Dept selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Dept record);

    int updateByPrimaryKey(Dept record);
    
    public  Dept  selById(Long id);

	public List<Dept> selectAndPage(Dept dept);
}
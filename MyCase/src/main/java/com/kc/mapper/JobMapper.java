package com.kc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kc.model.Job;
@Mapper
public interface JobMapper {
	public  int deleteByPrimaryKey(Long id);

	public  int insert(Job record);

	public int insertSelective(Job record);

	public Job selectByPrimaryKey(Long id);

	public  int updateByPrimaryKeySelective(Job record);

	public  int updateByPrimaryKey(Job record);
	
	public Job selById(Long id);
	
	public List<Job> selAll(Job job);

	public List<Job> selectAndPage(Job job);
}
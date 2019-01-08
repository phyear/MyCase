package com.kc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kc.model.Case;
@Mapper
public interface CaseMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Case record);

    int insertSelective(Case record);

    Case selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Case record);

    int updateByPrimaryKey(Case record);

	List<Case> selAll(Case case1);
}
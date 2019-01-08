package com.kc.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.kc.model.CaseStatus;
@Mapper
public interface CaseStatusMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CaseStatus record);

    int insertSelective(CaseStatus record);

    CaseStatus selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CaseStatus record);

    int updateByPrimaryKey(CaseStatus record);
}
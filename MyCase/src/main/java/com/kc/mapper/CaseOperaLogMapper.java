package com.kc.mapper;



import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import com.kc.model.CaseOperaLog;
@Mapper
public interface CaseOperaLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CaseOperaLog record);

    int insertSelective(CaseOperaLog record);

    CaseOperaLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CaseOperaLog record);

    int updateByPrimaryKey(CaseOperaLog record);
    
    List<CaseOperaLog> selByCaseId(Integer caseId);
    @Delete("delete from case_opera_log where case_id =#{0}")
	int deleteByCaseId(Long cid);
}
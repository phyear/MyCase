package com.kc.service;
import com.github.pagehelper.PageInfo;
import com.kc.model.Job;
import com.kc.util.JSONResult;

public interface JobService {
	   /**
	    * 增加岗位
	    * @param job
	    * @return
	    */
	   public JSONResult add(Job job);
	   /**
	    * 删除
	    * @param id
	    * @return
	    */
	   public JSONResult delete(Long id);
	   /**
	    * 修改岗位
	    * @param job
	    * @return
	    */
	   public JSONResult update(Job job);
	   /**
	    * 查询并分页
	    * @param pageNum
	    * @param pageSize
	    * @param job
	    * @return
	    */
	   public PageInfo<Job> selectAndPage(int pageNum,int pageSize,Job job);
       /**
        * 根据ID查询岗位
        * @param id
        * @return
        */
	   public Job selectById(Long id);
}

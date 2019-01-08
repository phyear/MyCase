package com.kc.model;

import java.util.Date;

public class Dept {
    @Override
	public String toString() {
		return "Dept [id=" + id + ", createDate=" + createDate + ", creater=" + creater + ", name=" + name + ", count="
				+ count + ", preDept=" + preDept + ", parentDept=" + parentDept + "]";
	}

	private Integer id;//

    private Date createDate;//创建时间

    private String creater;//创建者

    private String name;//部门名称

    private Integer count;//部门人数

    private Integer preDept;//父级部门id 
    
    private Dept parentDept;//父级部门

   

	
	public Integer getPreDept() {
		return preDept;
	}

	public void setPreDept(Integer preDept) {
		this.preDept = preDept;
	}

	public Dept getParentDept() {
		return parentDept;
	}

	public void setParentDept(Dept parentDept) {
		this.parentDept = parentDept;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater == null ? null : creater.trim();
    }

    public String getName() {
        return name;
      }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

   
}
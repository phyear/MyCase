package com.kc.model;

import java.util.Date;
import java.util.List;

public class Users {
    private Long userId; //用户id

    private String tel;//电话号码

    private String username;//用户名
 
    private String password;//密码

    private String email;//邮箱

    private Date createDate;//创建时间
    
    private String creater;//创建者
    
    private Long jobId;//职位Id
    
    private Job job;//工作
   
    private Long deptId;//部门编号
   
    private Dept dept;//所属部门

    private Integer isActive;//是否禁用

    private List<Menu> menus;//用户所有的菜单
    
    private List<Url>  urls;//所有的链接    
    
	public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

	public List<Url> getUrls() {
		return urls;
	}

	public void setUrls(List<Url> urls) {
		this.urls = urls;
	}

	public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
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

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}
	
	@Override
	public String toString() {
		return "Users [userId=" + userId + ", tel=" + tel + ", username=" + username + ", password=" + password
				+ ", job=" + job + ", email=" + email + ", createDate=" + createDate + ", creater=" + creater
				+ ", jobId=" + jobId + ", deptId=" + deptId + ", dept=" + dept + ", isActive=" + isActive + ", menus="
				+ menus + ", urls=" + urls + "]";
	}

	public Long getJobId() {
		return jobId;
	}

	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}

	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

}
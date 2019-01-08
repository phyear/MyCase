package com.kc.model;

import java.util.Date;

public class Role {
    private Long roleId;//角色编号
    
    private String roleName;//角色名

    private String description;//描述

    private Long creater;//创建者编号
    
    private Users createrInfo;//创建者信息

    private Date createTime;//创建时间

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Long getCreater() {
        return creater;
    }

    public void setCreater(Long creater) {
        this.creater = creater;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

	public Users getCreaterInfo() {
		return createrInfo;
	}
	public void setCreaterInfo(Users createrInfo) {
		this.createrInfo = createrInfo;
	}
	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName + ", description=" + description + ", creater="
				+ creater + ", createrInfo=" + createrInfo + ", createTime=" + createTime + "]";
	}

	

	
}
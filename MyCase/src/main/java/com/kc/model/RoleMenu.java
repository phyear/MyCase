package com.kc.model;

public class RoleMenu {
    private Long id;

    private Long roleid;

    @Override
	public String toString() {
		return "RoleMenu [id=" + id + ", roleid=" + roleid + ", menuid=" + menuid + "]";
	}

	private Long menuid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoleid() {
        return roleid;
    }

    public void setRoleid(Long roleid) {
        this.roleid = roleid;
    }

    public Long getMenuid() {
        return menuid;
    }

    public void setMenuid(Long menuid) {
        this.menuid = menuid;
    }
}
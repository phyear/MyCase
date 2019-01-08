package com.kc.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
public class Menu {	
	
    private Long id;//菜单ID
    @JsonProperty("name")
    private String menuname;//菜单名字
    private String description;//菜单描述
    private String url;//菜单链接  
    private Long parentid;//父级菜单的ID
    @JsonProperty("childrens")
    private List<Menu> childrenMenu;//子菜单  
    private Menu parentMenu;//父级菜单    
    private Long  creater;//创建者Id  
    private Users creaters;//创建者
    private Date createTime;//创建时间
    private String icon;//菜单样式
    
    private  List<Url> urls;//菜单所拥有的权限
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMenuname() {
		return menuname;
	}
	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Long getParentid() {
		return parentid;
	}
	public void setParentid(Long parentid) {
		this.parentid = parentid;
	}
	public List<Menu> getChildrenMenu() {
		return childrenMenu;
	}
	public void setChildrenMenu(List<Menu> childrenMenu) {
		this.childrenMenu = childrenMenu;
	}
	public Menu getParentMenu() {
		return parentMenu;
	}
	public void setParentMenu(Menu parentMenu) {
		this.parentMenu = parentMenu;
	}
	public Long getCreater() {
		return creater;
	}
	public void setCreater(Long creater) {
		this.creater = creater;
	}
	public Users getCreaters() {
		return creaters;
	}
	public void setCreaters(Users creaters) {
		this.creaters = creaters;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public List<Url> getUrls() {
		return urls;
	}
	public void setUrls(List<Url> urls) {
		this.urls = urls;
	}
	@Override
	public String toString() {
		return "Menu [id=" + id + ", menuname=" + menuname + ", description=" + description + ", url=" + url
				+ ", parentid=" + parentid + ", childrenMenu=" + childrenMenu + ", parentMenu=" + parentMenu
				+ ", creater=" + creater + ", creaters=" + creaters + ", createTime=" + createTime + ", icon=" + icon
				+ ", urls=" + urls + "]";
	}
   
}
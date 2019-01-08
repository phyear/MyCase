package com.kc.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Url {
    private Long id;//url编号
    @JsonProperty("name")
    private String urlname;//url名字
    private String url;//链接
    @JsonProperty("parentid")
    private Long mid;//所属菜单
    private Menu menu;//所属菜单的信息
    private boolean exits=false;//判断角色是否存在 此权限
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUrlname() {
		return urlname;
	}
	public void setUrlname(String urlname) {
		this.urlname = urlname;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Long getMid() {
		return mid;
	}
	public void setMid(Long mid) {
		this.mid = mid;
	}
	public Menu getMenu() {
		return menu;
	}
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	public boolean isExits() {
		return exits;
	}
	public void setExits(boolean exits) {
		this.exits = exits;
	}
	@Override
	public String toString() {
		return "Url [id=" + id + ", urlname=" + urlname + ", url=" + url + ", mid=" + mid + ", menu=" + menu
				+ ", exits=" + exits + "]";
	}
   
    
}
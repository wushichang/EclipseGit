package com.yidu.bean;

import org.springframework.stereotype.Component;

@Component
public class MenuInfo {
	private String menuId;//����
	private String title;//�˵�����
	private int state;//״̬
	private String url;//����url
	private String pid;//�ϼ��˵�id
	private String iconCls;//�˵���ͼ��
	public String getMenuId() {
		return menuId;
	}
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getIconCls() {
		return iconCls;
	}
	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}
	public MenuInfo() {
		super();
	}
	
}

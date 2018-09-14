package com.yidu.bean;

public class UserBean {
	private String userName;//ÕËºÅ
	private String userPass;//ÃÜÂë
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	public UserBean() {
		super();
	}
	public UserBean(String userName, String userPass) {
		super();
		this.userName = userName;
		this.userPass = userPass;
	}
	
	
}

package com.bsol.hss.bean;

public class User {

	private Integer userid;
	private String username;
	private String password;
	private Integer management;
	public Integer getUserid() {
		return userid;
	}
	public User() {
		this.management=0;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getManagement() {
		return management;
	}
	public void setManagement(Integer management) {
		this.management = management;
	}
	
	
	
}

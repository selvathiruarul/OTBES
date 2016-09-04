package com.otbes.vo;

/**
 * @author 588438
 * @version 1.0
 * @Class BTHMServlet
 * @Creation 07-12-2012 @ History
 */

public class BTHMUserVO {
	private int userId; 	// Id of the user
	private String pwd; 	//password of the user
	private String role;	//role of the user(administrator,employee)
	private int expiry; 	//Expiry Dates
	private String Theme;
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getExpiry() {
		return expiry;
	}

	public void setExpiry(int expiry) {
		this.expiry = expiry;
	}

	public String getTheme() {
		return Theme;
	}

	public void setTheme(String theme) {
		Theme = theme;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getuserId() {
		return userId;
	}

	public void setuserId(int userId) {
		this.userId = userId;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

}

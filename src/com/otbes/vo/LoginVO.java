package com.otbes.vo;

/**
 * The descriptive text that explaining the purpose and use of the class.
 * 
 * @author T.Gomathi Priya ,Rina
 * @version 1.0
 * @Class name LoginVO
 * @Creation Date 8/12/2012 @ History
 */

public class LoginVO {
	public Integer getUserName() {
		return userName;
	}

	public void setUserName(Integer userName) {
		this.userName = userName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private Integer userName;
	private String role;
	private String password;

}

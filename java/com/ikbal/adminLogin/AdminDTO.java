package com.ikbal.adminLogin;

import java.io.Serializable;

import javax.persistence.Entity;

public class AdminDTO implements Serializable {
	private String userid;
	private String password;

	public AdminDTO() {
		System.out.println(this.getClass().getSimpleName() + "object created");
	}
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}

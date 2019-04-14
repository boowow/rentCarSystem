package com.hwua.entity;

public class User {
	private long u_id;
	private String u_name;
	private String u_password;
	
	public User() {
		super();
	}

	public User(long uId, String uName, String uPassword) {
		super();
		u_id = uId;
		u_name = uName;
		u_password = uPassword;
	}

	public long getU_id() {
		return u_id;
	}

	public void setU_id(long uId) {
		u_id = uId;
	}

	public String getU_name() {
		return u_name;
	}

	public void setU_name(String uName) {
		u_name = uName;
	}

	public String getU_password() {
		return u_password;
	}

	public void setU_password(String uPassword) {
		u_password = uPassword;
	}

	@Override
	public String toString() {
		return "User [u_id=" + u_id + ", u_name=" + u_name + ", u_password="
				+ u_password + "]";
	}
}

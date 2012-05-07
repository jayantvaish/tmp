package com.intalio.bpms.taskmanager.vo;

public class AccessControlTypeVO {
	private String user;
	private String role;
	
	public AccessControlTypeVO() {
		super();
	}

	public AccessControlTypeVO(String user, String role) {
		super();
		this.user = user;
		this.role = role;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "ClaimActionVO [user=" + user + ", role=" + role + "]";
	}

}

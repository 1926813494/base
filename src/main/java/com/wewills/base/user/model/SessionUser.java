package com.wewills.base.user.model;

public class SessionUser {

	private String id;
	
	private String usercode;
	
	private String username;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsercode() {
		return usercode;
	}

	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "SessionUser [id=" + id + ", usercode=" + usercode + ", username=" + username + "]";
	}
}

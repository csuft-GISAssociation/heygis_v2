package com.heygis.pojo;

import java.io.Serializable;

public class User implements Serializable {

	private String account;
	private String password;
	private int uid;
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	@Override
	public String toString() {
		return "User [account=" + account + ", password=" + password + ", uid=" + uid + "]";
	}
	
	
}

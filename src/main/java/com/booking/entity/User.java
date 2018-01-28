package com.booking.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long Id;
	
	private String Name;
	
	private String email;
	
	private Timestamp regDate;
	
	private Timestamp lastLogin;
	
	private boolean isRegistered;
	
	private String password;

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Timestamp getRegDate() {
		return regDate;
	}

	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}

	public Timestamp getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Timestamp lastLogin) {
		this.lastLogin = lastLogin;
	}

	public boolean isRegistered() {
		return isRegistered;
	}

	public void setRegistered(boolean isRegistered) {
		this.isRegistered = isRegistered;
	}
	
	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
   
	
	@Override
	public String toString() {
		return "User [Id=" + Id + ", Name=" + Name + ", email=" + email + ", regDate=" + regDate + ", lastLogin="
				+ lastLogin + ", isRegistered=" + isRegistered + ", password=" + password + "]";
	}
	
	
	

}

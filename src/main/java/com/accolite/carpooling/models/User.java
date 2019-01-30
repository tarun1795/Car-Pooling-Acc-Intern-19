package com.accolite.carpooling.models;

public class User {

	private int userId;
	private String userName;
	private String password;
	private String email;
	
	public User() {
		
		super();
		
	}
	public User(int userId, String userName, String password, String email) {
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.email = email;
	}
	//ToDo add wallet to user
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String i) {
		this.email = i;
	}
	
	
	public String toString() {
		return "User [userId=" + userId + ", userName =  " + userName + "email = ] "+ email + "";
	}
	
}
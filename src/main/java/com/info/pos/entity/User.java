package com.info.pos.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	static int i = 1;
	
	@Id
	@Column(name = "user_id")
	private String userId = "user" + i++;;
	
	@Column(name = "user_name")
	private String userName;
	
	@Column(name = "user_phone")
	private String userPhone;
	
	@Column(name = "user_role")
	private String userRole;
	
	public User() {

	}

	public User(String userId, String userName, String userPhone, String userRole) {
		
//		this.userId = "user" + i++;this.User(userName, userPhone, userRole);
	}

	public User(String userName, String userPhone, String userRole) {
//		this.userId = "user" + i++;
		this.userName = userName;
		this.userPhone = userPhone;
		this.userRole = userRole;
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	
}

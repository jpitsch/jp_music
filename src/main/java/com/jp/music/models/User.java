package com.jp.music.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="ng_users")
public class User {
	
	@Id
	@Column(name="NG_USERS_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer userId;
	
	@Column(name="USERNAME")
	@NotNull @Size(min=2, max=20)
	private String userName;
	
	@Column(name="PASSWORD")
	@NotNull @Size(min=2, max=20)
	private String userPass;
	
//	private String roles;
	
	public User() {
	}
	
//	public User(String userName, String userPass, String roles) {
//		 this.userName = userName;
//	     this.userPass = userPass;
//	     this.roles = roles;
//	}

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

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	
//	public String getRoles() {
//		return roles;
//	}
//
//	public void setRoles(String roles) {
//		this.roles = roles;
//	}
}

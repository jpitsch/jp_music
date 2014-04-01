package com.jp.music.user.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.jp.music.common.model.BaseEntity;
import com.jp.music.common.model.Role;
import com.jp.music.common.model.SocialMediaType;

@Entity
@Table(name="users")
public class User extends BaseEntity {
	
	@Id
	@Column(name="USERS_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer userId;
	
	@Column(name="USERNAME")
	@NotNull @Size(min=2, max=20)
	private String username;
	
	@Column(name="PASSWORD")
	@NotNull @Size(min=2, max=20)
	private String password;
	
	@Column(name="ROLE")
	public Role role;
	
	@Column(name="SOCIAL_MEDIA_LOGIN")
	public SocialMediaType socialMediaLogin;
	
	public User() {
		
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public SocialMediaType getSocialMediaLogin() {
		return socialMediaLogin;
	}

	public void setSocialMediaLogin(SocialMediaType socialMediaLogin) {
		this.socialMediaLogin = socialMediaLogin;
	}
}

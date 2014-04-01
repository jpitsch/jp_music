package com.jp.music.user.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.jp.music.common.model.Role;
import com.jp.music.common.model.SocialMediaType;

@Entity
@Table(name="users")
public class User implements UserDetails {
	
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

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}
	
}

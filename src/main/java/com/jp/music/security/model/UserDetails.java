package com.jp.music.security.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.social.security.SocialUser;

import com.jp.music.common.model.Role;
import com.jp.music.common.model.SocialMediaType;

public class UserDetails extends SocialUser {
	
	private Long id;
	private String username;
	
	private Role role;
	private SocialMediaType socialMediaLogin;

	public UserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}
	
	public static Builder getBuilder() {
		return new Builder();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public static class Builder {
		private Long id;
		private String username;
		private String password;
		
		private Role role;
		private SocialMediaType socialMediaLogin;
		
		private Set<GrantedAuthority> authorities;
		
		 public Builder() {
	            this.authorities = new HashSet<>();
	        }

	        public Builder username(String username) {
	            this.username = username;
	            return this;
	        }

	        public Builder id(Long id) {
	            this.id = id;
	            return this;
	        }

	        public Builder password(String password) {
	            if (password == null) {
	                password = "SocialUser";
	            }

	            this.password = password;
	            return this;
	        }

	        public Builder role(Role role) {
	            this.role = role;

	            SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.toString());
	            this.authorities.add(authority);

	            return this;
	        }

	        public Builder socialMediaLogin(SocialMediaType socialMediaLogin) {
	            this.socialMediaLogin = socialMediaLogin;
	            return this;
	        }

	        public UserDetails build() {
	            UserDetails user = new UserDetails(username, password, authorities);

	            user.id = id;
	            user.role = role;
	            user.socialMediaLogin = socialMediaLogin;

	            return user;
	        }
	}
}

package com.jp.music.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.jp.music.security.model.UserDetails;
import com.jp.music.user.model.User;
import com.jp.music.user.service.UserService;

public class LoginUserDetailsService implements UserDetailsService {

	@Autowired
	private UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userService.findUserByName(username);
		
		UserDetails userDetails = UserDetails.getBuilder()
											 .id(Long.valueOf(user.getUserId()))
											 .username(user.getUsername())
											 .password(user.getPassword())
											 .role(user.getRole())
											 .socialMediaLogin(user.getSocialMediaLogin())
											 .build();
		return userDetails;
	}

}

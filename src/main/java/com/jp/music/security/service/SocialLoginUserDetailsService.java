package com.jp.music.security.service;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;

public class SocialLoginUserDetailsService implements SocialUserDetailsService {
	
	private UserDetailsService loginUserDetailsService;
	
	public SocialLoginUserDetailsService(UserDetailsService loginUserDetailsService) {
		this.loginUserDetailsService = loginUserDetailsService;
	}

	@Override
	public SocialUserDetails loadUserByUserId(String username) throws UsernameNotFoundException, DataAccessException {

		SocialUserDetails socialUserDetails = (SocialUserDetails) loginUserDetailsService.loadUserByUsername(username);
				
		return socialUserDetails;
	}

}

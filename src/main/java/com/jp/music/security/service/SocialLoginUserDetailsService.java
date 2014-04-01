package com.jp.music.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;

public class SocialLoginUserDetailsService implements SocialUserDetailsService {
	
	@Autowired
	LoginUserDetailsService loginUserDetailsService;

	@Override
	public SocialUserDetails loadUserByUserId(String username) throws UsernameNotFoundException, DataAccessException {

		SocialUserDetails socialUserDetails = (SocialUserDetails) loginUserDetailsService.loadUserByUsername(username);
				
		return socialUserDetails;
	}

}

package com.jp.music.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.social.security.SocialUserDetailsService;

import com.jp.music.security.service.LoginUserDetailsService;
import com.jp.music.security.service.SocialLoginUserDetailsService;
import com.jp.music.user.service.UserService;

@Configuration
@EnableWebMvcSecurity
public class SpringSecurityContext extends WebSecurityConfigurerAdapter {
	
	@Autowired
	UserService userService;
	
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .userDetailsService(userDetailsService());
    }

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	    http
	        .authorizeRequests()
	            .anyRequest().authenticated()
	            .and()
	        .formLogin()
	            .and()
	        .httpBasic();
//		http.csrf().disable();
	}
	
	@Bean
	public SocialUserDetailsService socialUserDetailsService() {
		return new SocialLoginUserDetailsService(userDetailsService());
	}

	@Bean
	public UserDetailsService userDetailsService() {
		return new LoginUserDetailsService(userService);
	}
}

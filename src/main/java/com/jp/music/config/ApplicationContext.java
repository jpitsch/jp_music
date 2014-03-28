package com.jp.music.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.jp.music.validator.FileValidator;

@Configuration
@ComponentScan({"com.jp.music.service"})
public class ApplicationContext {

//	<beans:bean id="fileValidator" class="com.jp.music.validator.FileValidator" />
//	
//	<beans:bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver" />
	
	@Bean
	public FileValidator fileValidator() {
		FileValidator fileValidator = new FileValidator();
		
		return fileValidator;
	}
	
	@Bean
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		
		return multipartResolver;
	}
}

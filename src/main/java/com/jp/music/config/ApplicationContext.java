package com.jp.music.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.jp.music.validator.FileValidator;

@Configuration
@ComponentScan({"com.jp"})
@ImportResource(value = { "/WEB-INF/spring/spring-security.xml" })
public class ApplicationContext {

//	<beans:bean id="fileValidator" class="com.jp.music.validator.FileValidator" />
//	
//	<beans:bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver" />
//	
//	  <filter>
//	    <filter-name>springSecurityFilterChain</filter-name>
//	    <filter-class>org.springframework.web.filter.DelegatingFilterProxy</filter-class>
//	  </filter>
//	  <filter-mapping>
//	    <filter-name>springSecurityFilterChain</filter-name>
//	    <url-pattern>/*</url-pattern>
//	  </filter-mapping>
	
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
	
	@Bean
    public static PropertySourcesPlaceholderConfigurer properties() {
        final PropertySourcesPlaceholderConfigurer pspc = new PropertySourcesPlaceholderConfigurer();
        return pspc;
    }
}

package com.jp.music.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

@Configuration
@PropertySource("classpath:database.properties")
public class PersistanceContext {
	
	@Value("${jdbc.driver}") String driverClass;
	@Value("${jdbc.url}") String jdbcUrl;
	@Value("${jdbc.username}") String username; 
	@Value("${jdbc.password}") String password;
	
//	   <bean id="propertyConfigurer" class="org.springframework.beans.factory.config.PropertyPlaceholderConfigurer">
//       <property name="locations">
//           <list>
//               <value>/resources/database.properties</value>
//           </list>
//       </property>
//   </bean>
//
//   <bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
//       <property name="driverClassName" value="${jdbc.driver}" />
//       <property name="url" value="${jdbc.url}" />
//       <property name="username" value="${jdbc.user}" />
//       <property name="password" value="${jdbc.password}" />
//   </bean>
//
//   <bean id="sessionFactory" class="org.springframework.orm.hibernate4.LocalSessionFactoryBean">
//       <property name="dataSource" ref="dataSource"/>
//       <property name="packagesToScan" value="com.jp.music.models" />
//       <property name="hibernateProperties">
//           <props>
//               <prop key="hibernate.dialect">org.hibernate.dialect.MySQLDialect</prop>
//               <prop key="hibernate.show_sql">true</prop>
//               <prop key="hibernate.current_session_context_class">thread</prop>
//           </props>
//       </property>
//   </bean>
//
//   <tx:annotation-driven transaction-manager="transactionManager"/>
//
//   <bean id="transactionManager" class="org.springframework.orm.hibernate4.HibernateTransactionManager">
//       <property name="sessionFactory" ref="sessionFactory"/>
//   </bean>
	@Bean
	public PropertyPlaceholderConfigurer propertyPlaceholderConfigurer() {

		PropertyPlaceholderConfigurer propertyPlaceholderConfigurer = new PropertyPlaceholderConfigurer();
		propertyPlaceholderConfigurer.setLocation(new ClassPathResource("database.properties"));

		return propertyPlaceholderConfigurer;
	}
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(driverClass);
		dataSource.setUrl(jdbcUrl);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		
		return dataSource;
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(this.dataSource());
		sessionFactory.setPackagesToScan("com.jp.music.album.model", "com.jp.music.recordcompany.model", "com.jp.music.user.model", "com.jp.music.singer.model");
		
		return sessionFactory;
	}
	
	final Properties hibernateProperties() {
        return new Properties() {
            {
                this.put("hibernate.dialect", org.hibernate.dialect.MySQLDialect.getDialect());
                this.put("hibernate.show_sql", true);
                this.put("hibernate.current_session_context_class", "thread");
            }
        };
    }
}

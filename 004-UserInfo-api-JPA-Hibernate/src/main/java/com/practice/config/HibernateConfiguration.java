package com.practice.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;


@Configuration
public class HibernateConfiguration {

	
		@Value("${db.driver}")
		private String DB_DRIVER;
		
		@Value("${db.password}")
		private String DB_PASSWORD;
		
		@Value("${db.url}")
		private String DB_URL;
		
		@Value("${db.username}")
		private String DB_USERNAME;
		
		@Value("${hibernate.dialect}")
		private String HIBERNATE_DIALECT;
		
		@Value("${hibernate.showmysql}")
		private String HIBERNATE_SHOW_MYSQL;
		
		@Value("${hibernate.dialect}")
		private String HBM2DDL_AUTO;
		
		@Value("${hibernate.show_sql}")
		private String PACKAGES_TO_SCAN;
		
		@Bean
		public DataSource dataSource() {
			
			DriverManagerDataSource dataSource = new DriverManagerDataSource();
			dataSource.setDriverClassName(DB_DRIVER);
			dataSource.setUrl(DB_URL);
			dataSource.setUsername(DB_USERNAME);
			dataSource.setPassword(DB_PASSWORD);
			return dataSource;
		}
		
		@Bean
		public LocalSessionFactoryBean sessionFactory() {
			LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
			sessionFactory.setDataSource(dataSource());
			sessionFactory.setPackagesToScan(PACKAGES_TO_SCAN);
			Properties hibernateProps = new Properties();
			hibernateProps.put("hibernate.dialect", HIBERNATE_DIALECT);
			hibernateProps.put("hibernate.show_sql", HIBERNATE_SHOW_MYSQL);
			hibernateProps.put("hibernate.hbm2ddl.auto", HBM2DDL_AUTO);
			
			sessionFactory.setHibernateProperties(hibernateProps);
			return sessionFactory;
		}
		
		
}

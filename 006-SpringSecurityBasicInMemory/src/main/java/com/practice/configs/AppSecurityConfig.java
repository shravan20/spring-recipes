package com.practice.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("SKB").password("{noop}password").roles("ADMIN")//noop means Don't encrypt
			.and()
			.withUser("Shravan").password("{noop}password").roles("USER"); 
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
			.antMatchers("/").permitAll()
			.antMatchers("/rest/hello*").access("hasRole('ROLE_ADMIN')")
			.and().httpBasic();
		
		http.csrf().disable();
		
	}

	
	
}

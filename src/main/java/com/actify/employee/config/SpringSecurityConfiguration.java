package com.actify.employee.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.AuthenticatedPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter{
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		UserBuilder users = User.withDefaultPasswordEncoder();
		auth.inMemoryAuthentication()
		.withUser(users.username("admin").password("admin").roles("ADMIN"))
		.withUser(users.username("devs").password("devs").roles("DEVELOPER"))
		.withUser(users.username("user").password("user").roles("USER")); 
	}
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http.authorizeRequests().antMatchers("/listAllEmployees")
    	.hasAnyRole("ADMIN").and().httpBasic();
    	http.authorizeRequests().antMatchers("/getEmployeeData/**")
    	.hasAnyRole("DEVELOPER").and().httpBasic();
    	http.authorizeRequests().antMatchers("/deleteEmployee/**")
    	.authenticated().and().httpBasic();
    	http.authorizeRequests().antMatchers("/**").authenticated().and().httpBasic();
    	http.csrf().disable();
    	http.headers().frameOptions().disable();

    }
}

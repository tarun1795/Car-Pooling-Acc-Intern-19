package com.accolite.carpooling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SpringBootApplication
public class CarPoolingApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarPoolingApplication.class, args);
	}
	
	@Configuration
	  @Order(SecurityProperties.BASIC_AUTH_ORDER)
	  protected static class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	      http
	      .csrf().disable()
	        .httpBasic()
	      .and()
	        .authorizeRequests()
	          .antMatchers("/admin/api/rides","/admin/api/ride/*","/admin/api/add").permitAll()
	          .anyRequest().authenticated();
	    }
	  }
}
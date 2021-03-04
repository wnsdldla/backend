package com.backend.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.backend.demo.service.UserService;

import lombok.AllArgsConstructor;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private UserService userService;
	
	@Autowired
	private JwtRequestFilter jwtRequestFilter;
	
	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	protected void configure(HttpSecurity http)	throws Exception{
		/*
		//02.18 11:17
		 http.authorizeRequests()
		    .antMatchers("/api/login").permitAll()
		    .antMatchers("/api/noticeList").permitAll()
		    .antMatchers("/api/auth").permitAll()
		    .antMatchers(HttpMethod.POST, "/api/signup").permitAll()
		    .antMatchers(HttpMethod.DELETE, "/api/customers/**").hasRole("USER")
		    .anyRequest().authenticated()
		    .and()
		    .httpBasic().authenticationEntryPoint(jwtAuthenticationEntryPoint())	
		    .and()
		    .csrf().disable()
		    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		    */
		http.csrf().disable()
		.authorizeRequests()
			.antMatchers("/api/login").permitAll()
			.antMatchers("/api/auth").permitAll()
			.antMatchers(HttpMethod.POST, "/api/signup").permitAll()
			.anyRequest().authenticated()
	    .and()
		    .httpBasic().authenticationEntryPoint(jwtAuthenticationEntryPoint)	
	    .and()
	    	.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		http
			.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
	}
	

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
	}
}

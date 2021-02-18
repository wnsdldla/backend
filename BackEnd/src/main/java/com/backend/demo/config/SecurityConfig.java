package com.backend.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.backend.demo.service.UserService;

import lombok.AllArgsConstructor;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	//02.17 13:27---
	@Autowired
	private UserService uService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider(UserService userService) {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userService);
		authenticationProvider.setPasswordEncoder(bCryptPasswordEncoder);
		return authenticationProvider;
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) {
		auth.authenticationProvider(authenticationProvider(uService));	
	}
	//---
	@Override
	protected void configure(HttpSecurity http)	throws Exception{
		/*
		http
		.csrf()
		.disable()
		.authorizeRequests()
		.anyRequest()
		.authenticated()
		.and()
		.httpBasic();
		 */
		
		/*
		실패
		//02.17 13.27 새로운 수정
		http.authorizeRequests()
		// 페이지 권한 설정
		.antMatchers("/admin/**").hasRole("ADMIN")
		.antMatchers("/user/myinfo").hasRole("MEMBER")
		.antMatchers("/**").permitAll()
	.and() // 로그인 설정
		.formLogin()
		.loginPage("/user/login")
		.defaultSuccessUrl("/user/login/result")
		.permitAll()
	.and() // 로그아웃 설정
		.logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
		.logoutSuccessUrl("/user/logout/result")
		.invalidateHttpSession(true)
	.and()	// 403 예외처리 핸들링
		.exceptionHandling().accessDeniedPage("/user/denied");
		*/
		//02.17 3:23
		http
		.authorizeRequests()
			.antMatchers("/user/save").permitAll()
			.antMatchers("/").hasAnyAuthority("ADMIN","USER")
			.anyRequest().authenticated()
		.and()
			.csrf().ignoringAntMatchers("/user/save")
		.and()
			.csrf().ignoringAntMatchers("/login")
		.and()
			.formLogin()
			.defaultSuccessUrl("/")
		.and()
			.logout()
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.deleteCookies("JSESSIONID")
		.and()
			.exceptionHandling()
			.accessDeniedPage("/access-denied");

	}
	

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		auth
		.inMemoryAuthentication()
		.withUser("user1")
		.password("{noop}password1")
		.roles("USER");
	}
}

package com.backend.demo;

import java.io.Console;
import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class TestRunner implements ApplicationRunner{

	@Autowired
	DataSource dataSource;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	

	@Override
	public void run(ApplicationArguments args) throws Exception {
		//DataSource
		Connection conn = dataSource.getConnection();
		System.out.println("DBCP : "+ dataSource.getClass());
		System.out.println("URL : " + conn.getMetaData().getURL());
		System.out.println("username : "+ conn.getMetaData().getUserName());
		
		//JDBCTemplate
//		jdbcTemplate.execute("INSERT INTO SECURITY_USER values(2,'user2','password2','name2','USER_ROLE',0)");
	}
	
}

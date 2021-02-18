package com.backend.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.backend.demo.VO.UserVO;
import com.backend.demo.service.UserService;

@RestController
public class UserRestController {

	@Autowired
	private UserService userService;
	
	@PostMapping(path = "/user/save", produces = MediaType.APPLICATION_JSON_VALUE)
	public String saveUserInfo(@RequestBody Map<String, String> user) {
		UserVO userVO = new UserVO();
		userVO.setUserId(user.get("userId"));
		userVO.setPassword(user.get("password"));
		userVO.setName(user.get("name"));
		System.out.println(userVO.toString());
		return userService.insertUser(userVO);
	}
}

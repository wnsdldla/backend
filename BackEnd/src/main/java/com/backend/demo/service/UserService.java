package com.backend.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.backend.demo.VO.UserPrincipalVO;
import com.backend.demo.VO.UserVO;
import com.backend.demo.mapper.UserMapper;

@Service
public class UserService implements UserDetailsService{

	@Autowired
	private UserMapper userMapper;



	@Override
	public UserPrincipalVO loadUserByUsername(String userId) throws UsernameNotFoundException {
		System.out.println("userService.class - userId : "+userId);
		ArrayList<UserVO> userAuthes = userMapper.findByUserId(userId);
		if(userAuthes.size()==0) {
			throw new UsernameNotFoundException("User " + userId + " Not Found!");
		}
		return new UserPrincipalVO(userAuthes);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
	public String insertUser(UserVO userVO) {
		userVO.setRoleName("USER");
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		userVO.setPassword(encoder.encode(userVO.getPassword()));
		int flag = userMapper.userSave(userVO);
		if(flag>0) {
			int userNo = userMapper.findUserNo(userVO.getUserId());
			int roleNo = userMapper.findRoleNo(userVO.getRoleName());
			
			userMapper.userRoleSave(userNo, roleNo);
			return "success";
		}
		return "fail";
	}
	
	
}

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
	private UserMapper uMapper;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	/* 수정 전
	public UserVO selectUserByNumber(long userNumber) {
		return uMapper.selectUserByNumber(userNumber);
	}
	
	public List<UserVO> selectAllUsers(){
		return uMapper.selectAllUsers();
	}
	
	@Transactional
	public void insertUser(UserVO user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		System.out.println("insertUser - UserService : "+user.toString());
		uMapper.insertUser(user);
	*/
	//02.17 추가분
	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		System.out.println("userId : "+userId);
		ArrayList<UserVO> userAuthes = uMapper.findByUserId(userId);
		if(userAuthes.size()==0) {
			throw new UsernameNotFoundException("User " + userId + " Not Found!");
		}
		return new UserPrincipalVO(userAuthes);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
	public String insertUser(UserVO userVO) {
		userVO.setRoleName("USER");
		userVO.setPassword(passwordEncoder.encode(userVO.getPassword()));
		int flag = uMapper.userSave(userVO);
		if(flag>0) {
			int userNo = uMapper.findUserNo(userVO.getUserId());
			int roleNo = uMapper.findRoleNo(userVO.getRoleName());
			
			uMapper.userRoleSave(userNo, roleNo);
			return "success";
		}
		return "fail";
	}
	
	
}

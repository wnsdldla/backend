package com.backend.demo.controller;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.demo.VO.JwtRequest;
import com.backend.demo.VO.JwtResponse;
import com.backend.demo.VO.UserPrincipalVO;
import com.backend.demo.VO.UserVO;
import com.backend.demo.config.JwtTokenUtil;
import com.backend.demo.service.UserService;

@RestController
@RequestMapping("/api")
public class UserRestController {

	@Autowired
	private UserService userService;

	//02.19--
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	
	@GetMapping("/hello")
	public String hello() {	
		System.out.println("/api/hello");
		return "안녕하세요. 현재 서버 시간은 "+new Date() +"입니다. \n";
	}
	
	@PostMapping("/signup")
	public UserVO saveUserInfo(@RequestBody Map<String, String> user)  {
		UserVO userVO = new UserVO();
		userVO.setUserId(user.get("userId"));
		userVO.setPassword(user.get("password"));
		userVO.setName(user.get("name"));
		
		userService.insertUser(userVO);

		return userVO;
	}
	//02.19 추가 --
	@PostMapping("/auth")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception{
		authenticate(authenticationRequest.getUserId(), authenticationRequest.getPassword());
		final UserPrincipalVO userDetails =(UserPrincipalVO) userService.loadUserByUsername(authenticationRequest.getUserId());
		final String token = jwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(new JwtResponse(token));
	}
	
	private void authenticate(String username, String password) throws Exception{
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		}catch(DisabledException de) {
			throw new Exception("USER_DISABLED" , de);
		}catch(BadCredentialsException bce) {
			throw new Exception("INVALID_CREDENTIALS",bce);
		}
	}
	
	//--

}






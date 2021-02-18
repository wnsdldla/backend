package com.backend.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.backend.demo.VO.UserPrincipalVO;
import com.backend.demo.VO.UserVO;
import com.backend.demo.service.UserService;

@Controller
public class HomeController {

	@GetMapping("/")
	public String loadExceptionPage(ModelMap model) throws Exception{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserPrincipalVO userPrincipalVO = (UserPrincipalVO)auth.getPrincipal();
		
		model.addAttribute("name",userPrincipalVO.getUsername());
		model.addAttribute("auth",userPrincipalVO.getAuthorities());
		
		return "index";
	}
	
	@GetMapping("/access-denied")
	public String loadAccessdeniedPage() throws Exception{
		return "index";
	}
}

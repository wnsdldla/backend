package com.backend.demo.VO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserPrincipalVO implements UserDetails {

	private ArrayList<UserVO> userVO;
	
	public UserPrincipalVO(ArrayList<UserVO> userAuthes) {
		this.userVO = userAuthes;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		for(int i=0; i<userVO.size(); i++) {
			authorities.add(new SimpleGrantedAuthority(userVO.get(i).getRoleName()));
		}
		return authorities;
	}

	@Override
	public String getPassword() {
		return userVO.get(0).getPassword();
	}

	@Override
	public String getUsername() {
		return userVO.get(0).getName();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}

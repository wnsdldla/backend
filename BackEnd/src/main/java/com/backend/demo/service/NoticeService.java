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

import com.backend.demo.VO.NoticeVO;
import com.backend.demo.VO.UserPrincipalVO;
import com.backend.demo.VO.UserVO;
import com.backend.demo.mapper.NoticeMapper;
import com.backend.demo.mapper.UserMapper;

@Service
public class NoticeService  {

	@Autowired
	private NoticeMapper noticeMapper;
	
	//공지 리스트
	public ArrayList<NoticeVO> noticeList(){
		System.out.println("NoticeList");
		return noticeMapper.noticeList();
	}
	
	//공지사항 보기
	public NoticeVO noticeRead(int noticeNum) {
		System.out.println("NoticeRead");
		return noticeMapper.noticeRead(noticeNum);
	}
	
	//공지 등록
	public int noticeRegister(NoticeVO noticeVO) {
		System.out.println("NoticeRegister - "+ noticeVO);
		return noticeMapper.noticeRegister(noticeVO);
	}
	
	//공지 수정
	public int noticeModify(NoticeVO noticeVO) {
		System.out.println("noticeModify - service - " + noticeVO);
		return noticeMapper.noticeModify(noticeVO); 
	}
	
	//공지 삭제
	public int noticeDelete(int noticeNum) {
		System.out.println("noticeDelete - service - "+noticeNum);
		return noticeMapper.noticeDelete(noticeNum);
	}
	
	
	
}

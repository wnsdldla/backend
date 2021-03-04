package com.backend.demo.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.backend.demo.VO.NoticeVO;
import com.backend.demo.VO.UserVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class UserServiceTest {

	@Autowired
	private UserService uService;
	
	@Autowired
	private NoticeService nService;
	
	@Test
	public void noticeUpdate() {
		NoticeVO notice = new NoticeVO();
		notice.setNoticeNum(48);
		notice.setNoticeContents("격투기 +");
		notice.setNoticeTitle("켄간 오메가");
		System.out.println(nService.noticeModify(notice));
		
	}
	
//	@Test
//	public void getUserByNumber() {
//		UserVO user = uService.selectUserByNumber(1L);
//		System.out.println(user.toString());
//	}
	
//	@Test
//	public void selectAllUsers() {
//		List<UserVO> users= uService.selectAllUsers();
//		for(UserVO user : users) {
//			System.out.println(user.toString());
//		}
//	}
	
//	@Test
//	@Transactional
//	public void insertUser() {
//		uService.insertUser(new UserVO(3L,"user3","password3","name3","USER_ROLE",0));
//	}
}

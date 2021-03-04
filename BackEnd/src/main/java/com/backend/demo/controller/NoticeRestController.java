package com.backend.demo.controller;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.demo.VO.NoticeVO;
import com.backend.demo.service.NoticeService;

@RestController
@RequestMapping("/api")
public class NoticeRestController {

	@Autowired
	private NoticeService noticeService;
	
	@GetMapping("/noticeList")
	public ArrayList<NoticeVO> noticeList(){
		System.out.println("noticeRestController");
		return noticeService.noticeList();
	}
	
	@GetMapping("/noticeRead")
	public NoticeVO noticeRead(@Param("noticeNum") int noticeNum) {
		System.out.println("noticeNum : "+ noticeNum);
		return noticeService.noticeRead(noticeNum);
	}
		
	
	@PostMapping("/noticeRegister")
	public int noticeRegister(@RequestBody Map<String, String> notice) {
		System.out.println("noticeRegister - controller");
		NoticeVO noticeVO = new NoticeVO();
		
		noticeVO.setAdminEmail(notice.get("adminEmail"));
		noticeVO.setNoticeContents(notice.get("noticeContents"));
		noticeVO.setNoticeTitle(notice.get("noticeTitle"));
		return noticeService.noticeRegister(noticeVO);
	}
	
	@PostMapping("/noticeModify")
	public int noticeModify(@RequestBody Map<String, String> notice) {
		System.out.println("noticeModify - controller ");
		NoticeVO noticeVO = new NoticeVO();
		
		noticeVO.setNoticeNum(Integer.parseInt(notice.get("noticeNum")));
		noticeVO.setAdminEmail(notice.get("adminEmail"));
		noticeVO.setNoticeContents(notice.get("noticeContents"));
		noticeVO.setNoticeTitle(notice.get("noticeTitle"));
		return noticeService.noticeModify(noticeVO);
	}
	
	@PostMapping("/noticeDelete")
	public int noticeDelete(@RequestBody Map<String, String> notice) {
		System.out.println("noticeDelete - controller");
		int noticeNum = Integer.parseInt(notice.get("noticeNum"));
		return noticeService.noticeDelete(noticeNum);
	}
	

}


























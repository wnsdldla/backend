package com.backend.demo.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.backend.demo.VO.NoticeVO;
import com.backend.demo.VO.UserVO;


@Repository
public interface NoticeMapper {

	
	//02.18 추가
	//공지 리스트
	ArrayList<NoticeVO> noticeList();
	
	//공지사항 보기
	NoticeVO noticeRead(int noticeNum);
	
	//공지 등록
	int noticeRegister(NoticeVO noticeVO);
	
	//공지 수정
	int noticeModify(NoticeVO noticeVO);
	
	//공지 삭제
	int noticeDelete(int noticeNum);
}
